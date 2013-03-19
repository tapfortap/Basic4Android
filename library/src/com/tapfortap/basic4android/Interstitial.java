/*
* Licensed under the MIT license
* http://htmlpreview.github.com/?https://github.com/tapfortap/Documentation/blob/master/License.html
* Copyright (c) 2013 Tap for Tap
*/

package com.tapfortap.basic4android;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;

import com.tapfortap.Interstitial.InterstitialListener;

@Events(values={"Dismissed", "FailedToReceiveAd"})
@ShortName("TapForTapInterstitial")
public class Interstitial {

	/**
	 * Prepares an interstitial
	 */
	public static void prepare(BA ba) {
		com.tapfortap.Interstitial.prepare(ba.context);
	}
	
	/**
	 * Shows and interstitial
	 */
	public static void show(BA ba) {
		com.tapfortap.Interstitial.show(ba.context);
	}
	
	/**
	 * Set the interstitial event handler.
	 */
	public static void setEventHandler(final BA ba, final String eventName) {
	    com.tapfortap.Interstitial.prepare(ba.context);
		com.tapfortap.Interstitial.setListener(new InterstitialListener() {
			
			@Override
			public void onDismiss() {
			    ba.raiseEventFromDifferentThread(this, null, 0, eventName.toLowerCase(BA.cul) + "_dismissed", true, null);
			}

            @Override
            public void onFail(String arg0) {
                ba.raiseEventFromDifferentThread(this, null, 0, eventName.toLowerCase(BA.cul) + "_failedtoreceivead", true, null);
            }
		});
	}
}
