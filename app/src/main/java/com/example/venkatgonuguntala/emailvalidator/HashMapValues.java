package com.example.venkatgonuguntala.emailvalidator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 5/12/15.
 */
public class HashMapValues {

        public HashMapValues(){
        Map maps = new HashMap<>();
        maps.put("200", "");
        maps.put("104", "No input data available");
        maps.put("105", "Email address exceeds max length of 254 character");
        maps.put("106", "Only one @ character allowed in valid email address");
        maps.put("107", "@ character does not exists in email address");
        maps.put("108", "Maximum 64 character allowed in local part of email address");
        maps.put("109", "Maximum 189 character allowed in domain part including period(.)");
        maps.put("130", "Format does’nt match ISO8601 Date format");
        }

}
