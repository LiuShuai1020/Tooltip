package com.libraris.demo.utils;

import android.os.CountDownTimer;

/**
 * created by liushuai on 2018/9/4
 */
public class TimeCount extends CountDownTimer {

    public interface OnTimeCountListener {
        void onTimeCountFinish();
    }

    private OnTimeCountListener onItemTimeCountListener;

    public void setOnTimeCountListener(OnTimeCountListener onItemTimeCountListener) {
        this.onItemTimeCountListener = onItemTimeCountListener;
    }

    private OnTimeCountListener getOnTimeCountListener() {
        return onItemTimeCountListener;
    }

    private long surplusTime;//剩余时间

    public TimeCount(long millisInFuture) {
        super(millisInFuture, 1000);
        this.surplusTime = millisInFuture;
    }

    public long getSurplusTime() {
        return surplusTime;
    }

    @Override
    public void onFinish() {
        this.surplusTime = 0;
        if (getOnTimeCountListener() != null) {
            getOnTimeCountListener().onTimeCountFinish();
        }
    }

    @Override
    public void onTick(long millisUntilFinished) {
        surplusTime = millisUntilFinished;
    }
}
