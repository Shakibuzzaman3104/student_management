package com.techtrixbd.studentattendence.util;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    private static MySharedPreference myPreferences;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private MySharedPreference(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences("SharedPreferenceName", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static MySharedPreference getPreferencesInstance(Context context) {
        if (myPreferences == null) myPreferences = new MySharedPreference(context);
        return myPreferences;
    }

    public void setIsFirstBoot(Boolean data) {
        editor.putBoolean(Util.encryptString("boot"), data);
        editor.apply();
    }

    public Boolean isFirstBoot() {
        return sharedPreferences.getBoolean(Util.encryptString("boot"), true);
    }

    public void setID(String  data) {
        editor.putString(Util.encryptString("id"), data);
        editor.apply();
    }

    public String getID() {
        return sharedPreferences.getString(Util.encryptString("id"), "none");
    }

    public void setSection(String  data) {
        editor.putString(Util.encryptString("sec"), data);
        editor.apply();
    }

    public String getSection() {
        return sharedPreferences.getString(Util.encryptString("sec"), "none");
    }
}
