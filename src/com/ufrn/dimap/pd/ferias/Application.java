package com.ufrn.dimap.pd.ferias;

import android.content.Context;
import android.content.SharedPreferences;

import com.parse.Parse;
import com.parse.ParseObject;

public class Application extends android.app.Application {
  // Debugging switch
  public static final boolean APPDEBUG = false;
  
  // Debugging tag for the application
  public static final String APPTAG = "AnyWall";

  // Key for saving the search distance preference
  private static final String KEY_SEARCH_DISTANCE = "searchDistance";

  private static SharedPreferences preferences;

  public Application() {
  }

  @Override
  public void onCreate() {
    super.onCreate();

    ParseObject.registerSubclass(AnywallPost.class);
    Parse.initialize(this, "7fid9iVxy3oA9N5xrQ6bPmsKJ3MotTdwW9ncrIfn",
        "aKCchIcKrlVLGRMmLfwULROquVB505tmzq4p6ffQ");
    preferences = getSharedPreferences("com.parse.anywall", Context.MODE_PRIVATE);
  }

  public static float getSearchDistance() {
    return preferences.getFloat(KEY_SEARCH_DISTANCE, 1000);
  }

  public static void setSearchDistance(float value) {
    preferences.edit().putFloat(KEY_SEARCH_DISTANCE, value).commit();
  }

}
