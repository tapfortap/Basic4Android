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

@Events(values = { "Dismissed", "FailedToReceiveAd" })
@ShortName("TapForTapInterstitial")
public class Interstitial {
    private static com.tapfortap.Interstitial interstitial;
    private static String mEventName;

    private static com.tapfortap.Interstitial getInterstitial(BA ba) {
        if (interstitial == null) {
            interstitial = com.tapfortap.Interstitial.create(ba.context, getListener(ba));
        }
        return interstitial;
    }

    /**
     * Prepares an Interstitial
     */
    public static void prepare(BA ba) {
        getInterstitial(ba).load();
    }

    /**
     * Shows and Interstitial
     */
    public static void show(BA ba) {
        getInterstitial(ba).showAndLoad();
    }

    /**
     * Set Interstitial the event handler.
     */
    public static void setEventHandler(final BA ba, final String eventName) {
        mEventName = eventName;
    }

    private static InterstitialListener getListener(final BA ba) {
        return new InterstitialListener() {
            @Override
            public void interstitialOnDismiss(com.tapfortap.Interstitial interstitial) {
                ba.raiseEventFromDifferentThread(this, null, 0,
                        mEventName.toLowerCase(BA.cul) + "_dismissed", true,
                        null);
            }

            @Override
            public void interstitialOnFail(com.tapfortap.Interstitial interstitial,
                    String reason, Throwable throwable) {
                ba.raiseEventFromDifferentThread(this, null, 0,
                        mEventName.toLowerCase(BA.cul) + "_failedtoreceivead",
                        true, null);
            }

            @Override
            public void interstitialOnReceive(com.tapfortap.Interstitial interstitial) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_receivead", true, null);
            }

            @Override
            public void interstitialOnShow(com.tapfortap.Interstitial interstitial) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_showad", true, null);
            }

            @Override
            public void interstitialOnTap(com.tapfortap.Interstitial interstitial) {
                ba.raiseEventFromDifferentThread(this, null, 0, mEventName.toLowerCase(BA.cul) + "_tapad", true, null);
            }
        };
    }
}
