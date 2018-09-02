package com.woodpecker.tc.demo;


import com.sword.autotest.framework.annotation.Data.ReadFile;
import com.sword.autotest.framework.annotation.http.AutoProxy;
import com.sword.autotest.framework.assertion.Validate;
import com.sword.autotest.framework.enums.FileType;
import com.woodpecker.tc.base.BaseTC;
import com.xujinjian.Assertion.Assertion;
import com.xujinjian.HttpClient.HttpResponse;
import org.testng.annotations.Test;

import java.util.Map;


/**
 * 类描述:〈Demo〉
 *
 * @author: sword
 */
@AutoProxy
public class Demo1TC extends BaseTC {

    /**
     * 用例ID
     */
    private String id = null;

    /**
     * 用例运行时的测试环境
     */
    private String envi = null;

    /**
     * 读取测试数据
     */
    @ReadFile(location = "src/main/resources/baidu.properties", type = FileType.properties)
    private Map<String, String> testDatas;


    @Test(description = "打开百度首页TC")
    public void openBaidu() {
        HttpResponse response = api.get(testDatas.get("baidu-url"));
        // log.info("响应状态码为：{}", response.getStatus());
        log.info("请求耗时：{}毫秒", response.getTime());
        // log.info("响应结果为：{}", response.getContent());
        //校验响应状态码是否为200
        Validate.isEquals(response.getStatus().getStatusCode(), Integer.parseInt(testDatas.get("stateCode")),
                "校验响应状态码是否为200");//不会中断流程，代码会继续往下跑
        //校验响应结果是否为百度首页
        Assertion.assertTrue(response.getContent().contains(testDatas.get("expected1")), "校验响应结果是否为百度首页");//校验不通过会中断流程
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
