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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

import ru.sample.pet.catalog.model.Pet;

/**
 * Provides the remote service interface for Pet. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PetServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PetService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>ru.sample.pet.catalog.service.impl.PetServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the pet remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PetServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Получаем ко-во объектов, доступных для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	@AccessControlled(guestAccessEnabled = true)
	public int countByGroup(long groupId);

	/**
	 * возращает кол-во объектов на сайте с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как countByGroup
	 */
	@AccessControlled(guestAccessEnabled = true)
	public int countByGroupStatus(long groupId, int status);

	@AccessControlled(guestAccessEnabled = true)
	public int countByUser(long userId) throws PortalException;

	/**
	 * возращает кол-во объектов пользователя с заданным статусом если @param
	 * status равен WorkflowConstants.STATUS_ANY - то работает как countByUser
	 */
	@AccessControlled(guestAccessEnabled = true)
	public int countByUserStatus(long userId, int status)
		throws PortalException;

	public void deletePet(long petId) throws PortalException;

	/**
	 * Получаем объекты, доступные для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByGroup(long groupId, int start, int end);

	/**
	 * возращает объекты сайта с заданным статусом если @param status равен
	 * WorkflowConstants.STATUS_ANY - то работает как getByGroup
	 */
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByGroupStatus(
		long groupId, int status, int start, int end);

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByUser(long userId, int start, int end)
		throws PortalException;

	/**
	 * возращает объекты пользователя с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как getByUser
	 */
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> getByUserStatus(
			long userId, int status, int start, int end)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Получаем информацию об объекте
	 */
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pet getPet(long petId) throws PortalException;

	/**
	 * Перемещаем объект в корзину
	 */
	public void movePetToTrash(long petId) throws PortalException;

	public void updatePet(Pet pet) throws PortalException;

}