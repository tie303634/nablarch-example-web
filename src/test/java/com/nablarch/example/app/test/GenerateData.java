package com.nablarch.example.app.test;

import nablarch.test.core.util.FileUtils;
import nablarch.test.tool.htmlcheck.util.FileUtil;

import java.io.*;
import java.text.MessageFormat;

/**
 * Created by tikK59667 on 2017/02/17.
 */
public class GenerateData {

    private static final String HEADER = "PROJECT_ID,PROJECT_NAME,PROJECT_TYPE,PROJECT_CLASS,PROJECT_START_DATE,PROJECT_END_DATE,CLIENT_ID,PROJECT_MANAGER,PROJECT_LEADER,USER_ID,NOTE,SALES,COST_OF_GOODS_SOLD,SGA,ALLOCATION_OF_CORP_EXPENSES,VERSION";
    private static final String PATTERN = "{0},プロジェクト{1},development,d,2012-6-22,2014-12-31,2,田中,鈴木,{2},備考欄８９,10000,1000,2000,3000,1";

    public static void main(String[] args) throws Exception {

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./PROJECT.csv"), "SJIS");
        String str;
        writer.write(HEADER + "\n");
        for (int i = 1; i <= 100000; i++) {
            str = MessageFormat.format(PATTERN, String.valueOf(i), changeNumHalfToFull(String.format("%06d", i)), String.valueOf(105 + i / 100)).toString();
            writer.write(str + "\n");
            System.out.println(str);
        }
        writer.flush();
        writer.close();
        System.out.println("完了");
    }

    private static String changeNumHalfToFull(String str) {
        String result = null;
        if (str != null) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < sb.length(); i++) {
                int c = (int) sb.charAt(i);
                if (c >= 0x30 && c <= 0x39) {
                    sb.setCharAt(i, (char) (c + 0xFEE0));
                }
            }
            result = sb.toString();
        }
        return result;
    }
}
