package com.pindian.lonphy.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DocServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DocServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
//		String path = request.getParameter("path");
		String path = (String) request.getSession().getAttribute("pdfUrlPath");
		path = path.substring(0, path.lastIndexOf('.'))+".pdf";
		File f = new File(getServletConfig().getServletContext().getRealPath("WEB-INF/upload/docs")+path);
		FileInputStream fis = new FileInputStream(f);
		int size = fis.available();
		byte[] bytes = new byte[size];
		fis.read(bytes);
		response.getOutputStream().write(bytes);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
