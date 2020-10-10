package com.inspur.icity.microsrv.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class IcityWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

   @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       //普通用户请求拦截器
//       registry.addInterceptor(new AccessControlInterceptor())
//               .addPathPatterns(
//                       "/app.v.2.0/*",
//                       "/app/*",
//                       "/appCity/*",
//                       "/city/*",
//                       "/appUsr/*",
//                       "/mobileAppVersion/*"
//
//       );
//
//       //管理员请求拦截器
//       registry.addInterceptor(new ManagerUserAccessInterceptor())
//               .addPathPatterns(
//                       "/appIconMange/*",
//                       "/appManage/*",
//                       "/appCityManage/*",
//                       "/appTypeManage/*",
//                       "/mobileAppVersionManage/*"
//               );
   }
}
