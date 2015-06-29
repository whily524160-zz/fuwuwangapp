package com.zczczy.leo.fuwuwangapp.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;
import com.zczczy.leo.fuwuwangapp.listener.TitleClickListener;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;


@EViewGroup(R.layout.title_layout)
public class MyTitleView extends LinearLayout {

    @ViewById
    TextView tv_title, tv_other;

    @ViewById
    LinearLayout img_back, ll_other;

    @ViewById
    ImageView i_bg;


    public MyTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    TitleClickListener clickListener;

    public void setListener(TitleClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public void setOther(String other) {
        tv_other.setText(other);
    }

    @Click
    public void img_back() {
        clickListener.backClick();
    }

    public void setImg_back() {
        i_bg.setImageBitmap(null);
    }

    @Click
    public void ll_other() {
        clickListener.otherClick();
    }

}
