package com._wzzit_01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>succez</p>
 * @author wzz
 * @createdate 2018年9月12日
 */
public class Lianxi {
	
	//将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null
	public static byte[] file2buf(File fobj) {
		byte[] buffer = null;
		//若文件不存在则返回null
		if(!fobj.exists()){
			return null;
		}
		try {
			//获取输入字节
			FileInputStream fs =new FileInputStream(fobj);
			//字节数组输出流在内存中创建一个字节数组缓冲区
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int len = -1;
			//读取
			while((len = fs.read(b))!=-1){
				bos.write(b, 0, len);
			}
			fs.close();
			bos.close();
			buffer = bos.toByteArray();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	//使用任何你熟悉的语言实现函数intToHex，将一个整数转换为16进制的字符串（不能使用库函数）。
	@Test
	public void intToHex(){
		int a = 1000;
		String hex = "";
		while(a!=0){
			int b = a%16;
			hex = fun(b) + hex;
			a = a / 16;
		}
		System.out.println(hex);;
	}

	private char fun(int b) {
		if(b<=9&&b>=0){
			//将int转为char
			return (char)(b + '0');
		}else{
			return (char)(b - 10 + 'A');
		}
	}
	

}
