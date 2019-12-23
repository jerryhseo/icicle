package com.osp.icicle.web.portlet.icebreakerentry.admin;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icicle.constants.OSPIciclePortletKeys;
import com.osp.icicle.model.IcebreakerEntry;
import com.osp.icicle.service.IcebreakerEntryLocalService;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.display-name=Icebreaker Entries Admin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/IcebreakerEntry/Admin/view.jsp",
		"javax.portlet.name=" + OSPIciclePortletKeys.OSPIcebreakerEntryAdmin,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OSPIcebreakerEntryAdminPortlet extends MVCPortlet {
	@Reference
	private IcebreakerEntryLocalService _icevreakerEntryLocalService;
	
	public void addIcebreakerEntry( ActionRequest request, ActionResponse response ) throws PortalException {
		ServiceContext sc = ServiceContextFactory.getInstance(IcebreakerEntry.class.getName(), request);
		
		String name = ParamUtil.getString(request, "name" );
		String type = ParamUtil.getString(request,  "type");
		String ibIp = ParamUtil.getString(request,  "ibIp");
		String ibPort = ParamUtil.getString(request,  "ibPort");
		String ibUserId = ParamUtil.getString(request,  "ibUserId");
		String ibUserPassword = ParamUtil.getString(request,  "ibUserPassword");
		
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(request, "description");
		
		try {
			this._icevreakerEntryLocalService.addIcebreakerEntry(name, type, ibIp, ibPort, ibUserId, ibUserPassword, descriptionMap, sc);
		}
		catch( PortalException e ) {
			Logger.getLogger(OSPIcebreakerEntryAdminPortlet.class.getName())
					.log(Level.SEVERE, null, e);
			
			response.setRenderParameter("mvcPath", "/IcebreakerEntry/Admin/edit-icebreaker-entry.jsp");
		}
	}
	
	public void updateIcebreakerEntry( ActionRequest request, ActionResponse response ) throws PortalException {
		ServiceContext sc = ServiceContextFactory.getInstance(IcebreakerEntry.class.getName(), request);
		
		long icebreakerId = ParamUtil.getLong(request, "icebreakerId");
		String name = ParamUtil.getString(request, "name" );
		String type = ParamUtil.getString(request,  "type");
		String ibIp = ParamUtil.getString(request,  "ibIp");
		String ibPort = ParamUtil.getString(request,  "ibPort");
		String ibUserId = ParamUtil.getString(request,  "ibUserId");
		String ibUserPassword = ParamUtil.getString(request,  "ibUserPassword");
		
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(request, "description");
		
		try {
			this._icevreakerEntryLocalService.updateIcebreakerEntry(icebreakerId, name, type, ibIp, ibPort, ibUserId, ibUserPassword, descriptionMap, sc);
		}
		catch( PortalException e ) {
			Logger.getLogger(OSPIcebreakerEntryAdminPortlet.class.getName())
					.log(Level.SEVERE, null, e);
			
			response.setRenderParameter("mvcPath", "/IcebreakerEntry/Admin/edit-icebreaker-entry.jsp");
		}
	}

	public void deleteIcebreakerEntry( ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext sc = ServiceContextFactory.getInstance(IcebreakerEntry.class.getName(), request);

		long icebreakerId = ParamUtil.getLong(request, "icebreakerId");
		try {
			this._icevreakerEntryLocalService.removeIcebreakerEntry(icebreakerId);
		}
		catch( PortalException e ) {
			Logger.getLogger(OSPIcebreakerEntryAdminPortlet.class.getName())
					.log(Level.SEVERE, null, e);
		}
	}
}