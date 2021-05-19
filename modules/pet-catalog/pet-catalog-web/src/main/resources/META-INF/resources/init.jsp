<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>

<%@ page import="java.text.DateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="com.liferay.portal.kernel.util.JavaConstants" %>
<%@ page import="ru.sample.pet.catalog.web.portlet.PetCatalogPortlet" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="ru.sample.pet.catalog.model.Pet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="ru.sample.pet.catalog.web.constants.PetCatalogPortletKeys" %>
<%@ page import="ru.sample.pet.catalog.service.permission.PetPermission" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.trash.kernel.util.TrashUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="ru.sample.pet.catalog.service.permission.PetCatalogPermission" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="javax.portlet.WindowState" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    WindowState windowState = renderRequest.getWindowState();
    String currentURL = PortalUtil.getCurrentURL(request);
    String imagePath = themeDisplay.getPathThemeImages() + "/custom";

// определяем форматы вывода дат (три варианта - только дата, дата и время, только время)
// с учетом локали и пользовательской timezone
    DateFormat dateFormatDate = DateFormat.getDateInstance(DateFormat.LONG, locale);
    dateFormatDate.setTimeZone(timeZone);
    DateFormat dateFormatDateTime = DateFormatFactoryUtil.getDateTime(locale, timeZone);
    DateFormat dateFormatTime = DateFormatFactoryUtil.getTime(locale, timeZone);

// RuDateFormatSymbols определен в emdev-liferay-utils и
// позволяет прввильно формировать даты для русского языка

/* Позже вернем
if (locale.getLanguage().equals("ru")) {
	if (dateFormatDate instanceof SimpleDateFormat) {
		SimpleDateFormat sdf = (SimpleDateFormat)dateFormatDate;
		sdf.setDateFormatSymbols(new RuDateFormatSymbols());
	}

	if (dateFormatDateTime instanceof SimpleDateFormat) {
		SimpleDateFormat sdf = (SimpleDateFormat)dateFormatDateTime;
		sdf.setDateFormatSymbols(new RuDateFormatSymbols());
	}
}
*/

    PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
    PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
%>