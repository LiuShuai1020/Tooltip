package com.liushiyu.tooltip.agent;

import android.content.Context;
import android.view.View;

import com.liushiyu.tooltip.core.toast.ToastUtils;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastAgent {

    private ToastUtils toastUtils;

    private void builderConfirm() {
        toastUtils = new ToastUtils();
    }

    // 通用
    public void show(Context context, String text) {
        builderConfirm();
        toastUtils.show(context, text);
    }

    public void show(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.show(context, text, leftIconResId);
    }

    // 强调
    public void showEmphasize(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showEmphasize(context, text, leftIconResId);
    }

    // 可点击的
    public void showClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        builderConfirm();
        toastUtils.showClickable(context, text, clickText, listener);
    }

    public void showClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        builderConfirm();
        toastUtils.showClickable(context, text, clickText, listener, leftIconResId);
    }

    // 成功
    public void showSuccess(Context context, String text) {
        builderConfirm();
        toastUtils.showSuccess(context, text);
    }

    public void showSuccess(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showSuccess(context, text, leftIconResId);
    }

    // 强调成功
    public void showSuccessEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showSuccessEmphasize(context, text);
    }

    public void showSuccessEmphasize(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showSuccessEmphasize(context, text, leftIconResId);
    }

    // 可点击的成功
    public void showSuccessClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        builderConfirm();
        toastUtils.showSuccessClickable(context, text, clickText, listener);
    }

    public void showSuccessClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        builderConfirm();
        toastUtils.showSuccessClickable(context, text, clickText, listener, leftIconResId);
    }

    // 警告
    public void showWarning(Context context, String text) {
        builderConfirm();
        toastUtils.showWarning(context, text);
    }

    public void showWarning(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showWarning(context, text, leftIconResId);
    }

    // 强调警告
    public void showWarningEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showWarningEmphasize(context, text);
    }

    public void showWarningEmphasize(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showWarningEmphasize(context, text, leftIconResId);
    }

    // 可点击的警告
    public void showWarningClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        builderConfirm();
        toastUtils.showWarningClickable(context, text, clickText, listener);
    }

    public void showWarningClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        builderConfirm();
        toastUtils.showWarningClickable(context, text, clickText, listener, leftIconResId);
    }

    // 错误
    public void showError(Context context, String text) {
        builderConfirm();
        toastUtils.showError(context, text);
    }

    public void showError(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showError(context, text, leftIconResId);
    }

    // 强调错误
    public void showErrorEmphasize(Context context, String text) {
        builderConfirm();
        toastUtils.showErrorEmphasize(context, text);
    }

    public void showErrorEmphasize(Context context, String text, int leftIconResId) {
        builderConfirm();
        toastUtils.showErrorEmphasize(context, text, leftIconResId);
    }

    // 可点击的错误
    public void showErrorClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        builderConfirm();
        toastUtils.showErrorClickable(context, text, clickText, listener);
    }

    public void showErrorClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        builderConfirm();
        toastUtils.showErrorClickable(context, text, clickText, listener, leftIconResId);
    }
}
