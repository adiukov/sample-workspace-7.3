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

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.service.TrashEntryLocalService;
import com.liferay.trash.service.TrashEntryService;
import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.Reference;
import ru.sample.pet.catalog.model.Pet;
import ru.sample.pet.catalog.service.PetLocalService;
import ru.sample.pet.catalog.service.base.PetServiceBaseImpl;
import ru.sample.pet.catalog.service.permission.PetPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the pet remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>ru.sample.pet.catalog.service.PetService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetServiceBaseImpl
 */
/**
 * Реализация Remote-сервиса.
 *
 * Важно - так как данный сервис можно вызвать в том числе и через JSON/REST -
 * то в его методах должны проверятся права доступа
 */
@Component(
	property = {
		"json.web.service.context.name=petscatalog",
		"json.web.service.context.path=Pet"
	},
	service = AopService.class
)
public class PetServiceImpl extends PetServiceBaseImpl {

	/**
	 * Получаем ко-во объектов, доступных для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	// эта аннотация говорит что данный метод может быть вызван анонимным
	// пользователем
	@AccessControlled(guestAccessEnabled = true)
	public int countByGroup(long groupId) {
		return petLocalService.countByGroup(groupId);
	}

	/**
	 * Получаем объекты, доступные для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	// эта аннотация говорит что данный метод может быть вызван анонимным
	// пользователем
	@AccessControlled(guestAccessEnabled = true)
	public List<Pet> getByGroup(long groupId, int start, int end) {
		return petLocalService.getByGroup(groupId, start, end);
	}

	/**
	 * возращает кол-во объектов на сайте с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как countByGroup
	 */
	@AccessControlled(guestAccessEnabled = true)
	public int countByGroupStatus(long groupId, int status) {
		if (status == WorkflowConstants.STATUS_ANY) {
			return petLocalService.countByGroup(groupId);
		} else {
			return petLocalService.countByGroupStatus(groupId, status);
		}
	}

	/**
	 * возращает объекты сайта с заданным статусом если @param status равен
	 * WorkflowConstants.STATUS_ANY - то работает как getByGroup
	 */
	@Override
	@AccessControlled(guestAccessEnabled = true)
	public List<Pet> getByGroupStatus(long groupId, int status, int start, int end) {
		if (status == WorkflowConstants.STATUS_ANY) {
			return petPersistence.findByGroup(groupId, start, end);
		} else {
			return petPersistence.findByGroupStatus(groupId, status, start, end);
		}
	}

	// эта аннотация говорит что данный метод может быть вызван анонимным
	// пользователем
	@AccessControlled(guestAccessEnabled = true)
	public int countByUser(long userId) throws PortalException {
		List<Pet> pets = filterFindByUser(userId);

		return pets.size();
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<Pet> getByUser(long userId, int start, int end) throws PortalException {
		List<Pet> allPets = filterFindByUser(userId);

		return ListUtil.subList(allPets, start, end);
	}

	/**
	 * возращает кол-во объектов пользователя с заданным статусом если @param
	 * status равен WorkflowConstants.STATUS_ANY - то работает как countByUser
	 */
	@Override
	@AccessControlled(guestAccessEnabled = true)
	public int countByUserStatus(long userId, int status) throws PortalException {
		List<Pet> pets = filterFindByUserStatus(userId, status);

		return pets.size();
	}

	/**
	 * возращает объекты пользователя с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как getByUser
	 */
	@Override
	@AccessControlled(guestAccessEnabled = true)
	public List<Pet> getByUserStatus(long userId, int status, int start, int end) throws PortalException {
		List<Pet> allPets = filterFindByUserStatus(userId, status);

		return ListUtil.subList(allPets, start, end);
	}

	/**
	 * Получаем информацию об объекте
	 *
	 */
	// эта аннотация говорит что данный метод может быть вызван анонимным
	// пользователем
	@AccessControlled(guestAccessEnabled = true)
	public Pet getPet(long petId) throws PortalException {
		Pet pet = petPersistence.findByPrimaryKey(petId);
		PetPermission.check(getPermissionChecker(), pet, ActionKeys.VIEW);

		return pet;
	}

	public void updatePet(Pet pet) throws PortalException {
		PetPermission.check(getPermissionChecker(), pet, ActionKeys.UPDATE);

		petPersistence.update(pet);
	}

	public void deletePet(long petId) throws PortalException {
		PetPermission.check(getPermissionChecker(), petId, ActionKeys.DELETE);

		petLocalService.deletePet(petId);
	}

	/**
	 * Перемещаем объект в корзину
	 *
	 */
	@Override
	public void movePetToTrash(long petId) throws PortalException {
		PetPermission.check(getPermissionChecker(), petId, ActionKeys.DELETE);
		//TODO
		//petLocalService.movePetToTrash(getPermissionChecker().getUserId(), petId);
	}

	/**
	 * Получаем все объекты, которыми владеет заданный пользователь - при этом
	 * проверяем права доступа к объекту
	 *
	 * @param userId
	 * @return
	 * @throws PortalException
	 */
	private List<Pet> filterFindByUser(long userId) throws PortalException {
		List<Pet> allPets = petPersistence.findByUser(userId);

		return filterPets(allPets);
	}

	/**
	 * Получаем все объекты, которыми владеет заданный пользователь с
	 * определенным статусом При этом проверяем права доступа
	 *
	 * @param userId
	 * @param status
	 * @return
	 * @throws PortalException
	 */
	private List<Pet> filterFindByUserStatus(long userId, int status) throws PortalException {
		List<Pet> allPets = null;

		// проверяем статус на STATUS_ANY
		if (status == WorkflowConstants.STATUS_ANY) {
			allPets = petPersistence.findByUser(userId);
		} else {
			allPets = petPersistence.findByUserStatus(userId, status);
		}

		return filterPets(allPets);
	}

	private List<Pet> filterPets(List<Pet> allPets) throws PortalException {
		List<Pet> filteredPets = new ArrayList<Pet>(allPets.size());

		for (Pet pet : allPets) {
			if (PetPermission.contains(getPermissionChecker(), pet, ActionKeys.VIEW)) {
				filteredPets.add(pet);
			}
		}

		return filteredPets;
	}
}