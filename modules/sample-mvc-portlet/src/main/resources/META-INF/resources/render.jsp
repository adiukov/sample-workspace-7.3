<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    if (Validator.isNotNull(redirect)) {
        portletDisplay.setShowBackIcon(true);
        portletDisplay.setURLBack(redirect);
    }
%>

<h2><liferay-ui:message key="host-x" arguments="${host}"/></h2>


