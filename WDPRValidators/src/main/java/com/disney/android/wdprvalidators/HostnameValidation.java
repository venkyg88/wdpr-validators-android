package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by GONUV001 on 6/22/2015.
 */
public class HostnameValidation {

    private static final String HOSTNAME_PATTERN = "^([a-z0-9][a-z0-9-]{0,63}\\.)+([a-z]{2,20})$";

    private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private static final Pattern hnpattern = Pattern.compile(HOSTNAME_PATTERN,Pattern.CASE_INSENSITIVE);

    private static final Pattern ipPattern = Pattern.compile(IPADDRESS_PATTERN);

    /**
     * @Description Validate hostname with regular expression
     * @param hostname for validation
     * @return true valid hostname, false invalid hostname
     */
    public boolean isHostName(String hostname)
    {
        return hnpattern.matcher(hostname).matches();
    }

    /**
     * @description Validate ip address with regular expression
     * @param ip ip address for validation
     * @return true valid ip address, false invalid ip address
     */
    public boolean isIPAddress(String ip)
    {
        return ipPattern.matcher(ip).matches();
    }

    /**
     * @Description checker to catch error msges of host name
     * @param hostname
     * @return List
     */
    public List<String> checkHostName(String hostname)
    {
        List<String> arraylist = new ArrayList<>();
        if (hostname != null && !hostname.isEmpty())
        {
            if (!isHostName(hostname))
            {
                int hostNameLength = hostname.length();
                if (hostNameLength > 255 || hostNameLength < 2)
                {
                     arraylist.add(ValidatorConstant.ERR_HOSTNAME_LEN);
                }
                if (hostname.contains("."))
                {
                    int tld = hostname.substring(hostname.lastIndexOf('.') + 1).length();
                    if (tld < 2 || tld > 20)
                    {
                        arraylist.add(ValidatorConstant.ERR_HOSTNAME_TLD_LEN);
                    }
                    String[] strArray = hostname.split("\\.");
                    int countOfSubDomains = strArray.length - 1;
                    for (int i = 0; i < countOfSubDomains; i++)
                    {
                        int strSubDomainLength = strArray[i].length();
                        if (strSubDomainLength > 63 || strSubDomainLength < 2)
                        {
                            arraylist.add(ValidatorConstant.ERR_HOSTNAME_SUBDOMAIN_LEN);
                            break;
                        }
                    }
                    if(hostname.endsWith("."))
                    {
                        arraylist.add(ValidatorConstant.ERR_HOSTNAME_TLD);
                    }
                }
                if (isIPAddress(hostname))
                {
                    arraylist.add(ValidatorConstant.ERR_HOSTNAME_IP);
                }
                if(arraylist.isEmpty())
                {
                    arraylist.add(ValidatorConstant.ERR_HOSTNAME_OTHER);
                }
            }
        }
        else
        {
            arraylist.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return arraylist;
    }
}