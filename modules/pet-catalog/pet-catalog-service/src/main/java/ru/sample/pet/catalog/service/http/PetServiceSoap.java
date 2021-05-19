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

package ru.sample.pet.catalog.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

import ru.sample.pet.catalog.service.PetServiceUtil;

/**
 * Provides the SOAP utility for the
 * <code>PetServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>ru.sample.pet.catalog.model.PetSoap</code>. If the method in the
 * service utility returns a
 * <code>ru.sample.pet.catalog.model.Pet</code>, that is translated to a
 * <code>ru.sample.pet.catalog.model.PetSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PetServiceSoap {

	/**
	 * Получаем ко-во объектов, доступных для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	public static int countByGroup(long groupId) throws RemoteException {
		try {
			int returnValue = PetServiceUtil.countByGroup(groupId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Получаем объекты, доступные для просмотра текущему пользователю в
	 * заданном сайте
	 *
	 * Так как данный запрос использует фильтр по groupId - то для него был
	 * сгенерирован метод filter...
	 */
	public static ru.sample.pet.catalog.model.PetSoap[] getByGroup(
			long groupId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<ru.sample.pet.catalog.model.Pet> returnValue =
				PetServiceUtil.getByGroup(groupId, start, end);

			return ru.sample.pet.catalog.model.PetSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * возращает кол-во объектов на сайте с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как countByGroup
	 */
	public static int countByGroupStatus(long groupId, int status)
		throws RemoteException {

		try {
			int returnValue = PetServiceUtil.countByGroupStatus(
				groupId, status);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * возращает объекты сайта с заданным статусом если @param status равен
	 * WorkflowConstants.STATUS_ANY - то работает как getByGroup
	 */
	public static ru.sample.pet.catalog.model.PetSoap[] getByGroupStatus(
			long groupId, int status, int start, int end)
		throws RemoteException {

		try {
			java.util.List<ru.sample.pet.catalog.model.Pet> returnValue =
				PetServiceUtil.getByGroupStatus(groupId, status, start, end);

			return ru.sample.pet.catalog.model.PetSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countByUser(long userId) throws RemoteException {
		try {
			int returnValue = PetServiceUtil.countByUser(userId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static ru.sample.pet.catalog.model.PetSoap[] getByUser(
			long userId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<ru.sample.pet.catalog.model.Pet> returnValue =
				PetServiceUtil.getByUser(userId, start, end);

			return ru.sample.pet.catalog.model.PetSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * возращает кол-во объектов пользователя с заданным статусом если @param
	 * status равен WorkflowConstants.STATUS_ANY - то работает как countByUser
	 */
	public static int countByUserStatus(long userId, int status)
		throws RemoteException {

		try {
			int returnValue = PetServiceUtil.countByUserStatus(userId, status);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * возращает объекты пользователя с заданным статусом если @param status
	 * равен WorkflowConstants.STATUS_ANY - то работает как getByUser
	 */
	public static ru.sample.pet.catalog.model.PetSoap[] getByUserStatus(
			long userId, int status, int start, int end)
		throws RemoteException {

		try {
			java.util.List<ru.sample.pet.catalog.model.Pet> returnValue =
				PetServiceUtil.getByUserStatus(userId, status, start, end);

			return ru.sample.pet.catalog.model.PetSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Получаем информацию об объекте
	 */
	public static ru.sample.pet.catalog.model.PetSoap getPet(long petId)
		throws RemoteException {

		try {
			ru.sample.pet.catalog.model.Pet returnValue = PetServiceUtil.getPet(
				petId);

			return ru.sample.pet.catalog.model.PetSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void updatePet(ru.sample.pet.catalog.model.PetSoap pet)
		throws RemoteException {

		try {
			PetServiceUtil.updatePet(
				ru.sample.pet.catalog.model.impl.PetModelImpl.toModel(pet));
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deletePet(long petId) throws RemoteException {
		try {
			PetServiceUtil.deletePet(petId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Перемещаем объект в корзину
	 */
	public static void movePetToTrash(long petId) throws RemoteException {
		try {
			PetServiceUtil.movePetToTrash(petId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PetServiceSoap.class);

}