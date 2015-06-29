package com.zczczy.leo.fuwuwangapp.items;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.model.CooperationMerchant;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by leo on 2015/6/20.
 */

@EViewGroup(R.layout.cooperation_merchant_item_layout)
public class CooperationMerchantItemView extends  ItemView<CooperationMerchant>  {


    @ViewById
    TextView txt_company_name,txt_major,txt_company_address;


    @ViewById
    ImageView img_company_logo;


    Context context;

    public CooperationMerchantItemView(Context context) {
        super(context);

        this.context=context;
    }

    @Override
    protected void init(Object... objects) {

        txt_company_name.setText(_data.CompanyName);

        txt_major.setText(_data.CompanyMajor);

        txt_company_address.setText(_data.CompanyAddress);

        if(!"".equals(_data.CompanyLogo)&&!_data.CompanyLogo.isEmpty()&&_data.CompanyLogo!=null){

            Picasso.with(context).load(_data.CompanyLogo).error(R.mipmap.unlaod).placeholder(R.mipmap.unlaod).into(img_company_logo);
        }

    }
}
