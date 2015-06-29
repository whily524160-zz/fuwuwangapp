package com.zczczy.leo.fuwuwangapp.items;

import android.content.Context;
import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.model.TransactionRecord;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by leo on 2015/6/20.
 */
@EViewGroup(R.layout.transaction_record_item_layout)
public class TransactionRecordItemView extends ItemView<TransactionRecord> {


    @ViewById
    TextView txt_transaction_name,txt_transaction_money,txt_transaction_date,txt_transaction_common;


    public TransactionRecordItemView(Context context) {
        super(context);
    }

    @Override
    protected void init(Object... objects) {

        txt_transaction_name.setText(_data.type);

        txt_transaction_money.setText(_data.money);

        txt_transaction_date.setText(_data.date);

        txt_transaction_common.setText(_data.common);

    }
}
