<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

Pet pet = (Pet)request.getAttribute(PetCatalogPortletKeys.PARAM_PET);
%>
<liferay-portlet:actionURL name="/pet/update" var="updatePetURL"/>

<liferay-ui:header title='<%= pet != null ? pet.getName() : "add-pet" %>' backURL="<%= redirect %>"/>

	
<aui:form method="post" action="<%= updatePetURL %>">
	<aui:input type="hidden" name="<%= WebKeys.REDIRECT %>" value="<%= redirect %>"/>
	<%--<aui:input type="hidden" name="jspPage" value="<%= PetCatalogPortletKeys.EDIT_PET_JSP %>"/>--%>
	
	<c:if test="<%= pet != null %>">
		<aui:input type="hidden" name="<%= PetCatalogPortletKeys.PARAM_PET_ID %>" value="<%= pet.getPetId() %>"/>
	</c:if>
	
	<aui:model-context bean="<%= pet %>" model="<%= Pet.class %>" />
	
	<c:if test="<%= pet != null %>">
		<%--Этот тег показывает статус Workflow для данного объекта --%>
		<aui:workflow-status id="<%= String.valueOf(pet.getPetId()) %>" status="<%= pet.getStatus() %>" />
	</c:if>
	
	<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="name" required="true"/>
	<aui:input name="description"/>
	<aui:input name="price" required="true">
		<aui:validator name="min" errorMessage="price-should-be-positive">0</aui:validator>
	</aui:input>
	
	<aui:input name="birthday"/>
	
	<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="petCategorizationPanel" persistState="<%= true %>" title="categorization">
		<aui:fieldset>
			<aui:input name="categories" type="assetCategories" />

			<aui:input name="tags" type="assetTags" />
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="petAssetLinksPanel" persistState="<%= true %>" title="related-assets">
		<aui:fieldset>
			<liferay-asset:input-asset-links
				className="<%= Pet.class.getName() %>"
				classPK="<%= pet != null ? pet.getPetId() : 0l %>"
			/>
		</aui:fieldset>
	</liferay-ui:panel>

	<c:if test="<%= (pet == null) || (pet.getStatus() == WorkflowConstants.STATUS_DRAFT) %>">
		<%-- unput-permissions необходим чтобы объект получил при создании настройки прав доступа по умолчанию --%>
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="<%= Pet.class.getName() %>"
			/>
		</aui:field-wrapper>
	</c:if>

	<aui:button-row>
		<aui:button type="submit" value='<%= pet != null ? "update-pet" : "add-pet" %>'/>
		<c:if test="<%= Validator.isNotNull(redirect) %>">
			<aui:button value="cancel" href="<%= redirect %>"/>
		</c:if>
	</aui:button-row>
</aui:form>