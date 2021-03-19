package com.pindian.lonphy.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class PictureUtil {
	private String srcFile;
	private String destFile;
	private int width;
	private int height;
	private Image img;
	private int index;
	private String ext;
	private int destWidth;
	private int destHeight;
	/**
	 * ���캯��
	 * @param fileName String
	 * @throws IOException
	 */
	public PictureUtil(String fileName) throws IOException{
		File _file = new File(fileName);
		this.srcFile = fileName;
		index = this.srcFile.indexOf(".");
		ext = this.srcFile.substring(index);
//		this.destFile = this.srcFile.subSequence(0, index)+"_s"+ext;
		img = ImageIO.read(_file);
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	/**
	 * ǿ�ƷŴ�/ѹ��ͼƬ���̶��Ĵ�С
	 * @param w �¿��
	 * @param h �¸߶�
	 * @throws IOException 
	 */
	public void resize(int w, int h) throws IOException {
		BufferedImage _image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		_image.getGraphics().drawImage(img,0,0,w,h,null);
		this.destFile = this.srcFile.subSequence(0, index)+"_"+destWidth+"x"+destHeight+ext;
		FileOutputStream out = new FileOutputStream(destFile);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(_image);
		out.close();
	}
	/**
	 * ���չ̶��ı�������ͼƬ
	 * @param t double����
	 * @throws IOException
	 */
	public void resize(double t) throws IOException {
		int w = (int)(width * t);
		int h = (int)(height * t);
		resize(w,h);
	}
	/**
	 * �Կ��Ϊ��׼���ȱ�������ͼƬ
	 * @param w int �¿��
	 * @throws IOException
	 */
	public void resizeByWidth(int w) throws IOException{
		int h = (int)(height*w/width);
		resize(w,h);
	}
	/**
	 * �Ը߶�Ϊ��׼���ȱ�������ͼƬ
	 * @param h int �¸߶�
	 * @throws IOException
	 */
	public void resizeByHeight(int h) throws IOException{
		int w = (int)(width*h/height);
		resize(w,h);
	}
	/**
	 * �������߶����ƣ�������ĵȱ�������ͼ
	 * @param w
	 * 			int ���߶�
	 * @param h
	 * 			int �����
	 * @throws IOException
	 */
	public void resizeFix(int w, int h) throws IOException{
		destWidth = w;
		destHeight = h;
		if(width/height > w/h) {
			resizeByWidth(w);
		}else {
			resizeByHeight(h);
		}
	}
	/**
	 * ����Ŀ���ļ���
	 * @param fileName
	 * 		String �ļ����ַ�
	 * @throws Exception
	 */
	public void setDestFile(String fileName) throws Exception {
		if(!fileName.endsWith(".jpg")) {
			throw new Exception("Dest File must end with .jpg");
		}
		destFile = fileName;
	}
	
	/**
	 * ��ȡĿ���ļ��� getDestFile
	 */
	public String getDestFile() {
		return destFile;
	}

	/**
	 * ��ȡͼƬԭʼ��� getSrcWidth
	 */
	public int getSrcWidth() {
		return width;
	}

	/**
	 * ��ȡͼƬԭʼ�߶� getSrcHeight
	 */
	public int getSrcHeight() {
		return height;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
