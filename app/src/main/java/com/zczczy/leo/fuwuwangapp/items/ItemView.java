package com.zczczy.leo.fuwuwangapp.items;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Leo on 2015/4/29.
 */
public abstract class ItemView<T> extends LinearLayout {

    protected T _data;


    public ItemView(Context context) {
        super(context);
    }

    public void init(T t, Object... objects) {
        this._data = t;
        init(objects);
    }

    protected abstract void init(Object... objects);

}
