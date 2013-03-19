/*
* Licensed under the MIT license
* http://htmlpreview.github.com/?https://github.com/tapfortap/Documentation/blob/master/License.html
* Copyright (c) 2013 Tap for Tap
*/

package com.tapfortap.basic4android;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;

import com.tapfortap.AppWall.AppWallListener;

@Events(values={"Dismissed", "FailedToReceiveAd"})
@ShortName("TapForTapAppWall")
public class AppWall {
	
	/**
	 * Prepares an AppWall
	 */
	public static void prepare(BA ba) {
		com.tapfortap.AppWall.prepare(ba.context);
	}
	
	/**
	 * Shows and AppWall
	 */
	public static void show(BA ba) {
		com.tapfortap.AppWall.show(ba.context);
	}
	
	/**
	 * Set AppWall the event handler.
	 */
	public static void setEventHandler(final BA ba, final String eventName) {
	    com.tapfortap.AppWall.prepare(ba.context);
		com.tapfortap.AppWall.setListener(new AppWallListener() {
			
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
