package com.inspur.icity.microsrv.app;

import com.inspur.icity.microsrv.app.logic.utils.BizConfig;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 爱城市网应用服务启动类
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = {"com.inspur.icity.microsrv.app.logic.repo","com.inspur.icity.*.repo"})
public class IcityAppServiceApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    private final static Logger logger = LoggerFactory.getLogger(IcityAppServiceApplication.class);
    private final static int PORT = BizConfig.getIntValue("server.port",8080);
    private final static int MAX_CONNECTIONS = BizConfig.getIntValue("server.max.connections",2000);
    private final static int MAX_THREADS = BizConfig.getIntValue("server.max.threads",2000);
    private final static int CONNECTION_TIMEOUT = BizConfig.getIntValue("server.connection.timeout",3000);
    private static int start_param_port = 0;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(IcityAppServiceApplication.class);
    }

    @Bean(name = "logicTM")
    public PlatformTransactionManager logicTM(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        TomcatEmbeddedServletContainerFactory tomcatFactory = (TomcatEmbeddedServletContainerFactory)container;

        if(start_param_port != 0 ){
            tomcatFactory.setPort(start_param_port);
        } else {
            tomcatFactory.setPort(PORT);
        }

        tomcatFactory.addConnectorCustomizers(new IcityAppServiceCenterTomcatConnectorCustomizer());
    }

    class IcityAppServiceCenterTomcatConnectorCustomizer implements TomcatConnectorCustomizer
    {
        @Override
        public void customize(Connector connector)
        {
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            //设置最大连接数
            protocol.setMaxConnections(MAX_CONNECTIONS);
            //设置最大线程数
            protocol.setMaxThreads(MAX_THREADS);
            protocol.setConnectionTimeout(CONNECTION_TIMEOUT);
        }
    }

    public static void main(String[] args) {
        logger.info("IcityAppServiceApplication init start.");

        if (args.length > 0) {
            try {
                start_param_port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                logger.error("参数异常",e);
            }
        }

        SpringApplication springApplication = new SpringApplication(IcityAppServiceApplication.class);
        logger.info("IcityAppServiceApplication init end.");

        logger.info("IcityAppServiceApplication run start.");
        springApplication.run(args);

    }
}
