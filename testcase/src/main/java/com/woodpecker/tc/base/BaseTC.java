package com.woodpecker.tc.base;


import com.sword.autotest.framework.testcase.BaseTestCase;
import com.woodpecker.tc.StartApplication;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 类描述:〈基础TC〉
 *
 * @author: sword
 */
@SpringBootTest(classes = {StartApplication.class})
public class BaseTC extends BaseTestCase {

    /**
     * 用例ID
     */
    private String id = null;

    /**
     * 用例运行时的测试环境
     */
    private String envi = null;


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


    /**
     * 方法功能描述: 删除Cookie，如果不删除，每次请求都会带上cookie
     *
     * @return void
     */
    public void clearCookie() {
        super.httpClientUtil.clearCookies();
    }

}
