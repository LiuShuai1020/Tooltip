package com.libraris.demo.module;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.libraris.demo.R;
import com.liushiyu.tooltip.Tooltip;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastDemoActivity extends AppCompatActivity {

    public static final String[] ITEMS = {
            "0默认",
            "1默认 可设置图片资源",
            "2强调",
            "3强调 可设置图片资源",
            "4默认成功",
            "5默认 强调成功",
            "6默认警告",
            "7默认 强调警告",
            "8默认 错误",
            "9默认 强调错误"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_demo_layout);
        init();
    }

    private void init() {

        Context context = getApplicationContext();
        int leftIconRes = R.mipmap.ic_about_us;

        ListView listView = findViewById(R.id.listview);

        listView.setAdapter(new ArrayAdapter(this, R.layout.adapter_toast_demo_item, ITEMS));

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String text = ITEMS[position];
            switch (position) {
                case 0:
                    Tooltip.toast().show(context, text);
                    break;
                case 1:
                    Tooltip.toast().show(context, text, leftIconRes);
                    break;
                case 2:
                    Tooltip.toast().showEmphasize(context, text);
                    break;
                case 3:
                    Tooltip.toast().showEmphasize(context, text, leftIconRes);
                    break;
                case 4:
                    Tooltip.toast().showSuccess(context, text);
                    break;
                case 5:
                    Tooltip.toast().showSuccessEmphasize(context, text);
                    break;
                case 6:
                    Tooltip.toast().showWarning(context, text);
                    break;
                case 7:
                    Tooltip.toast().showWarningEmphasize(context, text);
                    break;
                case 8:
                    Tooltip.toast().showError(context, text);
                    break;
                case 9:
                    Tooltip.toast().showErrorEmphasize(context, text);
                    break;
            }
        });
    }
}
