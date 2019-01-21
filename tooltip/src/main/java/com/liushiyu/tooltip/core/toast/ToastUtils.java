package com.liushiyu.tooltip.core.toast;

import android.content.Context;

import com.liushiyu.tooltip.R;
import com.liushiyu.tooltip.core.toast.auxiliary.UniversalToast;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastUtils {

    public ToastUtils() {

    }
    // 默认
    public void show(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.UNIVERSAL)
                .show();
    }

    // 默认 可设置图片资源
    public void show(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.UNIVERSAL)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_done_white_24dp : leftIconResId)
                .show();
    }

    // 强调
    public void showEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE)
                .show();
    }

    // 强调 可设置图片资源
    public void showEmphasize(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_done_white_24dp : leftIconResId)
                .show();
    }

    // 默认成功
    public void showSuccess(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT).showSuccess();
    }

    // 默认 强调成功
    public void showSuccessEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE).showSuccess();
    }

    // 默认警告
    public void showWarning(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT).showWarning();
    }

    // 默认 强调警告
    public void showWarningEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE).showWarning();
    }

    // 默认 错误
    public void showError(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT).showError();
    }

    // 默认 强调错误
    public void showErrorEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE).showError();
    }
}
