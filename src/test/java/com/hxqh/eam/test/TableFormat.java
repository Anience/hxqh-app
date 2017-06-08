package com.hxqh.eam.test;

import com.hxqh.eam.common.FileUtil;
import org.junit.Test;

import java.io.File;

/**
 * Created by Ocean Lin on 2017/6/8.
 */
public class TableFormat {

    @Test
    public void test() {
        File file = new File("src/test/resources/0410.log");
        String s = FileUtil.txt2String(file);
        //System.out.println(s);
        String[] split = s.split("\r\n");
        for (int i = 1; i < split.length; i++) {
            String[] rows = split[i].split("导出了");
            String[] split1 = rows[0].split("表");
            System.out.println(split1[1].trim());
            //System.out.println(rows[1]);
        }

    }

}
