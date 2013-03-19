/*
* Licensed under the MIT license
* http://htmlpreview.github.com/?https://github.com/tapfortap/Documentation/blob/master/License.html
* Copyright (c) 2013 Tap for Tap
*/ 

package com.tapfortap.basic4android;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;

import com.tapfortap.AdView.AdViewListener;

@Events(values={"ReceiveAd", "FailedToReceiveAd (Reason As String)", "OnTap"})
@ShortName("TapForTapAdView")
@ActivityObject
public class AdView extends AbsObjectWrapper<com.tapfortap.AdView> {

    /**
     * Create a new AdView and begin to load ads
     */
	public void initialize(BA ba) {
		setObject(new com.tapfortap.AdView(ba.activity));
	}
	
	/**
	 * Start loading ads
	 */
	public void loadAds() {
		getObject().loadAds();
	}
	
	/**
	 * Stop loading ads
	 */
	public void stopLoadingAds() {
		getObject().stopLoadingAds();
		
	}
	
	/**
	 * Set this AdView's event handler.
	 * @param eventName
	 */
	public void setEventHandler(final BA ba, final String eventName) {
		getObject().setListener(new AdViewListener() {
		@Override
		public void onFailToReceiveAd(String reason) {
			ba.raiseEvent(getObject(), eventName.toLowerCase(BA.cul) + "_failedtoreceivead", reason);
		}
	
		@Override
		public void onReceiveAd() {
			ba.raiseEvent(getObject(), eventName.toLowerCase(BA.cul) + "_receivead");	
		}
	
		@Override
		public void onTapAd() {
			ba.raiseEvent(getObject(), eventName.toLowerCase(BA.cul) + "_tapad");	
		};	
	});
		
	}
}
