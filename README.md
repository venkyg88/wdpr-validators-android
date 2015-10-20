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

## booleanPredicate(String value)

predicate method to determine where or not the input is a valid boolean input.

**Params**
- value `String`

**Returns** `boolean`

**Usage:**

```java
String value = "false";
boolean result = primitiveValidator.booleanPredicate(value)
if(result)
{
    //It is valid boolean type
}
else
{
    //Not a valid boolean type
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## booleanChecker(String value)

Checker method to determine where or not the input is a valid boolean input.

**Params**
- value `String`

**Returns** `List<String>`

**Usage:**

```java
String value = "false";
boolean result = primitiveValidator.booleanChecker(value)
if(result)
{
    //return empty list
}
else
{
    //return a list of errors
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_BOOL')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#boolean) for further details on their definitions

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

Predicate method to determine whether input `url` is a valid url per Disney specifications. If `relaxed` is set to `FALSE` the hostname portion of the input will be validated using `isHostname(Object)`, if set to `TRUE` the hostname portion of the input will not be validated to allow special case URLs to pass the predicate.

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

Checker method to check the input `url` based on relaxed parameter, and return an list of error codes for any failed criteria and returns an empty string for valid url. If `relaxed` is set to `FALSE` the hostname portion of the input will be validated using `checkHostName(Object)`, if set to `TRUE` the hostname portion of the input will not be validated to allow special case URLs to pass the predicate.

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

## isCreditCardCVC(String cvc)

Predicate method to determine whether or not an input value contains a valid Credit Card cvc.

**Params**
- cvc `String` 

**Returns** `boolean`

**Usage:**

```java
String cvc ="4003";

boolean value = creditCardValidator.isCreditCardCVC(cvc);

if(value)
{
  //Card cvc is valid.
}
else
{
  //Card cvc is Invalid because of exceeding range(3-4) or not number.
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkCreditCardCVC(String cvc)

Checker method to check credit card cvc, and return a list of error codes for any failed criteria. If the input is a valid credit card, this method returns an empty string.

**Params**
- cvc `String`

**Returns** `List<String>`

**Usage:**

```java
String cvc = "4003";

List<String> errorList = creditCardValidator.checkCreditCardCVC(cvc);

if(errorList.isEmpty()) 
{
  //It is a valid credit card cvc.
}
else
{
  //It is not a valid credit card cvc.
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_CC\_CVC\_LEN')<br>
> Failure Scenario: List('ERR\_CC\_CVC')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#credit-card) for further details on their definitions

------

## isPassword(String Password)

Predicate method to find the password is a valid password conforming to the RA security specified length(6-25) and at least having the minimum count of two categories(lower/upper case characters, digits, symbols) for achieving required password strength.

**Params**
- Password `String`

**Returns** `boolean`

**Usage:**

```java
String password ="ABCDefgh_123";

PasswordValidator mPasswordValidator = new PasswordValidator();
boolean mBoolean = mPasswordValidator.isPassword(password);

if(mBoolean)
{
  //Password is valid.
}
else
{
  /*Password is Invalid because of exceeding length(6-25) or doesn't contain the minimum category count for achieving the desired password strength or null/empty input.*/
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

## checkPassword(String Password)

Checker method to return a list of possible error/errors for passwords not specific to RA security standards otherwise return empty list.

**Params**
- Password `String`

**Returns** `list<String>`

**Usage:**

```java
String password ="ABCDefgh_123";

PasswordValidator mPasswordValidator = new PasswordValidator();
List<String> errorList = mPasswordValidator.checkPassword(password);

if(errorList.isEmpty())
{
  //Password is valid.
}
else
{
  //List of possible errors specifying the reason for invalid password.
  //ERR_PASSWORD_STRENGTH - if the category count falls less than two. Eg: Disney, !<#\%{}|^, 1234567
  //ERR_PASSWORD_OTHER - if charaters fall out of RA standards. Eg: Disney$, >disney
  //ERR_PASSWORD_MIN_LEN and ERR_PASSWORD_MAX_LEN if length doesn't fall in range(6-25)
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_PASSWORD\_MIN\_LEN')<br>
> Failure Scenario: List('ERR\_PASSWORD\_MAX\_LEN')<br>
> Failure Scenario: List('ERR\_PASSWORD\_STRENGTH')<br>
> Failure Scenario: List('ERR\_PASSWORD\_OTHER')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#password) for further details on their definitions

------

##isUnchecked()

Predicate method which doesn't take any parameters and always returns true. This function can be used when there a need for us to deliberately return true for all the values.

**Returns** `boolean`

**Usage:**

```java

PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();
boolean mBoolean = mPrimitiveValidator.isUnchecked();

if(mBoolean)
{
  //Returned value is `true`
}
else
{
  //Returned value is `false`
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

##checkUnchecked()

Checker method for unchecked Predicate method to return a error message list if at all it fails to return true otherwise returns empty list.

**Returns** `list<String>`

**Usage:**

```java

PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();
List<String> errorList = mPrimitiveValidator.checkUnchecked();

if(errorList.isEmpty())
{
  //Returns true
}
else
{
  //Error specifying the reason for failure.
  //ERR_UNCHECK - Unchecked check fails
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_UNCHECK')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#uncheck) for further details on their definitions

-----

##isNumber(Object number)

Predicate method to determine whether input value is a Number(that is Byte, Short, Integer, Long, Float, and Double) and also supports if the Number is passed in the form of string. Examples of Valid numbers are 12, -12, +12, 0, 12.12, 7.6E+7.

**Params**
- number `Object`

**Returns** `boolean`

**Usage:**

```java
Integer number =123;

PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();
boolean mBoolean = mPrimitiveValidator.isNumber(number);

if(mBoolean)
{
  //Valid number
}
else
{
  //Invalid number
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

##checkNumber(Object number)

Checker method to determine whether the input is a number which returns an empty list on success or a list of applicable error messages on failure.

**Params**
- number `Object`

**Returns** `List<String>`

**Usage:**

```java
PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();
List<String> list = mPrimitiveValidator.checkNumber(number);

if(list.isEmpty())
{
  //Valid number
}
else
{
  //Error specifying the reason for failure
  //ERR_NUM - Input not a number
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_NUM')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#number) for further details on their definitions

-----

##isNumberInRange(Object input, Object lower, Object Upper)

Predicate method to determine whether or not the input number falls in between the lower and upper bound values inclusively.

**Params**
- input `Object`
- lower `Object`
- upper `Object`

**Returns** `boolean`

**Usage:**

```java
PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();
boolean mBoolean = mPrimitiveValidator.isNumberInRange(12, 9, 23);

if(mBoolean)
{
  //true - falls in range
}
else
{
  //false - doesn't fall in range
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

##checkNumberInRange(Object input, Object lower, Object Upper)

Checker method to determine whether the input falls in the range of upper and lower bound inclusively which returns empty list on success and a list of applicable errors on failure.

**Params**
- input `Object`
- lower `Object`
- upper `Object`

**Returns** `List<String>`

**Usage:**

```java
PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();
List<String> list = mPrimitiveValidator.checkNumberInRange(input, lower, upper);

if(list.isEmpty())
{
  //Input falls in the range
}
else
{
  //Error specifying the reason for failure
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_NUM')<br>
> Failure Scenario: List('ERR\_NUM\_INVALID\_RANGE')<br>
> Failure Scenario: List('ERR\_NUM\_RANGE\_MAX')<br>
> Failure Scenario: List('ERR\_NUM\_RANGE\MIN')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#number) for further details on their definitions

-----

##isObjectInRange(Object object, int lower, int Upper)

Predicate method to determine whether or not the input object's length falls in between the lower and upper integer bound values inclusively. This method uses a public method to find the length of the passed object, it also takes care of all kinds of objects - arrays, collections, maps, Json objects, Json Arrays, class property length(number of exposed fields), etc.

**Params**
- object `Object`
- lower `int`
- upper `int`

**Returns** `boolean`

**Usage:**

```java
int lower = 3;
int upper = 10;
String []object = {"Cow", "Dog", "Pig", "Egg"}; //Here the object could be of any Object in java(list, map, string, array).
ObjectLengthValidator mObjectLengthValidator = new ObjectLengthValidator();
boolean mBoolean = mObjectLengthValidator.isObjectInRange(object, lower, upper);

if(mBoolean)
{
  //true - input object's length falls in range
}
else
{
  //false - input object's length doesn't fall in range
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

##checkObjectInRange(Object object, int lower, int Upper)

Checker method to determine whether the input object's length falls in the range of upper and lower bound inclusively which returns an empty list on success and a list of applicable errors on failure.

**Params**
- object `Object`
- lower `int`
- upper `int`

**Returns** `List<String>`

**Usage:**

```java
int lower = 3;
int upper = 10;
String []object = {"Cow", "Dog", "Pig", "Egg"}; //Here the object could be of any Object in java.
ObjectLengthValidator mObjectLengthValidator = new ObjectLengthValidator();
List<String> list = mObjectLengthValidator.checkObjectInRange(object, lower, upper);

if(list.isEmpty())
{
  //Input object's length falls in the range
}
else
{
  //Error specifying the reason for failure
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_POS_INTEGER')<br>
> Failure Scenario: List('ERR\_NUM\_INVALID\_RANGE')<br>
> Failure Scenario: List('ERR\_NUM\_RANGE\_MAX')<br>
> Failure Scenario: List('ERR\_NUM\_RANGE\MIN')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#number) for further details on their definitions

-----

##isRegex(String inputPattern)

Predicate method to validate the input pattern for valid regular expression

**Params**
- inputPattern `String`

**Returns** `boolean`

**Usage:**

```java
String inputPattern = "^([a-z0-9][a-z0-9-]{0,63}\\.)+([a-z]{2,20})$";
RegexValidator mRegexValidator = new RegexValidator();
boolean mBoolean = mRegexValidator.isRegex(inputPattern);
if(mBoolean)
{
  //true - Input is a valid regular expression
}
else
{
  //false - Input is a invalid regular expression
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

##checkRegex(String inputPattern)

Checker method to determine whether the input is a valid regular expression which returns an empty list on success or a list of applicable error messages on failure.

**Params**
- inputPattern `String`

**Returns** `List<String>`

**Usage:**

```java
String inputPattern = "^([a-z0-9][a-z0-9-]{0,63}\\.)+([a-z]{2,20})$";
RegexValidator mRegexValidator = new RegexValidator();
List<String> list = mRegexValidator.checkRegex(inputPattern);

if(list.isEmpty())
{
  //success - valid Regular expression
}
else
{
  //Error specifying the reason for failure
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_REGEXP')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#regexp) for further details on their definitions

-----

##isArrayOfIntendedType(Object objectArray[], Class arrayType)

Predicate method to validate that the input array contains only contents of the intended type. The intended type is passed as a Class argument.
**Params**
- objectArray[] `Object`
- arrayType `Class`

**Returns** `boolean`

**Usage:**

```java
Integer integer[] = {1,1,1,1};
ArrayContentsValidator mArrayContentsValidator = new ArrayContentsValidator();
boolean mBoolean = mArrayContentsValidator.isArrayOfIntendedType(integer, Integer.class);
if(mBoolean)
{
  //true - Array contents are of Intended type
}
else
{
  //false - Array contents are not of Intended type
}
```

**Output:**<br>
> **TRUE** (Boolean)<br>
> **FALSE** (Boolean)

-----

##checkArrayOfIntendedType(Object objectArray[], Class arrayType)

Checker method to validate the array contents of the input array, which returns an empty list if the array is of intended `Class` type and a list of applicable error on failure.

**Params**
- objectArray[] `Object`
- arrayType `Class`

**Returns** `List<String>`

**Usage:**

```java
Integer integer[] = {1,1,1,1};
ArrayContentsValidator mArrayContentsValidator = new ArrayContentsValidator();
List<String> list = mArrayContentsValidator.checkArrayOfIntendedType(integer, Integer.class);

if(list.isEmpty())
{
  //success
}
else
{
  //Error specifying the reason for failure
}
```

**Output:**<br>
> Success Scenario: Size of List will be zero<br>
> Failure Scenario: List('ERR\_EMPTY\_INPUT')<br>
> Failure Scenario: List('ERR\_ARRAY\_CONTENTS\_TYPE\_MISMATCH')

Please refer to our [error codes documentation](https://github.disney.com/WDPR-RA-UI/docs/blob/master/docs/security/Validator_Error_Codes.md#array) for further details on their definitions

-----