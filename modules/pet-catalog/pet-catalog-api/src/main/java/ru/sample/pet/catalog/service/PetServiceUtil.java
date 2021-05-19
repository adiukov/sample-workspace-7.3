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
 * Provides the remote service utility for Pet. This utility wraps
 * <code>ru.sample.pet.catalog.service.impl.PetServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PetService
 * @generated
 */
public class PetServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ru.sample.pet.catalog.service.impl.PetServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Получаем ко-во объектов, доступных для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	public static int countByGroup(long groupId) {
		return getService().countByGroup(groupId);
	}

	/**
	 * возращает кол-во объектов на сайте с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как countByGroup
	 */
	public static int countByGroupStatus(long groupId, int status) {
		return getService().countByGroupStatus(groupId, status);
	}

	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().countByUser(userId);
	}

	/**
	 * возращает кол-во объектов пользователя с заданным статусом если @param
	 * status равен WorkflowConstants.STATUS_ANY - то работает как countByUser
	 */
	public static int countByUserStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().countByUserStatus(userId, status);
	}

	public static void deletePet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deletePet(petId);
	}

	/**
	 * Получаем объекты, доступные для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	public static java.util.List<ru.sample.pet.catalog.model.Pet> getByGroup(
		long groupId, int start, int end) {

		return getService().getByGroup(groupId, start, end);
	}

	/**
	 * возращает объекты сайта с заданным статусом если @param status равен
	 * WorkflowConstants.STATUS_ANY - то работает как getByGroup
	 */
	public static java.util.List<ru.sample.pet.catalog.model.Pet>
		getByGroupStatus(long groupId, int status, int start, int end) {

		return getService().getByGroupStatus(groupId, status, start, end);
	}

	public static java.util.List<ru.sample.pet.catalog.model.Pet> getByUser(
			long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByUser(userId, start, end);
	}

	/**
	 * возращает объекты пользователя с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как getByUser
	 */
	public static java.util.List<ru.sample.pet.catalog.model.Pet>
			getByUserStatus(long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByUserStatus(userId, status, start, end);
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
	 * Получаем информацию об объекте
	 */
	public static ru.sample.pet.catalog.model.Pet getPet(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPet(petId);
	}

	/**
	 * Перемещаем объект в корзину
	 */
	public static void movePetToTrash(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().movePetToTrash(petId);
	}

	public static void updatePet(ru.sample.pet.catalog.model.Pet pet)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updatePet(pet);
	}

	public static PetService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PetService, PetService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PetService.class);

		ServiceTracker<PetService, PetService> serviceTracker =
			new ServiceTracker<PetService, PetService>(
				bundle.getBundleContext(), PetService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}