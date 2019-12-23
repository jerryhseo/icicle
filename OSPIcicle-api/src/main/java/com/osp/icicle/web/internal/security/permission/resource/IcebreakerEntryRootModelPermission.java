/**
 * Copyright 2020-present Jerry H. Seo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.osp.icicle.web.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.osp.icicle.constants.OSPIcicleConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true
)
public class IcebreakerEntryRootModelPermission{
	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, String actionId) {

		return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
	}

	@Reference(
			target = "(resource.name=" + OSPIcicleConstants.ROOT_MODEL_RESOURCE_NAME + ")",
			unbind = "-"
			)
	protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {
		_portletResourcePermission = portletResourcePermission;
	}

	private static PortletResourcePermission _portletResourcePermission;
}