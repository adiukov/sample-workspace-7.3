package ru.sample.portlet.action;


import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import org.osgi.service.component.annotations.Component;
import ru.sample.constants.SampleMVCPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SampleMVCPortletKeys.SAMPLEMVC,
                "mvc.command.name=/sample/captcha"
        },
        service = MVCResourceCommand.class
)
public class CaptchaMVCResourceCommand implements MVCResourceCommand {

    private Log LOG = LogFactoryUtil.getLog(CaptchaMVCResourceCommand.class);

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
        try {
            LOG.info("try serveImage");
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
            return false;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return true;
        }
    }
}
