package com.jalasoft.automation.erp.portal.ui.custom.Utils;

import java.util.Random;

/**
 * Created by Henry Benito on 2/23/2016.
 */
public class IDGenerator {

    public IDGenerator() {

    }

    public String getRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }
}
