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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the OSPFile service. Represents a row in the &quot;ICICLE_OSPFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.osp.icicle.model.impl.OSPFileModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.osp.icicle.model.impl.OSPFileImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OSPFile
 * @generated
 */
@ProviderType
public interface OSPFileModel
	extends BaseModel<OSPFile>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a osp file model instance should use the {@link OSPFile} interface instead.
	 */

	/**
	 * Returns the primary key of this osp file.
	 *
	 * @return the primary key of this osp file
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this osp file.
	 *
	 * @param primaryKey the primary key of this osp file
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the osp file ID of this osp file.
	 *
	 * @return the osp file ID of this osp file
	 */
	public long getOspFileId();

	/**
	 * Sets the osp file ID of this osp file.
	 *
	 * @param ospFileId the osp file ID of this osp file
	 */
	public void setOspFileId(long ospFileId);

	/**
	 * Returns the group ID of this osp file.
	 *
	 * @return the group ID of this osp file
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this osp file.
	 *
	 * @param groupId the group ID of this osp file
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this osp file.
	 *
	 * @return the company ID of this osp file
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this osp file.
	 *
	 * @param companyId the company ID of this osp file
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this osp file.
	 *
	 * @return the user ID of this osp file
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this osp file.
	 *
	 * @param userId the user ID of this osp file
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this osp file.
	 *
	 * @return the user uuid of this osp file
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this osp file.
	 *
	 * @param userUuid the user uuid of this osp file
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this osp file.
	 *
	 * @return the user name of this osp file
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this osp file.
	 *
	 * @param userName the user name of this osp file
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this osp file.
	 *
	 * @return the create date of this osp file
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this osp file.
	 *
	 * @param createDate the create date of this osp file
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this osp file.
	 *
	 * @return the modified date of this osp file
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this osp file.
	 *
	 * @param modifiedDate the modified date of this osp file
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this osp file.
	 *
	 * @return the name of this osp file
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this osp file.
	 *
	 * @param name the name of this osp file
	 */
	public void setName(String name);

	/**
	 * Returns the size of this osp file.
	 *
	 * @return the size of this osp file
	 */
	public long getSize();

	/**
	 * Sets the size of this osp file.
	 *
	 * @param size the size of this osp file
	 */
	public void setSize(long size);

	/**
	 * Returns the status of this osp file.
	 *
	 * @return the status of this osp file
	 */
	public int getStatus();

	/**
	 * Sets the status of this osp file.
	 *
	 * @param status the status of this osp file
	 */
	public void setStatus(int status);

}