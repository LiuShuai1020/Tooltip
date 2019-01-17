package com.liushiyu.tooltip.agent;

import android.support.v4.app.FragmentManager;

import com.liushiyu.tooltip.core.loading.LoadingDialog;

/**
 * created by liushuai on 2019/1/17
 */
public class LoadingAgent {

    private LoadingDialog.Builder builder;
    private LoadingDialog loadingDialog;

    private void builderConfirm() {
        if (builder == null) {
            builder = LoadingDialog.builder();
        }
    }

    public LoadingAgent style(int styleId) {
        builderConfirm();
//        builder.setStyleId(styleId);
        return this;
    }

    public LoadingAgent message(String message) {
        builderConfirm();
        builder.message(message);
        return this;
    }

    public LoadingAgent cancelable(boolean cancelable) {
        builderConfirm();
        builder.cancelable(cancelable);
        return this;
    }

    public LoadingAgent canceledOnTouchOutside(boolean canceledOnTouchOutside) {
        builderConfirm();
        builder.canceledOnTouchOutside(canceledOnTouchOutside);
        return this;
    }

    public LoadingDialog build() {
        builderConfirm();
        return builder.build();
    }

    public LoadingDialog show(FragmentManager manager) {
        return show(manager, LoadingDialog.class.getSimpleName());
    }

    public LoadingDialog show(FragmentManager manager, String tag) {
        LoadingDialog dialog = build();
        dialog.show(manager, tag);
        loadingDialog = dialog;
        return dialog;
    }

    public void dismiss() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }
}
