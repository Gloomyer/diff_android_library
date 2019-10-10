package com.gloomyer.diff.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;

/**
 * @Classname ApkUtils
 * @Description 工具apk
 * @Date 2019-09-24 16:12
 * @Created by gloomy
 */
public class ApkUtils {

    /**
     * 获取当前运行中的apk 全路径
     *
     * @param mContext 上下文
     * @return 路径
     */
    public static String getOldPath(Context mContext) {
        if (TextUtils.isEmpty(mContext.getPackageName()))
            return null;
        try {
            ApplicationInfo appInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), 0);
            return appInfo.sourceDir;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void installApk(Context mContext, String apkPath) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + apkPath),
                "application/vnd.android.package-archive");
        mContext.startActivity(intent);
    }
}
