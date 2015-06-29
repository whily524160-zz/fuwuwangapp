package com.zczczy.leo.fuwuwangapp.activities;

import android.view.View;
import android.view.Window;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.adapters.CooperationMerchantAdapter;
import com.zczczy.leo.fuwuwangapp.adapters.MyBaseAdapter;
import com.zczczy.leo.fuwuwangapp.model.CooperationMerchant;
import com.zczczy.leo.fuwuwangapp.prefs.MyPrefs_;
import com.zczczy.leo.fuwuwangapp.pullableview.PullToRefreshLayout;
import com.zczczy.leo.fuwuwangapp.pullableview.PullableListView;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;
import com.zczczy.leo.fuwuwangapp.viewgroup.MyTitleView;
import com.zczczy.leo.fuwuwangapp.viewgroup.NoDataView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.StringRes;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by leo on 2015/6/20.
 */
@EActivity(R.layout.cooperation_merchant_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class CooperationMerchantActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener{

    @StringRes
    String txt_cooperation_merchant_title;

    @ViewById
    MyTitleView title;

    @ViewById
    NoDataView no_data;

    @ViewById
    PullToRefreshLayout refresh_view;

    @ViewById
    PullableListView lv_list;

    @Pref
    MyPrefs_ pre;

    @Bean(CooperationMerchantAdapter.class)
    MyBaseAdapter<CooperationMerchant> myAdapter;


    int pageIndex=1;

    @AfterViews
    void afterView() {

        title.setListener(this);

        title.setTitle(txt_cooperation_merchant_title);

        refresh_view.setOnRefreshListener(this);

        lv_list.setAdapter(myAdapter);

        myAdapter.getMoreData(pageIndex, 10, "");

    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {

        pageIndex=1;

        myAdapter.getMoreData(pageIndex,10,"");

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

        if(myAdapter.getList().size()>=myAdapter.getTotal()){

            AndroidTool.showToast(this, "没有更多数据了");

            changeLoadTime();
        }else{

            pageIndex++;

            myAdapter.getMoreData(pageIndex, 10, "");
        }

    }

    public void changeLoadTime(){
        if (pageIndex == 1) {

            refresh_view.refreshFinish(PullToRefreshLayout.SUCCEED);
        } else {

            refresh_view.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        }

        if(myAdapter.getCount()==0){
            no_data.setVisibility(View.VISIBLE);
        }else{
            no_data.setVisibility(View.GONE);
        }

        AndroidTool.dismissLoadDialog();
    }


}
