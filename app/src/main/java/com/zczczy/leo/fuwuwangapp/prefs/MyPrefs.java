package com.zczczy.leo.fuwuwangapp.prefs;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by Leo on 2015/3/9.
 */

@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface MyPrefs {

    @DefaultString("")
    String channel_id();

    @DefaultString("")
    String user_id();

    @DefaultString("")
    String aap_id();
}
