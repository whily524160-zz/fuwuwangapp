package com.zczczy.leo.fuwuwangapp.adapters;

import android.content.Context;

import com.zczczy.leo.fuwuwangapp.activities.CooperationMerchantActivity;
import com.zczczy.leo.fuwuwangapp.finder.BaseFinder;
import com.zczczy.leo.fuwuwangapp.finder.CooperationMerchantFinder;
import com.zczczy.leo.fuwuwangapp.items.CooperationMerchantItemView_;
import com.zczczy.leo.fuwuwangapp.items.ItemView;
import com.zczczy.leo.fuwuwangapp.listener.DataReceiveListener;
import com.zczczy.leo.fuwuwangapp.model.CooperationMerchant;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by leo on 2015/6/20.
 */
@EBean
public class CooperationMerchantAdapter extends MyBaseAdapter<CooperationMerchant>  implements DataReceiveListener {


    @RootContext
    Context context;

    @RootContext
    CooperationMerchantActivity activity;

    @Bean(CooperationMerchantFinder.class)
    BaseFinder<CooperationMerchant> finder;


    @AfterInject
    void initData(){
        finder.setDataReceiveListener(this);
        setTotal(finder.getTotal());
        setList(finder.getList());
    }

    @Override
    public void receive(int type) {

        setTotal(finder.getTotal());

        setList(finder.getList());

        notifyDataSetChanged();

        activity.changeLoadTime();

    }

    @Override
    public void getMoreData(int pageIndex, int pageSize, Object... objects) {

        AndroidTool.showLoadDialog(context);

        if(pageIndex==1){
            finder.cleanListAndCount();
        }
        finder.pagingQuery(pageIndex, pageSize, objects);


    }

    @Override
    protected ItemView<CooperationMerchant> getItemView(Context context) {

        return CooperationMerchantItemView_.build(context);
    }
}
