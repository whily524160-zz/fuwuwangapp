package com.zczczy.leo.fuwuwangapp.activities;

import android.app.Activity;

import com.zczczy.leo.fuwuwangapp.listener.TitleClickListener;


/**
 * Created by Leo on 2015/4/29.
 */
public class BaseActivity extends Activity implements TitleClickListener {

    @Override
    public void backClick() {
        finish();
    }

    @Override
    public void otherClick() {
        // TODO Auto-generated method stub

    }
}
