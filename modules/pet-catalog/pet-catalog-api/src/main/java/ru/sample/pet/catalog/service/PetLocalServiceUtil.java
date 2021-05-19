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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Pet. This utility wraps
 * <code>ru.sample.pet.catalog.service.impl.PetLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PetLocalService
 * @generated
 */
public class PetLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ru.sample.pet.catalog.service.impl.PetLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ru.sample.pet.catalog.model.Pet addPet(
			long companyId, long groupId, long userId, String name,
			String description, double price, java.util.Date birthday,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addPet(
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
	public static ru.sample.pet.catalog.model.Pet addPet(
		ru.sample.pet.catalog.model.Pet pet) {

		return getService().addPet(pet);
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByGroup(groupId);
	}

	public static int countByGroupStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByGroupStatus(groupId, status);
	}

	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByUser(userId);
	}

	public static int countByUserStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByUserStatus(userId, status);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param petId the primary key for the new pet
	 * @return the new pet
	 */
	public static ru.sample.pet.catalog.model.Pet createPet(long petId) {
		return getService().createPet(petId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ru.sample.pet.catalog.model.Pet deletePet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deletePet(petId);
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
	public static ru.sample.pet.catalog.model.Pet deletePet(
			ru.sample.pet.catalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().deletePet(pet);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ru.sample.pet.catalog.model.Pet fetchPet(long petId) {
		return getService().fetchPet(petId);
	}

	/**
	 * Returns the pet matching the UUID and group.
	 *
	 * @param uuid the pet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static ru.sample.pet.catalog.model.Pet fetchPetByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPetByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<ru.sample.pet.catalog.model.Pet> getByCompany(
			long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByCompany(companyId, start, end);
	}

	public static java.util.List<ru.sample.pet.catalog.model.Pet> getByGroup(
			long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroup(groupId, start, end);
	}

	public static java.util.List<ru.sample.pet.catalog.model.Pet>
			getByGroupStatus(long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupStatus(groupId, status, start, end);
	}

	public static java.util.List<ru.sample.pet.catalog.model.Pet> getByUser(
			long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByUser(userId, start, end);
	}

	public static java.util.List<ru.sample.pet.catalog.model.Pet>
			getByUserStatus(long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByUserStatus(userId, status, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet with the primary key.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet
	 * @throws PortalException if a pet with the primary key could not be found
	 */
	public static ru.sample.pet.catalog.model.Pet getPet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPet(petId);
	}

	/**
	 * Returns the pet matching the UUID and group.
	 *
	 * @param uuid the pet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet
	 * @throws PortalException if a matching pet could not be found
	 */
	public static ru.sample.pet.catalog.model.Pet getPetByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPetByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<ru.sample.pet.catalog.model.Pet> getPets(
		int start, int end) {

		return getService().getPets(start, end);
	}

	/**
	 * Returns all the pets matching the UUID and company.
	 *
	 * @param uuid the UUID of the pets
	 * @param companyId the primary key of the company
	 * @return the matching pets, or an empty list if no matches were found
	 */
	public static java.util.List<ru.sample.pet.catalog.model.Pet>
		getPetsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getPetsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<ru.sample.pet.catalog.model.Pet>
		getPetsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ru.sample.pet.catalog.model.Pet> orderByComparator) {

		return getService().getPetsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	public static int getPetsCount() {
		return getService().getPetsCount();
	}

	/**
	 * Удаляет объект в корзину
	 */
	public static ru.sample.pet.catalog.model.Pet movePetToTrash(
			long userId, long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().movePetToTrash(userId, petId);
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
	public static ru.sample.pet.catalog.model.Pet movePetToTrash(
			long userId, ru.sample.pet.catalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().movePetToTrash(userId, pet);
	}

	/**
	 * Метод восстанавливает объект из корзины
	 *
	 * @param userId
	 * @param petId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ru.sample.pet.catalog.model.Pet restorePetFromTrash(
			long userId, long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().restorePetFromTrash(userId, petId);
	}

	/**
	 * Функция обновления объекта Pet По сути аналогична добавлению - только в
	 * данном случае мы не передаем companyId & groupId, но передает petId - ID
	 * изменяемого объекта
	 */
	public static ru.sample.pet.catalog.model.Pet updatePet(
			long petId, long userId, String name, String description,
			double price, java.util.Date birthday,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updatePet(
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
	public static ru.sample.pet.catalog.model.Pet updatePet(
		ru.sample.pet.catalog.model.Pet pet) {

		return getService().updatePet(pet);
	}

	/**
	 * Метод обновляет статус объекта
	 */
	public static ru.sample.pet.catalog.model.Pet updateStatus(
			long userId, long petId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, petId, status, serviceContext, workflowContext);
	}

	public static PetLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PetLocalService, PetLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PetLocalService.class);

		ServiceTracker<PetLocalService, PetLocalService> serviceTracker =
			new ServiceTracker<PetLocalService, PetLocalService>(
				bundle.getBundleContext(), PetLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}