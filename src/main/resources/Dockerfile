# 基础JAVA环境
FROM fabric8/java-centos-openjdk8-jdk:1.5.0
LABEL maintainer="wangxp@fosun.com"

# 时区
ENV TZ=Asia/Shanghai

# 环境变量
ENV LANG=en_US.UTF-8

# 设置JVM配置
ENV JAVA_MAX_MEM_RATIO 90
ENV JAVA_INIT_MEM_RATIO 50

# 设置JAVA_APP配置
ENV JAVA_APP_DIR=/opt/deployments
ENV JAVA_APP_NAME=@project.build.finalName@
ENV JAVA_APP_JAR=@project.build.finalName@.@project.packaging@
ENV JAVA_APP_VERSION=@project.version@

# 设置工作目录
WORKDIR $JAVA_APP_DIR

# 添加镜像文件
ADD $JAVA_APP_JAR $JAVA_APP_JAR

# 端口
EXPOSE 8080
