package com.liushiyu.tooltip.agent;

import android.content.Context;

import com.liushiyu.tooltip.core.toast.ToastUtils;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastAgent {

    ToastUtils toastUtils;

    ToastAgent(Context context) {
        toastUtils = new ToastUtils();
    }

}
