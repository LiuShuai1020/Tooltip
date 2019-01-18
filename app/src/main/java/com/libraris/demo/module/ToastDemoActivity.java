package com.libraris.demo.module;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.libraris.demo.R;
import com.liushiyu.tooltip.Tooltip;

/**
 * created by liushuai on 2019/1/18
 */
public class ToastDemoActivity extends AppCompatActivity {

    public static final String[] ITEMS = {
            "0普通",
            "1普通、可设置左侧图片",
            "2普通强调",
            "3普通、可点击",
            "4普通、可点击、可设置左侧图片",

            "5成功",
            "6成功、可设置左侧图片",
            "7强调成功",
            "8强调成功、可设置左侧图片",
            "9强调成功、可点击",
            "10强调成功、可点击、可设置左侧图片",

            "11警告",
            "12警告、可设置左侧图片",
            "13强调警告",
            "14强调警告、可设置左侧图片",
            "15强调警告、可点击",
            "16强调警告、可点击、可设置左侧图片",

            "17错误",
            "18错误、可设置左侧图片",
            "19强调错误",
            "20强调错误、可设置左侧图片",
            "21强调错误、可点击",
            "22强调错误、可点击、可设置左侧图片",
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
        String clickText = "点我";


        ListView listView = findViewById(R.id.listview);
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "toast clicked!!!");
            }
        };
        listView.setAdapter(new ArrayAdapter(this, R.layout.adapter_toast_demo_item, ITEMS));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = ITEMS[position];
                switch (position) {
                    case 0:
                        Tooltip.toast().show(context, text);
                        break;
                    case 1:
                        Tooltip.toast().show(context, text, leftIconRes);
                        break;
                    case 2:
                        Tooltip.toast().showEmphasize(context, text, leftIconRes);
                        break;
                    case 3:
                        Tooltip.toast().showClickable(context, text, clickText, listener);
                        break;
                    case 4:
                        Tooltip.toast().showClickable(context, text, clickText, listener, leftIconRes);
                        break;
                    case 5:
                        Tooltip.toast().showSuccess(context, text);
                        break;
                    case 6:
                        Tooltip.toast().showSuccess(context, text, leftIconRes);
                        break;
                    case 7:
                        Tooltip.toast().showSuccessEmphasize(context, text);
                        break;
                    case 8:
                        Tooltip.toast().showSuccessEmphasize(context, text, leftIconRes);
                        break;
                    case 9:
                        Tooltip.toast().showSuccessClickable(context, text, clickText, listener);
                        break;
                    case 10:
                        Tooltip.toast().showSuccessClickable(context, text, clickText, listener, leftIconRes);
                        break;
                    case 11:
                        Tooltip.toast().showWarning(context, text);
                        break;
                    case 12:
                        Tooltip.toast().showWarning(context, text, leftIconRes);
                        break;
                    case 13:
                        Tooltip.toast().showWarningEmphasize(context, text);
                        break;
                    case 14:
                        Tooltip.toast().showWarningEmphasize(context, text, leftIconRes);
                        break;
                    case 15:
                        Tooltip.toast().showWarningClickable(context, text, clickText, listener);
                        break;
                    case 16:
                        Tooltip.toast().showWarningClickable(context, text, clickText, listener, leftIconRes);
                        break;
                    case 17:
                        Tooltip.toast().showError(context, text);
                        break;
                    case 18:
                        Tooltip.toast().showError(context, text, leftIconRes);
                        break;
                    case 19:
                        Tooltip.toast().showErrorEmphasize(context, text);
                        break;
                    case 20:
                        Tooltip.toast().showErrorEmphasize(context, text, leftIconRes);
                        break;
                    case 21:
                        Tooltip.toast().showErrorClickable(context, text, clickText, listener);
                        break;
                    case 22:
                        Tooltip.toast().showErrorClickable(context, text, clickText, listener, leftIconRes);
                        break;

                }
            }
        });
    }
}
