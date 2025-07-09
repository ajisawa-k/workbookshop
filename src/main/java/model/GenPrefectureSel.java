package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class GenPrefectureSel {
    public String GenPrefectureSelTag(String selected) {
        String prefectureTag = "";
        boolean selFlg = false;
        String prefectureHeadTag1 = "<select name=\"prefecture\">\n<option value=\"\" selected>\u90fd\u9053\u5e9c\u770c</option>\n";
        String prefectureHeadTag2 = "<select name=\"prefecture\">\n<option value=\"\">\u90fd\u9053\u5e9c\u770c</option>\n";
        LinkedHashMap<String, String> hmpPrefecture = new LinkedHashMap<String, String>();
        hmpPrefecture = this.reHmpPrefecture();
        System.out.println(selected);
        for (Map.Entry<String, String> entry : hmpPrefecture.entrySet()) {
            if (entry.getKey().equals(selected)) {
                prefectureTag = prefectureTag + "<option value=\"" + entry.getKey() + "\" selected>" + entry.getValue() + "</option>\n";
                selFlg = true;
                continue;
            }
            prefectureTag = prefectureTag + "<option value=\"" + entry.getKey() + "\">" + entry.getValue() + "</option>\n";
        }
        prefectureTag = selFlg ? prefectureHeadTag2 + prefectureTag + "</select>" : prefectureHeadTag1 + prefectureTag + "</select>";
        return prefectureTag;
    }

    private LinkedHashMap<String, String> reHmpPrefecture() {
        LinkedHashMap<String, String> hmpPrefecture = new LinkedHashMap<String, String>();
        hmpPrefecture.put("\u5317\u6d77\u9053", "\u5317\u6d77\u9053");
        hmpPrefecture.put("\u9752\u68ee\u770c", "\u9752\u68ee\u770c");
        hmpPrefecture.put("\u5ca9\u624b\u770c", "\u5ca9\u624b\u770c");
        hmpPrefecture.put("\u5bae\u57ce\u770c", "\u5bae\u57ce\u770c");
        hmpPrefecture.put("\u79cb\u7530\u770c", "\u79cb\u7530\u770c");
        hmpPrefecture.put("\u5c71\u5f62\u770c", "\u5c71\u5f62\u770c");
        hmpPrefecture.put("\u798f\u5cf6\u770c", "\u798f\u5cf6\u770c");
        hmpPrefecture.put("\u8328\u57ce\u770c", "\u8328\u57ce\u770c");
        hmpPrefecture.put("\u6803\u6728\u770c", "\u6803\u6728\u770c");
        hmpPrefecture.put("\u7fa4\u99ac\u770c", "\u7fa4\u99ac\u770c");
        hmpPrefecture.put("\u57fc\u7389\u770c", "\u57fc\u7389\u770c");
        hmpPrefecture.put("\u5343\u8449\u770c", "\u5343\u8449\u770c");
        hmpPrefecture.put("\u6771\u4eac\u90fd", "\u6771\u4eac\u90fd");
        hmpPrefecture.put("\u795e\u5948\u5ddd\u770c", "\u795e\u5948\u5ddd\u770c");
        hmpPrefecture.put("\u65b0\u6f5f\u770c", "\u65b0\u6f5f\u770c");
        hmpPrefecture.put("\u5bcc\u5c71\u770c", "\u5bcc\u5c71\u770c");
        hmpPrefecture.put("\u77f3\u5ddd\u770c", "\u77f3\u5ddd\u770c");
        hmpPrefecture.put("\u798f\u4e95\u770c", "\u798f\u4e95\u770c");
        hmpPrefecture.put("\u5c71\u68a8\u770c", "\u5c71\u68a8\u770c");
        hmpPrefecture.put("\u9577\u91ce\u770c", "\u9577\u91ce\u770c");
        hmpPrefecture.put("\u5c90\u961c\u770c", "\u5c90\u961c\u770c");
        hmpPrefecture.put("\u9759\u5ca1\u770c", "\u9759\u5ca1\u770c");
        hmpPrefecture.put("\u611b\u77e5\u770c", "\u611b\u77e5\u770c");
        hmpPrefecture.put("\u4e09\u91cd\u770c", "\u4e09\u91cd\u770c");
        hmpPrefecture.put("\u6ecb\u8cc0\u770c", "\u6ecb\u8cc0\u770c");
        hmpPrefecture.put("\u4eac\u90fd\u5e9c", "\u4eac\u90fd\u5e9c");
        hmpPrefecture.put("\u5927\u962a\u5e9c", "\u5927\u962a\u5e9c");
        hmpPrefecture.put("\u5175\u5eab\u770c", "\u5175\u5eab\u770c");
        hmpPrefecture.put("\u5948\u826f\u770c", "\u5948\u826f\u770c");
        hmpPrefecture.put("\u548c\u6b4c\u5c71\u770c", "\u548c\u6b4c\u5c71\u770c");
        hmpPrefecture.put("\u9ce5\u53d6\u770c", "\u9ce5\u53d6\u770c");
        hmpPrefecture.put("\u5cf6\u6839\u770c", "\u5cf6\u6839\u770c");
        hmpPrefecture.put("\u5ca1\u5c71\u770c", "\u5ca1\u5c71\u770c");
        hmpPrefecture.put("\u5e83\u5cf6\u770c", "\u5e83\u5cf6\u770c");
        hmpPrefecture.put("\u5c71\u53e3\u770c", "\u5c71\u53e3\u770c");
        hmpPrefecture.put("\u5fb3\u5cf6\u770c", "\u5fb3\u5cf6\u770c");
        hmpPrefecture.put("\u9999\u5ddd\u770c", "\u9999\u5ddd\u770c");
        hmpPrefecture.put("\u611b\u5a9b\u770c", "\u611b\u5a9b\u770c");
        hmpPrefecture.put("\u9ad8\u77e5\u770c", "\u9ad8\u77e5\u770c");
        hmpPrefecture.put("\u798f\u5ca1\u770c", "\u798f\u5ca1\u770c");
        hmpPrefecture.put("\u4f50\u8cc0\u770c", "\u4f50\u8cc0\u770c");
        hmpPrefecture.put("\u9577\u5d0e\u770c", "\u9577\u5d0e\u770c");
        hmpPrefecture.put("\u718a\u672c\u770c", "\u718a\u672c\u770c");
        hmpPrefecture.put("\u5927\u5206\u770c", "\u5927\u5206\u770c");
        hmpPrefecture.put("\u5bae\u5d0e\u770c", "\u5bae\u5d0e\u770c");
        hmpPrefecture.put("\u9e7f\u5150\u5cf6\u770c", "\u9e7f\u5150\u5cf6\u770c");
        hmpPrefecture.put("\u6c96\u7e04\u770c", "\u6c96\u7e04\u770c");
        return hmpPrefecture;
    }
}
