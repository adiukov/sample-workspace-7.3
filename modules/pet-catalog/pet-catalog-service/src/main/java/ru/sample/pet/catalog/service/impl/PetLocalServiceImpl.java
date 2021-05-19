/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.sample.pet.catalog.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.social.SocialActivityManagerUtil;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.social.kernel.model.SocialActivityConstants;
import com.liferay.trash.exception.RestoreEntryException;
import com.liferay.trash.exception.TrashEntryException;
import com.liferay.trash.kernel.model.TrashEntry;
import org.osgi.service.component.annotations.Component;

import ru.sample.pet.catalog.model.Pet;
import ru.sample.pet.catalog.service.base.PetLocalServiceBaseImpl;
import ru.sample.pet.catalog.social.PetCatalogActivityKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the pet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>ru.sample.pet.catalog.service.PetLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=ru.sample.pet.catalog.model.Pet",
	service = AopService.class
)
public class PetLocalServiceImpl extends PetLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(PetLocalServiceImpl.class);

	/**
	 * Метод добавления сущности Pet Получает в качестве параметров
	 *
	 * @param companyId
	 *            - ID portal Instance к которому относится объект
	 * @param groupId
	 *            - ID сайта к которому относится объект
	 * @param userId
	 *            - пользователь который создает объект
	 * @param serviceContext
	 *            - параметр который содержит контекст и дополнительные
	 *            параметры, например информацию о тегах и категориях другие
	 *            параметры - это непосредственно данные сущности
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet addPet(long companyId, long groupId, long userId,
					  String name, String description, double price, Date birthday,
					  ServiceContext serviceContext) throws SystemException, PortalException {
		log.debug("User " + userId + " attemtps to add pet");
		// получаем ID для новой сущности используя counterLocalService
		long petId = counterLocalService.increment(Pet.class.getName());

		// получаем информацию о пользователе
		User user = userLocalService.getUser(userId);

		// создаем сущность со сгенерированным ID
		Pet pet = createPet(petId);

		// зполняем базовые audit-поля
		pet.setCompanyId(companyId);
		pet.setGroupId(groupId);
		pet.setUserId(userId);
		// дополнительно с userId сохраняем userName -
		// в случае если пользователь будет удален у нас хотя бы останется его
		// имя
		pet.setUserName(user.getScreenName());

		// заполняем даты
		Date now = new Date();
		pet.setCreateDate(serviceContext.getCreateDate(now));
		pet.setModifiedDate(serviceContext.getModifiedDate(now));

		// заполняем поля сущности
		pet.setName(name);
		pet.setDescription(description);
		pet.setPrice(price);
		pet.setBirthday(birthday);

		// workflow - ставим статус Draft
		pet.setStatus(WorkflowConstants.STATUS_DRAFT);
		pet.setStatusByUserId(userId);
		pet.setStatusByUserName(user.getScreenName());
		pet.setStatusDate(serviceContext.getModifiedDate(now));

		// сохраняем объект
		pet = petPersistence.update(pet);

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
				serviceContext.isAddGuestPermissions()) {

			addPetResources(
					pet, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		}
		else {
			//TODO Fix permissions
			/*addPetResources(
					pet, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());*/
			addPetResources(
					pet, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		}

		// Asset
		updateAsset(
				userId, pet, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds(),
				serviceContext.getAssetPriority());

		// Workflow - запускаем процесс согласования
		pet = startWorkflowInstance(userId, pet, serviceContext);

		log.debug("User " + userId + " added pet " + petId);

		return pet;
	}

	protected void addPetResources(
			Pet pet, boolean addGroupPermissions,
			boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(
				pet.getCompanyId(), pet.getGroupId(), pet.getUserId(),
				Pet.class.getName(), pet.getPetId(), false,
				addGroupPermissions, addGuestPermissions);
	}

	protected void addPetResources(
			Pet pet, String[] groupPermissions,
			String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(
				pet.getCompanyId(), pet.getGroupId(), pet.getUserId(),
				Pet.class.getName(), pet.getPetId(), groupPermissions,
				guestPermissions);
	}


	protected void addPetResources(
			long petId, boolean addGroupPermissions,
			boolean addGuestPermissions)
			throws PortalException, SystemException {

		Pet pet = petPersistence.findByPrimaryKey(petId);

		addPetResources(pet, addGroupPermissions, addGuestPermissions);
	}

	protected void addPetResources(
			long petId, String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		Pet pet = petPersistence.findByPrimaryKey(petId);

		addPetResources(pet, groupPermissions, guestPermissions);
	}

	/**
	 * Функция обновления объекта Pet По сути аналогична добавлению - только в
	 * данном случае мы не передаем companyId & groupId, но передает petId - ID
	 * изменяемого объекта
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet updatePet(long petId, long userId,
						 String name, String description, double price, Date birthday,
						 ServiceContext serviceContext) throws SystemException, PortalException {
		log.debug("User " + userId + " attemtps to update pet " + petId);

		// получаем изменяемый объект по ID
		Pet pet = petPersistence.findByPrimaryKey(petId);
		User user = userLocalService.getUser(userId);

		// заполняем дату (только modifiedDate)
		Date now = new Date();
		pet.setModifiedDate(serviceContext.getModifiedDate(now));

		// заполняем поля объекта
		pet.setName(name);
		pet.setDescription(description);
		pet.setPrice(price);
		pet.setBirthday(birthday);

		// workflow - статус - проставляем в драфт
		if (!pet.isPending() && !pet.isDraft()) {
			pet.setStatus(WorkflowConstants.STATUS_DRAFT);
			pet.setStatusByUserId(userId);
			pet.setStatusByUserName(user.getScreenName());
			pet.setStatusDate(serviceContext.getModifiedDate(now));
		}

		// обновляем объект
		pet = petPersistence.update(pet);

		// Resources
		//TODO Fix permissions
		/*if ((serviceContext.getGroupPermissions() != null) ||
				(serviceContext.getGuestPermissions() != null)) {

			updatePetResources(
					pet, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}*/

		// Asset
		updateAsset(
				userId, pet, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds(),
				serviceContext.getAssetPriority());

		// Workflow - запускаем процесс согласования
		pet = startWorkflowInstance(userId, pet, serviceContext);


		log.debug("User " + userId + " updated pet " + petId);
		return pet;
	}

	protected void updatePetResources(
			Pet pet, String[] groupPermissions,
			String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(
				pet.getCompanyId(), pet.getGroupId(),
				Pet.class.getName(), pet.getPetId(), groupPermissions,
				guestPermissions);
	}

	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public Pet deletePet(Pet pet) throws SystemException {
		try {
			// Resources

			resourceLocalService.deleteResource(
					pet.getCompanyId(), Pet.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, pet.getPetId());

			// Asset

			assetEntryLocalService.deleteEntry(
					Pet.class.getName(), pet.getPetId());


			// trash
			trashEntryLocalService.deleteEntry(
					Pet.class.getName(), pet.getPetId());

			// Ratings
			ratingsStatsLocalService.deleteStats(
					Pet.class.getName(), pet.getPetId());

			// Workflow

			workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
					pet.getCompanyId(), pet.getGroupId(),
					Pet.class.getName(), pet.getPetId());

			return super.deletePet(pet);
		} catch (Exception ex) {
			log.error("Cannot remove pet ", ex);
			return null;
		}
	}

	@Override
	public Pet deletePet(long petId) throws PortalException, SystemException {
		Pet pet = petPersistence.findByPrimaryKey(petId);

		return deletePet(pet);
	}

	// /
	// / Далее следует набор методов - оберток вокруг сгенерированных
	// / по определенынм в service.xml Finder-ах
	// /
	public int countByCompany(long companyId) throws SystemException {
		return petPersistence.countByCompany(companyId);
	}

	public List<Pet> getByCompany(long companyId, int start, int end) throws SystemException {
		return petPersistence.findByCompany(companyId, start, end);
	}

	public int countByGroup(long groupId) throws SystemException {
		return petPersistence.countByGroup(groupId);
	}

	public List<Pet> getByGroup(long groupId, int start, int end) throws SystemException {
		return petPersistence.findByGroup(groupId, start, end);
	}

	public int countByGroupStatus(long groupId, int status) throws SystemException {
		if (status == WorkflowConstants.STATUS_ANY) {
			return petPersistence.countByGroup(groupId);
		} else {
			return petPersistence.countByGroupStatus(groupId, status);
		}
	}

	public List<Pet> getByGroupStatus(long groupId, int status, int start, int end) throws SystemException {
		if (status == WorkflowConstants.STATUS_ANY) {
			return petPersistence.findByGroup(groupId, start, end);
		} else {
			return petPersistence.findByGroupStatus(groupId, status, start, end);
		}
	}

	public int countByUser(long userId) throws SystemException {
		return petPersistence.countByUser(userId);
	}

	public List<Pet> getByUser(long userId, int start, int end) throws SystemException {
		return petPersistence.findByUser(userId, start, end);
	}

	public int countByUserStatus(long userId, int status) throws SystemException {
		if (status == WorkflowConstants.STATUS_ANY) {
			return petPersistence.countByUser(userId);
		} else {
			return petPersistence.countByUserStatus(userId, status);
		}
	}

	public List<Pet> getByUserStatus(long userId, int status, int start, int end) throws SystemException {
		if (status == WorkflowConstants.STATUS_ANY) {
			return petPersistence.findByUser(userId, start, end);
		} else {
			return petPersistence.findByUserStatus(userId, status, start, end);
		}
	}

	protected void updateAsset(
			long userId, Pet pet, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds, Double priority)
			throws PortalException, SystemException {

		boolean visible = true;

		String summary = HtmlUtil.extractText(
				StringUtil.shorten(pet.getDescription(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				userId, pet.getGroupId(), pet.getCreateDate(),
				pet.getModifiedDate(), Pet.class.getName(),
				pet.getPetId(), pet.getUuid(), 0, assetCategoryIds,
				assetTagNames, true, visible, null, null, null, null,
				ContentTypes.TEXT_HTML, pet.getName(), pet.getDescription(),
				summary, null, null, 0, 0, priority);

		assetLinkLocalService.updateLinks(
				userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);
	}

	/**
	 * Метод обновляет статус объекта
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet updateStatus(
			long userId, long petId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
			throws PortalException {

		// Entry

		User user = userLocalService.getUserById(userId);
		Date now = new Date();

		Pet pet = petPersistence.findByPrimaryKey(petId);
		int oldStatus = pet.getStatus();

		pet.setModifiedDate(serviceContext.getModifiedDate(now));
		pet.setStatus(status);
		pet.setStatusByUserId(user.getUserId());
		pet.setStatusByUserName(user.getFullName());
		pet.setStatusDate(serviceContext.getModifiedDate(now));

		petPersistence.update(pet);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				Pet.class.getName(), petId);

		if ((assetEntry == null) || (assetEntry.getPublishDate() == null)) {
			serviceContext.setCommand(Constants.ADD);
		}

		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("title", pet.getName());

		if (status == WorkflowConstants.STATUS_APPROVED) {

			// Asset
			assetEntryLocalService.updateEntry(
					Pet.class.getName(), petId, now,
					null, true, true);

			// Social
			if ((oldStatus != WorkflowConstants.STATUS_IN_TRASH) &&
					(oldStatus != WorkflowConstants.STATUS_SCHEDULED)) {

				if (serviceContext.isCommandUpdate()) {
					SocialActivityManagerUtil.addActivity(
							user.getUserId(), pet,
							PetCatalogActivityKeys.KEY_UPDATE_PET,
							extraDataJSONObject.toString(), 0);
				}
				else {
					SocialActivityManagerUtil.addUniqueActivity(
							user.getUserId(), pet,
							PetCatalogActivityKeys.KEY_ADD_PET,
							extraDataJSONObject.toString(), 0);
				}
			}

			// Trash

			if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.restoreDiscussionFromTrash(
						Pet.class.getName(), petId);

				trashEntryLocalService.deleteEntry(
						Pet.class.getName(), petId);
			}

		} else {

			// Asset
			assetEntryLocalService.updateVisible(
					Pet.class.getName(), petId, false);

			// Social

			if ((status == WorkflowConstants.STATUS_SCHEDULED) &&
					(oldStatus != WorkflowConstants.STATUS_IN_TRASH)) {

				if (serviceContext.isCommandUpdate()) {
					SocialActivityManagerUtil.addActivity(
							user.getUserId(), pet,
							PetCatalogActivityKeys.KEY_UPDATE_PET,
							extraDataJSONObject.toString(), 0);
				}
				else {
					SocialActivityManagerUtil.addUniqueActivity(
							user.getUserId(), pet,
							PetCatalogActivityKeys.KEY_ADD_PET,
							extraDataJSONObject.toString(), 0);
				}
			}

			// Trash

			if (status == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.moveDiscussionToTrash(
						Pet.class.getName(), petId);

				trashEntryLocalService.addTrashEntry(
						userId, pet.getGroupId(), Pet.class.getName(),
						pet.getPetId(), pet.getUuid(), null, oldStatus, null,
						null);
			}
			else if (oldStatus == WorkflowConstants.STATUS_IN_TRASH) {
				CommentManagerUtil.restoreDiscussionFromTrash(
						Pet.class.getName(), petId);


				trashEntryLocalService.deleteEntry(
						Pet.class.getName(), petId);
			}

		}

		return pet;
	}

	/** Удаляет объект в корзину
	 *
	 * @param userId
	 * @param pet
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet movePetToTrash(long userId, Pet pet)
			throws PortalException {

		// Entry
		if (pet.isInTrash()) {
			throw new TrashEntryException();
		}

		int oldStatus = pet.getStatus();

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			pet.setStatus(WorkflowConstants.STATUS_DRAFT);

			petPersistence.update(pet);
		}

		pet = updateStatus(userId, pet.getPetId(), WorkflowConstants.STATUS_IN_TRASH,
				new ServiceContext(),
				new HashMap<String, Serializable>());

		// Social

		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("title", pet.getName());

		SocialActivityManagerUtil.addActivity(
				userId, pet,
				SocialActivityConstants.TYPE_MOVE_TO_TRASH,
				extraDataJSONObject.toString(), 0);

		// Workflow

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
					pet.getCompanyId(), pet.getGroupId(),
					Pet.class.getName(), pet.getPetId());
		}

		return pet;
	}

	/**
	 * Удаляет объект в корзину
	 */
	public Pet movePetToTrash(long userId, long petId)
			throws PortalException {

		Pet pet = petPersistence.findByPrimaryKey(petId);

		return movePetToTrash(userId, pet);
	}

	/** Метод восстанавливает объект из корзины
	 *
	 * @param userId
	 * @param petId
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet restorePetFromTrash(long userId, long petId)
			throws PortalException {

		// Entry
		Pet pet = petPersistence.findByPrimaryKey(petId);

		if (!pet.isInTrash()) {
			throw new RestoreEntryException(
					RestoreEntryException.INVALID_STATUS);
		}

		TrashEntry trashEntry = trashEntryLocalService.getEntry(
				Pet.class.getName(), petId);

		pet = updateStatus(userId, petId, trashEntry.getStatus(),
				new ServiceContext(),
				new HashMap<String, Serializable>());

		// Social
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("title", pet.getName());

		SocialActivityManagerUtil.addActivity(
				userId, pet,
				SocialActivityConstants.TYPE_RESTORE_FROM_TRASH,
				extraDataJSONObject.toString(), 0);

		return pet;
	}


	protected String getPetURL(
			Pet pet, ServiceContext serviceContext)
			throws PortalException {

		String entryURL = GetterUtil.getString(
				serviceContext.getAttribute("entryURL"));

		if (Validator.isNotNull(entryURL)) {
			return entryURL;
		}

		HttpServletRequest request = serviceContext.getRequest();

		if (request == null) {
			return StringPool.BLANK;
		}

		// TODO Validate followed code
		String portletId = PortletProviderUtil.getPortletId(
				Pet.class.getName(), PortletProvider.Action.VIEW);

		if (Validator.isNotNull(portletId)) {
			String layoutURL = ""; /* TODO LayoutURLUtil.getLayoutURL(
				pet.getGroupId(), portletId, serviceContext);
			*/

			if (Validator.isNotNull(layoutURL)) {
				return layoutURL + Portal.FRIENDLY_URL_SEPARATOR + "pets" +
						StringPool.SLASH + pet.getPetId();
			}
		}

		portletId = PortletProviderUtil.getPortletId(
				Pet.class.getName(), PortletProvider.Action.MANAGE);

		if (Validator.isNull(portletId)) {
			return StringPool.BLANK;
		}

		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
				request, portletId, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", "/pets/view_pet");
		portletURL.setParameter("petId", String.valueOf(pet.getPetId()));

		return portletURL.toString();
	}

	/** Start new workflow instance
	 *
	 * @param userId
	 * @param pet
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	protected Pet startWorkflowInstance(
			long userId, Pet pet, ServiceContext serviceContext)
			throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();

		workflowContext.put(
				WorkflowConstants.CONTEXT_URL, getPetURL(pet, serviceContext));

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUserById(userId);

			userPortraitURL = user.getPortraitURL(
					serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(
				WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
				pet.getCompanyId(), pet.getGroupId(), userId,
				Pet.class.getName(), pet.getPetId(), pet,
				serviceContext, workflowContext);
	}
}