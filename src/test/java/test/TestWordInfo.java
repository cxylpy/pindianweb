package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

public class TestWordInfo {
	public static void main(String[] args){
//		try {
//			FileInputStream fis = new FileInputStream("c://test.docx");
//			WordExtractor word = new WordExtractor(fis);
//			System.out.println("大声告诉我，你有多少页！！！ "+word.getSummaryInformation().getPageCount());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			try {
				FileInputStream fis = new FileInputStream("c://test.docx");
				XWPFDocument docx = new XWPFDocument(fis);
				System.out.println("大声告诉我，你有多少页！！！ "+docx.getProperties().getExtendedProperties().getPages());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
//	@Test
	public void testGetPAges() {
//		try {
//			FileInputStream fis = new FileInputStream("c://test.docx");
//			XWPFDocument docx = new XWPFDocument(fis);
//			System.out.println("大声告诉我，你有多少页！！！ "+docx.getProperties().getExtendedProperties().getPages());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			FileInputStream fis = new FileInputStream("c://test.doc");
			WordExtractor word = new WordExtractor(fis);
			System.out.println("大声告诉我，你有多少页！！！ "+word.getSummaryInformation().getPageCount());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
