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
 * Provides a wrapper for {@link PetService}.
 *
 * @author Brian Wing Shun Chan
 * @see PetService
 * @generated
 */
public class PetServiceWrapper
	implements PetService, ServiceWrapper<PetService> {

	public PetServiceWrapper(PetService petService) {
		_petService = petService;
	}

	/**
	 * Получаем ко-во объектов, доступных для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	@Override
	public int countByGroup(long groupId) {
		return _petService.countByGroup(groupId);
	}

	/**
	 * возращает кол-во объектов на сайте с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как countByGroup
	 */
	@Override
	public int countByGroupStatus(long groupId, int status) {
		return _petService.countByGroupStatus(groupId, status);
	}

	@Override
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petService.countByUser(userId);
	}

	/**
	 * возращает кол-во объектов пользователя с заданным статусом если @param
	 * status равен WorkflowConstants.STATUS_ANY - то работает как countByUser
	 */
	@Override
	public int countByUserStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petService.countByUserStatus(userId, status);
	}

	@Override
	public void deletePet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_petService.deletePet(petId);
	}

	/**
	 * Получаем объекты, доступные для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByGroup(
		long groupId, int start, int end) {

		return _petService.getByGroup(groupId, start, end);
	}

	/**
	 * возращает объекты сайта с заданным статусом если @param status равен
	 * WorkflowConstants.STATUS_ANY - то работает как getByGroup
	 */
	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByGroupStatus(
		long groupId, int status, int start, int end) {

		return _petService.getByGroupStatus(groupId, status, start, end);
	}

	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByUser(
			long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petService.getByUser(userId, start, end);
	}

	/**
	 * возращает объекты пользователя с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как getByUser
	 */
	@Override
	public java.util.List<ru.sample.pet.catalog.model.Pet> getByUserStatus(
			long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petService.getByUserStatus(userId, status, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petService.getOSGiServiceIdentifier();
	}

	/**
	 * Получаем информацию об объекте
	 */
	@Override
	public ru.sample.pet.catalog.model.Pet getPet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petService.getPet(petId);
	}

	/**
	 * Перемещаем объект в корзину
	 */
	@Override
	public void movePetToTrash(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_petService.movePetToTrash(petId);
	}

	@Override
	public void updatePet(ru.sample.pet.catalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.PortalException {

		_petService.updatePet(pet);
	}

	@Override
	public PetService getWrappedService() {
		return _petService;
	}

	@Override
	public void setWrappedService(PetService petService) {
		_petService = petService;
	}

	private PetService _petService;

}