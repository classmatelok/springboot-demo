package com.lok.common.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Lok
 */
public class FileTools {

	public static void main(String[] args) {
		copyFile("e:/testA.txt","e:/testB.txt");
	}
	
	/**
	 * 复制文件
	 * @param inputUrl 拷贝源url
	 * @param outputUrl 拷贝后url
	 */
	public static void copyFile(String inputUrl, String outputUrl){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(inputUrl);
			fos = new FileOutputStream(outputUrl);
			int len = 0;
			byte[] arr = new byte[1024];
			while ((len = fis.read(arr))!=-1) {
				fos.write(arr,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
