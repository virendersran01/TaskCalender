package com.virtualstudios.taskcalender.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private SharedPreferences sharedPreferences;
    public final String KEY_PREFERENCE_NAME = "sharedPreference";
    public final String KEY_PREFERENCE_LOGIN_STATUS = "loginStatus";
    private final String KEY_PREFERENCE_USER_ID = "userId";
    private final String KEY_PREFERENCE_USER_FULL_NAME = "userFullName";
    private final String KEY_PREFERENCE_USER_EMAIL = "email";
    private final String KEY_PREFERENCE_USER_PROFILE_PIC_URL = "profilePicture";

    public PreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void setLoginStatus(boolean loginStatus) {
        sharedPreferences.edit().putBoolean(KEY_PREFERENCE_LOGIN_STATUS, loginStatus).apply();
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean(KEY_PREFERENCE_LOGIN_STATUS, false);
    }

    public void setUserId(String userId){
        sharedPreferences.edit().putString(KEY_PREFERENCE_USER_ID, userId).apply();
    }

    public String getUserId() {
        return sharedPreferences.getString(KEY_PREFERENCE_USER_ID, null);
    }

    public void setUserFullName(String userFullName){
        sharedPreferences.edit().putString(KEY_PREFERENCE_USER_FULL_NAME, userFullName).apply();
    }

    public String getUserFullName() {
        return sharedPreferences.getString(KEY_PREFERENCE_USER_FULL_NAME, null);
    }

    public void setUserEmail(String userEmail){
        sharedPreferences.edit().putString(KEY_PREFERENCE_USER_EMAIL,userEmail).apply();
    }

    public String getUserEmail(){
        return sharedPreferences.getString(KEY_PREFERENCE_USER_EMAIL,null);
    }


    public void setProfilePicUrl(String profilePicUrl){
        sharedPreferences.edit().putString(KEY_PREFERENCE_USER_PROFILE_PIC_URL, profilePicUrl).apply();
    }

    public String getProfilePicUrl(){
        return sharedPreferences.getString(KEY_PREFERENCE_USER_PROFILE_PIC_URL, null);
    }

    public void clearUserData(){
        sharedPreferences.edit().clear().apply();
    }


}
