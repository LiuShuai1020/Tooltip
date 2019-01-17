package com.liushiyu.tooltip.core.loading;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liushiyu.tooltip.R;
import com.liushiyu.tooltip.core.base.BaseDialog;

/**
 * created by liushuai on 2018/11/9
 */
public class LoadingDialog extends BaseDialog {

    TextView mLoadingText;

    private String mMessage;
    private boolean mCancelable;
    private boolean mCanceledOnTouchOutside;

    private int styleId = -1;

    public static Builder builder() {
        return new Builder();
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override
    protected void created(LayoutInflater inflater, ViewGroup container, View root, Bundle savedInstanceState) {
        mLoadingText = root.findViewById(R.id.loadingText);
    }

    @Override
    protected int styleId() {
        return styleId == -1 ? R.style.AppTheme_LoadingDialog : styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    @Override
    protected int layoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (getContext() == null) {
                    return;
                }
                ProgressBar progressBar = mRootView.findViewById(R.id.progress_dialog_layout_progressBar);
                final Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.indeterminate_loading_6_0);
                progressBar.setIndeterminateDrawable(drawable);
            }
        } catch (Exception ignore) {
        }

        final Bundle bundle = getArguments();
        if (bundle != null) {
            mCancelable = bundle.getBoolean("cancelable", true);
            mCanceledOnTouchOutside = bundle.getBoolean("canceledOnTouchOutside", false);
            setCancelable(mCancelable);
            setCanceledOnTouchOutside(mCanceledOnTouchOutside);

            mMessage = bundle.getString("message");
            if (!TextUtils.isEmpty(mMessage)) {
                mLoadingText.setVisibility(View.VISIBLE);
                mLoadingText.setText(mMessage);
            } else {
                mLoadingText.setVisibility(View.GONE);
            }

            styleId = bundle.getInt("styleId");
//            setStyle(DialogFragment.STYLE_NO_TITLE, styleId());
        }
    }


    public static class Builder {
        boolean cancelable;
        boolean canceledOnTouchOutside;
        String message;
        int styleId = -1;
        public Builder() {
            cancelable = true;
            canceledOnTouchOutside = false;
        }

        private Builder(LoadingDialog dialog) {
            this.canceledOnTouchOutside = dialog.mCanceledOnTouchOutside;
            this.cancelable = dialog.mCancelable;
            this.message = dialog.mMessage;
        }

        public Builder setStyleId(int styleId) {
            this.styleId = styleId;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
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

        public LoadingDialog build() {
            Bundle bundle = new Bundle();
            bundle.putString("message", message);
            bundle.putBoolean("cancelable", cancelable);
            bundle.putBoolean("canceledOnTouchOutside", canceledOnTouchOutside);
            bundle.putInt("styleId", styleId);
            LoadingDialog dialog = new LoadingDialog();
            dialog.setArguments(bundle);
            return dialog;
        }

        public LoadingDialog show(FragmentManager manager) {
            return show(manager, LoadingDialog.class.getSimpleName());
        }

        public LoadingDialog show(FragmentManager manager, String tag) {
            LoadingDialog dialog = build();
            dialog.show(manager, tag);
            return dialog;
        }
    }
}
