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

package ru.sample.pet.catalog.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PetLocalService
 * @generated
 */
public class PetLocalServiceWrapper
	implements PetLocalService, ServiceWrapper<PetLocalService> {

	public PetLocalServiceWrapper(PetLocalService petLocalService) {
		_petLocalService = petLocalService;
	}

	/**
	 * Метод добавления сущности Pet Получает в качестве параметров
	 *
	 * @param companyId
	 - ID portal Instance к которому относится объект
	 * @param groupId
	 - ID сайта к которому относится объект
	 * @param userId
	 - пользователь который создает объект
	 * @param serviceContext
	 - параметр который содержит контекст и дополнительные
	 параметры, например информацию о тегах и категориях другие
	 параметры - это непосредственно данные сущности
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet addPet(
			long companyId, long groupId, long userId, String name,
			String description, double price, java.util.Date birthday,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.addPet(
			companyId, groupId, userId, name, description, price, birthday,
			serviceContext);
	}

	/**
	 * Adds the pet to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pet the pet
	 * @return the pet that was added
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet addPet(
		ru.sample.pet.catalog.model.Pet pet) {

		return _petLocalService.addPet(pet);
	}

	@Override
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.countByCompany(companyId);
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.countByGroup(groupId);
	}

	@Override
	public int countByGroupStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.countByGroupStatus(groupId, status);
	}

	@Override
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.countByUser(userId);
	}

	@Override
	public int countByUserStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.countByUserStatus(userId, status);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param petId the primary key for the new pet
	 * @return the new pet
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet createPet(long petId) {
		return _petLocalService.createPet(petId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petId the primary key of the pet
	 * @return the pet that was removed
	 * @throws PortalException if a pet with the primary key could not be found
	 * @throws SystemException
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet deletePet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.deletePet(petId);
	}

	/**
	 * Deletes the pet from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pet the pet
	 * @return the pet that was removed
	 * @throws SystemException
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet deletePet(
			ru.sample.pet.catalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.deletePet(pet);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _petLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.sample.pet.catalog.model.impl.PetModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _petLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.sample.pet.catalog.model.impl.PetModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _petLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _petLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _petLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ru.sample.pet.catalog.model.Pet fetchPet(long petId) {
		return _petLocalService.fetchPet(petId);
	}

	/**
	 * Returns the pet matching the UUID and group.
	 *
	 * @param uuid the pet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet fetchPetByUuidAndGroupId(
		String uuid, long groupId) {

		return _petLocalService.fetchPetByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByCompany(
			long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.getByCompany(companyId, start, end);
	}

	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByGroup(
			long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.getByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByGroupStatus(
			long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.getByGroupStatus(groupId, status, start, end);
	}

	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByUser(
			long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.getByUser(userId, start, end);
	}

	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByUserStatus(
			long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.getByUserStatus(userId, status, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _petLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet with the primary key.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet
	 * @throws PortalException if a pet with the primary key could not be found
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet getPet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.getPet(petId);
	}

	/**
	 * Returns the pet matching the UUID and group.
	 *
	 * @param uuid the pet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet
	 * @throws PortalException if a matching pet could not be found
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet getPetByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.getPetByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.sample.pet.catalog.model.impl.PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of pets
	 */
	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getPets(
		int start, int end) {

		return _petLocalService.getPets(start, end);
	}

	/**
	 * Returns all the pets matching the UUID and company.
	 *
	 * @param uuid the UUID of the pets
	 * @param companyId the primary key of the company
	 * @return the matching pets, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet>
		getPetsByUuidAndCompanyId(String uuid, long companyId) {

		return _petLocalService.getPetsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of pets matching the UUID and company.
	 *
	 * @param uuid the UUID of the pets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching pets, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet>
		getPetsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ru.sample.pet.catalog.model.Pet> orderByComparator) {

		return _petLocalService.getPetsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	@Override
	public int getPetsCount() {
		return _petLocalService.getPetsCount();
	}

	/**
	 * Удаляет объект в корзину
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet movePetToTrash(
			long userId, long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.movePetToTrash(userId, petId);
	}

	/**
	 * Удаляет объект в корзину
	 *
	 * @param userId
	 * @param pet
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet movePetToTrash(
			long userId, ru.sample.pet.catalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.movePetToTrash(userId, pet);
	}

	/**
	 * Метод восстанавливает объект из корзины
	 *
	 * @param userId
	 * @param petId
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet restorePetFromTrash(
			long userId, long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.restorePetFromTrash(userId, petId);
	}

	/**
	 * Функция обновления объекта Pet По сути аналогична добавлению - только в
	 * данном случае мы не передаем companyId & groupId, но передает petId - ID
	 * изменяемого объекта
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet updatePet(
			long petId, long userId, String name, String description,
			double price, java.util.Date birthday,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _petLocalService.updatePet(
			petId, userId, name, description, price, birthday, serviceContext);
	}

	/**
	 * Updates the pet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pet the pet
	 * @return the pet that was updated
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet updatePet(
		ru.sample.pet.catalog.model.Pet pet) {

		return _petLocalService.updatePet(pet);
	}

	/**
	 * Метод обновляет статус объекта
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet updateStatus(
			long userId, long petId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petLocalService.updateStatus(
			userId, petId, status, serviceContext, workflowContext);
	}

	@Override
	public PetLocalService getWrappedService() {
		return _petLocalService;
	}

	@Override
	public void setWrappedService(PetLocalService petLocalService) {
		_petLocalService = petLocalService;
	}

	private PetLocalService _petLocalService;

}