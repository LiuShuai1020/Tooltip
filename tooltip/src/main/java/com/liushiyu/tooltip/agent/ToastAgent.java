package com.liushiyu.tooltip.agent;

import android.content.Context;

import com.liushiyu.tooltip.core.toast.ToastUtils;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastAgent {

    private ToastUtils toastUtils;

    private void builderConfirm() {
        toastUtils = new ToastUtils();
    }

    // 默认
    public void show(Context context, String text) {
        builderConfirm();
        toastUtils.show(context, text);
    }


    // 默认 可设置图片资源
    public void show(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.show(context, text, leftIconResId);
    }

    // 强调
    public void showEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showEmphasize(context, text);
    }

    // 强调 可设置图片资源
    public void showEmphasize(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showEmphasize(context, text, leftIconResId);
    }

    // 默认成功
    public void showSuccess(Context context, String text) {
        builderConfirm();
        toastUtils.showSuccess(context, text);
    }

    // 默认 强调成功
    public void showSuccessEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showSuccessEmphasize(context, text);
    }

    // 默认警告
    public void showWarning(Context context, String text) {
        builderConfirm();
        toastUtils.showWarning(context, text);
    }

    // 默认 强调警告
    public void showWarningEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showWarningEmphasize(context, text);
    }

    // 默认 错误
    public void showError(Context context, String text) {
        builderConfirm();
        toastUtils.showError(context, text);
    }

    // 默认 强调错误
    public void showErrorEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showErrorEmphasize(context, text);
    }
}
