package com.zczczy.leo.fuwuwangapp.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by leo on 2015/6/2.
 */
public class PullableWebView extends WebView implements Pullable
{

    private boolean isForbidPullDown = false;

    private boolean isForbidPullUp = false;

    public PullableWebView(Context context)
    {
        super(context);
    }

    public PullableWebView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullableWebView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown()
    {

        if (isForbidPullDown) {

            return false;
        }

        if (getScrollY() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean canPullUp()
    {
        if (isForbidPullUp) {

            return false;
        }

        if (getScrollY() >= getContentHeight() * getScale()
                - getMeasuredHeight())
            return true;
        else
            return false;
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
