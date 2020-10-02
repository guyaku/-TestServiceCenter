package com.inspur.icity.microsrv.app;

import com.inspur.icity.microsrv.base.utils.BizConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @Package com.inspur.icity.microsrv
 * @Class CommonConfig
 * @Description:
 *
 * @Author sunchj
 * @CreateDate 2018/3/6 15:34
 *
 */
@Configuration
public class CommonConfig {
    private Logger logger = LoggerFactory.getLogger(CommonConfig.class);


    private final static long FILE_MAX_SIZE = BizConfig.getLongValue("upload.file.max.size",1024L * 1024L);

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(FILE_MAX_SIZE);
        return factory.createMultipartConfig();
    }
}
