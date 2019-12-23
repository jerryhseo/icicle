package com.osp.icicle.portlet;

import com.osp.icicle.constants.OSPIcebreakerEntryManagerPortletKeys;
import com.osp.icicle.service.IcebreakerEntryLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.osp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OSPIcebreakerEntryManager",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OSPIcebreakerEntryManagerPortletKeys.OSPICEBREAKERENTRYMANAGER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OSPIcebreakerEntryManagerPortlet extends MVCPortlet {
	@Reference
	private IcebreakerEntryLocalService _icebreakerEntryLocalService;
}