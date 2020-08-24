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

package com.osp.icicle.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.osp.icicle.service.http.OSPFileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class OSPFileSoap implements Serializable {

	public static OSPFileSoap toSoapModel(OSPFile model) {
		OSPFileSoap soapModel = new OSPFileSoap();

		soapModel.setOspFileId(model.getOspFileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setSize(model.getSize());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OSPFileSoap[] toSoapModels(OSPFile[] models) {
		OSPFileSoap[] soapModels = new OSPFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OSPFileSoap[][] toSoapModels(OSPFile[][] models) {
		OSPFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OSPFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OSPFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OSPFileSoap[] toSoapModels(List<OSPFile> models) {
		List<OSPFileSoap> soapModels = new ArrayList<OSPFileSoap>(
			models.size());

		for (OSPFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OSPFileSoap[soapModels.size()]);
	}

	public OSPFileSoap() {
	}

	public long getPrimaryKey() {
		return _ospFileId;
	}

	public void setPrimaryKey(long pk) {
		setOspFileId(pk);
	}

	public long getOspFileId() {
		return _ospFileId;
	}

	public void setOspFileId(long ospFileId) {
		_ospFileId = ospFileId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _ospFileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _size;
	private int _status;

}