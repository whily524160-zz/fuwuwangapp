package com.zczczy.leo.fuwuwangapp.activities;

import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by leo on 2015/6/20.
 */
@EActivity(R.layout.transfer_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class TransferActivity extends  BaseActivity{

    @ViewById
    MyTitleView title;


    @ViewById
    EditText edt_money,edt_receiver,edt_real_name;


    @ViewById
    Button btn_transfer;


    @StringRes
    String txt_transfer_title;

    @AfterViews
    void afterView() {

        title.setListener(this);

        title.setTitle(txt_transfer_title);

    }

    @Click
    void btn_transfer(){

    }


}
