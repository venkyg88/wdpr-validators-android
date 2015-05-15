<<<<<<< HEAD
wdpr-validators-android
=======================
=======
# WDPR-Validators-Android

The following library block performs email validation.

# Why?

The following library block provides the email validation which cover most of the Invalid email messages enabling diffenent teams in Disney to use the feature they require for the appilcation instead of writing the boilerplate. This helps to maintian consistency across different teams working on different applications.

## Getting Started

#Consuming the API.
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

## checkEmail(email)

This function help to verify whether input is a valid email or not, if its not valid it will throw error codes of the respective messages.

**Params**
- email `String` - Email should follow RFC standards.

**Returns**: `String`

**Usage:**

String result = emailValidatorClass.checkEmail(email);
if (result=="200"){
mResultText.setText("Email format is good");
}
else {
mEmailText.setError((CharSequence) HashMapValues.hashMethod().get(result));
mResultText.setText("");
}

> **OUTPUT:**<br>
> **200** (Valid Email)<br>
> **100** (Email is empty)<br>
> **105** (Email length exceeds the limit)<br>
> **106** (Email has more than one '@')<br>
> **107** (Email Cannot start with '@')<br>
> **108** (Local-part length exceeds the limit)<br>
> **109** (Domain length exceeds the limit)<br>
> **110** (Valid Email has both local and domain)<br>
> **111** (Email cannot start of End with '.')<br>
> **112** (Email cannot have two repeating dots)<br>
> **113** (Email not in proper format)

>>>>>>> 4d64900a990791ac7f953c3cc8c3db92c2644083
