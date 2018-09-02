                           啄木鸟(woodpecker)自动化测试工具使用手册
GitHub下载地址：https://github.com/xudashen/woodpecker
微云下载地址：


Maven仓库注册：
    将lib目录下的install_maven.txt文件内容，执行一遍。
    注意：
    1.jar包下载地址：
    链接： https://share.weiyun.com/5j7fzLj （密码：ZaqK）
    将下载下来的jar，放到lib目录下去。
    2.需cd至lib目录下执行，否则会报错(提示文件不存在)。



POM依赖：
    <dependency>
        <groupId>com.sword</groupId>
        <artifactId>auto-test</artifactId>
        <version>2.0</version>
    </dependency>
    <dependency>
        <groupId>com.sword</groupId>
        <artifactId>commons</artifactId>
        <version>2.0</version>
    </dependency>



Case使用：
    TestCase，需继承com.sword.autotest.framework.testcase.BaseTestCase类(也可以间接继承)。
    没有其他要求了。
    其他功能请查阅TestNG，Case层是采用TestNG进行驱动的。



API使用：
	
    @AutoHttpRequest(ignore = false)：会对接口/类对象进行自动注入。
    如果ignore为false表示一定要对其注入，要求一定要在配置文件中将autotest.api.enable设置为true，否则会报错。
    如果ignore为true表示忽略注入，程序不会为其进行自动注入，也就是对象引用为null。

    @ReadFile(location = "src/main/resources/baidu.properties", type = FileType.properties, encoding = "UTF-8", ignore = false)：
    会自动读取文件内容，location属性表示文件路径，type表示按什么格式读取文件内容，encoding表示读取文件时的编码，ignore表示是否忽略读取文件注解。

    @HttpRequest(type = RequestType.GET, description = "接口说明")：只要在@AutoHttpRequest注解的对象引用的对应的类/接口上，
    在方法上加上@HttpRequest注解，框架会自动发送HTTP请求，type属性表示发送什么样的请求。

    @Url、@Param、@Header、@Download、@UploadName、@UploadFile、@Cookie这些注解，只能加上@HttpRequest注解的方法的参数上，在做HTTP请求时，会被自动解析。



报告输出：
    默认输出到test-output目录下。



日志输出：
    默认在log目录下。



测试用例运行方式：
    1.直接运行TestCase类
    2.编写TestCase.xml文件，运行这个xml文件
    3.使用mvn test运行



Demo：
    看testcase工程下的com.woodpecker.tc.demo.Demo1TC类和com.woodpecker.tc.demo.Demo2TC类。
    Demo运行方式：
    1：直接运行Demo1TC类
    2：运行TestCase.xml文件
    3：执行mvn test



日期：2018-09-01