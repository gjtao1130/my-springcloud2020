# my-springcloud2020

版本：
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
        <spring-cloud.version>Hoxton.SR3</spring-cloud.version>
    </properties>

<!--使用eureka和nacos冲突，只能存在一个，故只能放置各自的过程pom中-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

不建新项目想使用集群的话，可以在Edit Configurations中的VM Options 中复制一个已有的工程，
改名以区别原来的，再在VM Options中添加 -Dserver.port=8902 以改变端口号，然后运到
