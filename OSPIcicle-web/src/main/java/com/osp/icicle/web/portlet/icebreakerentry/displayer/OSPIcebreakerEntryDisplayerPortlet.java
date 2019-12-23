package com.osp.icicle.web.portlet.icebreakerentry.displayer;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.osp.icicle.constants.OSPIciclePortletKeys;
import com.osp.icicle.service.IcebreakerEntryLocalService;

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
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.display-name=Icebreaker Entries Displayer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/IcebreakerEntry/Displayer/view.jsp",
		"javax.portlet.name=" + OSPIciclePortletKeys.OSPIcebreakerEntryDisplayer,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OSPIcebreakerEntryDisplayerPortlet extends MVCPortlet {
	@Reference
	private IcebreakerEntryLocalService _icevreakerEntryLocalService;
	
}