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

import com.tapfortap.Banner;
import com.tapfortap.Banner.BannerListener;

@Events(values={"ReceiveAd", "FailedToReceiveAd (Reason As String)", "OnTap"})
@ShortName("TapForTapAdView")
@ActivityObject
public class AdView extends AbsObjectWrapper<Banner> {

    /**
     * Create a new AdView and begin to load ads
     */
	public void initialize(BA ba) {
		setObject(Banner.create(ba.activity));
	}
	
	/**
	 * Start loading ads
	 */
	public void loadAds() {
		getObject().startShowingAds();
	}
	
	/**
	 * Stop loading ads
	 */
	public void stopLoadingAds() {
		getObject().stopShowingAds();
		
	}
	
	/**
	 * Set this AdView's event handler.
	 * @param eventName
	 */
	public void setEventHandler(final BA ba, final String eventName) {
	    getObject().setListener(new BannerListener() {
            
            @Override
            public void bannerOnTap(Banner banner) {
                 ba.raiseEvent(getObject(), eventName.toLowerCase(BA.cul) + "_tapad");
                
            }
            
            @Override
            public void bannerOnReceive(Banner banner) {
                 ba.raiseEvent(getObject(), eventName.toLowerCase(BA.cul) + "_receivead");
                
            }
            
            @Override
            public void bannerOnFail(Banner banner, String reason, Throwable throwable) {
                 ba.raiseEvent(getObject(), eventName.toLowerCase(BA.cul) + "_failedtoreceivead", reason);
                
            }
        });
	}
}
