### 1. 代码自动生成
```shell
run class  src/main/java/CodeGenerator.main()
```

### 2.部署war包
```shell
#demo4项目根目录下运行
mvn install
```
```shell
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ demo4 ---
[INFO] Building jar: D:\WorkSpace\Github-Project\demo4\target\demo4-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.7.8:repackage (repackage) @ demo4 ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ demo4 ---
[INFO] Installing D:\WorkSpace\Github-Project\demo4\target\demo4-0.0.1-SNAPSHOT.jar to C:\Users\cheng\.m2\repository\com\example\demo4\0.0.1-SNAPSHOT\demo4-0.0.1-SNAPSHOT.jar
[INFO] Installing D:\WorkSpace\Github-Project\demo4\pom.xml to C:\Users\cheng\.m2\repository\com\example\demo4\0.0.1-SNAPSHOT\demo4-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  18.920 s
[INFO] Finished at: 2023-04-09T18:44:52+08:00

```