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

package ru.sample.pet.catalog.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import ru.sample.pet.catalog.model.Pet;

/**
 * The cache model class for representing Pet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PetCacheModel implements CacheModel<Pet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetCacheModel)) {
			return false;
		}

		PetCacheModel petCacheModel = (PetCacheModel)object;

		if (petId == petCacheModel.petId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", petId=");
		sb.append(petId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", price=");
		sb.append(price);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pet toEntityModel() {
		PetImpl petImpl = new PetImpl();

		if (uuid == null) {
			petImpl.setUuid("");
		}
		else {
			petImpl.setUuid(uuid);
		}

		petImpl.setPetId(petId);
		petImpl.setGroupId(groupId);
		petImpl.setCompanyId(companyId);
		petImpl.setUserId(userId);

		if (userName == null) {
			petImpl.setUserName("");
		}
		else {
			petImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petImpl.setCreateDate(null);
		}
		else {
			petImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petImpl.setModifiedDate(null);
		}
		else {
			petImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			petImpl.setName("");
		}
		else {
			petImpl.setName(name);
		}

		if (description == null) {
			petImpl.setDescription("");
		}
		else {
			petImpl.setDescription(description);
		}

		petImpl.setPrice(price);

		if (birthday == Long.MIN_VALUE) {
			petImpl.setBirthday(null);
		}
		else {
			petImpl.setBirthday(new Date(birthday));
		}

		petImpl.setStatus(status);
		petImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			petImpl.setStatusByUserName("");
		}
		else {
			petImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			petImpl.setStatusDate(null);
		}
		else {
			petImpl.setStatusDate(new Date(statusDate));
		}

		petImpl.resetOriginalValues();

		return petImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		petId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		price = objectInput.readDouble();
		birthday = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(petId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(price);
		objectOutput.writeLong(birthday);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long petId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public double price;
	public long birthday;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}