package com.hxqh.eam.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/9.
 */
public class StaticUtils {




    // 默认时间格式
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // 时间格式化
    private static DateFormat dateTimeFormat = null;

    static Map<String, String> map = new HashMap<>();

    static {
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
    }

    static {
        map.put("METRO", "1");
        map.put("PE", "2");
        map.put("TERA", "3");
    }
    /**
     * 日期格式化yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDateTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }


    public static Map<String, String> getMap()
    {
        return map;
    }

}
