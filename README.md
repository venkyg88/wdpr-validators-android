# WDPR-Validators-Android

The following library performs validation for primitive methods and complex methods like Credit Cards.

# Why?

The following library block provides both basic and complex methods for input validation which is intended to be imported and implemented within Android applications.

# Getting Started

## Installing.
1. After Building the module-WDPRValidators, a jar file of all the source code and resource files is created in the folder.
   `WDPRValidators/build/intermediates/bundles/debug/res/classes.jar`
2. You can rename the classes.jar according to your wish(Library.jar). 
3. Copy that Library in your Module under libs folder.
4. Now, we need to tell gradle to include this Library during build. So add the line in dependencies of your build.gradle       file.
   <p>
   <code>
    dependencies{
      
          compile files('libs/Library.jar')
    }
    </code>
    </p>

# Demo
1. Open Android Studio, Select File -> New -> Import Project from Version Control -> Git.</p>
2. Enter Git Repository URL, Parent Directory and Directory Name and then Clone.
3. After you have the project in Android Studio, Under Run/Debug configurations select WDPRValidatorsDemo
4. Once you have the respective module selected you can run the application using either from an emulator or a real device.
5. Instructions for running the demo on [Real Device.](http://developer.android.com/training/basics/firstapp/running-app.html#RealDevice)
6. Instructions for running the demo on [Emulator](http://developer.android.com/training/basics/firstapp/running-app.html#Emulator)
7. Select the WDPRValidatorDemo module from Run/Debug option run the application.

Note: Always Make sure your emulator/device is up and running before you test.

# Unit Tests
1. To run unit tests, go the respective folder in terminal and type `./gradlew connectedcheck`(Mac) `gradlew connectedcheck`(Windows).
2. After the build is successful running the commands mentioned above - a generated report of pass/fail of test cases can be seen by opening the link [Unit Test Report](http://localhost:63342/wdpr-validators-android/build/outputs/reports/androidTests/connected/com.disney.android.wdprvalidators.html)

# Code Coverage
1. Open `Run/Debug` and select `AllTests`.
2. Open `Build Variants` and select `Unit Tests` under `Test Artifact`.
3. Click the `Coverage` menu icon, next to `Run/Debug`.

## API Methods

The WDPRValidators have the following methods.

## isValidEmail(emailPattern, email)

This function returns a boolean, checking whether it is valid email or Invalid email.

**Params**
- email 'String'

**Returns:** `Boolean`

**Usage:**

    emailValidator.isValidEmail(email)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkEmail(email)

This function will throw error codes of the respective messages, if isValidEmail funtion returns false.

**Params**
- email `String` Email should follow RFC standards.

**Returns:** `List<String>`

**Usage:**

    emailValidator.checkEmail(email)

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMAIL\_LEN\_LOCAL')<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')
> Failure Scenario: List('ERR\_EMAIL\_STRT\_DOT')
> Failure Scenario: List('ERR\_EMAIL\_END\_DOT')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#email) for further details on their definitions

-----

## aUnicodeString(Object)

Predicate to determine whether something is a fully nuanced Unicode string with nothing too scary in it.

**Params**
- Object `String`

**Returns:** `Boolean`

**Usage:**

    unicodeValidator.aUnicodeString(email)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## unicodeChecker(email)

Checker function to identify the error messages, if its not unicode.

**Params**
- unicode `String`

**Returns:** `List<String>`

**Usage:**

    unicodeValidator.unicodeChecker(unicode)

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_UNICODE\_STRING')<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#string) for further details on their definitions

-----

## isISO8601(Object)

predicate to determine whether a date meets the basic structure of an ISO 8601 date format.

**Params**
- Object `String` - date Object to be evaluated

**Returns:** `boolean`

**Usage:**

    dateValidator.isISO8601(date)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#string) for further details on their definitions

-----

## checkIsoDate(Object)

Checker to determine whether the provided string is a valid ISO8601 date.

**Params**
- Object `String` - date Object to be evaluated

**Returns** `List<String>`

**Usage:**

    dateValidator.checkIsoDate(date)

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_ISO\_DATE')<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#iso8601-date) for further details on their definitions

-----

## isAnArray(Object)

predicate to determine whether the provided Object is an array.

**Params**
- Object `Object` - array Object to be evaluated

**Returns:** `boolean` 

**Usage:**

    primitiveValidator.isAnArray(Object)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## arrayChecker(Object)

Checker to determine whether the input object is a array.

**Params**
- Object `Object` - Object to be evaluated

**Returns** `boolean`

**Usage:**

    primitiveValidator.arrayChecker(Object)

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_ARRAY')<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#array) for further details on their definitions

-----

## isAString(Object)

predicate to determine whether the provided Object is a String.

**Params**
- Object `Object` - string Object to be evaluated

**Returns** `boolean`

**Usage:**

    primitiveValidator.isAString(Object)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## stringChecker(Object)

Checker to determine whether the input object is a string.

**Params**
- Object `Object` - Object to be evaluated

**Returns** `boolean`

**Usage:**

    primitiveValidator.stringChecker(Object)

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_STRING')<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')

Please refer to our [error codes documentation] (https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#string) for further details on their definitions

-----

## checkDateRange(Object, Object, Object)

Checker to determine whether user date falls in the range of start date and end date inclusively.

**Params**
- Object `Date` - start date Object
- Object `Date` - end date Object
- Object `Date` - target date Object to be evaluated with start and end date

**Returns** `List<String>`

**Usage:**

    dateValidator.checkDateRange(startDate, endDate, userDate)

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_DATE\_RANGE\_BEFORE')
> Failure Scenario: List('ERR\_DATE\_RANGE\_AFTER')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#date-range) for further details on their definitions

-----

## isInRange(Object, Object, Object)

predicate to determine whether the target date is in the range provided.

**Params**
- Object `Date` - start date Object
- Object `Date` - end date Object
- Object `Date` - target date Object to be evaluated with start and end date

**Returns** `boolean`

**Usage:**

    dateValidator.isInRange(startDate, endDate, userDate)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## isHostname(Object)

Predicate to determine whether input value contain valid Hostname or not. It accepts alphanumeric and other accepted character as specified in RFC1123

**Params**
- Object `String` - hostname Object

**Returns** `boolean`

**Usage:**

    hostnameValidator.isHostName(hostname)

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkHostName(Object)

Checker to determine the error code/codes for hostname failure, if failed else return empty string.

**Params**
- Object `String` - hostname Object

**Returns** `List<String>`

**Usage:**

    hostnameValidator.checkHostName(hostname);

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_HOSTNAME\_OTHER')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#hostname) for further details on their definitions

-----

## isValidURL(String url, boolean relaxed)

Predicate method to determine whether input URL url is valid or not based on relaxed parameter, if the flag "relaxed" is set to true, skips the use of Hostname predicate within this so that those special case URLs can pass the predicate. Otherwise always uses the Hostname predicate to validate the hostname part of the URL.

**Params**
- url `String`
- relaxed `boolean`

**Returns** `boolean`

**Usage:**

```java
String url = "https://143.23.2.2";
boolean relaxed = false
boolean result = urlValidator.isValidURL(url, relaxed)
if(result)
{
    //It is valid url
}
else
{
    //It is Invalid url
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkURL(String url, boolean relaxed)

Checker method to check the url input based on relaxed parameter, and return an list of error codes for any failed criteria and returns an empty string for valid url. If the flag "relaxed" is set to true, skips the use of Hostname predicate within this so that those special case URLs can pass the predicate. Otherwise always uses the Hostname predicate to validate the hostname part of the URL.

**Params**
- url `String`
- relaxed `boolean`

**Returns** `List<String>`

**Usage:**

```java
String url = "https://143.23.2.2";
boolean relaxed = false
List<String> errorList = urlValidator.checkURL(url);
if(errorList.isEmpty())
{
    //It is Valid url
}
else
{
    //List of Error messages
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_URL\_OTHER')<br>
> Failure Scenario: List('URL\_MAX\_LENGTH')<br>
> Failure Scenario: List('ERR\_URL\_SCHEME')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#uri) for further details on their definitions

-----

## isCreditCard(String creditCardNumber, String creditCardType)

Predicate method to determine whether or not an input value contains a valid Credit Card number.

**Params**
- creditCardNumber `String`

**Returns** `boolean`

**Usage:**

```java
String creditCardNumber = "4111111111111111";

boolean value = creditCardValidator.isCreditCard(creditCardNumber)

if(value)
{
  //It is a valid credit card.
}
else
{
  //It is not a valid credit card.
}  
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkCreditCard(String creditCardNumber)

Checker method to check a credit card input, and return an list of error codes for any failed criteria. If the input is a valid credit card, this method returns an empty string.

**Params**
- creditCardNumber `String`

**Returns** `List<String>`

**Usage:**

```java
String creditCardNumber = "411111111111111";

List<String> errorList = creditCardValidator.checkCreditCard(creditCardNumber);

if(errorList.isEmpty()) 
{
  //It is a valid credit card.
}
else
{
  //It is not a valid credit card.
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_CC\_OTHER')<br>
> Failure Scenario: List('ERR\_CC\_LUHN')<br>
> Failure Scenario: List('ERR\_CC\_LENGTH')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#credit-card) for further details on their definitions

------

## isValidCreditCardDate(year, month)

Predicate method to determine whether or not the passed parameters(year and month) falls after the current date(year and month).
Note: while consuming the block, Developers should make sure that they pass integer types for year and month otherwise it will lead to compile time error.

**Params**
- year `int` Format YY/YYYY
- month `int` Format MM

**Returns** `boolean`

**Usage:**

```java
int year = 35; //35/2035
int month = 10;

boolean value = creditCardValidator.isValidCreditCardDate(year, month);

if(value)
{
  //Card date is valid.
}
else
{
  //Card date is expired/ Invalid input date type/ exceeding range.
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkCreditCardDate(year, month)

Checker method to check a credit card date input parameters, and return an list of error codes for any failed criteria. If the input is a valid credit card date, this method returns an empty string.
Note: While consuming the block, developers should make sure that they pass integer types for year and month otherwise it will lead to compile time error.

**Params**
- year `int` Format YY/YYYY
- month `int` Format MM

**Returns** `List<String>`

**Usage:**

```java
int year = 35; //35/2035
int month = 10;

List<String> errorList = creditCardValidator.checkCreditCardDate(year, month);

if(errorList.isEmpty())
{
  //It is a valid credit card.
}
else
{
  //Card date is expired/ Invalid input date type/ exceeding range.
  //print errorList
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_CC\_OTHER')<br>
> Failure Scenario: List('ERR\_CC\_EXP')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#credit-card) for further details on their definitions

------
