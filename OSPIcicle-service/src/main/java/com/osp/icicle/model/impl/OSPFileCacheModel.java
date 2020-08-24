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

package com.osp.icicle.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.osp.icicle.model.OSPFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing OSPFile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class OSPFileCacheModel implements CacheModel<OSPFile>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OSPFileCacheModel)) {
			return false;
		}

		OSPFileCacheModel ospFileCacheModel = (OSPFileCacheModel)obj;

		if (ospFileId == ospFileCacheModel.ospFileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ospFileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ospFileId=");
		sb.append(ospFileId);
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
		sb.append(", size=");
		sb.append(size);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OSPFile toEntityModel() {
		OSPFileImpl ospFileImpl = new OSPFileImpl();

		ospFileImpl.setOspFileId(ospFileId);
		ospFileImpl.setGroupId(groupId);
		ospFileImpl.setCompanyId(companyId);
		ospFileImpl.setUserId(userId);

		if (userName == null) {
			ospFileImpl.setUserName("");
		}
		else {
			ospFileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ospFileImpl.setCreateDate(null);
		}
		else {
			ospFileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ospFileImpl.setModifiedDate(null);
		}
		else {
			ospFileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ospFileImpl.setName("");
		}
		else {
			ospFileImpl.setName(name);
		}

		ospFileImpl.setSize(size);
		ospFileImpl.setStatus(status);

		ospFileImpl.resetOriginalValues();

		return ospFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ospFileId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		size = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ospFileId);

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

		objectOutput.writeLong(size);

		objectOutput.writeInt(status);
	}

	public long ospFileId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long size;
	public int status;

}