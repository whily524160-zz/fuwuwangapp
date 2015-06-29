package com.zczczy.leo.fuwuwangapp.finder;

import com.zczczy.leo.fuwuwangapp.model.BaseModelJson;
import com.zczczy.leo.fuwuwangapp.model.CooperationMerchant;
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
 * Created by leo on 2015/6/20.
 */
@EBean
public class CooperationMerchantFinder extends BaseFinder<CooperationMerchant> {


    @RestService
    MyRestClient myRestClient;

    @Pref
    MyPrefs_ pre;

    @Override
    @Background
    public void pagingQuery(int pageIndex, int pageSize, Object... objects) {

        BaseModelJson<PagerResult<CooperationMerchant>> bmj =new BaseModelJson();

        PagerResult<CooperationMerchant> pr =new PagerResult();

        pr.ListData = new ArrayList();

        for(int i=pageIndex*pageSize;i<(pageIndex+1)*pageSize;i++){

            CooperationMerchant cooperationMerchant =new CooperationMerchant();

            cooperationMerchant.CompanyName="锦州市杭大电子公司"+i;

            cooperationMerchant.CompanyMajor="格力、长虹、三星、松下、辛飞、海尔、美菱、松下等家用电器。";

            cooperationMerchant.CompanyAddress="辽宁省大连市高新园区黄浦路701号银海万象1503室";

            cooperationMerchant.CompanyLogo="";

            pr.ListData.add(cooperationMerchant);
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
    public void afterPagingQuery(BaseModelJson<PagerResult<CooperationMerchant>> bmj) {

        if(bmj.Successful){
            getList().addAll(bmj.Data.ListData);
            setTotal(bmj.Data.RowCount);
            listener.receive(0);
        }else{
            listener.receive(0);
        }

    }
}
