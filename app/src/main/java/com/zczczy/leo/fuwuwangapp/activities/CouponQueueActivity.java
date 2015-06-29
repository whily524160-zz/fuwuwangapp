package com.zczczy.leo.fuwuwangapp.activities;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
 * Created by leo on 2015/6/22.
 */
@EActivity(R.layout.coupon_queue_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class CouponQueueActivity extends BaseActivity {

    @ViewById
    MyTitleView title;

    @ViewById
    LinearLayout ll_electron_coupon, ll_paper_coupon;

    @ViewById
    RadioGroup rg_rg, rg_electron_coupon;

    @ViewById
    RadioButton rb_electron_coupon, rb_paper_coupon, rb_one_hundred, rb_two_hundred, rb_four_hundred, rb_five_hundred;

    @ViewById
    TextView txt_one_hundred, txt_two_hundred, txt_four_hundred, txt_five_hundred;

    @ViewById
    Button btn_transfer, btn_queue, btn_paper_transfer, btn_coupon_scan;

    @ViewById
    EditText edt_coupon_code, edt_coupon_pass;

    @StringRes
    String txt_coupon_queue_title;

    @AfterViews
    void afterView() {
        title.setTitle(txt_coupon_queue_title);
        title.setListener(this);

    }


    @Click
    void btn_transfer(){

    }

    @Click
    void btn_queue(){

        ElectronCouponQueueActivity_.intent(this).start();
    }

    @Click
    void btn_paper_transfer(){

    }

    @Click
    void btn_coupon_scan(){

    }



    @CheckedChange
    void rb_one_hundred(boolean checked) {
        if (checked) {
            rb_two_hundred.setChecked(!checked);
            rb_four_hundred.setChecked(!checked);
            rb_five_hundred.setChecked(!checked);
        }

    }

    @CheckedChange
    void rb_two_hundred(boolean checked) {
        if (checked) {
            rb_one_hundred.setChecked(!checked);
            rb_four_hundred.setChecked(!checked);
            rb_five_hundred.setChecked(!checked);
        }

    }

    @CheckedChange
    void rb_four_hundred(boolean checked) {
        if (checked) {
            rb_two_hundred.setChecked(!checked);
            rb_one_hundred.setChecked(!checked);
            rb_five_hundred.setChecked(!checked);
        }

    }

    @CheckedChange
    void rb_five_hundred(boolean checked) {
        if (checked) {
            rb_two_hundred.setChecked(!checked);
            rb_four_hundred.setChecked(!checked);
            rb_one_hundred.setChecked(!checked);
        }
    }


    @CheckedChange
    void rb_electron_coupon(boolean checked) {

        if (checked) {
            ll_electron_coupon.setVisibility(View.VISIBLE);
        } else {
            ll_electron_coupon.setVisibility(View.GONE);
        }

    }

    @CheckedChange
    void rb_paper_coupon(boolean checked) {

        if (checked) {
            ll_paper_coupon.setVisibility(View.VISIBLE);
        } else {
            ll_paper_coupon.setVisibility(View.GONE);
        }

    }


}
