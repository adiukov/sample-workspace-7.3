<%@ include file="./init.jsp" %>

<%
	// получаем значения сохраненные в аттрибутах запроса в портлетом классе
	List<Pet> pets = (List<Pet>) request.getAttribute(PetCatalogPortletKeys.PARAM_PETS);
	Integer petsCount = (Integer) request.getAttribute(PetCatalogPortletKeys.PARAM_PETS_COUNT);

	PortletURL iteratorURL = renderResponse.createRenderURL();

	int delta = GetterUtil.getInteger(portletPreferences.getValue("numberOfRecords", "10"));

	String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", StringPool.BLANK));
	long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), scopeGroupId);

// TODO - Support for ADT
// long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, displayStyle);
	long portletDisplayDDMTemplateId = 0;
%>

<c:if test="<%= pets != null %>">
	<c:choose>
		<c:when test="<%=portletDisplayDDMTemplateId > 0%>">
			<%
				// pass variables used in template
				Map<String, Object> contextVars = new HashMap<String,Object>();
				contextVars.put("pets",pets);
				contextVars.put("petsCount",petsCount);

			%>
			<%-- PortletDisplayTemplateUtil.renderDDMTemplate(pageContext,portletDisplayDDMTemplateId,pets, contextVars) --%>
		</c:when>
		<c:otherwise>

			<liferay-ui:search-container
					iteratorURL="<%= iteratorURL %>"
					emptyResultsMessage="no-pets-found"
					headerNames="#,name,description,price,birthday,actions"
					delta="<%= delta %>">
				<liferay-ui:search-container-results results="<%= pets %>"/>

				<liferay-ui:search-container-row className="ru.sample.pet.catalog.model.Pet"
												 modelVar="pet"
												 escapedModel="true"> <%-- Очень важно указать escapedModel - это позвоялет избежать попадания неправильных кодов на страницу! --%>

					<%-- Формируем url для просмотра детальной информации о питомце
                        windowsState - MAXIMIZED - пример того, как "раскрыть" портлет на всю страницу
                    --%>
					<liferay-portlet:renderURL var="petURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
						<liferay-portlet:param name="mvcRenderCommandName" value="/pet/view"/>
						<portlet:param name="<%= PetCatalogPortletKeys.PARAM_PET_ID %>" value="<%= String.valueOf(pet.getPetId()) %>" />
					</liferay-portlet:renderURL>

					<%--   Формируем колонки - в простых случаях достаточно просто указания property или value --%>
					<liferay-ui:search-container-column-text href="<%= petURL %>"
															 name="#"
															 property="petId"/>

					<liferay-ui:search-container-column-text href="<%= petURL %>"
															 name="name"
															 property="name"/>

					<liferay-ui:search-container-column-text name="description"
															 property="description"/>

					<liferay-ui:search-container-column-text name="price"
															 property="price"/>

					<liferay-ui:search-container-column-text name="birthday">
						<%--Это пример правильного вывода даты - с учетом локали я timezone --%>
						<%= dateFormatDateTime.format(pet.getBirthday()) %>
					</liferay-ui:search-container-column-text>


					<%-- колонка с действиями над объектом --%>
					<liferay-ui:search-container-column-text name="actions">
						<liferay-ui:icon-list>

							<c:if test="<%= PetPermission.contains(permissionChecker, pet, ActionKeys.UPDATE) %>">
								<%--Формируем ссылку на редактирование объекта - аналогично добавлению но так же указываем и ID редактируемого объекта --%>
								<portlet:renderURL var="editPetURL">
									<portlet:param name="<%= PetCatalogPortletKeys.PARAM_PET_ID %>" value="<%= String.valueOf(pet.getPetId()) %>" />
									<portlet:param name="mvcRenderCommandName" value="/pet/edit"/>
									<portlet:param name="<%= WebKeys.REDIRECT %>" value="<%= currentURL %>"/>
								</portlet:renderURL>
								<%-- Размещаем иконку редактирования --%>
								<liferay-ui:icon image="edit" url="<%= editPetURL %>"/>
							</c:if>

							<c:if test="<%= PetPermission.contains(permissionChecker, pet, ActionKeys.DELETE) %>">
								<%--В зависимости от настроек - либо удаляем объект - либо переносим его в корзину --%>
								<c:choose>
									<c:when test="<%= !TrashUtil.isTrashEnabled(scopeGroupId) %>">
										<%--Формируем ссылку на удаление объекта --%>
										<portlet:actionURL name="deletePet" var="deletePetURL">
											<portlet:param name="<%= PetCatalogPortletKeys.PARAM_PET_ID %>" value="<%= String.valueOf(pet.getPetId()) %>" />
											<portlet:param name="<%= WebKeys.REDIRECT %>" value="<%= currentURL %>"/>
										</portlet:actionURL>
										<%-- Размещаем иконку удаления - она добавляет дополнительный вопрос "Вы уверены..." --%>
										<liferay-ui:icon-delete url="<%= deletePetURL %>"/>
									</c:when>
									<c:otherwise>
										<%--Формируем ссылку на перемещение объекта --%>
										<portlet:actionURL name="movePetToTrash" var="movePetURL">
											<portlet:param name="<%= PetCatalogPortletKeys.PARAM_PET_ID %>" value="<%= String.valueOf(pet.getPetId()) %>" />
											<portlet:param name="<%= WebKeys.REDIRECT %>" value="<%= currentURL %>"/>
										</portlet:actionURL>
										<%-- Размещаем иконку удаления - она добавляет дополнительный вопрос "Вы уверены..." --%>
										<liferay-ui:icon-delete url="<%= movePetURL %>"/>
									</c:otherwise>
								</c:choose>
							</c:if>

							<!-- Управление  правами доступа к объекту -->
							<c:if test="<%= PetPermission.contains(permissionChecker, pet, ActionKeys.PERMISSIONS) %>">
								<liferay-security:permissionsURL
										modelResource="<%= Pet.class.getName() %>"
										modelResourceDescription="<%= pet.getName() %>"
										resourcePrimKey="<%= String.valueOf(pet.getPetId()) %>"
										var="petPermissionsURL"
										windowState="<%= LiferayWindowState.POP_UP.toString() %>"
								/>
								<liferay-ui:icon image="permissions" url="<%= petPermissionsURL %>" useDialog="<%= true %>"/>
							</c:if>

						</liferay-ui:icon-list>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<%--Этот тег непосредственно "рисует" таблицу --%>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>

			<%-- Кнопки в конце списка - лучше окружать в button-row --%>
			<aui:button-row>
				<c:if test="<%= PetCatalogPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), PetCatalogPermission.ACTION_ADD_PET) %>">
					<portlet:renderURL var="addPetURL">
						<portlet:param name="mvcRenderCommandName" value="/pet/edit"/>
						<portlet:param name="<%= WebKeys.REDIRECT %>" value="<%= currentURL %>"/>
					</portlet:renderURL>

					<aui:button value="add-pet" href="<%= addPetURL %>"/>
				</c:if>

				<c:if test="<%= PetCatalogPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.PERMISSIONS) %>">
					<liferay-security:permissionsURL
							modelResource="<%= PetCatalogPermission.RESOURCE_NAME %>"
							modelResourceDescription='<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) + " - " + LanguageUtil.get(request, "model.resource.ru.emdev.samples.petcatalog") %>'
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
							windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>
					<aui:button value="edit-permissions" href="<%= permissionsURL %>" useDialog="<%= true %>"/>
				</c:if>
			</aui:button-row>
		</c:otherwise>
	</c:choose>
</c:if>