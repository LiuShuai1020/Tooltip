package com.liushiyu.tooltip.core.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.liushiyu.tooltip.R;
import com.liushiyu.tooltip.core.toast.auxiliary.UniversalToast;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastUtils {

    public ToastUtils() {

    }

    // 0 通用
    public void show(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.UNIVERSAL)
                .setGravity(Gravity.CENTER, 0, 0)
                .show();
    }

    // 1
    public void show(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.UNIVERSAL)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_done_white_24dp : leftIconResId)
                .setGravity(Gravity.CENTER, 0, 0)
                .show();
    }

    // 2 强调
    public void showEmphasize(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_check_circle_white_24dp : leftIconResId)
                .show();
    }

    // 3 可点击的
    public void showClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setGravity(Gravity.TOP, 0, 0)
                .setClickCallback(clickText, listener)
                .show();
    }

    // 4
    public void showClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setGravity(Gravity.TOP, 0, 0)
                .setClickCallback(clickText, listener)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_done_white_24dp : leftIconResId)
                .show();
    }

    //  5 成功
    public void showSuccess(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT).showSuccess();
    }

    // 6
    public void showSuccess(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_done_white_24dp : leftIconResId)
                .showSuccess();
    }

    // 7 强调成功
    public void showSuccessEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE).showSuccess();
    }

    // 8
    public void showSuccessEmphasize(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT, UniversalToast.EMPHASIZE)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_check_circle_white_24dp : leftIconResId)
                .showSuccess();
    }

    // 9 可点击的成功
    public void showSuccessClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setClickCallback(clickText, listener)
                .showSuccess();
    }

    // 10
    public void showSuccessClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setClickCallback(clickText, listener)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_done_white_24dp : leftIconResId)
                .showSuccess();
    }

    // 11 警告
    public void showWarning(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT).showWarning();
    }

    // 12
    public void showWarning(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_error_outline_white_24dp : leftIconResId)
                .showWarning();
    }

    // 13强调警告
    public void showWarningEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE).showWarning();
    }

    // 14
    public void showWarningEmphasize(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_error_outline_white_24dp : leftIconResId)
                .showWarning();
    }

    // 15 可点击的警告
    public void showWarningClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setClickCallback(clickText, listener)
                .showWarning();
    }

    // 16
    public void showWarningClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setClickCallback(clickText, listener)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_error_outline_white_24dp : leftIconResId)
                .showWarning();
    }

    // 17 错误
    public void showError(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT).showError();
    }

    // 18
    public void showError(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_clear_white_24dp : leftIconResId)
                .showError();
    }

    // 19 强调错误
    public void showErrorEmphasize(Context context, String text) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE).showError();
    }

    // 20
    public void showErrorEmphasize(Context context, String text, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_clear_white_24dp : leftIconResId)
                .showError();
    }

    // 21 可点击的错误
    public void showErrorClickable(Context context, String text, String clickText, View.OnClickListener listener) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setClickCallback(clickText, listener)
                .showError();
    }

    // 22
    public void showErrorClickable(Context context, String text, String clickText, View.OnClickListener listener, int leftIconResId) {
        UniversalToast.makeText(context, text, UniversalToast.LENGTH_SHORT,
                UniversalToast.CLICKABLE)
                .setClickCallback(clickText, listener)
                .setLeftIconRes(leftIconResId == 0 ? R.drawable.ic_clear_white_24dp : leftIconResId)
                .showError();
    }
}
