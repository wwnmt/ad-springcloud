package edu.nuaa.wwn.ad.util;


import edu.nuaa.wwn.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-26
 * Time: 18:09
 */
public class CommonUtils {

    private static String[] patterns = {
            "yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd"
    };

    public static String md5(String value) {
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    public static Date String2Date(String dateString) throws AdException {
        try {
            return DateUtils.parseDate(dateString, patterns);
        } catch (ParseException e) {
            throw new AdException(e.getMessage());
        }
    }
}
