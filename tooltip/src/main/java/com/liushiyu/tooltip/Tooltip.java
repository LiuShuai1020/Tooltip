package com.liushiyu.tooltip;

import com.liushiyu.tooltip.agent.DialogAgent;
import com.liushiyu.tooltip.agent.LoadingAgent;
import com.liushiyu.tooltip.agent.SheetAgent;

/**
 * created by liushuai on 2019/1/16
 */
public class Tooltip {

    private Tooltip() {
        throw new AssertionError();
    }

    public static DialogAgent alertDialog() {
        return new DialogAgent();
    }

    public static LoadingAgent loading() {
        return new LoadingAgent();
    }

    public static SheetAgent sheet() {
        return new SheetAgent();
    }
}
