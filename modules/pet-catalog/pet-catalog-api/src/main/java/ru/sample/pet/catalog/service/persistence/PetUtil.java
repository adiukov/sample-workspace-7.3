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

package ru.sample.pet.catalog.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import ru.sample.pet.catalog.model.Pet;

/**
 * The persistence utility for the pet service. This utility wraps <code>ru.sample.pet.catalog.service.persistence.impl.PetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetPersistence
 * @generated
 */
public class PetUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Pet pet) {
		getPersistence().clearCache(pet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Pet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Pet> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Pet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Pet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Pet update(Pet pet) {
		return getPersistence().update(pet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Pet update(Pet pet, ServiceContext serviceContext) {
		return getPersistence().update(pet, serviceContext);
	}

	/**
	 * Returns all the pets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pets
	 */
	public static List<Pet> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the pets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUuid_First(
			String uuid, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUuid_First(
		String uuid, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUuid_Last(
			String uuid, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUuid_Last(
		String uuid, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByUuid_PrevAndNext(
			long petId, String uuid, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUuid_PrevAndNext(
			petId, uuid, orderByComparator);
	}

	/**
	 * Removes all the pets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of pets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pets
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the pet where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUUID_G(String uuid, long groupId)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the pet where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet that was removed
	 */
	public static Pet removeByUUID_G(String uuid, long groupId)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of pets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pets
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the pets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pets
	 */
	public static List<Pet> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the pets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUuid_C_PrevAndNext(
			petId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the pets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of pets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pets
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the pets where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching pets
	 */
	public static List<Pet> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the pets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByCompany(long companyId, int start, int end) {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByCompany_First(
			long companyId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByCompany_First(
		long companyId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByCompany_Last(
			long companyId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByCompany_Last(
		long companyId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where companyId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByCompany_PrevAndNext(
			long petId, long companyId,
			OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByCompany_PrevAndNext(
			petId, companyId, orderByComparator);
	}

	/**
	 * Removes all the pets where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of pets where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching pets
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the pets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pets
	 */
	public static List<Pet> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the pets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByGroup_First(
			long groupId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByGroup_First(
		long groupId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByGroup_Last(
			long groupId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByGroup_Last(
		long groupId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where groupId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByGroup_PrevAndNext(
			long petId, long groupId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByGroup_PrevAndNext(
			petId, groupId, orderByComparator);
	}

	/**
	 * Removes all the pets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of pets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pets
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the pets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching pets
	 */
	public static List<Pet> findByGroupStatus(long groupId, int status) {
		return getPersistence().findByGroupStatus(groupId, status);
	}

	/**
	 * Returns a range of all the pets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByGroupStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().findByGroupStatus(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByGroupStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByGroupStatus(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByGroupStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupStatus(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByGroupStatus_First(
			long groupId, int status, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByGroupStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByGroupStatus_First(
		long groupId, int status, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByGroupStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByGroupStatus_Last(
			long groupId, int status, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByGroupStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByGroupStatus_Last(
		long groupId, int status, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByGroupStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByGroupStatus_PrevAndNext(
			long petId, long groupId, int status,
			OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByGroupStatus_PrevAndNext(
			petId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the pets where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByGroupStatus(long groupId, int status) {
		getPersistence().removeByGroupStatus(groupId, status);
	}

	/**
	 * Returns the number of pets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching pets
	 */
	public static int countByGroupStatus(long groupId, int status) {
		return getPersistence().countByGroupStatus(groupId, status);
	}

	/**
	 * Returns all the pets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching pets
	 */
	public static List<Pet> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns a range of all the pets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByUser(long userId, int start, int end) {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUser(
		long userId, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUser(
		long userId, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUser_First(
			long userId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUser_First(
		long userId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUser_Last(
			long userId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUser_Last(
		long userId, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where userId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByUser_PrevAndNext(
			long petId, long userId, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUser_PrevAndNext(
			petId, userId, orderByComparator);
	}

	/**
	 * Removes all the pets where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of pets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching pets
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Returns all the pets where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching pets
	 */
	public static List<Pet> findByUserStatus(long userId, int status) {
		return getPersistence().findByUserStatus(userId, status);
	}

	/**
	 * Returns a range of all the pets where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public static List<Pet> findByUserStatus(
		long userId, int status, int start, int end) {

		return getPersistence().findByUserStatus(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the pets where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUserStatus(
		long userId, int status, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findByUserStatus(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public static List<Pet> findByUserStatus(
		long userId, int status, int start, int end,
		OrderByComparator<Pet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserStatus(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUserStatus_First(
			long userId, int status, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUserStatus_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUserStatus_First(
		long userId, int status, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUserStatus_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public static Pet findByUserStatus_Last(
			long userId, int status, OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUserStatus_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public static Pet fetchByUserStatus_Last(
		long userId, int status, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().fetchByUserStatus_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the pets before and after the current pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet[] findByUserStatus_PrevAndNext(
			long petId, long userId, int status,
			OrderByComparator<Pet> orderByComparator)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByUserStatus_PrevAndNext(
			petId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the pets where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByUserStatus(long userId, int status) {
		getPersistence().removeByUserStatus(userId, status);
	}

	/**
	 * Returns the number of pets where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching pets
	 */
	public static int countByUserStatus(long userId, int status) {
		return getPersistence().countByUserStatus(userId, status);
	}

	/**
	 * Caches the pet in the entity cache if it is enabled.
	 *
	 * @param pet the pet
	 */
	public static void cacheResult(Pet pet) {
		getPersistence().cacheResult(pet);
	}

	/**
	 * Caches the pets in the entity cache if it is enabled.
	 *
	 * @param pets the pets
	 */
	public static void cacheResult(List<Pet> pets) {
		getPersistence().cacheResult(pets);
	}

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param petId the primary key for the new pet
	 * @return the new pet
	 */
	public static Pet create(long petId) {
		return getPersistence().create(petId);
	}

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet remove(long petId)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().remove(petId);
	}

	public static Pet updateImpl(Pet pet) {
		return getPersistence().updateImpl(pet);
	}

	/**
	 * Returns the pet with the primary key or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet findByPrimaryKey(long petId)
		throws ru.sample.pet.catalog.exception.NoSuchPetException {

		return getPersistence().findByPrimaryKey(petId);
	}

	/**
	 * Returns the pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet, or <code>null</code> if a pet with the primary key could not be found
	 */
	public static Pet fetchByPrimaryKey(long petId) {
		return getPersistence().fetchByPrimaryKey(petId);
	}

	/**
	 * Returns all the pets.
	 *
	 * @return the pets
	 */
	public static List<Pet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of pets
	 */
	public static List<Pet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pets
	 */
	public static List<Pet> findAll(
		int start, int end, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pets
	 */
	public static List<Pet> findAll(
		int start, int end, OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PetPersistence, PetPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PetPersistence.class);

		ServiceTracker<PetPersistence, PetPersistence> serviceTracker =
			new ServiceTracker<PetPersistence, PetPersistence>(
				bundle.getBundleContext(), PetPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}