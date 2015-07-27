package com.disney.android.wdprvalidators;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 7/08/15.
 */
public class UrlValidator {

    private static final String ERR_URI_LEN = "ERR_URI_LEN";

    private static final String ERR_URI_SCHEME = "ERR_URI_SCHEME";

    private static final String ERR_URI_OTHER = "ERR_URI_OTHER";

    private static final String ERR_EMPTY_INPUT = "ERR_EMPTY_INPUT";

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
    public boolean isValidURL(String url) throws MalformedURLException {

        boolean result = false;

        if(urlpattern.matcher(url).matches())
        {
            String hostname = getHostname(url);

            if(hostnameValidation.isHostName(hostname))
            {
                result = true;
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

    public List<String> checkURL(String stringURL) throws MalformedURLException
    {
        final List<String> errorUrlList = new ArrayList<>();

        final String hostname;

        if (stringURL != null && !stringURL.isEmpty())
        {
            final int lengthURL = stringURL.length();

            if (!this.isValidURL(stringURL.toLowerCase()))
            {

                if (lengthURL > URL_MAX_LENGTH)
                {
                    errorUrlList.add(ERR_URI_LEN);
                }

                if (!hasIntentedPrefix(stringURL))
                {
                    errorUrlList.add(ERR_URI_SCHEME);
                }

                if (errorUrlList.isEmpty())
                {
                    errorUrlList.add(ERR_URI_OTHER);
                }

                if (hasIntentedPrefix(stringURL))
                {
                    hostname = getHostname(stringURL);

                    errorUrlList.addAll(hostnameValidation.checkHostName(hostname));
                }

            }

        }
        else
        {
            errorUrlList.add(ERR_EMPTY_INPUT);
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
