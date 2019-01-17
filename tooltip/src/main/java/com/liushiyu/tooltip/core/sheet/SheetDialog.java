package com.liushiyu.tooltip.core.sheet;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alibaba.fastjson.JSONObject;
import com.liushiyu.tooltip.R;
import com.liushiyu.tooltip.R2;
import com.liushiyu.tooltip.core.base.BaseDialog;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 底部弹出框
 * Created by liushuai on 17/10/16.
 */

public class SheetDialog extends BaseDialog {
    private static final String CANCELABLE_BACK_BUTTON_CAN_GO_AWAY = "cancelableBackButtonCanGoAway";
    private static final String CANCELABLE = "cancelable";

    private ArrayList<String> options;
    private String specialButtonText;

    private boolean cancelable;
    private boolean cancelableBackButtonCanGoAway;

    @BindView(R2.id.animationView)
    LinearLayout animationView;
    @BindView(R2.id.containerView)
    LinearLayout containerView;
    @BindView(R2.id.cancelView)
    LinearLayout cancelView;
    @BindView(R2.id.cancelButton)
    TextView cancelButton;

    public SheetDialogListener mListener;

    public interface SheetDialogListener extends BaseDialogListener {
        void onOptionSelected(JSONObject option);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public SheetDialog setSheetListener(SheetDialogListener mListener) {
        this.mListener = mListener;
        return this;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        int color = ContextCompat.getColor(getActivity(), android.R.color.transparent);
        window.setBackgroundDrawable(new ColorDrawable(color));
    }

    @Override
    protected int layoutId() {
        return R.layout.dialog_sheet_view;
    }

    @Override
    protected void created(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            init(bundle);
        }
    }

    @Override
    protected int styleId() {
        return R.style.SheetDialogStyle;
    }

    private void init(Bundle args) {
        options = args.getStringArrayList("options");
        specialButtonText = args.getString("specialButton", "");

        cancelable = args.getBoolean(CANCELABLE);
        cancelableBackButtonCanGoAway = args.getBoolean(CANCELABLE_BACK_BUTTON_CAN_GO_AWAY);

        setItemView(options);
        if (TextUtils.isEmpty(specialButtonText)) {
            cancelView.setVisibility(View.GONE);
        } else {
            cancelView.setVisibility(View.VISIBLE);
            cancelButton.setText(specialButtonText);
        }
        cancelButton.setOnClickListener((v) -> {

            if (mListener != null) {
                JSONObject optionObj = new JSONObject();
                optionObj.put("index", -1);
                optionObj.put("value", specialButtonText);
                mListener.onOptionSelected(optionObj);
            }
            dismiss();
        });

        if (cancelable) {
            setCancelable(true);
            setCanceledOnTouchOutside(cancelableBackButtonCanGoAway);
        } else {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }

    }

    private void setItemView(ArrayList options) {
        containerView.removeAllViews();
        for (int i = 0; i < options.size(); i++) {
            getItem(i, options.get(i).toString());
        }
    }

    private void getItem(final int index, final String text) {
        View itemView = View.inflate(this.getContext(), R.layout.dialog_sheet_item_view, null);
        TextView textView = itemView.findViewById(R.id.optionName);
        textView.setText(text);
        containerView.addView(itemView);
        itemView.setOnClickListener((v) -> {
            if (mListener != null) {
                JSONObject optionObj = new JSONObject();
                optionObj.put("index", index);
                optionObj.put("value", text);
                mListener.onOptionSelected(optionObj);
            }
            dismiss();
        });
    }

    public static class Builder {

        ArrayList<String> options;
        String specialButtonText;

        boolean cancelable = true;
        boolean cancelableBackButtonCanGoAway = false;

        SheetDialogListener listener;

        public Builder() {
            options = new ArrayList();
            specialButtonText = "";
        }

        private Builder(SheetDialog sheetDialog) {
            options = sheetDialog.options;
            specialButtonText = sheetDialog.specialButtonText;
            this.listener = sheetDialog.mListener;
            cancelable = sheetDialog.cancelable;
            cancelableBackButtonCanGoAway = sheetDialog.cancelableBackButtonCanGoAway;
        }

        public Builder setOptions(ArrayList<String> options) {
            this.options = options;
            return this;
        }

        public Builder setSpecialButtonText(String specialButtonText) {
            this.specialButtonText = specialButtonText;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            if (cancelable) {
                this.cancelableBackButtonCanGoAway = true;
            }
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCancelableBackButtonCanGoAway(boolean cancelableBackButtonCanGoAway) {
            this.cancelableBackButtonCanGoAway = cancelableBackButtonCanGoAway;
            return this;
        }

        public Builder setSheetListener(SheetDialogListener listener) {
            this.listener = listener;
            return this;
        }

        public SheetDialog build() {
            SheetDialog sheetDialog = new SheetDialog();
            sheetDialog.setArguments(getArguments());
            sheetDialog.setSheetListener(listener);
            return sheetDialog;
        }

        public SheetDialog show(FragmentManager fragmentManager, String tag) {
            SheetDialog sheetDialog = build();
            sheetDialog.show(fragmentManager, tag);
            return sheetDialog;
        }

        private Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("options", options);
            bundle.putString("specialButton", specialButtonText);
            bundle.putBoolean(CANCELABLE, cancelable);
            bundle.putBoolean(CANCELABLE_BACK_BUTTON_CAN_GO_AWAY, cancelableBackButtonCanGoAway);
            return bundle;
        }
    }
}
