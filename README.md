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