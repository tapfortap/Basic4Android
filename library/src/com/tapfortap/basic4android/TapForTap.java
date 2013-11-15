/*
* Licensed under the MIT license
* http://htmlpreview.github.com/?https://github.com/tapfortap/Documentation/blob/master/License.html
* Copyright (c) 2013 Tap for Tap
*/

package com.tapfortap.basic4android;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

import com.tapfortap.TapForTap.Gender;

@Permissions(values={"android.permission.INTERNET" , "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE"})
@ShortName("TapForTap")
@Author("TapForTap")
@Version(1.4f)
@ActivityObject
public class TapForTap {
	
	/**
	 * Initializes Tap for Tap so that you can begin showing ads
	 * 
	 * @param apiKey Your Tap for Tap API key
	 */
	public static void initialize(final BA ba, String apiKey) {
	    com.tapfortap.TapForTap.PLUGIN = "basic4aNDROID";
        com.tapfortap.TapForTap.PLUGIN_VERSION = "1.3.1";
	    com.tapfortap.TapForTap.initialize(ba.activity != null ? ba.activity : ba.context, apiKey);
	}
	
	/**
	 * Get the version of the Tap for Tap SDK
	 * @return Tap for Tap SDK version
	 */
	public static String getTftVersion() {
		return com.tapfortap.TapForTap.getVersion();
	}
	
	/**
	 * Set the user's gender
	 * @param gender, 0 for male, 1 for female
	 */
	public static void setGender(int gender) {
		switch (gender) {
		case 0:
			com.tapfortap.TapForTap.setGender(Gender.MALE);
			break;
		case 1:
			com.tapfortap.TapForTap.setGender(Gender.FEMALE);
			break;
		default:
			com.tapfortap.TapForTap.setGender(Gender.NONE);
			break;
		}
	}
	
	/**
	 * Set the user's year of birth
	 * 
	 * @param yearOfBirth
	 */
	public static void setYearOfBirth(int yearOfBirth) {
		com.tapfortap.TapForTap.setYearOfBirth(yearOfBirth);
	}
	
	/**
	 * Set a custom user id
	 * 
	 * @param userAccountId
	 */
	public static void setUserAccountId(String userAccountId) {
		com.tapfortap.TapForTap.setUserAccountId(userAccountId);
	}
}


