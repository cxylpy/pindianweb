package com.pindian.lonphy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.pdf.PdfReader;
import com.opensymphony.xwork2.ActionSupport;
import com.pindian.lonphy.domain.Files;
import com.pindian.lonphy.domain.Images;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.FilesService;
import com.pindian.lonphy.service.ImageService;

/**
 * @author Lonphy
 * 
 */
public class UploadAction extends ActionSupport {
	private File image;
	private String imageFileName;
	private String imageContentType;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private ImageService iService = BaseFactory.getInstance(ImageService.class);
	private FilesService fService = BaseFactory.getInstance(FilesService.class);
	public String uploadImage() {
		String fileName = UUID.randomUUID().toString() + "_" + imageFileName;
		String hexString = Integer.toHexString(fileName.hashCode());
		char[] dirs = hexString.toCharArray();
		StringBuffer dirPath = new StringBuffer(ServletActionContext
				.getServletContext().getRealPath("/WEB-INF/upload/images"));
		StringBuffer urlPath = new StringBuffer();
		for (char c : dirs) {
			urlPath.append("/").append(c);
		}
		urlPath.append("/").append(fileName);
		dirPath.append(urlPath.toString());
		try {
			FileUtils.copyFile(image, new File(dirPath.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Images images = new Images(null, dirPath.toString(), urlPath.toString());
		iService.saveNewEntity(images);
		ServletActionContext.getRequest().setAttribute("result",
				urlPath.toString());
		return SUCCESS;
	}

	public String uploadFile() {
		String fileName = UUID.randomUUID().toString() + "_" + fileFileName;
		String hexString = Integer.toHexString(fileName.hashCode());
		char[] dirs = hexString.toCharArray();
		StringBuffer dirPath = new StringBuffer(ServletActionContext
				.getServletContext().getRealPath("/WEB-INF/upload/docs"));
		StringBuffer urlPath = new StringBuffer();
		for (char c : dirs) {
			urlPath.append("/").append(c);
		}
		urlPath.append("/").append(fileName);
		dirPath.append(urlPath.toString());
		try {
			FileUtils.copyFile(file, new File(dirPath.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Files files = new Files(null, dirPath.toString(), urlPath.toString());
		fService.saveNewEntity(files);
		String filePath = dirPath.toString();
		int numOfPages = 0;
		if (fileFileName.endsWith(".pdf")) {
			try {
				numOfPages = new PdfReader(filePath.toString())
						.getNumberOfPages();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (fileFileName.endsWith(".doc")) {
			try {
				FileInputStream fis = new FileInputStream(filePath);
				WordExtractor word = new WordExtractor(fis);
				numOfPages = word.getSummaryInformation().getPageCount();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (fileFileName.endsWith(".docx")) {
			try {
				FileInputStream fis = new FileInputStream(filePath);
				XWPFDocument docx = new XWPFDocument(fis);
				numOfPages = docx.getProperties().getExtendedProperties().getPages();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			ServletActionContext.getRequest().setAttribute("result", "error");
			return ERROR;
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("pdfUrlPath", urlPath.toString());
		ServletActionContext.getRequest().setAttribute("result",
				numOfPages + "");
		return SUCCESS;
	}

	public String queryProgress() {
		Integer progress = (Integer) ServletActionContext.getRequest()
				.getSession().getAttribute("progress");
		ServletActionContext.getRequest().setAttribute("result", progress + "");
		return SUCCESS;
	}

	public String readImage() {
		return SUCCESS;
	}

	public String readPdf() {
		return SUCCESS;
	}

	public String getByPath() {
		return SUCCESS;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
