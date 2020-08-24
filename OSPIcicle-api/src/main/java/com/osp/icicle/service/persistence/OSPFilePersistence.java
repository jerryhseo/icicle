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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.osp.icicle.exception.NoSuchOSPFileException;
import com.osp.icicle.model.OSPFile;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the osp file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OSPFileUtil
 * @generated
 */
@ProviderType
public interface OSPFilePersistence extends BasePersistence<OSPFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OSPFileUtil} to access the osp file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the osp file in the entity cache if it is enabled.
	 *
	 * @param ospFile the osp file
	 */
	public void cacheResult(OSPFile ospFile);

	/**
	 * Caches the osp files in the entity cache if it is enabled.
	 *
	 * @param ospFiles the osp files
	 */
	public void cacheResult(java.util.List<OSPFile> ospFiles);

	/**
	 * Creates a new osp file with the primary key. Does not add the osp file to the database.
	 *
	 * @param ospFileId the primary key for the new osp file
	 * @return the new osp file
	 */
	public OSPFile create(long ospFileId);

	/**
	 * Removes the osp file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file that was removed
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	public OSPFile remove(long ospFileId) throws NoSuchOSPFileException;

	public OSPFile updateImpl(OSPFile ospFile);

	/**
	 * Returns the osp file with the primary key or throws a <code>NoSuchOSPFileException</code> if it could not be found.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	public OSPFile findByPrimaryKey(long ospFileId)
		throws NoSuchOSPFileException;

	/**
	 * Returns the osp file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file, or <code>null</code> if a osp file with the primary key could not be found
	 */
	public OSPFile fetchByPrimaryKey(long ospFileId);

	/**
	 * Returns all the osp files.
	 *
	 * @return the osp files
	 */
	public java.util.List<OSPFile> findAll();

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
	public java.util.List<OSPFile> findAll(int start, int end);

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
	public java.util.List<OSPFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPFile>
			orderByComparator);

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
	public java.util.List<OSPFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPFile>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the osp files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of osp files.
	 *
	 * @return the number of osp files
	 */
	public int countAll();

}