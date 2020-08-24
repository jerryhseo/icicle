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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link OSPFile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OSPFile
 * @generated
 */
@ProviderType
public class OSPFileWrapper
	extends BaseModelWrapper<OSPFile>
	implements OSPFile, ModelWrapper<OSPFile> {

	public OSPFileWrapper(OSPFile ospFile) {
		super(ospFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ospFileId", getOspFileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("size", getSize());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ospFileId = (Long)attributes.get("ospFileId");

		if (ospFileId != null) {
			setOspFileId(ospFileId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this osp file.
	 *
	 * @return the company ID of this osp file
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this osp file.
	 *
	 * @return the create date of this osp file
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this osp file.
	 *
	 * @return the group ID of this osp file
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this osp file.
	 *
	 * @return the modified date of this osp file
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this osp file.
	 *
	 * @return the name of this osp file
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the osp file ID of this osp file.
	 *
	 * @return the osp file ID of this osp file
	 */
	@Override
	public long getOspFileId() {
		return model.getOspFileId();
	}

	/**
	 * Returns the primary key of this osp file.
	 *
	 * @return the primary key of this osp file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the size of this osp file.
	 *
	 * @return the size of this osp file
	 */
	@Override
	public long getSize() {
		return model.getSize();
	}

	/**
	 * Returns the status of this osp file.
	 *
	 * @return the status of this osp file
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this osp file.
	 *
	 * @return the user ID of this osp file
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this osp file.
	 *
	 * @return the user name of this osp file
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this osp file.
	 *
	 * @return the user uuid of this osp file
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this osp file.
	 *
	 * @param companyId the company ID of this osp file
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this osp file.
	 *
	 * @param createDate the create date of this osp file
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this osp file.
	 *
	 * @param groupId the group ID of this osp file
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this osp file.
	 *
	 * @param modifiedDate the modified date of this osp file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this osp file.
	 *
	 * @param name the name of this osp file
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the osp file ID of this osp file.
	 *
	 * @param ospFileId the osp file ID of this osp file
	 */
	@Override
	public void setOspFileId(long ospFileId) {
		model.setOspFileId(ospFileId);
	}

	/**
	 * Sets the primary key of this osp file.
	 *
	 * @param primaryKey the primary key of this osp file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the size of this osp file.
	 *
	 * @param size the size of this osp file
	 */
	@Override
	public void setSize(long size) {
		model.setSize(size);
	}

	/**
	 * Sets the status of this osp file.
	 *
	 * @param status the status of this osp file
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this osp file.
	 *
	 * @param userId the user ID of this osp file
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this osp file.
	 *
	 * @param userName the user name of this osp file
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this osp file.
	 *
	 * @param userUuid the user uuid of this osp file
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OSPFileWrapper wrap(OSPFile ospFile) {
		return new OSPFileWrapper(ospFile);
	}

}