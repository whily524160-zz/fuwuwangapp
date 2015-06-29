package com.zczczy.leo.fuwuwangapp.activities;

import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by Leo on 2015/6/19.
 */
@EActivity(R.layout.wealth_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class WealthActivity extends  BaseActivity{

    @ViewById
    MyTitleView title;

    @ViewById
    TextView txt_e_purse,txt_transfer,txt_withdraw,txt_bill,txt_stamp,txt_ticket,txt_total_dou,txt_bi,txt_dou,txt_status;

    @ViewById
    LinearLayout ll_stamp,ll_ticket,ll_total_dou,ll_bi,ll_dou,ll_status;

    @StringRes
    String txt_w_wealth;




    @AfterViews
    void afterView() {

        title.setListener(this);

        title.setTitle(txt_w_wealth);

        txt_status.setText("代理商");

        txt_dou.setText("1320");

        txt_bi.setText("1532");

        txt_total_dou.setText("2580");

        txt_ticket.setText("50");

        txt_stamp.setText("108");

    }

    @Click
    void txt_transfer(){

        TransferActivity_.intent(this).start();
    }

    @Click
    void txt_withdraw(){

        WithDrawActivity_.intent(this).start();
    }

    @Click
    void txt_bill(){

        TransactionRecordActivity_.intent(this).start();

    }
    @Click
    void ll_stamp(){

        AndroidTool.showToast(this,"开发中");

    }

    @Click
    void ll_ticket(){

        AndroidTool.showToast(this,"开发中");
    }

    @Click
    void ll_total_dou(){
        AndroidTool.showToast(this,"开发中");

    }
    @Click
    void ll_bi(){
        AndroidTool.showToast(this,"开发中");

    }

    @Click
    void ll_dou(){
        AndroidTool.showToast(this,"开发中");
    }

    @Click
    void ll_status(){
        AndroidTool.showToast(this,"开发中");
    }

}
