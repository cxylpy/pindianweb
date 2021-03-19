package com.pindian.lonphy.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class FileUploadListener implements ProgressListener{
	private HttpSession session;
	
	public FileUploadListener(HttpSession session) {
		super();
		this.session = session;
	}

	@Override
	public void update(long readedBytes, long totalBytes, int currentItem) {
		int progress = (int) (100*readedBytes/totalBytes);
		session.setAttribute("progress", progress);
	}

}
