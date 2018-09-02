package com.woodpecker.service.demo;

import com.sword.autotest.framework.annotation.http.HttpRequest;
import com.sword.autotest.framework.annotation.http.Param;
import com.sword.autotest.framework.annotation.http.Url;
import com.xujinjian.HttpClient.HttpResponse;
import com.xujinjian.HttpClient.RequestType;


/**
 * 接口描述:〈发送百度请求相关Service〉
 *
 * @author: sword
 */
public interface KugouService {

    /**
     * 方法功能描述: 登录酷狗繁星
     *
     * @param url
     * @param params
     * @return HttpResponse
     */
    @HttpRequest(type = RequestType.GET, description = "繁星登录接口")
    HttpResponse login(@Url String url, @Param String params);


    /**
     * 方法功能描述: 访问酷狗繁星主页
     *
     * @param url
     * @return HttpResponse
     */
    @HttpRequest(type = RequestType.GET)
    HttpResponse index(@Url String url);

}
