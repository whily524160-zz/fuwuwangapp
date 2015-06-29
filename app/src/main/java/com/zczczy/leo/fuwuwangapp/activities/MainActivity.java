package com.zczczy.leo.fuwuwangapp.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zczczy.leo.fuwuwangapp.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

/**
 * Created by Leo on 2015/4/29.
 */

@EActivity(R.layout.main_layout)
@WindowFeature(value = {Window.FEATURE_NO_TITLE, Window.FEATURE_INDETERMINATE_PROGRESS})
public class MainActivity extends Activity {

    @ViewById
    LinearLayout ll_home, ll_me;

    @ViewById
    ImageView img_home, img_me;

    @ViewById
    TextView txt_home,  txt_me;

    FragmentManager fragmentManager;

    HomeFragment homeFragment;

    MeFragment meFragment;

    //控制  选中状态时再被点中
    int flag = 0;

    @AfterViews
    void afterView() {
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }

    @Click
    void ll_home() {
        if (flag == 0) {
            return;
        }
        setTabSelection(0);
    }


    @Click
    void ll_me() {
        if (flag == 1) {
            return;
        }
        setTabSelection(1);
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *
     */
    void setTabSelection(int index) {

        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        transaction.setCustomAnimations(R.anim.left_in, R.anim.left_out, R.anim.right_in, R.anim.right_out);

        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                img_home.setSelected(true);
                txt_home.setSelected(true);

                if (homeFragment == null) {
                    // 如果homeFragment为空，则创建一个并添加到界面上
                   homeFragment = HomeFragment_.builder().build();
                    transaction.add(R.id.fl_content, homeFragment);
                } else {
                    // 如果homeFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                flag = 0;
                break;
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                img_me.setSelected(true);
                txt_me.setSelected(true);


                if (meFragment == null) {
                    // 如果meFragment为空，则创建一个并添加到界面上
                    meFragment = MeFragment_.builder().build();
                    transaction.add(R.id.fl_content, meFragment);
                } else {
                    // 如果meFragment不为空，则直接将它显示出来
                    transaction.show(meFragment);
                }
                flag = 1;
                break;
            default:
                break;
        }
        transaction.commit();

    }

    /**
     * 清除掉所有的选中状态。
     */
    void clearSelection() {
        img_home.setSelected(false);
        img_me.setSelected(false);

        txt_home.setSelected(false);
        txt_me.setSelected(false);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }

}
