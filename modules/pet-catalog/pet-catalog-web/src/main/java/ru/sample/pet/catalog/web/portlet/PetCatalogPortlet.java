package ru.sample.pet.catalog.web.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Reference;
import ru.sample.pet.catalog.model.Pet;
import ru.sample.pet.catalog.service.PetLocalService;
import ru.sample.pet.catalog.service.permission.PetCatalogPermission;
import ru.sample.pet.catalog.web.constants.PetCatalogPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author adiukov-dell
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PetCatalogPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PetCatalogPortletKeys.PETCATALOGPORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PetCatalogPortlet extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(PetCatalogPortlet.class);

	@Reference
	private PetLocalService petLocalService;

	@Override
	public void doView(
			RenderRequest request, RenderResponse response)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Group group = themeDisplay.getScopeGroup();
		List<Pet> pets;
		int petsCount = 0;

		try {
			// для того, чтобы определить шаг pagination-а (start и end) нам
			// необходимо инициировать
			// объект searchContainer
			// так как кол-во полей в задается в конфигурации портлета - то мы
			// должны сначала получить настройки портлета
			PortletPreferences preferences = request.getPreferences();
			String portletResource = ParamUtil.getString(request, "portletResource");

			if (Validator.isNotNull(portletResource)) {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
			}
			Integer numberOfRecords = GetterUtil.getInteger(preferences.getValue("numberOfRecords", "10"));

			PortletURL iteratorURL = response.createRenderURL();

			// создаем объект searchContainer
			SearchContainer<Pet> searchContainer = new SearchContainer<Pet>(request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, numberOfRecords, iteratorURL, null, null);

			// проверяем - может ли пользователь добавлять объекты на текущем
			// сайте?
			// если да - то выводим все объекты
			// если нет - то только объекты со статусом Approved
			int status = WorkflowConstants.STATUS_APPROVED;
			/*if (PetCatalogPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
					PetCatalogPermission.ACTION_ADD_PET)) {
				status = WorkflowConstants.STATUS_ANY;
			}*/

			// определяем тип текущего сайта
			if (group.isUser()) {
				// если это сайт пользователя - то мы отображаем все объекты
				// связанные с данным пользователем
				pets = petLocalService.getByUserStatus(group.getClassPK(), status, searchContainer.getStart(),
						searchContainer.getEnd());
				petsCount = petLocalService.countByUserStatus(group.getClassPK(), status);
			} else {
				pets = petLocalService.getByGroupStatus(group.getGroupId(), status, searchContainer.getStart(),
						searchContainer.getEnd());
				petsCount = petLocalService.countByGroupStatus(group.getGroupId(), status);
			}

			request.setAttribute(PetCatalogPortletKeys.PARAM_PETS, pets);
			request.setAttribute(PetCatalogPortletKeys.PARAM_PETS_COUNT, petsCount);
		} catch (Exception ex) {
			log.error("Cannot get pets", ex);
		}
		super.doView(request, response);
	}
}