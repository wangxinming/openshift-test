FROM harbor.yun.fosun.com/library/openjdk-jmx-exporter:1.0.0

RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo "Asia/Shanghai" > /etc/timezone

ADD openshift-test-0.0.1-SNAPSHOT.jar /opt/openshift.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx800M","-jar","/opt/openshift.jar"]
