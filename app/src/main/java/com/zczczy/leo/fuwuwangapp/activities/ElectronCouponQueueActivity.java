package com.zczczy.leo.fuwuwangapp.activities;

import android.view.Window;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by leo on 2015/6/22.
 */
@EActivity(R.layout.electron_coupon_queue_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class ElectronCouponQueueActivity extends BaseActivity {

    @ViewById
    MyTitleView title;

    @StringRes
    String txt_electron_coupon_queue_title;

    @AfterViews
    void afterView(){

        title.setTitle(txt_electron_coupon_queue_title);

        title.setListener(this);
    }

}



