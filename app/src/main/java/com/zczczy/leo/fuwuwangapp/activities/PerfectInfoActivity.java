package com.zczczy.leo.fuwuwangapp.activities;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by leo on 2015/6/21.
 */

@EActivity(R.layout.perfect_info_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class PerfectInfoActivity extends BaseActivity {

    @ViewById
    MyTitleView title;

    @ViewById
    EditText edt_real_name,edt_mobile_phone,edt_post_code,edt_delivery,edt_name,edt_bank_card,edt_bank,edt_bank_area,edt_bank_city;

    @ViewById
    RadioGroup rg_rg;

    @ViewById
    Button btn_save;

    @ViewById
    RadioButton rb_user_info,rb_finance_info;

    @ViewById
    LinearLayout ll_user_info,ll_finance_info;

    @StringRes
    String txt_perfect_info_title;


    @AfterViews
    void afterView() {
        title.setListener(this);
        title.setTitle(txt_perfect_info_title);
    }

    @Click
    void btn_save(){

    }

    @Click
    void edt_bank(){

    }




    @CheckedChange
    void rb_user_info(boolean checked){

        if(checked){
            ll_user_info.setVisibility(View.VISIBLE);

        }else {
            ll_user_info.setVisibility(View.GONE);
        }

    }

    @CheckedChange
    void rb_finance_info(boolean checked){

        if(checked){
            ll_finance_info.setVisibility(View.VISIBLE);

        }else {
            ll_finance_info.setVisibility(View.GONE);
        }

    }

}
