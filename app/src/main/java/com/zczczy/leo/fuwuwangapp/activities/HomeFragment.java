package com.zczczy.leo.fuwuwangapp.activities;


import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.rest.MyErrorHandler;
import com.zczczy.leo.fuwuwangapp.rest.MyRestClient;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;
import org.androidannotations.annotations.rest.RestService;

import cn.lightsky.infiniteindicator.InfiniteIndicatorLayout;
import cn.lightsky.infiniteindicator.slideview.BaseSliderView;
import cn.lightsky.infiniteindicator.slideview.DefaultSliderView;

/**
 * Created by Leo on 2015/4/29.
 */

@EFragment(R.layout.home_layout)
public class HomeFragment extends BaseFragment  implements BaseSliderView.OnSliderClickListener{

    @ViewById
    MyTitleView title;

    @ViewById
    TextView txt_notice,txt_topic,txt_fund,txt_cooperation_merchant,txt_experience_center,txt_agent,txt_activity,txt_business_institute,txt_service;

    @StringRes
    String txt_home;

    @ViewById
    InfiniteIndicatorLayout indicator_default_circle;

    @RestService
    MyRestClient myRestClient;


    @StringRes
    String no_net;

    @Bean
    MyErrorHandler myErrorHandler;

    @AfterInject
    void afterInject(){

        myRestClient.setRestErrorHandler(myErrorHandler);
    }


    @AfterViews
    void afterView() {
        title.setListener(this);
        title.setTitle(txt_home);
        title.setImg_back();
        GetBanner();
    }

    @Background
    void GetBanner(){
        afterGetBanner();
    }

    @UiThread
    void afterGetBanner(){
        DefaultSliderView textSliderView = new DefaultSliderView(getActivity());
        textSliderView.image(R.mipmap.banner1).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this);
        textSliderView.getBundle().putString("extra","");
        indicator_default_circle.addSlider(textSliderView);

        DefaultSliderView textSliderView1 = new DefaultSliderView(getActivity());
        textSliderView1.image(R.mipmap.banner1).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this);
        textSliderView1.getBundle().putString("extra", "");
        indicator_default_circle.addSlider(textSliderView1);

        indicator_default_circle.setIndicatorPosition(InfiniteIndicatorLayout.IndicatorPosition.Right_Bottom);
        indicator_default_circle.startAutoScroll();
    }

    @Click
    void  txt_notice(){
        NoticeActivity_.intent(this).start();
    }

    @Click
    void  txt_topic(){

        AndroidTool.showToast(getActivity(), "开发中");
    }

    @Click
    void  txt_fund(){

        AndroidTool.showToast(getActivity(), "开发中");
    }

    @Click
    void  txt_cooperation_merchant(){

        CooperationMerchantActivity_.intent(this).start();
    }

    @Click
    void  txt_experience_center(){

        AndroidTool.showToast(getActivity(),"开发中");
    }

    @Click
    void  txt_agent(){

        AndroidTool.showToast(getActivity(),"开发中");
    }

    @Click
    void  txt_activity(){

        AndroidTool.showToast(getActivity(),"开发中");
    }

    @Click
    void  txt_business_institute(){

        BusinessInstituteActivity_.intent(this).start();
    }

    @Click
    void  txt_service(){

       ServiceActivity_.intent(this).start();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        // TODO Auto-generated method stub
        super.onHiddenChanged(hidden);
        if(hidden){

            indicator_default_circle.stopAutoScroll();
        }else {

            indicator_default_circle.startAutoScroll();
        }
    }



    @Override
    public  void onPause() {
        super.onPause();
        indicator_default_circle.stopAutoScroll();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(indicator_default_circle!=null){
            indicator_default_circle.startAutoScroll();

        }
    }


}
