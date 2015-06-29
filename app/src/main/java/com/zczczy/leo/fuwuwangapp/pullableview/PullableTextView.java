package com.zczczy.leo.fuwuwangapp.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by leo on 2015/6/2.
 */
public class PullableTextView extends TextView implements Pullable
{

    private boolean isForbidPullDown = false;

    private boolean isForbidPullUp = false;


    public PullableTextView(Context context)
    {
        super(context);
    }

    public PullableTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullableTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown()
    {
        if (isForbidPullDown) {

            return false;
        }

        return true;
    }

    @Override
    public boolean canPullUp()
    {
        if (isForbidPullUp) {

            return false;
        }

        return true;
    }

    /**
     * 设置是否禁止下拉刷新
     *
     * @param isForbidPullDown
     */
    public void setIsForbidPullDown(boolean isForbidPullDown) {

        this.isForbidPullDown = isForbidPullDown;
    }

    /**
     * 设置是否禁止上拉加载
     * @param isForbidPullUp
     */
    public void setIsForbidPullUp(boolean isForbidPullUp) {

        this.isForbidPullUp = isForbidPullUp;
    }

}
