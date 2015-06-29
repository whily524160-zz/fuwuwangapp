package com.zczczy.leo.fuwuwangapp.adapters;

import android.content.Context;

import com.zczczy.leo.fuwuwangapp.activities.TransactionRecordActivity;
import com.zczczy.leo.fuwuwangapp.finder.BaseFinder;
import com.zczczy.leo.fuwuwangapp.finder.TransactionRecordFinder;
import com.zczczy.leo.fuwuwangapp.items.ItemView;
import com.zczczy.leo.fuwuwangapp.items.TransactionRecordItemView_;
import com.zczczy.leo.fuwuwangapp.listener.DataReceiveListener;
import com.zczczy.leo.fuwuwangapp.model.TransactionRecord;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by leo on 2015/6/20.
 */
@EBean
public class TransactionRecordAdapter extends MyBaseAdapter<TransactionRecord> implements DataReceiveListener {


    @RootContext
    Context context;

    @RootContext
    TransactionRecordActivity activity;

    @Bean(TransactionRecordFinder.class)
    BaseFinder<TransactionRecord> finder;


    @AfterInject
    void initData(){
        finder.setDataReceiveListener(this);
        setTotal(finder.getTotal());
        setList(finder.getList());
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
    protected ItemView<TransactionRecord> getItemView(Context context) {
        return TransactionRecordItemView_.build(context);
    }

    @Override
    public void receive(int type) {

        setTotal(finder.getTotal());

        setList(finder.getList());

        notifyDataSetChanged();

        activity.changeLoadTime();

    }
}
