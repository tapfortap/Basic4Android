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
    private static com.tapfortap.AppWall appWall;
    private static String mEventName;
    
    private static com.tapfortap.AppWall getAppWall(BA ba) {
        if (appWall == null) {
            appWall = com.tapfortap.AppWall.create(ba.context, getListener(ba));
        }
        return appWall;
    }
	
	/**
	 * Prepares an AppWall
	 */
	public static void prepare(BA ba) {
	    getAppWall(ba).load();
	}
	
	/**
	 * Shows and AppWall
	 */
	public static void show(BA ba) {
	    getAppWall(ba).showAndLoad();
	}
	
	/**
	 * Set AppWall the event handler.
	 */
	public static void setEventHandler(final BA ba, final String eventName) {
	   mEventName = eventName;
	}
	
	private static AppWallListener getListener(final BA ba) {
	    return new AppWallListener() {
            @Override
            public void appWallOnDismiss(com.tapfortap.AppWall appWall) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_dismissed", true, null);
            }

            @Override
            public void appWallOnFail(com.tapfortap.AppWall appWall, String reason, Throwable throwable) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_failedtoreceivead", true, null);
            }

            @Override
            public void appWallOnReceive(com.tapfortap.AppWall appWall) {
                 ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_receivead", true, null);
                
            }

            @Override
            public void appWallOnShow(com.tapfortap.AppWall appWall) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_showad", true, null);
                
            }

            @Override
            public void appWallOnTap(com.tapfortap.AppWall appWall) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_tapad", true, null);
                
            }
        };
	}
}
