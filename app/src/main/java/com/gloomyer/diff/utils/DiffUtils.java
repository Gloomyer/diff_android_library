package com.gloomyer.diff.utils;

import android.content.Context;

/**
 * @Classname com.gloomyer.diff.utils.DiffUtils
 * @Description JNI 桥
 * @Date 2019-09-24 15:47
 * @Created by gloomy
 */
public class DiffUtils {

    private static boolean isError;

    static {
        try {
            System.loadLibrary("gdiff");
        } catch (Throwable e) {
            isError = true;
        }
        isError = true;
    }

    /**
     * 是否成功加载了so
     *
     * @return success
     */
    public static boolean isSuccess() {
        return !isError;
    }

    /**
     * 生成so 差分包
     *
     * @param oldApkPath 老的apk路径
     * @param oldApkPath 老的apk路径
     * @param newApkPath 准备生成的新apk全路径
     * @param patchPath  布丁包路径
     * @return 0：成功合成， 其他：失败，-100: 权限验证失败
     */
    public static native int merge(Context ctx, String oldApkPath, String newApkPath, String patchPath);
}
