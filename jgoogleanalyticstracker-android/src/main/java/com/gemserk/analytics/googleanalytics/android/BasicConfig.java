package com.gemserk.analytics.googleanalytics.android;

import java.util.Locale;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;

import com.dmurph.tracking.AnalyticsConfigData;

public class BasicConfig {
	public static void configure(AnalyticsConfigData data, Context context) {
		data.setEncoding("UTF-8"); // it is hardcoded on the analytics for android sdk

		Locale locale = Locale.getDefault();
		data.setUserLanguage(locale.getLanguage() + "-" + locale.getCountry());

		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		data.setScreenResolution(width + "x" + height);

		String userAgentProduct = "JGoogleAnalyticsTracker";
		String userAgentVersion = "1.0";
		data.setUserAgent(String.format("%s/%s (Linux; U; Android %s; %s-%s; %s; Build/%s)", new Object[] { userAgentProduct, userAgentVersion, Build.VERSION.RELEASE, (locale.getLanguage() != null) ? locale.getLanguage().toLowerCase() : "en", (locale.getCountry() != null) ? locale.getCountry().toLowerCase() : "", Build.MODEL, Build.ID }));
	}
}
