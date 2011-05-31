package com.gemserk.analytics.googleanalytics.android;

import java.util.Locale;

import android.content.Context;
import android.util.DisplayMetrics;

import com.dmurph.tracking.AnalyticsConfigData;

public class BasicConfig {
	public static void configure(AnalyticsConfigData data, Context context){
		data.setEncoding("UTF-8"); //it is hardcoded on the analytics for android sdk
		
		Locale locale = Locale.getDefault();
		data.setUserLanguage(locale.getLanguage() + "-" +  locale.getCountry());
		
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		data.setScreenResolution(width + "x" + height);
		
	}
}
