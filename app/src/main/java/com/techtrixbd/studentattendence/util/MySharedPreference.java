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

    /*public void setID(String data) {
        editor.putString(Util.encryptString("id"), Util.encryptString(data));
        editor.apply();
    }

    public String getID() {
        return Util.decryptString(sharedPreferences.getString(Util.encryptString("id"), "bg=="));
    }

    public void setEmail(String data) {
        editor.putString(Util.encryptString("email"), Util.encryptString(data));
        editor.apply();
    }

    public String getEmail() {
        return Util.decryptString(sharedPreferences.getString(Util.encryptString("email"), "bg=="));
    }

    public void setLocale(String locale) {
        editor.putString(Util.encryptString("locale"), Util.encryptString(locale));
        editor.apply();
    }

    public String getLocale() {
        return Util.decryptString(sharedPreferences.getString(Util.encryptString("locale"), "ZW4="));
    }

    public void setIsUser(Boolean data) {
        editor.putBoolean(Util.encryptString("type"), data);
        editor.apply();
    }

    public Boolean getIsUser() {
        return sharedPreferences.getBoolean(Util.encryptString("type"), true);
    }


    public void setIsLoggedIn(Boolean data) {
        editor.putBoolean(Util.encryptString("logged"), data);
        editor.apply();
    }

    public Boolean getIsLoggedIn() {
        return sharedPreferences.getBoolean(Util.encryptString("logged"), false);
    }

    public void setIsLogged(String data) {
        editor.putString(Util.encryptString("log"), Util.encryptString(data));
        editor.apply();
    }

    public String getIsLogged() {
        return Util.decryptString(sharedPreferences.getString(Util.encryptString("log"), "bg=="));
    }


    public void setUUID(String data) {
        editor.putString(Util.encryptString("uuid"), Util.encryptString(data));
        editor.apply();
    }

    public String getUUID() {
        return Util.decryptString(sharedPreferences.getString(Util.encryptString("uuid"), "bg=="));
    }

    public void setSubscribed(String data,boolean isTrue) {
        editor.putBoolean(Util.encryptString(data), isTrue);
        editor.apply();
    }

    public boolean getSubscribed(String data) {
        return sharedPreferences.getBoolean(Util.encryptString(data), false);
    }

    public void setIsNoticeSeenCount(String inst, int data) {
        editor.putInt(Util.encryptString(inst), data);
        editor.apply();
    }

    public int getIsNoticeSeenCount(String inst) {
        return sharedPreferences.getInt(Util.encryptString(inst), 0);
    }

    public void setCode( String data) {
        editor.putString(Util.encryptString("code"),  Util.encryptString(data));
        editor.apply();
    }

    public String getCode() {
        return Util.decryptString(sharedPreferences.getString(Util.encryptString("code"), "bg=="));
    }

    public void setHaveSeenNotice(String inst, boolean data) {
        editor.putBoolean(Util.encryptString(inst), data);
        editor.apply();
    }

    public boolean getHaveSeenNotice(String inst) {
        return sharedPreferences.getBoolean(Util.encryptString(inst), false);
    }

    public void setIsNotificationSynced( boolean data) {
        editor.putBoolean(Util.encryptString("isSynced"), data);
        editor.apply();
    }

    public boolean getISNotificationSynced() {
        return sharedPreferences.getBoolean(Util.encryptString("isSynced"), false);
    }

    public void isBlocked( boolean data) {
        editor.putBoolean(Util.encryptString("isBlocked"), data);
        editor.apply();
    }

    public boolean getIsBlocked() {
        return sharedPreferences.getBoolean(Util.encryptString("isBlocked"), false);
    }*/
}
