package com.libraris.demo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.libraris.demo.utils.TimeCount;
import com.liushiyu.tooltip.Tooltip;
import com.liushiyu.tooltip.core.loading.LoadingDialog;
import com.liushiyu.tooltip.core.sheet.SheetDialog;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tooltipAlertDialogButton)
    public void TooltipButtonClick() {
        Tooltip.alertDialog()
                .title("提示")
                .message("提示内容")
                .buttonOneText("取消", alertDialog -> {
                    alertDialog.dismiss();
                    return false;
                })
                .buttonTwoText("确定", alertDialog -> {
                    alertDialog.dismiss();
                    return false;
                })
//                .buttonThreeText("其他", alertDialog -> {
//                    alertDialog.dismiss();
//                    return false;
//                })
                .show(this.getSupportFragmentManager(), "alertDialog");
    }

    @OnClick(R.id.tooltipLoadingDialogButton)
    public void tooltipLoadingDialogButtonClick() {

        LoadingDialog loadingDialog = Tooltip.loading().message("正在加载...").build();
        loadingDialog.show(this.getSupportFragmentManager(), "loadingDialog");

        TimeCount timeCount = new TimeCount(10000);
        timeCount.setOnTimeCountListener(loadingDialog::dismiss);
        timeCount.start();
    }

    @OnClick(R.id.tooltipSheetDialogButton)
    public void tooltipSheetDialogButtonClick() {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("我是按钮".concat("" + i));
        }

        Tooltip.sheet()
                .setOptions(list)
                .setSpecialButtonText("取消")
                .setCancelable(true)
                .setCancelableBackButtonCanGoAway(true)
                .setSheetListener(new SheetDialog.SheetDialogListener() {
                    @Override
                    public void onOptionSelected(JSONObject option) {
                        String index = option.getString("index");
                        String value = option.getString("value");
                        Toast.makeText(MainActivity.this, "点击了第" + index + "条的" + value + "数据", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismiss(DialogInterface dialog) {

                    }
                }).build().show(getSupportFragmentManager(), "sheet");
    }
}
