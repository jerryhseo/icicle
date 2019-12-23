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

package com.osp.icicle.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.osp.icicle.model.IcebreakerEntry;
import com.osp.icicle.service.base.IcebreakerEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the icebreakerEntry entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icicle.service.IcebreakerEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IcebreakerEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icicle.model.IcebreakerEntry",
	service = AopService.class
)
public class IcebreakerEntryLocalServiceImpl
	extends IcebreakerEntryLocalServiceBaseImpl {
	public IcebreakerEntry addIcebreakerEntry( 
			String name, 
			String type, 
			String ibIp, 
			String ibPort, 
			String ibUserId, 
			String ibUserPassword, 
			Map<Locale, String> descriptionMap,
			ServiceContext sc) throws PortalException {
		long icebreakerEntryId = super.counterLocalService.increment();
		IcebreakerEntry ib = super.createIcebreakerEntry(icebreakerEntryId);
		ib.setName(name);
		ib.setType(type);
		ib.setIbIp(ibIp);
		ib.setIbPort(ibPort);
		ib.setIbUserId(ibUserId);
		ib.setIbUserPassword(ibUserPassword);
		
		ib.setDescriptionMap(descriptionMap);
		
		long companyId = sc.getCompanyId();
		ib.setCompanyId(companyId);
		
		ib.setGroupId( sc.getScopeGroupId() );
		User user =  UserLocalServiceUtil.getUser(sc.getUserId());
		
		ib.setUserId(user.getUserId());
		ib.setUserName(user.getFullName());
		
		Date createDate = sc.getCreateDate();
		if( Validator.isNull(createDate)) {
			createDate = new Date();
		}
		ib.setCreateDate(createDate);
		ib.setModifiedDate(createDate);
		
		super.icebreakerEntryPersistence.update(ib);
		
		/*
		super.resourceLocalService.addResources(
				companyId, 
				ib.getGroupId(), 
				ib.getUserId(), 
				IcebreakerEntry.class.getName(), 
				ib.getPrimaryKey(), 
				false, 
				true, 
				true);
		*/
		return ib;
	}
	
	public IcebreakerEntry deleteIcebreakerEntry( long icebreakerEntryId ) throws PortalException {
		return removeIcebreakerEntry( icebreakerEntryId );
	}
	
	public IcebreakerEntry deleteIcebreakerEntry( IcebreakerEntry ib ) throws PortalException {
		return removeIcebreakerEntry( ib );
	}
	
	public IcebreakerEntry removeIcebreakerEntry( long icebreakerEntryId ) throws PortalException {
		IcebreakerEntry ib = super.deleteIcebreakerEntry(icebreakerEntryId);
		super.resourceLocalService.deleteResource(
					ib.getCompanyId(), 
					IcebreakerEntry.class.getName(), 
					ResourceConstants.SCOPE_INDIVIDUAL, 
					ib.getPrimaryKey() );
		
		return ib;
	}
	
	public IcebreakerEntry removeIcebreakerEntry( IcebreakerEntry ib ) throws PortalException {
		return removeIcebreakerEntry(ib.getPrimaryKey());
	}
	
	public IcebreakerEntry updateIcebreakerEntry(
			long icebreakerEntryId,
			String name, 
			String type, 
			String ibIp, 
			String ibPort, 
			String ibUserId, 
			String ibUserPassword,
			Map<Locale, String> descriptionMap,
			ServiceContext sc
			) throws PortalException {
		IcebreakerEntry ib = super.getIcebreakerEntry(icebreakerEntryId);
		ib.setName(name);
		ib.setType(type);
		ib.setIbIp(ibIp);
		ib.setIbPort(ibPort);
		ib.setIbUserId(ibUserId);
		ib.setIbUserPassword(ibUserPassword);
		ib.setDescriptionMap(descriptionMap);
		
		Date modifiedDate = sc.getModifiedDate();
		if( Validator.isNull(modifiedDate)) {
			modifiedDate = new Date();
		}
		ib.setModifiedDate(modifiedDate);
		
		ib.setExpandoBridgeAttributes(sc);

		super.icebreakerEntryPersistence.update(ib);
		
		return ib;
	}
}