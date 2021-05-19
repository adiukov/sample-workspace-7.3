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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

import ru.sample.pet.catalog.model.Pet;

/**
 * Provides the local service interface for Pet. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PetLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PetLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ru.sample.pet.catalog.service.impl.PetLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the pet local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PetLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public Pet addPet(
			long companyId, long groupId, long userId, String name,
			String description, double price, Date birthday,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Pet addPet(Pet pet);

	public int countByCompany(long companyId) throws SystemException;

	public int countByGroup(long groupId) throws SystemException;

	public int countByGroupStatus(long groupId, int status)
		throws SystemException;

	public int countByUser(long userId) throws SystemException;

	public int countByUserStatus(long userId, int status)
		throws SystemException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param petId the primary key for the new pet
	 * @return the new pet
	 */
	@Transactional(enabled = false)
	public Pet createPet(long petId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Pet deletePet(long petId) throws PortalException, SystemException;

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
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public Pet deletePet(Pet pet) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pet fetchPet(long petId);

	/**
	 * Returns the pet matching the UUID and group.
	 *
	 * @param uuid the pet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pet fetchPetByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByCompany(long companyId, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByGroup(long groupId, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByGroupStatus(
			long groupId, int status, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByUser(long userId, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByUserStatus(
			long userId, int status, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the pet with the primary key.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet
	 * @throws PortalException if a pet with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pet getPet(long petId) throws PortalException;

	/**
	 * Returns the pet matching the UUID and group.
	 *
	 * @param uuid the pet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet
	 * @throws PortalException if a matching pet could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pet getPetByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getPets(int start, int end);

	/**
	 * Returns all the pets matching the UUID and company.
	 *
	 * @param uuid the UUID of the pets
	 * @param companyId the primary key of the company
	 * @return the matching pets, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getPetsByUuidAndCompanyId(String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getPetsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pet> orderByComparator);

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPetsCount();

	/**
	 * Удаляет объект в корзину
	 */
	public Pet movePetToTrash(long userId, long petId) throws PortalException;

	/**
	 * Удаляет объект в корзину
	 *
	 * @param userId
	 * @param pet
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet movePetToTrash(long userId, Pet pet) throws PortalException;

	/**
	 * Метод восстанавливает объект из корзины
	 *
	 * @param userId
	 * @param petId
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet restorePetFromTrash(long userId, long petId)
		throws PortalException;

	/**
	 * Функция обновления объекта Pet По сути аналогична добавлению - только в
	 * данном случае мы не передаем companyId & groupId, но передает petId - ID
	 * изменяемого объекта
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet updatePet(
			long petId, long userId, String name, String description,
			double price, Date birthday, ServiceContext serviceContext)
		throws PortalException, SystemException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Pet updatePet(Pet pet);

	/**
	 * Метод обновляет статус объекта
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pet updateStatus(
			long userId, long petId, int status, ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}