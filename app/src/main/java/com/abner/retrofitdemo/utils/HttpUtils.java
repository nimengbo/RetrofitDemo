package com.abner.retrofitdemo.utils;

import android.text.TextUtils;

import java.util.Map;

/**
 * Created by Abner on 16/1/14.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public class HttpUtils {

    /**
     * 处理params
     *
     * @param params
     * @return
     */
    public static Map<String, String> initParams(Map<String, String> params, String methodName) {
        //deviceType=1&fromPageId=9&goodsId=27021599157136361&method=test.test&session=BwsIDQNRAQUFA0VVCVdSVlNWUg1RWgEHXVdTAAcCXVoEW1RfCwQJBVIEAEsIAgZUAlRRAgcO&userId=1384009166&version=1.1

        params.put("method", methodName);
        params.put("version", "1.1");
        params.put("deviceType", "1");

        params.put("userId","1384009166");
        params.put("session","BwsIDQNRAQUFA0VVCVdSVlNWUg1RWgEHXVdTAAcCXVoEW1RfCwQJBVIEAEsIAgZUAlRRAgcO");


        //如果当前方法不需要session，则直接返回
//        for (String tmpMethod : sessionExcludeLst) {
//            if (methodName.toLowerCase().contains(tmpMethod.toLowerCase())) {
//                LogUtils.d("http request without session => " + getHttpUrl(requestType) + "?" + params.toString());
//                return;
//            }
//        }
//
//        //当session或userId为空时，从配置里再取一次，避免后台服务调用接口时，session与userId变量为空了
//        if (TextUtils.isEmpty(AppContext.session)) {
//            AppContext.session = AppConfig.getInstance().getStringValue(AppConfig.CURRENT_SESSION);
//        }
//        if (TextUtils.isEmpty(AppContext.userId)) {
//            AppContext.userId = AppConfig.getInstance().getStringValue(AppConfig.CURRENT_USER_ID);
//        }
//
//        LogUtils.d("request initParam get CURRENT_SESSION = " + AppContext.session + ", userId = " + AppContext.userId);
//
//        //检查用户是否已经登陆
//        if (TextUtils.isEmpty(AppContext.session) || TextUtils.isEmpty(AppContext.userId)) {
//            throw new NotLoginException();
//        }
//
//        if (!AppContext.session.equals("")) {
//            params.put(AppConfig.API_SESSION_NAME, AppContext.session);
//        }
//        if (!AppContext.userId.equals("")) {
//            params.put(AppConfig.API_USERID_NAME, AppContext.userId);
//        }
//        params.put(AppConfig.API_FROM_PAGE_ID, String.valueOf(AppContext.fromPageId)); // 接口统计 frompageid
//
//        LogUtils.d(" 接口统计 ：  " + methodName + " -- fromPageId : " + AppContext.fromPageId);

        return params;
    }
}
