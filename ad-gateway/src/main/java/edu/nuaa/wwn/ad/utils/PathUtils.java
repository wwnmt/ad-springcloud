package edu.nuaa.wwn.ad.utils;

import org.springframework.util.AntPathMatcher;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-09-03
 * Time: 16:51
 */
public class PathUtils {

    private static final AntPathMatcher matcher = new AntPathMatcher();

    public static boolean isPathMatch(String pattern, String path) {
        return matcher.match(pattern, path);
    }
}
