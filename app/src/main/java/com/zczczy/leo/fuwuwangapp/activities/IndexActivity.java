package com.zczczy.leo.fuwuwangapp.activities;

import android.view.Window;

import com.zczczy.leo.fuwuwangapp.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.WindowFeature;

/**
 * Created by leo on 2015/6/18.
 */
@EActivity(R.layout.index_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class IndexActivity extends BaseActivity {

    @AfterViews
    void  afterView(){
        afterHolding();
    }


    @Background()
    void holdidng(){

    }

    @UiThread(delay = 1000)
    void afterHolding(){
        MainActivity_.intent(this).start();
        finish();
    }

}
