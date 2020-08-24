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

package com.osp.icicle.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link OSPFileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OSPFileLocalService
 * @generated
 */
@ProviderType
public class OSPFileLocalServiceWrapper
	implements OSPFileLocalService, ServiceWrapper<OSPFileLocalService> {

	public OSPFileLocalServiceWrapper(OSPFileLocalService ospFileLocalService) {
		_ospFileLocalService = ospFileLocalService;
	}

	/**
	 * Adds the osp file to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospFile the osp file
	 * @return the osp file that was added
	 */
	@Override
	public com.osp.icicle.model.OSPFile addOSPFile(
		com.osp.icicle.model.OSPFile ospFile) {

		return _ospFileLocalService.addOSPFile(ospFile);
	}

	/**
	 * Creates a new osp file with the primary key. Does not add the osp file to the database.
	 *
	 * @param ospFileId the primary key for the new osp file
	 * @return the new osp file
	 */
	@Override
	public com.osp.icicle.model.OSPFile createOSPFile(long ospFileId) {
		return _ospFileLocalService.createOSPFile(ospFileId);
	}

	/**
	 * Deletes the osp file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file that was removed
	 * @throws PortalException if a osp file with the primary key could not be found
	 */
	@Override
	public com.osp.icicle.model.OSPFile deleteOSPFile(long ospFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospFileLocalService.deleteOSPFile(ospFileId);
	}

	/**
	 * Deletes the osp file from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospFile the osp file
	 * @return the osp file that was removed
	 */
	@Override
	public com.osp.icicle.model.OSPFile deleteOSPFile(
		com.osp.icicle.model.OSPFile ospFile) {

		return _ospFileLocalService.deleteOSPFile(ospFile);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospFileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ospFileLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ospFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icicle.model.impl.OSPFileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ospFileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icicle.model.impl.OSPFileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ospFileLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ospFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ospFileLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.osp.icicle.model.OSPFile fetchOSPFile(long ospFileId) {
		return _ospFileLocalService.fetchOSPFile(ospFileId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ospFileLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ospFileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ospFileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the osp file with the primary key.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file
	 * @throws PortalException if a osp file with the primary key could not be found
	 */
	@Override
	public com.osp.icicle.model.OSPFile getOSPFile(long ospFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospFileLocalService.getOSPFile(ospFileId);
	}

	/**
	 * Returns a range of all the osp files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icicle.model.impl.OSPFileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp files
	 * @param end the upper bound of the range of osp files (not inclusive)
	 * @return the range of osp files
	 */
	@Override
	public java.util.List<com.osp.icicle.model.OSPFile> getOSPFiles(
		int start, int end) {

		return _ospFileLocalService.getOSPFiles(start, end);
	}

	/**
	 * Returns the number of osp files.
	 *
	 * @return the number of osp files
	 */
	@Override
	public int getOSPFilesCount() {
		return _ospFileLocalService.getOSPFilesCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the osp file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ospFile the osp file
	 * @return the osp file that was updated
	 */
	@Override
	public com.osp.icicle.model.OSPFile updateOSPFile(
		com.osp.icicle.model.OSPFile ospFile) {

		return _ospFileLocalService.updateOSPFile(ospFile);
	}

	@Override
	public OSPFileLocalService getWrappedService() {
		return _ospFileLocalService;
	}

	@Override
	public void setWrappedService(OSPFileLocalService ospFileLocalService) {
		_ospFileLocalService = ospFileLocalService;
	}

	private OSPFileLocalService _ospFileLocalService;

}