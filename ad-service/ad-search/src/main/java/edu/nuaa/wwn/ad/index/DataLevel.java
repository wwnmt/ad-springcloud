package edu.nuaa.wwn.ad.index;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 14:58
 */
@Getter
public enum DataLevel {

    LEVEL2("2", "level 2"),
    LEVEL3("3", "level 3"),
    LEVEL4("4", "level 4");

    private final String level;
    private final String desc;

    DataLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
