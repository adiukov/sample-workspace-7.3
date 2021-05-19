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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ru.sample.pet.catalog.exception.NoSuchPetException;
import ru.sample.pet.catalog.model.Pet;

/**
 * The persistence interface for the pet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetUtil
 * @generated
 */
@ProviderType
public interface PetPersistence extends BasePersistence<Pet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetUtil} to access the pet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByUuid(String uuid);

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
	public java.util.List<Pet> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Pet> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the pets before and after the current pet in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet[] findByUuid_PrevAndNext(
			long petId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of pets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pets
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the pet where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUUID_G(String uuid, long groupId)
		throws NoSuchPetException;

	/**
	 * Returns the pet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the pet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUUID_G(String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the pet where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet that was removed
	 */
	public Pet removeByUUID_G(String uuid, long groupId)
		throws NoSuchPetException;

	/**
	 * Returns the number of pets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pets
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the pets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Pet> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Pet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public Pet[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of pets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pets
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the pets where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByCompany(long companyId);

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
	public java.util.List<Pet> findByCompany(
		long companyId, int start, int end);

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
	public java.util.List<Pet> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the pets before and after the current pet in the ordered set where companyId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet[] findByCompany_PrevAndNext(
			long petId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of pets where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching pets
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the pets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByGroup(long groupId);

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
	public java.util.List<Pet> findByGroup(long groupId, int start, int end);

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
	public java.util.List<Pet> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the pets before and after the current pet in the ordered set where groupId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet[] findByGroup_PrevAndNext(
			long petId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of pets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pets
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the pets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByGroupStatus(long groupId, int status);

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
	public java.util.List<Pet> findByGroupStatus(
		long groupId, int status, int start, int end);

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
	public java.util.List<Pet> findByGroupStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByGroupStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByGroupStatus_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByGroupStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByGroupStatus_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByGroupStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public Pet[] findByGroupStatus_PrevAndNext(
			long petId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByGroupStatus(long groupId, int status);

	/**
	 * Returns the number of pets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching pets
	 */
	public int countByGroupStatus(long groupId, int status);

	/**
	 * Returns all the pets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByUser(long userId);

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
	public java.util.List<Pet> findByUser(long userId, int start, int end);

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
	public java.util.List<Pet> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUser_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUser_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the pets before and after the current pet in the ordered set where userId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet[] findByUser_PrevAndNext(
			long petId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUser(long userId);

	/**
	 * Returns the number of pets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching pets
	 */
	public int countByUser(long userId);

	/**
	 * Returns all the pets where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByUserStatus(long userId, int status);

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
	public java.util.List<Pet> findByUserStatus(
		long userId, int status, int start, int end);

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
	public java.util.List<Pet> findByUserStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findByUserStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUserStatus_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUserStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByUserStatus_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByUserStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public Pet[] findByUserStatus_PrevAndNext(
			long petId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByUserStatus(long userId, int status);

	/**
	 * Returns the number of pets where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching pets
	 */
	public int countByUserStatus(long userId, int status);

	/**
	 * Caches the pet in the entity cache if it is enabled.
	 *
	 * @param pet the pet
	 */
	public void cacheResult(Pet pet);

	/**
	 * Caches the pets in the entity cache if it is enabled.
	 *
	 * @param pets the pets
	 */
	public void cacheResult(java.util.List<Pet> pets);

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param petId the primary key for the new pet
	 * @return the new pet
	 */
	public Pet create(long petId);

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet remove(long petId) throws NoSuchPetException;

	public Pet updateImpl(Pet pet);

	/**
	 * Returns the pet with the primary key or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet findByPrimaryKey(long petId) throws NoSuchPetException;

	/**
	 * Returns the pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet, or <code>null</code> if a pet with the primary key could not be found
	 */
	public Pet fetchByPrimaryKey(long petId);

	/**
	 * Returns all the pets.
	 *
	 * @return the pets
	 */
	public java.util.List<Pet> findAll();

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
	public java.util.List<Pet> findAll(int start, int end);

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
	public java.util.List<Pet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	public int countAll();

}