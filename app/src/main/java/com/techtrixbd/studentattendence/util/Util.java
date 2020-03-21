package com.techtrixbd.studentattendence.util;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.util.TypedValue;

import java.io.File;
import java.util.regex.Pattern;

public class Util {

    public static int dpToPx(int dp) {
        Resources r = Resources.getSystem();
        float val = (float) dp;
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, val, r.getDisplayMetrics()));
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static  boolean isValidPassword(CharSequence pass)
    {
        return pass.toString().trim().length()>5;
    }


    public static  boolean isValidName(CharSequence name)
    {
        String regex = "(.)*(\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);
        return name.toString().trim().length()>2 && !pattern.matcher(name.toString().trim()).matches();
    }

    public static  boolean isValidSection(CharSequence name)
    {
        return name.toString().trim().length()<2 && name.toString().trim().matches("^[a-hA-H]*$");
    }

    public static  boolean isValidID(CharSequence id)
    {
        return id.toString().trim().length()>7;
    }


    public static boolean matchPassword(CharSequence pass, CharSequence pass2)
    {
        return pass.equals(pass2);
    }

    public  static  boolean isValidNumber(String number)
    {
        return number.length() == 11 ;
    }


    public static String encryptString( String input) {
        // This is base64 encoding, which is not an encryption
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }

    public static String decryptString(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }

    public static String getName(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return "";
        }
        int extract = filePath.lastIndexOf('?');
        if (extract > 0) {
            filePath = filePath.substring(0, extract);
        }
        int namePos = filePath.lastIndexOf(File.separatorChar);
        return (namePos >= 0) ? filePath.substring(namePos + 1) : filePath;
    }




}
