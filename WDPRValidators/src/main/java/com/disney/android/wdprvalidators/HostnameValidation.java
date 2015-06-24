package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by GONUV001 on 6/22/2015.
 */
public class HostnameValidation {

    private static final String HOSTNAME_PATTERN = "^([a-z0-9][a-zA-Z0-9-]{0,62}\\.)+([a-zA-Z]{2,20})$";

    private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private static Pattern hnpattern = Pattern.compile(HOSTNAME_PATTERN);

    private static Pattern ipPattern = Pattern.compile(IPADDRESS_PATTERN);

    /**
     * @Description Validate hostname with regular expression
     * @param hostname
     *            for validation
     * @return true valid hostname, false invalid hostname
     */
    public boolean isHostName(final String hostname) {
        return hnpattern.matcher(hostname).matches();
    }

    /**
     * @description Validate ip address with regular expression
     * @param ip ip address for validation
     * @return true valid ip address, false invalid ip address
     */
    public boolean isIPAddress(final String ip) {
        return ipPattern.matcher(ip).matches();

    }

    /**
     * @Description checker to catch error msges of host name
     * @param hostname
     * @return List
     */
    public List<String> checkHostName(final String hostname) {
        List<String> arraylist = new ArrayList<>();
        arraylist.add("ERR_EMPTY_INPUT");
        if ((hostname != null) && (!hostname.equals(""))) {
            arraylist.clear();
            arraylist.add("");
            if (!isHostName(hostname)) {
                arraylist.clear();
                if (hostname.length() > 255) {
                    arraylist.add("ERR_HOSTNAME_LEN");
                }

                if ((hostname.length() - hostname.replace(".", "").length()) > 0) {

                    if ((hostname.substring(hostname.lastIndexOf('.') + 1).trim()).length() < 2 || (hostname.substring(hostname.lastIndexOf('.') + 1).trim()).length() > 20) {
                        arraylist.add("ERR_HOSTNAME_TLD_LEN");
                    }

                    String[] strArray = hostname.split("\\.");

                    for (int i = 0; i < strArray.length - 1; i++) {
                        if (strArray[i].length() > 63) {
                            arraylist.add("ERR_HOSTNAME_SUBDOMAIN_LEN");
                        }
                    }
                    if(hostname.endsWith(".")){
                        arraylist.add("ERR_HOSTNAME_TLD");
                    }

                }
                if (isIPAddress(hostname) == true) {
                    arraylist.add("ERR_HOSTNAME_IP");
                }
                if (arraylist.isEmpty()) {
                    arraylist.add("ERR_HOSTNAME_OTHER");
                }
            }
        }
        return arraylist;
    }
}