package com.dzzchao.wandroid.ui.widget;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dzzchao.wandroid.R;

/**
 * 封装标题栏
 */
public class TitleBar {


    /**
     * 标题栏
     */
    private final RelativeLayout rl_titlebar;
    /**
     * 左边点击区域
     */
    private final RelativeLayout rlLeft;
    /**
     * 右边点击区域
     */
    private final RelativeLayout rlRight;
    /**
     * 左边文字
     */
    private final TextView tvLeft;
    /**
     * 右边文字
     */
    private final TextView tvRight;
    /**
     * 标题
     */
    private final TextView tvTitle;

    public TitleBar(Activity context) {
        rl_titlebar = context.findViewById(R.id.rl_title_bar);
        rlLeft = context.findViewById(R.id.rl_left);
        rlRight = context.findViewById(R.id.rl_right);
        tvLeft = context.findViewById(R.id.tv_left);
        tvRight = context.findViewById(R.id.tv_right);
        tvTitle = context.findViewById(R.id.tv_title);
    }

    public TitleBar(View view) {
        rl_titlebar = view.findViewById(R.id.rl_title_bar);
        rlLeft = view.findViewById(R.id.rl_left);
        rlRight = view.findViewById(R.id.rl_right);
        tvLeft = view.findViewById(R.id.tv_left);
        tvRight = view.findViewById(R.id.tv_right);
        tvTitle = view.findViewById(R.id.tv_title);
    }

    public TitleBar setBackgroundResource(int color) {
        rl_titlebar.setBackgroundResource(color);
        return this;
    }


    public TitleBar setLeftText(String leftText) {
        tvLeft.setText(leftText);
        return this;
    }

    public TitleBar setLeftText(int leftTextStringId) {
        tvLeft.setText(leftTextStringId);
        return this;
    }


    public TitleBar setRightText(String rightText) {
        tvRight.setText(rightText);
        return this;
    }

    public TitleBar setRightText(int rightTextStringId) {
        tvRight.setText(rightTextStringId);
        return this;
    }

    public TitleBar setTitleText(String titleText) {
        tvTitle.setText(titleText);
        return this;
    }

    public TitleBar setTitleText(int titleTextStringId) {
        tvTitle.setText(titleTextStringId);
        return this;
    }

    public TitleBar setLeftOnClickListener(View.OnClickListener leftOnClickListener) {
        rlLeft.setOnClickListener(leftOnClickListener);
        return this;
    }

    public TitleBar setRightOnClickListener(View.OnClickListener rightOnClickListener) {
        rlRight.setOnClickListener(rightOnClickListener);
        return this;
    }
}
