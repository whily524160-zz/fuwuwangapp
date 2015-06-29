package com.zczczy.leo.fuwuwangapp.items;

import android.content.Context;
import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.model.Notice;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by leo on 2015/6/18.
 */

@EViewGroup(R.layout.notice_item_layout)
public class NoticeItemView extends ItemView<Notice> {

    @ViewById
    TextView txt_title,txt_date;

    public NoticeItemView(Context context) {
        super(context);
    }


    @Override
    protected void init(Object... objects) {

        txt_title.setText(_data.title);

        txt_date.setText(_data.date);
    }

}
