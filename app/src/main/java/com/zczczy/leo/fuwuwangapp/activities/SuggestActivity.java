package com.zczczy.leo.fuwuwangapp.activities;

import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by leo on 2015/6/20.
 */
@EActivity(R.layout.suggest_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class SuggestActivity extends BaseActivity {


    @ViewById
    MyTitleView title;

    @ViewById
    EditText edt_suggest_username,edt_suggest_pass,edt_confirm_pass,edt_id_card,edt_real_name,edt_region;

    @ViewById
    Button btn_register;

    @StringRes
    String txt_suggest;

    @ViewById
    CheckBox cb_isShow;

    @AfterViews
    void afterView() {

        title.setListener(this);

        title.setTitle(txt_suggest);

    }

    @CheckedChange
    void cb_isShow(boolean checked){

    }

}
