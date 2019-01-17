package com.liushiyu.tooltip.core.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liushiyu.tooltip.R;
import com.liushiyu.tooltip.core.base.BaseDialog;

/**
 * created by liushuai on 2018/11/9
 */
public class AlertDialog extends BaseDialog {

    private static final String TITLE = "title";
    private static final String MESSAGE = "mMessage";
    private static final String CHILD_MESSAGE = "mChildMessage";
    private static final String BUTTON_ONE_TEXT = "mButtonOneText";
    private static final String BUTTON_TWO_TEXT = "mButtonTwoText";
    private static final String BUTTON_THREE_TEXT = "mButtonThreeText";
    private static final String CANCELABLE = "cancelable";
    private static final String CANCELED_ON_TOUCH_OUTSIDE = "cancelableBackButtonCanGoAway";
    //Dialog相关
    private CharSequence mTitle;
    private CharSequence mMessage;
    private CharSequence mChildMessage;
    private CharSequence mButtonOneText;
    private CharSequence mButtonTwoText;
    private CharSequence mButtonThreeText;
    private boolean mCancelable;
    private boolean mCanceledOnTouchOutside;

    //中间view
    private View middleView;
    //中间View 的布局参数
    private ViewGroup.LayoutParams middleParams;

    //新中间view
    private View newMiddleView;
    //新中间View 的布局参数
    private ViewGroup.LayoutParams newMiddleViewParams;

    TextView dialogTitle;

    TextView dialogMessage;

    TextView dialogChildMessage;

    LinearLayout middleLayout;

    Button dialogButtonOne;

    Button dialogButtonTwo;

    Button dialogButtonThree;

    View dialogButtonOneButtonTwoLine;

    View dialogButtonTwoButtonThreeLine;

    View buttonLayoutTopLine;

    public static Builder builder() {
        return new Builder();
    }

    private AlertDialogClickListener alertDialogListener;

    public interface AlertDialogClickListener {
        boolean onButtonClick(View v, AlertDialog alertDialog, CharSequence buttonTitle, int index);
    }

    public void setAlertDialogListener(AlertDialogClickListener listener) {
        this.alertDialogListener = listener;
    }

    public interface OnClickListener {

        boolean onClick(AlertDialog alertDialog);
    }

    private OnClickListener onButtonOneClickListener;

    public void setOnButtonOneClickListener(OnClickListener onClickListener) {
        this.onButtonOneClickListener = onClickListener;
    }

    private OnClickListener onButtonTwoClickListener;

    public void setOnButtonTwoClickListener(OnClickListener onClickListener) {
        this.onButtonTwoClickListener = onClickListener;
    }

    private OnClickListener onButtonThreeClickListener;

    public void setOnButtonThreeClickListener(OnClickListener onClickListener) {
        this.onButtonThreeClickListener = onClickListener;
    }

    @Override
    protected void created(LayoutInflater inflater, ViewGroup container, View root, Bundle savedInstanceState) {
        dialogTitle = root.findViewById(R.id.dialogTitle);

        dialogMessage = root.findViewById(R.id.dialogMessage);

        dialogChildMessage = root.findViewById(R.id.dialogChildMessage);

        middleLayout = root.findViewById(R.id.middleLayout);

        dialogButtonOne = root.findViewById(R.id.dialogButtonOne);

        dialogButtonTwo = root.findViewById(R.id.dialogButtonTwo);

        dialogButtonThree = root.findViewById(R.id.dialogButtonThree);

        dialogButtonOneButtonTwoLine = root.findViewById(R.id.dialogButtonOneButtonTwoLine);

        dialogButtonTwoButtonThreeLine = root.findViewById(R.id.dialogButtonTwoButtonThreeLine);

        buttonLayoutTopLine = root.findViewById(R.id.buttonLayoutTopLine);

    }

    @Override
    protected int styleId() {
        return R.style.AppTheme_AlertDialog;
    }

    @Override
    protected int layoutId() {
        return R.layout.dialog_alert;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitle = bundle.getCharSequence(TITLE);
            mMessage = bundle.getCharSequence(MESSAGE);
            mChildMessage = bundle.getCharSequence(CHILD_MESSAGE);
            mButtonOneText = bundle.getCharSequence(BUTTON_ONE_TEXT);
            mButtonTwoText = bundle.getCharSequence(BUTTON_TWO_TEXT);
            mButtonThreeText = bundle.getCharSequence(BUTTON_THREE_TEXT);
            mCancelable = bundle.getBoolean(CANCELABLE);
            mCanceledOnTouchOutside = bundle.getBoolean(CANCELED_ON_TOUCH_OUTSIDE);
        }

