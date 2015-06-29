package com.zczczy.leo.fuwuwangapp.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by leo on 2015/6/2.
 */
public class PullableGridView extends GridView implements Pullable
{

    private boolean isForbidPullDown = false;

    private boolean isForbidPullUp = false;


    public PullableGridView(Context context)
    {
        super(context);
    }

    public PullableGridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullableGridView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown()
    {
        if (isForbidPullDown) {
            return false;

        } else if (getCount() == 0)
        {
            // 没有item的时候也可以下拉刷新
            return true;
        } else if (getFirstVisiblePosition() == 0
                && getChildAt(0).getTop() >= 0)
        {
            // 滑到顶部了
            return true;
        } else
            return false;
    }

    @Override
    public boolean canPullUp()
    {
        if (isForbidPullUp) {

            return false;

        } else if (getCount() == 0)
        {
            // 没有item的时候也可以上拉加载
            return true;
        } else if (getLastVisiblePosition() == (getCount() - 1))
        {
            // 滑到底部了
            if (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null
                    && getChildAt(
                    getLastVisiblePosition()
                            - getFirstVisiblePosition()).getBottom() <= getMeasuredHeight())
                return true;
        }
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
