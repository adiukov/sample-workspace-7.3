package ru.sample.pet.catalog.web.portlet.action;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.sample.pet.catalog.model.Pet;
import ru.sample.pet.catalog.service.PetLocalService;
import ru.sample.pet.catalog.web.constants.PetCatalogPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + PetCatalogPortletKeys.PETCATALOGPORTLET,
                "mvc.command.name=/pet/view",
                "mvc.command.name=/pet/edit"
        },
        service = MVCRenderCommand.class
)
public class PetViewMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private PetLocalService petLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long petId = ParamUtil.getLong(renderRequest, PetCatalogPortletKeys.PARAM_PET_ID);
        Pet pet = petLocalService.fetchPet(petId);
        renderRequest.setAttribute(PetCatalogPortletKeys.PARAM_PET, pet);
        String mvcRenderCommandName = ParamUtil.getString(renderRequest, "mvcRenderCommandName");
        if (mvcRenderCommandName.equals("/pet/edit")) {
            return "/edit-pet.jsp";
        }
        return "/view-pet.jsp";
    }
}