        if (!TextUtils.isEmpty(mTitle)) {
            dialogTitle.setText(mTitle);
            dialogTitle.setVisibility(View.VISIBLE);
        } else {
            dialogTitle.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mMessage)) {
            dialogMessage.setText(mMessage);
            dialogMessage.setVisibility(View.VISIBLE);
        } else {
            dialogMessage.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mChildMessage)) {
            dialogChildMessage.setText(mChildMessage);
            dialogChildMessage.setVisibility(View.VISIBLE);
        } else {
            dialogChildMessage.setVisibility(View.GONE);
        }

        if (newMiddleView != null) {
            resetMiddleView(newMiddleView, newMiddleViewParams);
        }

        if (!TextUtils.isEmpty(mButtonOneText)) {
            dialogButtonOne.setText(mButtonOneText);
            dialogButtonOne.setVisibility(View.VISIBLE);
            dialogButtonOne.setOnClickListener((v) -> {
                if (onButtonOneClickListener != null) {
                    if (!onButtonOneClickListener.onClick(AlertDialog.this)) {
                        dismiss();
                    }
                } else {
                    dismiss();
                }

                if (alertDialogListener != null) {
                    if (!alertDialogListener.onButtonClick(v, AlertDialog.this, mButtonOneText, 0)) {
                        dismiss();
                    }
                } else {
                    dismiss();
                }
            });
        } else {
            dialogButtonOne.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mButtonTwoText)) {
            dialogButtonTwo.setText(mButtonTwoText);
            dialogButtonTwo.setVisibility(View.VISIBLE);
            dialogButtonTwo.setOnClickListener((v) -> {
                if (onButtonTwoClickListener != null) {
                    if (!onButtonTwoClickListener.onClick(AlertDialog.this)) {
                        dismiss();
                    }
                } else {
                    dismiss();
                }

                if (alertDialogListener != null) {
                    if (!alertDialogListener.onButtonClick(v, AlertDialog.this, mButtonTwoText, 1)) {
                        dismiss();
                    }
                } else {
                    dismiss();
                }
            });
        } else {
            dialogButtonTwo.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mButtonThreeText)) {
            dialogButtonThree.setText(mButtonThreeText);
            dialogButtonThree.setVisibility(View.VISIBLE);
            dialogButtonThree.setOnClickListener((v) -> {
                if (onButtonThreeClickListener != null) {
                    if (!onButtonThreeClickListener.onClick(AlertDialog.this)) {
                        dismiss();
                    }
                } else {
                    dismiss();
                }

                if (alertDialogListener != null) {
                    if (!alertDialogListener.onButtonClick(v, AlertDialog.this, mButtonThreeText, 2)) {
                        dismiss();
                    }
                } else {
                    dismiss();
                }
            });
        } else {
            dialogButtonThree.setVisibility(View.GONE);
        }

        if (dialogButtonOne.getVisibility() == View.VISIBLE && dialogButtonTwo.getVisibility() == View.VISIBLE && dialogButtonThree.getVisibility() == View.VISIBLE) {
            dialogButtonOneButtonTwoLine.setVisibility(View.VISIBLE);
            dialogButtonTwoButtonThreeLine.setVisibility(View.VISIBLE);
        } else {
            if (dialogButtonOne.getVisibility() == View.VISIBLE && dialogButtonTwo.getVisibility() == View.VISIBLE) {
                dialogButtonOneButtonTwoLine.setVisibility(View.VISIBLE);
            }
            if (dialogButtonTwo.getVisibility() == View.VISIBLE && dialogButtonThree.getVisibility() == View.VISIBLE) {
                dialogButtonTwoButtonThreeLine.setVisibility(View.VISIBLE);
            }
        }

        if (dialogButtonOne.getVisibility() == View.GONE && dialogButtonTwo.getVisibility() == View.GONE && dialogButtonThree.getVisibility() == View.GONE) {
            buttonLayoutTopLine.setVisibility(View.GONE);
        }

        setCancelable(mCancelable);
        setCanceledOnTouchOutside(mCanceledOnTouchOutside);
    }

    /**
     * 设置AlertDialog中间view
     */
    public void setMiddleView(View view) {
        this.newMiddleView = view;
        this.newMiddleViewParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /**
     * 设置AlertDialog中间view
     */
    public void setMiddleView(View view, ViewGroup.LayoutParams params) {
        this.newMiddleView = view;
        this.newMiddleViewParams = params;
    }

    /**
     * 设置AlertDialog中间view
     */
    private void resetMiddleView(View view, ViewGroup.LayoutParams params) {
        this.middleView = view;
        this.middleParams = params;
        initMiddleView();
    }

    /**
     * 设置AlertDialog中间view
     */
    private void resetMiddleView(View view) {
        this.middleView = view;
        this.middleParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        initMiddleView();
    }

    /**
     * 初始化AlertDialog中间view
     */
    private void initMiddleView() {
        if (middleView != null) {
            removeMiddleView();
            middleLayout.addView(middleView, middleParams);
            middleLayout.bringChildToFront(middleView);
            middleLayout.postInvalidate();
        }
    }

    /**
     * remove通过setMiddleView（）设置的view
     */
    private void removeMiddleView() {
        if (middleLayout.getChildCount() > 1) {
            if (null != middleView.getParent()) {
                ((ViewGroup) middleView.getParent()).removeView(middleView);
            }
            middleLayout.removeView(middleView);
        }
    }

    public static class Builder {

        CharSequence title;
        CharSequence mMessage;
        CharSequence mChildMessage;
        CharSequence mButtonOneText;
        CharSequence mButtonTwoText;
        CharSequence mButtonThreeText;
        AlertDialogClickListener alertDialogListener;
        AlertDialog.OnClickListener onButtonOneClickListener;
        AlertDialog.OnClickListener onButtonTwoClickListener;
        AlertDialog.OnClickListener onButtonThreeClickListener;
        boolean cancelable;
        boolean canceledOnTouchOutside;
        View newMiddleView;
        ViewGroup.LayoutParams newMiddleViewParams;

        public Builder() {
            title = "";
            mMessage = "";
            mChildMessage = "";
            cancelable = true;
            canceledOnTouchOutside = false;
        }

        private Builder(AlertDialog dialog) {
            title = dialog.mTitle;
            mMessage = dialog.mMessage;
            alertDialogListener = dialog.alertDialogListener;
            cancelable = dialog.mCancelable;
            canceledOnTouchOutside = dialog.mCanceledOnTouchOutside;
        }

        public Builder title(String titleText) {
            title = titleText;
            return this;
        }

        public Builder message(CharSequence message) {
            mMessage = message;
            return this;
        }

        public Builder childMessage(CharSequence childMessage) {
            mChildMessage = childMessage;
            return this;
        }

        public Builder buttonOneText(CharSequence buttonText) {
            this.mButtonOneText = buttonText;
            return this;
        }

        public Builder buttonOneText(CharSequence buttonText, AlertDialog.OnClickListener listener) {
            this.mButtonOneText = buttonText;
            this.onButtonOneClickListener = listener;
            return this;
        }

        public Builder buttonTwoText(CharSequence buttonText) {
            this.mButtonTwoText = buttonText;
            return this;
        }

        public Builder buttonTwoText(CharSequence buttonText, AlertDialog.OnClickListener listener) {
            this.mButtonTwoText = buttonText;
            this.onButtonTwoClickListener = listener;
            return this;
        }

        public Builder buttonThreeText(CharSequence buttonText) {
            this.mButtonThreeText = buttonText;
            return this;
        }

        public Builder buttonThreeText(CharSequence buttonText, AlertDialog.OnClickListener listener) {
            this.mButtonThreeText = buttonText;
            this.onButtonThreeClickListener = listener;
            return this;
        }

        public Builder cancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.canceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public Builder alertDialogClickListener(AlertDialogClickListener listener) {
            this.alertDialogListener = listener;
            return this;
        }

        /**
         * 设置AlertDialog中间view
         */
        public Builder middleView(View view) {
            this.newMiddleView = view;
            this.newMiddleViewParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            return this;
        }

        /**
         * 设置AlertDialog中间view
         */
        public Builder middleView(View view, ViewGroup.LayoutParams params) {
            this.newMiddleView = view;
            this.newMiddleViewParams = params;
            return this;
        }

        public AlertDialog build() {
            AlertDialog dialog = new AlertDialog();
            dialog.setArguments(getArguments());
            dialog.setAlertDialogListener(this.alertDialogListener);
            dialog.setOnButtonOneClickListener(this.onButtonOneClickListener);
            dialog.setOnButtonTwoClickListener(this.onButtonTwoClickListener);
            dialog.setOnButtonThreeClickListener(this.onButtonThreeClickListener);
            dialog.setMiddleView(this.newMiddleView, this.newMiddleViewParams);
            return dialog;
        }

        public AlertDialog show(FragmentManager fragmentManager, String tag) {
            AlertDialog dialog = build();
            dialog.show(fragmentManager, tag);
            return dialog;
        }

        private Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putCharSequence(TITLE, title);
            bundle.putCharSequence(MESSAGE, mMessage);
            bundle.putCharSequence(CHILD_MESSAGE, mChildMessage);
            bundle.putCharSequence(BUTTON_ONE_TEXT, mButtonOneText);
            bundle.putCharSequence(BUTTON_TWO_TEXT, mButtonTwoText);
            bundle.putCharSequence(BUTTON_THREE_TEXT, mButtonThreeText);
            bundle.putBoolean(CANCELABLE, cancelable);
            bundle.putBoolean(CANCELED_ON_TOUCH_OUTSIDE, canceledOnTouchOutside);
            return bundle;
        }
    }
}
