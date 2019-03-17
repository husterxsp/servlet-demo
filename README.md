## Servlet demo


### 运行

#### 1. 编译

```shell
javac DemoServ.java -cp /Users/xushaopeng/Desktop/personal/Java/apache-tomcat-9.0.12/lib/*:.
```

注意添加classpath，主要用到 jsp-api.jar、servlet-api.jar

#### 2. 启动tomcat

```shell
./bin/startup.sh
```

然后将项目文件夹拷贝到tomcat的`webapps` 目录即可访问

<http://127.0.0.1:8090/servlet-demo/>

这里本地tomcat的端口设置成了8090。可以修改 `conf/server.xml` 配置


### 参考

- <https://www.javatpoint.com/steps-to-create-a-servlet-using-tomcat-server>