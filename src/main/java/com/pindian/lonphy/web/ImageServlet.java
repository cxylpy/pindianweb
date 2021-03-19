package com.pindian.lonphy.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pindian.lonphy.util.PictureUtil;

public class ImageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getParameter("path");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String destPath = null;
		int size;
		File destFile = null;
		byte[] bytes = null;
		if (width != null && height != null) {
			int index = path.indexOf('.');
			String ext = path.substring(index);

			destPath = path.subSequence(0, index) + "_" + width + "x"
					+ height + ext;
			destFile = new File(getServletConfig().getServletContext()
					.getRealPath("WEB-INF/upload/images") + destPath);
			if (!destFile.exists()) {
				new PictureUtil(getServletConfig().getServletContext()
						.getRealPath("WEB-INF/upload/images")+path).resizeFix(Integer.parseInt(width),
						Integer.parseInt(height));
			}
		} else {
			destFile = new File(getServletConfig().getServletContext()
					.getRealPath("WEB-INF/upload/images")+path);
		}
		FileInputStream fis = new FileInputStream(destFile);
		size = fis.available();
		bytes = new byte[size];
		fis.read(bytes);
		response.getOutputStream().write(bytes);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
