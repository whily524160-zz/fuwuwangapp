package com.zczczy.leo.fuwuwangapp.finder;

import com.zczczy.leo.fuwuwangapp.model.BaseModelJson;
import com.zczczy.leo.fuwuwangapp.model.TransactionRecord;
import com.zczczy.leo.fuwuwangapp.tools.PagerResult;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

/**
 * Created by leo on 2015/6/20.
 */
@EBean
public class TransactionRecordFinder  extends BaseFinder<TransactionRecord>{


    @Override
    @Background
    public void pagingQuery(int pageIndex, int pageSize, Object... objects) {

        BaseModelJson<PagerResult<TransactionRecord>> bmj =new BaseModelJson();

        PagerResult<TransactionRecord> pr =new PagerResult();

        pr.ListData = new ArrayList();

        for(int i=pageIndex*pageSize;i<(pageIndex+1)*pageSize;i++){

            TransactionRecord notice =new TransactionRecord();

            notice.type="存入";

            notice.money="106.00";

            notice.common="麻豆红利";

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
    public void afterPagingQuery(BaseModelJson<PagerResult<TransactionRecord>> bmj) {

        if(bmj.Successful){
            getList().addAll(bmj.Data.ListData);
            setTotal(bmj.Data.RowCount);
            listener.receive(0);
        }else{
            listener.receive(0);
        }
    }
}
