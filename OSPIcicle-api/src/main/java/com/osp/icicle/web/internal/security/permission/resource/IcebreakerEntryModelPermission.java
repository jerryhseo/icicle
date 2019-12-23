package com.osp.icicle.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.osp.icicle.constants.OSPIcicleConstants;
import com.osp.icicle.model.IcebreakerEntry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class IcebreakerEntryModelPermission {
	public static boolean contains(
			PermissionChecker permissionChecker, 
			IcebreakerEntry entry,
			String actionId) throws PortalException {
		return _icebreakerEntryFolderModelResourcePermission.contains(
										permissionChecker, entry, actionId);
	}

	public static boolean contains( PermissionChecker permissionChecker, long entryId, String actionId)
			throws PortalException {

		return _icebreakerEntryFolderModelResourcePermission.contains(permissionChecker, entryId, actionId);
	}

	@Reference(
			target = "(model.class.name=" + OSPIcicleConstants.ICEBREAKERENTRY_MODEL_RESOURCE_NAME + ")",
			unbind = "-"
	)
	protected void setEntryModelPermission(
			ModelResourcePermission<IcebreakerEntry> modelResourcePermission) {

		_icebreakerEntryFolderModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<IcebreakerEntry>
					_icebreakerEntryFolderModelResourcePermission;
}
