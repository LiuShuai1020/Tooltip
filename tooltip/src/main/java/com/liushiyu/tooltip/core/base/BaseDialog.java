package com.liushiyu.tooltip.core.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * created by liushuai on 2018/11/9
 */
public abstract class BaseDialog extends DialogFragment {

    private BaseDialogListener mListener;

    public interface BaseDialogListener {
        void onDismiss(DialogInterface dialog);
    }

    public void setBaseDialogListener(BaseDialogListener listener) {
        this.mListener = listener;
    }

    protected abstract void created(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    private DialogInterface.OnDismissListener mOnDismissListener;
    protected View mRootView;

    protected abstract int styleId();

    @LayoutRes
    protected abstract int layoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, styleId());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mRootView == null) {
            mRootView = inflater.inflate(layoutId(), container, false);
            ButterKnife.bind(this, mRootView);
        } else {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        }
        created(inflater, container, savedInstanceState);
        return mRootView;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mOnDismissListener != null) {
            mOnDismissListener.onDismiss(dialog);
        }
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        getDialog().setCanceledOnTouchOutside(cancel);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener listener) {
        this.mOnDismissListener = listener;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception ignore) {
        }
    }

    @Override
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception ignore) {
        }
    }

    @Override
    public void dismissAllowingStateLoss() {
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception ignore) {
        }
    }
}
