<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
Pet pet = (Pet)request.getAttribute(PetCatalogPortletKeys.PARAM_PET);

pet = pet.toEscapedModel();
%>
<c:if test="<%= pet != null %>">
	<liferay-ui:header title="<%= pet.getName() %>" />
	<aui:workflow-status id="<%= String.valueOf(pet.getPetId()) %>" status="<%= pet.getStatus() %>" />
	
	<aui:fieldset>
		<aui:field-wrapper first="true" label="name">
			<%= pet.getName() %>
		</aui:field-wrapper>

		<aui:field-wrapper label="description">
			<%= pet.getDescription() %>
		</aui:field-wrapper>

		<aui:field-wrapper label="price">
			<%= pet.getPrice() %>
		</aui:field-wrapper>

		<aui:field-wrapper label="birthday">
			<%= dateFormatDateTime.format(pet.getBirthday()) %>
		</aui:field-wrapper>
		
		<%-- Categorisation --%>
		<liferay-ui:asset-categories-summary className="<%= Pet.class.getName() %>" classPK="<%= pet.getPetId() %>"/>
		<liferay-ui:asset-tags-summary className="<%= Pet.class.getName() %>" classPK="<%= pet.getPetId() %>"/>
		<liferay-asset:input-asset-links className="<%= Pet.class.getName() %>" classPK="<%= pet.getPetId() %>"/>
		
		<%-- Social: Comments and Votes --%>

		<%--Comments --%>
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
							id="modelCommentsPanel" persistState="<%=true%>"
							title="comments">
									
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL">
				<portlet:param name="<%=WebKeys.REDIRECT%>" value="<%=currentURL%>"/>
			</portlet:actionURL>
						
			<liferay-comment:discussion className="<%=Pet.class.getName()%>"
							classPK="<%= pet.getPetId() %>"
							formAction="<%=discussionURL%>" formName="fm2"
							ratingsEnabled="<%=false%>" 
							redirect="<%=currentURL%>"
							userId="<%=themeDisplay.getUserId()%>" />
		</liferay-ui:panel>
		
		<%-- Ratings --%>
		<liferay-ui:ratings className="<%=Pet.class.getName()%>" classPK="<%=pet.getPetId()%>" type="stars" />
		
	</aui:fieldset>
</c:if>