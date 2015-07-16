/*
package com.disney.android.wdprvalidators;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
*/
/**
 * Created by venkatgonuguntala on 7/8/15.
 *//*


    public class UrlValidator implements Serializable {

        private static final long serialVersionUID = 7557161713937335013L;
        public static final long ALLOW_ALL_SCHEMES = 1 << 0;

           public static final long ALLOW_2_SLASHES = 1 << 1;
            public static final long NO_FRAGMENTS = 1 << 2;

        private static final String URL_REGEX =
                          "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
          private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
          private static final int PARSE_URL_SCHEME = 2;
           private static final int PARSE_URL_AUTHORITY = 4;
          private static final int PARSE_URL_PATH = 5;
           private static final int PARSE_URL_QUERY = 7;
           private static final int PARSE_URL_FRAGMENT = 9;
          private static final Pattern SCHEME_PATTERN = Pattern.compile(SCHEME_REGEX);
           private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
           private static final String AUTHORITY_REGEX =
                           "^([" + AUTHORITY_CHARS_REGEX + "]*)(:\\d*)?(.*)?";
          private static final Pattern AUTHORITY_PATTERN = Pattern.compile(AUTHORITY_REGEX);
            private static final int PARSE_AUTHORITY_HOST_IP = 1;
            private static final int PARSE_AUTHORITY_PORT = 2;
           private static final int PARSE_AUTHORITY_EXTRA = 3;
         private static final String PATH_REGEX = "^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$";
           private static final Pattern PATH_PATTERN = Pattern.compile(PATH_REGEX);

    private static final String QUERY_REGEX = "^(.*)$";
           private static final Pattern QUERY_PATTERN = Pattern.compile(QUERY_REGEX);

              private static final String PORT_REGEX = "^:(\\d{1,5})$";
           private static final Pattern PORT_PATTERN = Pattern.compile(PORT_REGEX);
         private final long options;
            private final Set allowedSchemes; // Must be lower-case
            private final RegexValidator authorityValidator;

               private static final String[] DEFAULT_SCHEMES = {"http", "https", "ftp"}; // Must be lower-case
            private static final UrlValidator DEFAULT_URL_VALIDATOR = new UrlValidator();
            public static UrlValidator getInstance() {
                    return DEFAULT_URL_VALIDATOR;
                }
            public UrlValidator() {
                    this(null);
                }

                    public UrlValidator(String[] schemes) {
                    this(schemes, 0L);
               }
            public UrlValidator(long options) {
                    this(null, null, options);
               }

                    public UrlValidator(String[] schemes, long options) {
                    this(schemes, null, options);
               }
            public UrlValidator(RegexValidator authorityValidator, long options) {
                   this(null, authorityValidator, options);
               }
           public UrlValidator(String[] schemes, RegexValidator authorityValidator, long options) {
                    this.options = options;

                    if (isOn(ALLOW_ALL_SCHEMES)) {
                            allowedSchemes = Collections.EMPTY_SET;
                        } else {
                           if (schemes == null) {
                                    schemes = DEFAULT_SCHEMES;
                                }
                            allowedSchemes = new HashSet(schemes.length);
                        for(int i=0; i < schemes.length; i++) {
                       allowedSchemes.add(schemes[i].toLowerCase(Locale.ENGLISH));
                              }
                }
             this.authorityValidator = authorityValidator;
            }
            public boolean isValid(String value) {
                     if (value == null) {
                             return false;
                         }

                     // Check the whole url address structure
                     Matcher urlMatcher = URL_PATTERN.matcher(value);
                     if (!urlMatcher.matches()) {
                             return false;
                         }

                     String scheme = urlMatcher.group(PARSE_URL_SCHEME);
                     if (!isValidScheme(scheme)) {
                             return false;
                         }

                     String authority = urlMatcher.group(PARSE_URL_AUTHORITY);
                     if ("file".equals(scheme) && "".equals(authority)) {
                             // Special case - file: allows an empty authority
                         } else {
                             // Validate the authority
                             if (!isValidAuthority(authority)) {
                                     return false;
                                 }
                         }

                     if (!isValidPath(urlMatcher.group(PARSE_URL_PATH))) {
                             return false;
                         }

                     if (!isValidQuery(urlMatcher.group(PARSE_URL_QUERY))) {
                             return false;
                         }

                     if (!isValidFragment(urlMatcher.group(PARSE_URL_FRAGMENT))) {
                             return false;
                         }

                     return true;
                }
        protected boolean isValidScheme(String scheme) {
                    if (scheme == null) {
                            return false;
                        }

                    // TODO could be removed if external schemes were checked in the ctor before being stored
                    if (!SCHEME_PATTERN.matcher(scheme).matches()) {
                            return false;
                        }

                    if (isOff(ALLOW_ALL_SCHEMES) && !allowedSchemes.contains(scheme.toLowerCase(Locale.ENGLISH))) {
                            return false;
                        }

                    return true;
                }
           protected boolean isValidAuthority(String authority) {
                    if (authority == null) {
                            return false;
                        }

                    // check manual authority validation if specified
                    if (authorityValidator != null && authorityValidator.isValid(authority)) {
                            return true;
                        }
                    // convert to ASCII if possible
                    final String authorityASCII = DomainValidator.unicodeToASCII(authority);

                    Matcher authorityMatcher = AUTHORITY_PATTERN.matcher(authorityASCII);
                    if (!authorityMatcher.matches()) {
                            return false;
                        }

                    String hostLocation = authorityMatcher.group(PARSE_AUTHORITY_HOST_IP);
                    // check if authority is hostname or IP address:
                    // try a hostname first since that's much more likely
                    DomainValidator domainValidator = DomainValidator.getInstance(isOn(ALLOW_LOCAL_URLS));
                    if (!domainValidator.isValid(hostLocation)) {
                            // try an IP address
                            InetAddressValidator inetAddressValidator =
                                        InetAddressValidator.getInstance();
                            if (!inetAddressValidator.isValid(hostLocation)) {
                                    // isn't either one, so the URL is invalid
                                    return false;
                                }
                        }

                    String port = authorityMatcher.group(PARSE_AUTHORITY_PORT);
                    if (port != null && !PORT_PATTERN.matcher(port).matches()) {
                            return false;
                        }

                    String extra = authorityMatcher.group(PARSE_AUTHORITY_EXTRA);
                    if (extra != null && extra.trim().length() > 0){
                            return false;
                        }

                    return true;
                }
          protected boolean isValidPath(String path) {
                    if (path == null) {
                            return false;
                        }

                    if (!PATH_PATTERN.matcher(path).matches()) {
                            return false;
                        }

                    int slash2Count = countToken("//", path);
                    if (isOff(ALLOW_2_SLASHES) && (slash2Count > 0)) {
                            return false;
                        }

                    int slashCount = countToken("/", path);
                    int dot2Count = countToken("..", path);
                    if (dot2Count > 0 && (slashCount - slash2Count - 1) <= dot2Count) {
                            return false;
                        }

                    return true;
              }
          protected boolean isValidQuery(String query) {
                   if (query == null) {
                            return true;
                       }

                   return QUERY_PATTERN.matcher(query).matches();
               }
           protected boolean isValidFragment(String fragment) {
               if (fragment == null) {
                           return true;
        }
                   return isOff(NO_FRAGMENTS);
             }
           protected int countToken(String token, String target) {
                   int tokenIndex = 0;
                   int count = 0;
                    while (tokenIndex != -1) {
                           tokenIndex = target.indexOf(token, tokenIndex);
                          if (tokenIndex > -1) {
                                   tokenIndex++;
                                   count++;
                             }
                     }
                return count;
             }
           private boolean isOn(long flag) {
                 return (options & flag) > 0;
            }

    private boolean isOff(long flag) {
        return (options & flag) == 0;
    }
}


*/
