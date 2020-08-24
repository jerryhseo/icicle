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

import com.osp.icicle.service.base.OSPFileLocalServiceBaseImpl;

import java.io.File;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the osp file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icicle.service.OSPFileLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OSPFileLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icicle.model.OSPFile",
	service = AopService.class
)
public class OSPFileLocalServiceImpl extends OSPFileLocalServiceBaseImpl {

	public void connectServer(
			String serverIP, 
			String port, 
			String userId, 
			String password 
			) {
		
	}
	
	public void uploadFile( 
			String serverIP, 
			String port, 
			String userId, 
			String password, 
			File srcFile, 
			String targetDir, 
			boolean overlap,
			int security ) {
		
	}
	
	public void downloadFile(
		String serverIP, 
		String port, 
		String userId, 
		String password, 
		String targetDir, 
		int security) {
	}
	
	public void deleteFile() {
		
	}
	
	public void moveFile() {
		
	}
	
	public void copyFile() {
		
	}
	
	public void renameFile() {
		
	}
	
	public void execute() {
		
	}
	
	public void sendCommand() {
		
	}
	
	public void sendEMail() {
		
	}
}