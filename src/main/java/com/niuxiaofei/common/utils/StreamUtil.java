package com.niuxiaofei.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 
 * @ClassName: StreamUtil
 * @Description:流处理类
 * @author:nxf
 * @date 2019年9月20日
 *
 */
public class StreamUtil {
	/*
	 * 方法1：批量关闭流，参数能传入无限个。(10分)
	 * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	 */
	public static void closeAll(AutoCloseable... aotuAutoCloseable) throws Exception {
		for (AutoCloseable autoCloseable : aotuAutoCloseable) {
			autoCloseable.close();
		}
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	 */
	public static String readTextFile(InputStream src) throws Exception {
		byte[] b = new byte[1024];
		String result = "";
		while (src.read(b) > -1) {
			result += b;
		}
		closeAll(src);
		return result;
	}

	public static void main(String[] args) throws Exception {
		/*
		 * InputStream src = new FileInputStream(new File("H:\\Photo\\a.txt")); String
		 * readTextFile = readTextFile(src); System.out.println(readTextFile);
		 */
		File file = new File("H:\\\\Photo\\\\a.txt");
		System.out.println(readTextFile(file));
		
	}

	/*
	 * 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) throws Exception {
		InputStream src = new FileInputStream(txtFile);
		return readTextFile(src);
	}
}
