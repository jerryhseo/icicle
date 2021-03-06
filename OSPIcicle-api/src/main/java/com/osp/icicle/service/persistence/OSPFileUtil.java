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

package com.osp.icicle.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icicle.model.OSPFile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the osp file service. This utility wraps <code>com.osp.icicle.service.persistence.impl.OSPFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OSPFilePersistence
 * @generated
 */
@ProviderType
public class OSPFileUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(OSPFile ospFile) {
		getPersistence().clearCache(ospFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, OSPFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OSPFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OSPFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OSPFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OSPFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OSPFile update(OSPFile ospFile) {
		return getPersistence().update(ospFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OSPFile update(
		OSPFile ospFile, ServiceContext serviceContext) {

		return getPersistence().update(ospFile, serviceContext);
	}

	/**
	 * Caches the osp file in the entity cache if it is enabled.
	 *
	 * @param ospFile the osp file
	 */
	public static void cacheResult(OSPFile ospFile) {
		getPersistence().cacheResult(ospFile);
	}

	/**
	 * Caches the osp files in the entity cache if it is enabled.
	 *
	 * @param ospFiles the osp files
	 */
	public static void cacheResult(List<OSPFile> ospFiles) {
		getPersistence().cacheResult(ospFiles);
	}

	/**
	 * Creates a new osp file with the primary key. Does not add the osp file to the database.
	 *
	 * @param ospFileId the primary key for the new osp file
	 * @return the new osp file
	 */
	public static OSPFile create(long ospFileId) {
		return getPersistence().create(ospFileId);
	}

	/**
	 * Removes the osp file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file that was removed
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	public static OSPFile remove(long ospFileId)
		throws com.osp.icicle.exception.NoSuchOSPFileException {

		return getPersistence().remove(ospFileId);
	}

	public static OSPFile updateImpl(OSPFile ospFile) {
		return getPersistence().updateImpl(ospFile);
	}

	/**
	 * Returns the osp file with the primary key or throws a <code>NoSuchOSPFileException</code> if it could not be found.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	public static OSPFile findByPrimaryKey(long ospFileId)
		throws com.osp.icicle.exception.NoSuchOSPFileException {

		return getPersistence().findByPrimaryKey(ospFileId);
	}

	/**
	 * Returns the osp file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file, or <code>null</code> if a osp file with the primary key could not be found
	 */
	public static OSPFile fetchByPrimaryKey(long ospFileId) {
		return getPersistence().fetchByPrimaryKey(ospFileId);
	}

	/**
	 * Returns all the osp files.
	 *
	 * @return the osp files
	 */
	public static List<OSPFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the osp files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPFileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp files
	 * @param end the upper bound of the range of osp files (not inclusive)
	 * @return the range of osp files
	 */
	public static List<OSPFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the osp files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPFileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp files
	 * @param end the upper bound of the range of osp files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of osp files
	 */
	public static List<OSPFile> findAll(
		int start, int end, OrderByComparator<OSPFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPFileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp files
	 * @param end the upper bound of the range of osp files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of osp files
	 */
	public static List<OSPFile> findAll(
		int start, int end, OrderByComparator<OSPFile> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the osp files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of osp files.
	 *
	 * @return the number of osp files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OSPFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OSPFilePersistence, OSPFilePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSPFilePersistence.class);

		ServiceTracker<OSPFilePersistence, OSPFilePersistence> serviceTracker =
			new ServiceTracker<OSPFilePersistence, OSPFilePersistence>(
				bundle.getBundleContext(), OSPFilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}