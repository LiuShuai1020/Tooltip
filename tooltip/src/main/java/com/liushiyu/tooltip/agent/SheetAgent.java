package com.liushiyu.tooltip.agent;

import android.support.v4.app.FragmentManager;

import com.liushiyu.tooltip.core.sheet.SheetDialog;

import java.util.ArrayList;

/**
 * created by liushuai on 2019/1/17
 */
public class SheetAgent {

    private SheetDialog.Builder builder;

    private void builderConfirm() {
        if (builder == null) {
            builder = SheetDialog.builder();
        }
    }

    public SheetAgent setOptions(ArrayList<String> options) {
        builderConfirm();
        builder.setOptions(options);
        return this;
    }

    public SheetAgent setSpecialButtonText(String specialButtonText) {
        builderConfirm();
        builder.setSpecialButtonText(specialButtonText);
        return this;
    }

    public SheetAgent setCancelable(boolean cancelable) {
        builderConfirm();
        if (cancelable) {
            builder.setCancelableBackButtonCanGoAway(true);
        }
        builder.setCancelable(cancelable);
        return this;
    }

    public SheetAgent setCancelableBackButtonCanGoAway(boolean cancelableBackButtonCanGoAway) {
        builderConfirm();
        builder.setCancelableBackButtonCanGoAway(cancelableBackButtonCanGoAway);
        return this;
    }

    public SheetAgent setSheetListener(SheetDialog.SheetDialogListener listener) {
        builderConfirm();
        builder.setSheetListener(listener);
        return this;
    }

    public SheetDialog build() {
        builderConfirm();
        return builder.build();
    }

    public SheetDialog show(FragmentManager fragmentManager, String tag) {
        SheetDialog sheetDialog = build();
        sheetDialog.show(fragmentManager, tag);
        return sheetDialog;
    }
}
