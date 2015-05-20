package com.wdpr.validator.emailvalidator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 5/12/15.
 */
public class HashMapValues {

    public static Map hashMethod() {
        Map maps = new HashMap<>();
        maps.put("200", "");
        maps.put("100", "Email is empty");
        maps.put("105", "Email length exceeds the limit"); //Email length > 254
        maps.put("106", "Email has more than one '@'");
        maps.put("107", "Email Cannot start with '@'");
        maps.put("108", "Local-part length exceeds the limit"); // >64
        maps.put("109", "Domain length exceeds the limit"); // >189 including dot(.)
        maps.put("110", "Valid Email has both local and domain");
        maps.put("111", "Email cannot start or end with '.'");
        maps.put("112", "Email cannot have two repeating dots");
        maps.put("113", "Email not in proper format");
        return maps;
    }
}
