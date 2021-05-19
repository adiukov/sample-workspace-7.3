package ru.sample.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.sample.constants.SampleMVCPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SampleMVCPortletKeys.SAMPLEMVC,
                "mvc.command.name=/sample/render"
        },
        service = MVCRenderCommand.class
)
public class ShowHostnameMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String host = PortalUtil.getHost(renderRequest);
        renderRequest.setAttribute("host",host);
        return "/render.jsp";
    }
}
