package com.zczczy.leo.fuwuwangapp.adapters;

import android.content.Context;

import com.zczczy.leo.fuwuwangapp.activities.NoticeActivity;
import com.zczczy.leo.fuwuwangapp.finder.BaseFinder;
import com.zczczy.leo.fuwuwangapp.finder.NoticeFinder;
import com.zczczy.leo.fuwuwangapp.items.ItemView;
import com.zczczy.leo.fuwuwangapp.items.NoticeItemView_;
import com.zczczy.leo.fuwuwangapp.listener.DataReceiveListener;
import com.zczczy.leo.fuwuwangapp.model.Notice;
import com.zczczy.leo.fuwuwangapp.tools.AndroidTool;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by leo on 2015/6/18.
 */
@EBean
public class NoticeAdapter extends MyBaseAdapter<Notice>  implements DataReceiveListener {

    @RootContext
    Context context;

    @Bean(NoticeFinder.class)
    BaseFinder<Notice> finder;

    @RootContext
    NoticeActivity activity;

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
    protected ItemView<Notice> getItemView(Context context) {
        return NoticeItemView_.build(context);
    }

    @Override
    public void receive(int type) {

        setTotal(finder.getTotal());

        setList(finder.getList());

        notifyDataSetChanged();

        activity.changeLoadTime();
    }
}
