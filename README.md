## Servlet demo


### 运行

#### 1. 编译

```shell
javac **/*.java -cp /Users/xushaopeng/Desktop/personal/Java/apache-tomcat-9.0.12/lib/*:.
```

注意添加classpath，主要用到 jsp-api.jar、servlet-api.jar

#### 2. 启动tomcat

```shell
./bin/startup.sh
```

然后将项目文件夹拷贝到tomcat的`webapps` 目录即可访问

<http://127.0.0.1:8090/servlet-demo/>

这里本地tomcat的端口设置成了8090。可以修改 `conf/server.xml` 配置

日志输出可以查看logs 目录

### servlet设置

可以通过web.xml配置

```xml
<servlet-mapping>
    <servlet-name>test</servlet-name>
    <url-pattern>/welcome</url-pattern>
</servlet-mapping>
```

也可以通过注解 `@WebServlet`

```java
@WebServlet(urlPatterns = {"/welcome"}, loadOnStartup = 1)
public class DemoServ extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String name = req.getParameter("name");
        pw.println("Welcome " + name);
    }
}
```




### 参考

- <https://www.javatpoint.com/steps-to-create-a-servlet-using-tomcat-server>
- JavaEE-Servlet-Filter和Listener：<https://www.jianshu.com/p/46e5b3bf42d7>
- Servlet、Filter 和Listener 工作原理：<https://www.cnblogs.com/windlaughing/archive/2013/03/29/2989052.html>