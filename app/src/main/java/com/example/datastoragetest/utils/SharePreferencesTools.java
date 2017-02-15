package com.example.datastoragetest.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 坏蛋 on 2017/2/15.
 */
public class SharePreferencesTools {
    public static final void writeData(Context context, String string) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("share1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("content", string);
        editor.apply();
//        SQLiteOpenHelper
    }

    public static final String readData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("share1", Context.MODE_PRIVATE);
        String content=sharedPreferences.getString("content","");
        return content;
    }
}
