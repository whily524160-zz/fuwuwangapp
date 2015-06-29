package com.zczczy.leo.fuwuwangapp.activities;


import android.widget.LinearLayout;
import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by Leo on 2015/4/29.
 */

@EFragment(R.layout.me_layout)
public class MeFragment extends BaseFragment {


    @ViewById
    LinearLayout ll_wealth,ll_perfect_info,ll_queue,ll_manager,ll_suggest,ll_scan,ll_game_club,ll_address;

    @ViewById
    TextView txt_username,txt_realname;

    @ViewById
    MyTitleView title;

    @StringRes
    String txt_me,txt_register;

    @AfterViews
    void afterView() {
        title.setListener(this);
        title.setTitle(txt_me);
        title.setOther(txt_register);
        title.setImg_back();
        txt_username.setText("Ricky");
        txt_realname.setText("服务网");
    }


    @Override
    public void otherClick() {

    }


    @Click
    void ll_wealth(){

        WealthActivity_.intent(this).start();
    }

    @Click
    void ll_perfect_info(){

        PerfectInfoActivity_.intent(this).start();
    }

    @Click
    void ll_queue(){

        CouponQueueActivity_.intent(this).start();
    }

    @Click
    void ll_manager(){

        AndroidTool.showToast(getActivity(),"开发中");
    }

    @Click
    void ll_suggest(){

        SuggestActivity_.intent(this).start();

    }

    @Click
    void ll_scan(){

        AndroidTool.showToast(getActivity(),"开发中");
    }

    @Click
    void ll_game_club(){

        AndroidTool.showToast(getActivity(),"开发中");
    }
    @Click
    void ll_address(){

        AndroidTool.showToast(getActivity(),"开发中");
    }

}
