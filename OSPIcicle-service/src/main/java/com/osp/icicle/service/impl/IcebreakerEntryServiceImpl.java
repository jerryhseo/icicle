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
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.osp.icicle.constants.OSPIcicleConstants;
import com.osp.icicle.model.IcebreakerEntry;
import com.osp.icicle.service.base.IcebreakerEntryServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the icebreaker entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icicle.service.IcebreakerEntryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IcebreakerEntryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=icicle",
		"json.web.service.context.path=IcebreakerEntry"
	},
	service = AopService.class
)
public class IcebreakerEntryServiceImpl extends IcebreakerEntryServiceBaseImpl {

	private static volatile ModelResourcePermission<IcebreakerEntry>
					_icebreakerEntryFolderModelResourcePermission =
											ModelResourcePermissionFactory.getInstance(
																IcebreakerEntryServiceImpl.class,
																"_icebreakerEntryFolderModelResourcePermission", 
																IcebreakerEntry.class);
	private static volatile PortletResourcePermission
					_portletResourcePermission =
											PortletResourcePermissionFactory.getInstance(
																IcebreakerEntryServiceImpl.class, 
																"_portletResourcePermission",
																OSPIcicleConstants.ROOT_MODEL_RESOURCE_NAME);
	
	@Override
	public IcebreakerEntry addIcebreakerEntry(
			String name, 
			String type, 
			String ip, 
			String port, 
			String ibUserId, 
			String ibUserPassword,
			String description,
			ServiceContext sc) throws PortalException {
		
		_portletResourcePermission.check(super.getPermissionChecker(), sc.getScopeGroupId(), ActionKeys.ADD_ENTRY);
		
		
		return super.icebreakerEntryLocalService.addIcebreakerEntry(
				name, 
				type, 
				ip, 
				port, 
				ibUserId, 
				ibUserPassword, 
				null,
				sc);
	}
	
}