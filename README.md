# Tooltip
##### Tooltip 是一个提示工具包，当前版本只包含 Dialog、Loading、底部弹出框，在创建新的项目时，可以省去来来回回copy的事情，更加专注主要逻辑的编写。

### Add Libraries

###### Step 1. Add the JitPack repository to your build file
###### Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
             ...
             maven { url 'https://jitpack.io' }
		}
	}

###### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.LiuShuai1020:Tooltip:1.0.0'
	}

##### 简单介绍一下用法

##### Dialog:
![dialog.png](https://upload-images.jianshu.io/upload_images/13761067-efc2a54ecd91f4c2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

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

##### Loading:
![loading.png](https://upload-images.jianshu.io/upload_images/13761067-74036721ec338965.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

        LoadingDialog loadingDialog = Tooltip.loading().message("正在加载...").build();
        loadingDialog.show(this.getSupportFragmentManager(), "loadingDialog");

        TimeCount timeCount = new TimeCount(10000);
        timeCount.setOnTimeCountListener(loadingDialog::dismiss);
        timeCount.start();

##### Sheet:
![sheet.png](https://upload-images.jianshu.io/upload_images/13761067-953c27451f0778ca.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

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