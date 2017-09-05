# FirebaseAndroidLogin
Logging in via Facebook, Google, Email for your Android application, with Firebase as backend, with verification

Features of the application:

1. First time launch shows help sliders.
2. Register using email, Google, Facebook for the application.
3. Email verification, resend verification and Password Reset.
4. Logout option in navigation drawer.


<h3>Follow all the steps after this to connect to Firebase:</h3>

<h6>Preparing Firebase</h6><br>

1. Create a Firebase project in the <a href="https://console.firebase.google.com">Firebase console </a>
2. Click Add Firebase to your Android app and follow the setup steps.(No need to enter SHA1 value, we will do that later)
3. Download the json and follow instructions to place it in app folder of your application.
4. No need to follow gradle instructions as dependencies are already added.

<h6>Adding Authentication types in Firebase (email, fb, gmail) - Click on the Authentication tab of your current firebase application console and setup sign-in methods.</h6><br>

#EMAIL:<br>
1. Enable email/password sign-in option.<br>

#GMAIL:<br>
1. Enable gmail sign-in option and then goto <a href="https://developers.google.com/android/guides/client-auth">Google Client Auth </a> to get your SHA1<br>
2. Go to settings of your firebase application and add the SHA1 to SHA certificate fingerprints.<br>
3. Download the google-services.json file again and save at the same location as stored previously. (under \app)<br>

#FB:<br>
1. Get the App ID and an App Secret for your app from <a href="https://developers.facebook.com/docs/facebook-login/android">Facebook for Developers</a><br><br>
a. Create a new app from step 1 in the above mentioned link.<br>
b. Goto step 4. and get: "facebook_app_id" and "fb_login_protocol_scheme". Replace the values in your strings.xml<br>
c. Goto step 5 and add Package Name and Default CLass names from the manifest.<br>
d. Goto step 6 and generate development hash, add it and save. (Note: If you get and error saying openssl is unrecognised, replace openssl with the location of openssl.exe, eg.<br><br><i>
    keytool -exportcert -alias androiddebugkey -keystore %HOMEPATH%\.android\debug.keystore | "C:\OpenSSL\bin\openssl.exe" sha1 -binary | "C:\OpenSSL\bin\openssl.exe" base64) </i><br><br>
e. Enable Single Sign On and save.<br><br>
2. Goto Dashboard of the newly create facebook app, and get the app id and key.<br>
3. Enable facebook sign-in option on your firebase authentication tab, and add the app id and key. Also copy the OAuth link.<br>
4. Goto Facebook App dashboard. Click on Add product and add Facebook Login. Ignore the steps and go to setting for Facebook Login and add the copied O-auth link to Valid OAuth redirect URIs.<br>
