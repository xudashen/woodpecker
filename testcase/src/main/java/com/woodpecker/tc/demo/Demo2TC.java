package com.woodpecker.tc.demo;


import com.sword.autotest.framework.annotation.http.AutoHttpRequest;
import com.sword.autotest.framework.annotation.http.AutoProxy;
import com.sword.autotest.framework.assertion.Validate;
import com.woodpecker.service.demo.KugouService;
import com.woodpecker.tc.base.BaseTC;
import com.xujinjian.HttpClient.HttpResponse;
import com.xujinjian.Security.MD5Util;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * 类描述:〈Demo〉
 *
 * @author: sword
 */
@AutoProxy
public class Demo2TC extends BaseTC {

    /**
     * 用例ID
     */
    private String id = null;

    /**
     * 用例运行时的测试环境
     */
    private String envi = null;

    @AutoHttpRequest
    KugouService kugouService;


    @Parameters({"url", "username", "password"})
    @Test(description = "登录繁星TC")
    public void login(String url, String username, String password) {
        //登录
        String params = "appid=1010&username=" + username + "&pwd=" + MD5Util.encrypt(password).toLowerCase() +
                "&code=&ticket=Z_ZQiLXPSenpL14LUvXh_2Ok74OESU_79iY0YAWmWJY_rOIc4U1EQC5HPp6D7I2JPNNb0q-SHGI*&clienttime=1535780844&expire_day=3&autologin=false&redirect_uri=&state=1&callback=Fx.login.loginSdkkugouCallback.loginSuccess&login_ver=1&mobile=&mobile_code=&mid=37b803dfbed016b490482759404f88c2&kguser_jv=180829";
        HttpResponse response = kugouService.login(url, params);
        // log.info("响应状态码为：{}", response.getStatus());
        log.info("请求耗时：{}毫秒", response.getTime());
        log.info("响应结果为：{}", response.getContent());
        //校验响应结果是否为 success
        Validate.isEquals("success", response.getContent(),
                "校验响应结果为success");//不会中断流程，代码会继续往下跑
        // Assertion.assertEquals("success", response.getContent(), "校验响应结果为success");//校验不通过会中断流程
        //访问主页
        String indexUrl = "http://fanxing.kugou.com/";
        HttpResponse httpResponse = kugouService.index(indexUrl);
        log.info("请求耗时：{}毫秒", httpResponse.getTime());
        // log.info("响应结果为：{}", httpResponse.getContent());
        //判断是否登录成功
        Validate.isTrue(!httpResponse.getContent().contains("<a href=\"javascript:;\" title=\"登录\" onclick=\"return showLogin()\" id='fxLogin'>登录</a>"), "校验是否登录成功");
        log.info("用例结束");
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getEnvi() {
        return envi;
    }


    public void setEnvi(String envi) {
        this.envi = envi;
    }
}
