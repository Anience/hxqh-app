package com.hxqh.eam.generate;

import com.hxqh.eam.common.FileUtil;

import java.io.*;

/**
 * 生成字段类
 * @author lh
 *
 */
public class GenerateDaoClass {

	private static String[] MBOName = {"App","Attribute","Domain"};
	

	public static void main(String[] args) throws IOException {
		File mboFile = new File("src/test/resources/dao.property");
		File daoImpl = new File("src/test/resources/daoImpl.property");

		for (String string : MBOName) {
			String mboStr = FileUtil.txt2String(mboFile).replaceAll("XXXXX", string+"Dao").replaceAll("YYYYY",string);
			FileUtil.WriteStringToFile("src/"+string+"Dao"+".java",mboStr);

			//daoImpl
			StringBuilder sb = new StringBuilder(string);
			sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
			String daoImplStr = FileUtil.txt2String(daoImpl).replaceAll("XXXX", string+"Dao").replaceAll("YYYY",string)
					.replaceAll("ZZZZ",string+"DaoImpl").replaceAll("WWWW",sb.toString()+ "Dao");
			FileUtil.WriteStringToFile("src/"+string+"DaoImpl"+".java",daoImplStr);
		}
		
		System.out.println("Generate Success!");
	}


}
