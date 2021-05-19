package ru.sample.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import ru.sample.constants.SampleMVCPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SampleMVCPortletKeys.SAMPLEMVC,
                "mvc.command.name=greet"
        },
        service = MVCActionCommand.class
)
public class GreetMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        String greet = ParamUtil.getString(actionRequest, "greet");
        actionRequest.setAttribute("greet", greet);
        return false;
    }
}
