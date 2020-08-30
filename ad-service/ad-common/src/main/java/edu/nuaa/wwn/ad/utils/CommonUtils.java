package edu.nuaa.wwn.ad.utils;


import edu.nuaa.wwn.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

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

    public static <K, V> V getOrCreate(K key, Map<K, V> map,
                                       Supplier<V> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }

    public static String stringConcat(String... args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg);
            result.append("-");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
