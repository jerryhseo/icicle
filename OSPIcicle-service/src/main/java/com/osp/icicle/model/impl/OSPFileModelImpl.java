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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.osp.icicle.model.OSPFile;
import com.osp.icicle.model.OSPFileModel;
import com.osp.icicle.model.OSPFileSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the OSPFile service. Represents a row in the &quot;ICICLE_OSPFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>OSPFileModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OSPFileImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OSPFileImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class OSPFileModelImpl
	extends BaseModelImpl<OSPFile> implements OSPFileModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a osp file model instance should use the <code>OSPFile</code> interface instead.
	 */
	public static final String TABLE_NAME = "ICICLE_OSPFile";

	public static final Object[][] TABLE_COLUMNS = {
		{"ospFileId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"size_", Types.BIGINT}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ospFileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("size_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ICICLE_OSPFile (ospFileId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,size_ LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table ICICLE_OSPFile";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ospFile.ospFileId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ICICLE_OSPFile.ospFileId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OSPFile toModel(OSPFileSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OSPFile model = new OSPFileImpl();

		model.setOspFileId(soapModel.getOspFileId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setSize(soapModel.getSize());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OSPFile> toModels(OSPFileSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OSPFile> models = new ArrayList<OSPFile>(soapModels.length);

		for (OSPFileSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public OSPFileModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ospFileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOspFileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ospFileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OSPFile.class;
	}

	@Override
	public String getModelClassName() {
		return OSPFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<OSPFile, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<OSPFile, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<OSPFile, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((OSPFile)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<OSPFile, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<OSPFile, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(OSPFile)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<OSPFile, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<OSPFile, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, OSPFile>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			OSPFile.class.getClassLoader(), OSPFile.class, ModelWrapper.class);

		try {
			Constructor<OSPFile> constructor =
				(Constructor<OSPFile>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<OSPFile, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<OSPFile, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<OSPFile, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<OSPFile, Object>>();
		Map<String, BiConsumer<OSPFile, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<OSPFile, ?>>();

		attributeGetterFunctions.put("ospFileId", OSPFile::getOspFileId);
		attributeSetterBiConsumers.put(
			"ospFileId", (BiConsumer<OSPFile, Long>)OSPFile::setOspFileId);
		attributeGetterFunctions.put("groupId", OSPFile::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<OSPFile, Long>)OSPFile::setGroupId);
		attributeGetterFunctions.put("companyId", OSPFile::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<OSPFile, Long>)OSPFile::setCompanyId);
		attributeGetterFunctions.put("userId", OSPFile::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<OSPFile, Long>)OSPFile::setUserId);
		attributeGetterFunctions.put("userName", OSPFile::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<OSPFile, String>)OSPFile::setUserName);
		attributeGetterFunctions.put("createDate", OSPFile::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<OSPFile, Date>)OSPFile::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", OSPFile::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<OSPFile, Date>)OSPFile::setModifiedDate);
		attributeGetterFunctions.put("name", OSPFile::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<OSPFile, String>)OSPFile::setName);
		attributeGetterFunctions.put("size", OSPFile::getSize);
		attributeSetterBiConsumers.put(
			"size", (BiConsumer<OSPFile, Long>)OSPFile::setSize);
		attributeGetterFunctions.put("status", OSPFile::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<OSPFile, Integer>)OSPFile::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getOspFileId() {
		return _ospFileId;
	}

	@Override
	public void setOspFileId(long ospFileId) {
		_ospFileId = ospFileId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public long getSize() {
		return _size;
	}

	@Override
	public void setSize(long size) {
		_size = size;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), OSPFile.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OSPFile toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OSPFileImpl ospFileImpl = new OSPFileImpl();

		ospFileImpl.setOspFileId(getOspFileId());
		ospFileImpl.setGroupId(getGroupId());
		ospFileImpl.setCompanyId(getCompanyId());
		ospFileImpl.setUserId(getUserId());
		ospFileImpl.setUserName(getUserName());
		ospFileImpl.setCreateDate(getCreateDate());
		ospFileImpl.setModifiedDate(getModifiedDate());
		ospFileImpl.setName(getName());
		ospFileImpl.setSize(getSize());
		ospFileImpl.setStatus(getStatus());

		ospFileImpl.resetOriginalValues();

		return ospFileImpl;
	}

	@Override
	public int compareTo(OSPFile ospFile) {
		long primaryKey = ospFile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OSPFile)) {
			return false;
		}

		OSPFile ospFile = (OSPFile)obj;

		long primaryKey = ospFile.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		OSPFileModelImpl ospFileModelImpl = this;

		ospFileModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<OSPFile> toCacheModel() {
		OSPFileCacheModel ospFileCacheModel = new OSPFileCacheModel();

		ospFileCacheModel.ospFileId = getOspFileId();

		ospFileCacheModel.groupId = getGroupId();

		ospFileCacheModel.companyId = getCompanyId();

		ospFileCacheModel.userId = getUserId();

		ospFileCacheModel.userName = getUserName();

		String userName = ospFileCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ospFileCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ospFileCacheModel.createDate = createDate.getTime();
		}
		else {
			ospFileCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ospFileCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ospFileCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ospFileCacheModel.name = getName();

		String name = ospFileCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ospFileCacheModel.name = null;
		}

		ospFileCacheModel.size = getSize();

		ospFileCacheModel.status = getStatus();

		return ospFileCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<OSPFile, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<OSPFile, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<OSPFile, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((OSPFile)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<OSPFile, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<OSPFile, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<OSPFile, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((OSPFile)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, OSPFile>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ospFileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private long _size;
	private int _status;
	private OSPFile _escapedModel;

}