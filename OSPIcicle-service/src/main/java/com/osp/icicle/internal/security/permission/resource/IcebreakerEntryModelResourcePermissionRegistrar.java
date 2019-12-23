package com.osp.icicle.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.osp.icicle.constants.OSPIcicleConstants;
import com.osp.icicle.constants.OSPIciclePortletKeys;
import com.osp.icicle.model.IcebreakerEntry;
import com.osp.icicle.service.IcebreakerEntryLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;;

@Component(immediate = true)
public class IcebreakerEntryModelResourcePermissionRegistrar {
	@Activate
	public void activate(BundleContext bundleContext) {
		 Dictionary<String, Object> properties = new HashMapDictionary<>();

		 properties.put("model.class.name", IcebreakerEntry.class.getName());
		 _serviceRegistration = bundleContext.registerService(
					ModelResourcePermission.class,
					ModelResourcePermissionFactory.create(
							IcebreakerEntry.class, 
							IcebreakerEntry::getPrimaryKey,
							_icebreakerEntryLocalService::getIcebreakerEntry, 
							_portletResourcePermission,
							(modelResourcePermission, consumer) -> {
									consumer.accept(
											new StagedModelPermissionLogic<IcebreakerEntry>(
													_stagingPermission, 
													OSPIciclePortletKeys.OSPIcebreakerEntryAdmin,
													IcebreakerEntry::getPrimaryKey));
									consumer.accept(
											new WorkflowedModelPermissionLogic<IcebreakerEntry>(
													_workflowPermission, 
													modelResourcePermission,
													_groupLocalService,
													IcebreakerEntry::getPrimaryKey));
							}),
					properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	private IcebreakerEntryLocalService _icebreakerEntryLocalService;

	@Reference(target = "(resource.name=" + OSPIcicleConstants.ROOT_MODEL_RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;
	
	@Reference
    private GroupLocalService _groupLocalService;
}
