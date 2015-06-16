<<<<<<< HEAD
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
7. For testing, go the respective folder in terminal and type './gradlew connectedcheck'.
8. Then open the index.html file in reports folder, you can see the report of test cases failed/passed/percentage.

Note: Alwasys Make sure your emulator/device is up and running before you test.

## API Methods

The WDPRValidators have the following methods.

## isValidEmail(emailPattern, email)

This function returns a boolean, checking whether it is valid email or Invalid email.

**Params**
- emailPattern 'Pattern' predefined email pattern.
- email 'String'

**Returns:** `Boolean`


## checkEmail(email)

This function will throw error codes of the respective messages, if isValidEmail funtion returns false.

**Params**
- email `String` Email should follow RFC standards.

**Returns:** `String`


## aUnicodeString(Object)

Predicate to determine whether something is a fully nuanced Unicode string with nothing too scary in it.

**Params**
- Object `String`

**Returns:** `boolean`

## isISO8601(Object)

predicate to determine whether a date meets the basic structure of an ISO 8601 date format.

**Params**
- Object `String` - date Object to be evaluated

**Returns:** `boolean`

## checkIsoDate(Object)

Checker to determine whether the provided string is a valid ISO8601 date.

**Params**
- Object `String` - date Object to be evaluated

**Returns:** `String` - function that takes a single object for testing Function. This returns a string error message.

## isAnArray(Object)

predicate to determine whether the provided Object is an array.

**Params**
- Object `Object` - array Object to be evaluated

**Returns:** `boolean` 


## isAString(Object)

predicate to determine whether the provided Object is a String.

**Params**
- Object `Object` - string Object to be evaluated

**Returns** `boolean`


## checkDateRange(Object, Object, Object)

Checker to determine whether user date falls in the range of start date and end date inclusively.

**Params**
- Object `Date` - start date Object
- Object `Date` - end date Object
- Object `Date` - target date Object to be evaluated with start and end date

**Returns** `String`

## isInRange(Object, Object, Object)

predicate to determine whether the target date is in the range provided.

**Params**
- Object `Date` - start date Object
- Object `Date` - end date Object
- Object `Date` - target date Object to be evaluated with start and end date

**Returns** `boolean`
=======
# WDPR-Validators-Android

The following library performs validation for primitive methods and complex methods like Credit Cards.

# Why?

The following library block provides both basic and complex methods for input validation which is intended to be imported and implemented within Android applications.

# Getting Started

## Installing.
1. Need to include the particular package in dependencies block under build.gradle.
2. Yet to decide on how to include the packages in the repository and where?


# Demo
1. Open Android Studio, Select File -> New -> Import Project from Version Control -> Git.</p>
2. Enter Git Repository URL, Parent Directory and Directory Name and then Clone.
3. Once you have the project you can run the application using either from an emulator or a real device.
4. Instructions for running the demo on [Real Device.](http://developer.android.com/training/basics/firstapp/running-app.html#RealDevice)
5. Instructions for running the demo on [Emulator](http://developer.android.com/training/basics/firstapp/running-app.html#Emulator)
6. For testing, go the respective folder in terminal and type './gradlew connectedcheck'.
7. Then open the index.html file in reports folder, you can see the report of test cases failed/passed/percentage.

## API Methods

The WDPR Validators have the following methods.

## isValidEmail(emailPattern, email)

This function returns a boolean, checking whether it is valid email or Invalid email.

**Params**
- emailPattern 'Pattern' predefined email pattern.
- email 'String'

**Returns:** `Boolean`


## checkEmail(email)

This function will throw error codes of the respective messages, if isValidEmail funtion returns false.

**Params**
- email `String` Email should follow RFC standards.

**Returns:** `String`


## aUnicodeString(Object)

Predicate to determine whether something is a fully nuanced Unicode string with nothing too scary in it.

**Params**
- Object `String`

**Returns:** `boolean`

## isISO8601(Object)

predicate to determine whether a date meets the basic structure of an ISO 8601 date format.

**Params**
- Object `String` - date Object to be evaluated

**Returns:** `boolean`

## checkIsoDate(Object)

Checker to determine whether the provided string is a valid ISO8601 date.

**Params**
- Object `String` - date Object to be evaluated

**Returns:** `String` - function that takes a single object for testing Function. This returns a string error message.

## isAnArray(Object)

predicate to determine whether the provided Object is an array.

**Params**
- Object `Object` - array Object to be evaluated

**Returns:** `boolean` 


>>>>>>> develop
