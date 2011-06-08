package com.gemserk.analytics.googleanalytics.android;

import com.dmurph.tracking.VisitorData;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class AnalyticsStoredConfig {

	private static final String VISITOR_ID = "visitorId";
	private static final String TIMESTAMP_FIRST = "timestampFirst";
	private static final String TIMESTAMP_LAST = "timestampLast";
	private static final String VISITS = "visits";
	private SharedPreferences preferences;
	private final Context context;

	public AnalyticsStoredConfig(Context context) {
		this.context = context;
		preferences = context.getSharedPreferences(AnalyticsStoredConfig.class.getCanonicalName(), Context.MODE_PRIVATE);
	}
	
	public VisitorData loadVisitor(){
		if(!preferences.contains(VISITOR_ID)){
			VisitorData visitorData = VisitorData.newVisitor();
			Log.i("ANALYTICS", "Creating new visitor data for visitorid: " + visitorData.getVisitorId());
			return visitorData;
		} else {
			
			int visitorId = preferences.getInt(VISITOR_ID, 1);
			long timestampFirst = preferences.getLong(TIMESTAMP_FIRST, 0);
			long timestampLast = preferences.getLong(TIMESTAMP_LAST, 0);
			int visits = preferences.getInt(VISITS, 1);
			Log.i("ANALYTICS", "Loading visitor data for visitorId: " + visitorId);
			return VisitorData.newSession(visitorId, timestampFirst, timestampLast, visits);
		}
	}
	
	public void saveVisitor(VisitorData visitorData){
		Editor editor = preferences.edit();
		editor.putInt(VISITOR_ID,visitorData.getVisitorId());
		editor.putLong(TIMESTAMP_FIRST,visitorData.getTimestampFirst());
		editor.putLong(TIMESTAMP_LAST,visitorData.getTimestampCurrent());
		editor.putInt(VISITS,visitorData.getVisits());
		editor.commit();
		Log.i("ANALYTICS", "Saving visitor data for visitorId: " + visitorData.getVisitorId());
	}
}
