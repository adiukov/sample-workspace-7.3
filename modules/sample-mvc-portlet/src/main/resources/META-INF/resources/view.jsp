<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	Log LOG = LogFactoryUtil.getLog("ru.sample.jsp.view");
	String greet = ParamUtil.getString(request, "greet");
	LOG.info("greet from JSP:" + greet);
%>
<p>
	<h1><liferay-ui:message key="samplemvc.caption"/> <%=themeDisplay.getUser().getFullName()%>!</h1>
	<c:if test="${not empty greet}">
		<h1>Хелло ${greet}!</h1>
	</c:if>
</p>

<liferay-portlet:renderURL var="renderURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="mvcRenderCommandName" value="/sample/render"/>
	<liferay-portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()%>"/>
</liferay-portlet:renderURL>

<aui:button href="<%=renderURL%>" value="show-host"/>

<liferay-portlet:actionURL name="greet" var="greetURL"/>

<aui:form action="<%=greetURL%>" method="post" name="fm">
	<aui:input name="greet" type="text" label=""/>

	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>

<portlet:resourceURL id="/sample/captcha" var="captchaURL"/>
<liferay-captcha:captcha url="<%=captchaURL%>"/>