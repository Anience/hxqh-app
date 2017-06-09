package com.hxqh.eam.generate;

import com.hxqh.eam.common.FileUtil;

import java.io.*;

/**
 * 生成字段类
 *
 * @author lh
 */
public class GenerateDaoClass {


    public static void main(String[] args) throws IOException {
        File mboFile = new File("src/test/resources/dao.property");
        File daoImpl = new File("src/test/resources/daoImpl.property");

        //生成Mbo实体
        File file = new File("src/test/resources/table.list");
        String s = FileUtil.txt2String(file);
        //        System.out.println(s);
        String[] mBOName = s.split("\r\n");

        int i = 0;
        for (String string : mBOName) {
            if(i==0)
            {
                i++;
                continue;
            }
            String mboStr = FileUtil.txt2String(mboFile).replaceAll("XXXXX", string + "Dao").replaceAll("YYYYY", string);
            FileUtil.WriteStringToFile("src/" + string + "Dao" + ".java", mboStr);

            //daoImpl
            StringBuilder sb = new StringBuilder(string);
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
            String daoImplStr = FileUtil.txt2String(daoImpl).replaceAll("XXXX", string + "Dao").replaceAll("YYYY", string)
                    .replaceAll("ZZZZ", string + "DaoImpl").replaceAll("WWWW", sb.toString() + "Dao");
            FileUtil.WriteStringToFile("src/" + string + "DaoImpl" + ".java", daoImplStr);
            i++;
        }

        System.out.println("Generate Success!");
    }


}
