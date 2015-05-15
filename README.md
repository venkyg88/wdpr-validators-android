# WDPR-Validators-Android

The following library block performs email validation.

# Why?

The following library block provides the email validation which cover most of the Invalid email messages enabling diffenent teams in Disney to use the feature they require for the appilcation instead of writing the boilerplate. This helps to maintian consistency across different teams working on different applications.

## Getting Started

# Installing


# Demo
1. Open Android Studio, Select File -> New -> Import Project from Version Control -> Git.</p>
2. Enter Git Repository URL, Parent Directory and Directory Name and then Clone.
3. Once you have the project you can run the application using either from an emulator or a real device.
4. Instructions for running the demo on [Real Device.](http://developer.android.com/training/basics/firstapp/running-app.html#RealDevice)
5. Instructions for running the demo on [Emulator](http://developer.android.com/training/basics/firstapp/running-app.html#Emulator)

## API Methods

The WDPR Validators have the following methods.

## checkEmail(email)

This function help to verify whether input is a valid email or not, if its not valid it will throw error codes of the respective messages.

**Params**
- email `String` - Email should follow RFC standards. 
- <p>Valid email addresses</p>
<p><code>niceandsimple@example.com</code></p>
<p><code>very.common@example.com</code></p>
<p><code>a.little.lengthy.but.fine@dept.example.com</code></p>
<p><code>disposable.style.email.with+symbol@example.com</code></p>
<p><code>other.email-with-dash@example.com</code></p>
<p><code>"much.more unusual"@example.com</code></p>
<p><code>"very.unusual.@.unusual.com"@example.com</code></p>
<p><code>"very.(),:;<>[]\".VERY.\"very@\\ \"very\".unusual"@strange.example.com</code></p>
<p><code>admin@mailserver1 (local domain name with no TLD)</code></p>
<p><code>#!$%&'*+-/=?^_`{}|~@example.org</code></p>
<p><code>"()<>[]:,;@\\\"!#$%&'*+-/=?^_`{}| ~.a"@example.org</code></p>
<p><code>" "@example.org </p>
<p><code>üñîçøðé@example.com </code></p>
<p><code>üñîçøðé@üñîçøðé.com /code></p>
- <p>Invalid email addresses</p>
<p><code>Abc.example.com</code></p>
<p><code>A@b@c@example.com</code></p>
<p><code>a"b(c)d,e:f;g<h>i[j\k]l@example.com </code></p>
<p><code>just"not"right@example.com </code></p>
<p><code>this is"not\allowed@example.com </code></p>
<p><code>this\ still\"not\\allowed@example.com </code></p>
<p><code>john..doe@example.com (double dot before @)</code></p>
<p><code>john.doe@example..com (double dot after @)</code></p>

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

