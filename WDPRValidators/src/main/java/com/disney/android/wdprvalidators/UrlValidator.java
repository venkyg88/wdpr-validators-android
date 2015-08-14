package com.disney.android.wdprvalidators;

import com.disney.android.wdprvalidators.HostnameValidation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 7/08/15.
 */
public class UrlValidator {

    private static final int URL_MAX_LENGTH = 2048;

    private static final String URL_PATTERN = "\\b(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    private static final Pattern urlpattern = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);

    final HostnameValidation hostnameValidation = new HostnameValidation();

    /**
     *
     * @description: Predicate url specific to disney EX: http://packetmover is not valid becasue of missing TLD.
     * @param url
     * @return boolean
     * @throws MalformedURLException
     */
    public boolean isValidURL(String url, boolean relaxed) throws MalformedURLException {

        boolean result = false;

        if(urlpattern.matcher(url).matches())
        {
            if(relaxed){
                result = true;
            }
            else
            {
                String hostname = getHostname(url);
                if (hostnameValidation.isHostName(hostname)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     *
     * @description: checker function which returns a list of error messages when URL is false, and returns nothing if its valid URL
     * @param stringURL
     * @return
     * @throws MalformedURLException
     */

    public List<String> checkURL(String stringURL, boolean relaxed) throws MalformedURLException
    {
        final List<String> errorUrlList = new ArrayList<>();

        final String hostname;

        if (stringURL != null && !stringURL.isEmpty())
        {
            final int lengthURL = stringURL.length();

            if (!this.isValidURL(stringURL.toLowerCase(), relaxed))
            {

                if (lengthURL > URL_MAX_LENGTH)
                {
                    errorUrlList.add(ValidatorConstant.ERR_URL_LEN);
                }

                if (!hasIntentedPrefix(stringURL))
                {
                    errorUrlList.add(ValidatorConstant.ERR_URL_SCHEME);
                }

                if (errorUrlList.isEmpty())
                {
                    errorUrlList.add(ValidatorConstant.ERR_URL_OTHER);
                }

                if (hasIntentedPrefix(stringURL) && !relaxed)
                {
                    hostname = getHostname(stringURL);

                    errorUrlList.addAll(hostnameValidation.checkHostName(hostname));
                }

            }

        }
        else
        {
            errorUrlList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }

        return errorUrlList;
    }

    /**
     * Method to retrieve hostname from URL.
     */
    private String getHostname(String stringURL) throws MalformedURLException
    {
        URL url = new URL(stringURL);

        String hostname = url.getHost();

        return hostname;
    }

    /**
     * Method to check URL has a valid scheme
     */
    private boolean hasIntentedPrefix(String stringURL)
    {
        return (stringURL.startsWith("https://") || stringURL.startsWith("http://"));
    }
}

