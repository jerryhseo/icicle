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

package com.osp.icicle.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.osp.icicle.exception.NoSuchOSPFileException;
import com.osp.icicle.model.OSPFile;
import com.osp.icicle.model.impl.OSPFileImpl;
import com.osp.icicle.model.impl.OSPFileModelImpl;
import com.osp.icicle.service.persistence.OSPFilePersistence;
import com.osp.icicle.service.persistence.impl.constants.ICICLEPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the osp file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OSPFilePersistence.class)
@ProviderType
public class OSPFilePersistenceImpl
	extends BasePersistenceImpl<OSPFile> implements OSPFilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OSPFileUtil</code> to access the osp file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OSPFileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public OSPFilePersistenceImpl() {
		setModelClass(OSPFile.class);

		setModelImplClass(OSPFileImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("size", "size_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the osp file in the entity cache if it is enabled.
	 *
	 * @param ospFile the osp file
	 */
	@Override
	public void cacheResult(OSPFile ospFile) {
		entityCache.putResult(
			entityCacheEnabled, OSPFileImpl.class, ospFile.getPrimaryKey(),
			ospFile);

		ospFile.resetOriginalValues();
	}

	/**
	 * Caches the osp files in the entity cache if it is enabled.
	 *
	 * @param ospFiles the osp files
	 */
	@Override
	public void cacheResult(List<OSPFile> ospFiles) {
		for (OSPFile ospFile : ospFiles) {
			if (entityCache.getResult(
					entityCacheEnabled, OSPFileImpl.class,
					ospFile.getPrimaryKey()) == null) {

				cacheResult(ospFile);
			}
			else {
				ospFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all osp files.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OSPFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the osp file.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OSPFile ospFile) {
		entityCache.removeResult(
			entityCacheEnabled, OSPFileImpl.class, ospFile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OSPFile> ospFiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OSPFile ospFile : ospFiles) {
			entityCache.removeResult(
				entityCacheEnabled, OSPFileImpl.class, ospFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new osp file with the primary key. Does not add the osp file to the database.
	 *
	 * @param ospFileId the primary key for the new osp file
	 * @return the new osp file
	 */
	@Override
	public OSPFile create(long ospFileId) {
		OSPFile ospFile = new OSPFileImpl();

		ospFile.setNew(true);
		ospFile.setPrimaryKey(ospFileId);

		ospFile.setCompanyId(companyProvider.getCompanyId());

		return ospFile;
	}

	/**
	 * Removes the osp file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file that was removed
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	@Override
	public OSPFile remove(long ospFileId) throws NoSuchOSPFileException {
		return remove((Serializable)ospFileId);
	}

	/**
	 * Removes the osp file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the osp file
	 * @return the osp file that was removed
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	@Override
	public OSPFile remove(Serializable primaryKey)
		throws NoSuchOSPFileException {

		Session session = null;

		try {
			session = openSession();

			OSPFile ospFile = (OSPFile)session.get(
				OSPFileImpl.class, primaryKey);

			if (ospFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOSPFileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ospFile);
		}
		catch (NoSuchOSPFileException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OSPFile removeImpl(OSPFile ospFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ospFile)) {
				ospFile = (OSPFile)session.get(
					OSPFileImpl.class, ospFile.getPrimaryKeyObj());
			}

			if (ospFile != null) {
				session.delete(ospFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ospFile != null) {
			clearCache(ospFile);
		}

		return ospFile;
	}

	@Override
	public OSPFile updateImpl(OSPFile ospFile) {
		boolean isNew = ospFile.isNew();

		if (!(ospFile instanceof OSPFileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ospFile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ospFile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ospFile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OSPFile implementation " +
					ospFile.getClass());
		}

		OSPFileModelImpl ospFileModelImpl = (OSPFileModelImpl)ospFile;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ospFile.getCreateDate() == null)) {
			if (serviceContext == null) {
				ospFile.setCreateDate(now);
			}
			else {
				ospFile.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ospFileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ospFile.setModifiedDate(now);
			}
			else {
				ospFile.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ospFile.isNew()) {
				session.save(ospFile);

				ospFile.setNew(false);
			}
			else {
				ospFile = (OSPFile)session.merge(ospFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, OSPFileImpl.class, ospFile.getPrimaryKey(),
			ospFile, false);

		ospFile.resetOriginalValues();

		return ospFile;
	}

	/**
	 * Returns the osp file with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the osp file
	 * @return the osp file
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	@Override
	public OSPFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOSPFileException {

		OSPFile ospFile = fetchByPrimaryKey(primaryKey);

		if (ospFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOSPFileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ospFile;
	}

	/**
	 * Returns the osp file with the primary key or throws a <code>NoSuchOSPFileException</code> if it could not be found.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file
	 * @throws NoSuchOSPFileException if a osp file with the primary key could not be found
	 */
	@Override
	public OSPFile findByPrimaryKey(long ospFileId)
		throws NoSuchOSPFileException {

		return findByPrimaryKey((Serializable)ospFileId);
	}

	/**
	 * Returns the osp file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ospFileId the primary key of the osp file
	 * @return the osp file, or <code>null</code> if a osp file with the primary key could not be found
	 */
	@Override
	public OSPFile fetchByPrimaryKey(long ospFileId) {
		return fetchByPrimaryKey((Serializable)ospFileId);
	}

	/**
	 * Returns all the osp files.
	 *
	 * @return the osp files
	 */
	@Override
	public List<OSPFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OSPFile> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<OSPFile> findAll(
		int start, int end, OrderByComparator<OSPFile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<OSPFile> findAll(
		int start, int end, OrderByComparator<OSPFile> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<OSPFile> list = null;

		if (retrieveFromCache) {
			list = (List<OSPFile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OSPFILE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OSPFILE;

				if (pagination) {
					sql = sql.concat(OSPFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OSPFile>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OSPFile>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the osp files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OSPFile ospFile : findAll()) {
			remove(ospFile);
		}
	}

	/**
	 * Returns the number of osp files.
	 *
	 * @return the number of osp files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OSPFILE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ospFileId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OSPFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OSPFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the osp file persistence.
	 */
	@Activate
	public void activate() {
		OSPFileModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		OSPFileModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OSPFileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ICICLEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.osp.icicle.model.OSPFile"),
			true);
	}

	@Override
	@Reference(
		target = ICICLEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ICICLEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OSPFILE =
		"SELECT ospFile FROM OSPFile ospFile";

	private static final String _SQL_COUNT_OSPFILE =
		"SELECT COUNT(ospFile) FROM OSPFile ospFile";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ospFile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OSPFile exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		OSPFilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"size"});

}