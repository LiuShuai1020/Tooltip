package com.liushiyu.tooltip.agent;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;

import com.liushiyu.tooltip.core.dialog.AlertDialog;

/**
 * created by liushuai on 2019/1/17
 */
public class DialogAgent {

    private AlertDialog.Builder builder;

    private void builderConfirm() {
        if (builder == null) {
            builder = AlertDialog.builder();
        }
    }

    public DialogAgent title(String titleText) {
        builderConfirm();
        builder.title(titleText);
        return this;
    }

    public DialogAgent message(CharSequence message) {
        builderConfirm();
        builder.message(message);
        return this;
    }

    public DialogAgent childMessage(CharSequence childMessage) {
        builderConfirm();
        builder.childMessage(childMessage);
        return this;
    }

    public DialogAgent buttonOneText(CharSequence buttonText) {
        builderConfirm();
        builder.buttonOneText(buttonText);
        return this;
    }

    public DialogAgent buttonOneText(CharSequence buttonText, AlertDialog.OnClickListener listener) {
        builderConfirm();
        builder.buttonOneText(buttonText, listener);
        return this;
    }

    public DialogAgent buttonTwoText(CharSequence buttonText) {
        builderConfirm();
        builder.buttonTwoText(buttonText);
        return this;
    }

    public DialogAgent buttonTwoText(CharSequence buttonText, AlertDialog.OnClickListener listener) {
        builderConfirm();
        builder.buttonTwoText(buttonText, listener);
        return this;
    }

    public DialogAgent buttonThreeText(CharSequence buttonText) {
        builderConfirm();
        builder.buttonThreeText(buttonText);
        return this;
    }

    public DialogAgent buttonThreeText(CharSequence buttonText, AlertDialog.OnClickListener listener) {
        builderConfirm();
        builder.buttonThreeText(buttonText, listener);
        return this;
    }

    public DialogAgent cancelable(boolean cancelable) {
        builderConfirm();
        builder.cancelable(cancelable);
        return this;
    }

    public DialogAgent canceledOnTouchOutside(boolean canceledOnTouchOutside) {
        builderConfirm();
        builder.canceledOnTouchOutside(canceledOnTouchOutside);
        return this;
    }

    public DialogAgent alertDialogClickListener(AlertDialog.AlertDialogClickListener listener) {
        builderConfirm();
        builder.alertDialogClickListener(listener);
        return this;
    }

    /**
     * 设置AlertDialog中间view
     */
    public DialogAgent middleView(View view) {
        builderConfirm();
        builder.middleView(view);
        return this;
    }

    /**
     * 设置AlertDialog中间view
     */
    public DialogAgent middleView(View view, ViewGroup.LayoutParams params) {
        builderConfirm();
        builder.middleView(view, params);
        return this;
    }

    public AlertDialog build() {
        builderConfirm();
        return builder.build();
    }

    public AlertDialog show(FragmentManager fragmentManager, String tag) {
        AlertDialog dialog = build();
        dialog.show(fragmentManager, tag);
        return dialog;
    }
}
