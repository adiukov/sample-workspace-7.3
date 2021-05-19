package ru.sample.pet.catalog.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.sample.pet.catalog.model.Pet;
import ru.sample.pet.catalog.service.PetLocalService;
import ru.sample.pet.catalog.service.permission.PetCatalogPermission;
import ru.sample.pet.catalog.service.permission.PetPermission;
import ru.sample.pet.catalog.web.constants.PetCatalogPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + PetCatalogPortletKeys.PETCATALOGPORTLET,
                "mvc.command.name=/pet/update"
        },
        service = MVCActionCommand.class
)
public class UpdateMVCActionCommand implements MVCActionCommand {

        private Log log = LogFactoryUtil.getLog(UpdateMVCActionCommand.class);

        @Reference
        private PetLocalService petLocalService;


        @Override
        public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
                ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
                String redirect = ParamUtil.getString(request, WebKeys.REDIRECT);
                long petId = ParamUtil.getLong(request, PetCatalogPortletKeys.PARAM_PET_ID);

                String name = ParamUtil.getString(request, "name");
                String description = ParamUtil.getString(request, "description");
                Double price = ParamUtil.getDouble(request, "price");
                Date birthday = getDateFromRequest(request, "birthday");

                try {
                        ServiceContext serviceContext = ServiceContextFactory.getInstance(Pet.class.getName(), request);

                        Pet pet = null;
                        // определяем - был ли передан ID объекта или нет
                        // если нет - значит мы добавляем новый объект
                        // если да - значит обновляем существующий
                        if (petId == 0) {
                                // при любых действиях обязательно проверяем права доступа
                                PetCatalogPermission.check(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
                                        PetCatalogPermission.ACTION_ADD_PET);

                                log.info("User " + themeDisplay.getUserId() + " attemtps to add new pet");
                                pet = petLocalService.addPet(themeDisplay.getCompanyId(),
                                        themeDisplay.getScopeGroupId(),
                                        themeDisplay.getUserId(),
                                        name, description, price, birthday,
                                        serviceContext);
                        } else {
                                // при любых действиях обязательно проверяем права доступа
                                PetPermission.check(themeDisplay.getPermissionChecker(), petId, ActionKeys.UPDATE);

                                log.info("User " + themeDisplay.getUserId() + " attemtps to edit pet " + petId);
                                pet = petLocalService.updatePet(petId,
                                        themeDisplay.getUserId(),
                                        name, description, price, birthday,
                                        serviceContext);
                        }

                        log.info("Pet " + pet.getPetId() + " added/updated");
                        // TODO
                        /*if (Validator.isNotNull(redirect)) {
                                // В случае если redirect пустой- мы должны остаться на той же
                                // форме редактирвоания.
                                // такое может быть в случае если редактирование было вызвано из
                                // asset publisher-а или формы workflow task
                                response.setRenderParameter("jspPage", PetCatalogPortletKeys.EDIT_PET_JSP);
                                response.setRenderParameter(PetCatalogPortletKeys.PARAM_PET_ID, String.valueOf(petId));
                        }*/
                } catch (Exception ex) {
                        log.error("Cannot add/update pet", ex);
                        PortalUtil.copyRequestParameters(request, response);
                        SessionErrors.add(request, "cannot-add-pet");
                }
                return false;
        }

        protected Date getDateFromRequest(PortletRequest request, String prefix) {

                return getDateFromRequest(PortalUtil.getHttpServletRequest(request), prefix);
        }


        protected Date getDateFromRequest(HttpServletRequest request, String prefix) {

                return getDateFromRequest(request, prefix, null);
        }


        protected Date getDateFromRequest(HttpServletRequest request, String prefix, TimeZone timeZone) {
                int month = ParamUtil.getInteger(request, prefix + "Month");
                int day = ParamUtil.getInteger(request, prefix + "Day");
                int year = ParamUtil.getInteger(request, prefix + "Year");

                Locale locale = request.getLocale();
                if (timeZone == null) {
                        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
                        timeZone = themeDisplay.getTimeZone();
                }

                return getDate(month, day, year, locale, timeZone);

        }

        protected Date getDate(int month, int day, int year, Locale locale, TimeZone timeZone) {

                Calendar date = CalendarFactoryUtil.getCalendar(timeZone, locale);

                date.set(Calendar.MONTH, month);
                date.set(Calendar.DATE, day);
                date.set(Calendar.YEAR, year);
                date.set(Calendar.HOUR_OF_DAY, 0);
                date.set(Calendar.MINUTE, 0);
                date.set(Calendar.SECOND, 0);
                date.set(Calendar.MILLISECOND, 0);

                return date.getTime();
        }
}
