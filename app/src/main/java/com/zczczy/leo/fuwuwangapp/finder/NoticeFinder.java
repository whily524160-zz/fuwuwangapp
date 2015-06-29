package com.zczczy.leo.fuwuwangapp.finder;

import com.zczczy.leo.fuwuwangapp.model.BaseModelJson;
import com.zczczy.leo.fuwuwangapp.model.Notice;
import com.zczczy.leo.fuwuwangapp.prefs.MyPrefs_;
import com.zczczy.leo.fuwuwangapp.rest.MyRestClient;
import com.zczczy.leo.fuwuwangapp.tools.PagerResult;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.util.ArrayList;

/**
 * Created by leo on 2015/6/18.
 */

@EBean
public class NoticeFinder extends BaseFinder<Notice> {

    @RestService
    MyRestClient myRestClient;

    @Pref
    MyPrefs_ pre;

    @Override
    @Background
    public void pagingQuery(int pageIndex, int pageSize, Object... objects) {

        BaseModelJson<PagerResult<Notice>> bmj =new BaseModelJson();

        PagerResult<Notice> pr =new PagerResult();

        pr.ListData = new ArrayList();

        for(int i=pageIndex*pageSize;i<(pageIndex+1)*pageSize;i++){

            Notice notice =new Notice();

            notice.title="公告标题公告标题公告标题公告标题公告标题"+i;

            notice.date="2015-06-18";

            pr.ListData.add(notice);
        }

        pr.PageIndex=pageIndex;

        pr.PageSize=pageSize;

        pr.RowCount=52;

        bmj.Data=pr;

        bmj.Successful=true;

        afterPagingQuery(bmj);
    }

    @Override
    @UiThread
    public void afterPagingQuery(BaseModelJson<PagerResult<Notice>> bmj) {

        if(bmj.Successful){
            getList().addAll(bmj.Data.ListData);
            setTotal(bmj.Data.RowCount);
            listener.receive(0);
        }else{
            listener.receive(0);
        }
    }
}
