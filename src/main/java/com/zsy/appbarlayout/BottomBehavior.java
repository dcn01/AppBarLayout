package com.zsy.appbarlayout;

/*
 * 文件名:     BottomBehavior
 * 创建者:     阿钟
 * 创建时间:   2016/10/22 22:47
 * 描述:       自定义CoordinatorLayout的Behavior实现动态显示与隐藏
 */

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class BottomBehavior extends CoordinatorLayout.Behavior<View> {
    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //这个方法是说明这个子控件是依赖AppBarLayout的
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float translationY = Math.abs(dependency.getTop());//获取跟随布局的顶部位置
        child.setTranslationY(translationY);
        return true;
    }
}