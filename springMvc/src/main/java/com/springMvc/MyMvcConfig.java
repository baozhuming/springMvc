package com.springMvc;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.springMvc.interceptor.DemoInterceptor;
import com.springMvc.messageconverter.MyMessageConverter;

@Configuration
@EnableWebMvc//若无此句，重写WebMvcConfiguraAdapter方法无效
@EnableScheduling
@ComponentScan("com.springMvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter{//重写其方法可对SpringMVC进行配置

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	//注册自定义的拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {//注册拦截器
		registry.addInterceptor(demoInterceptor());
	}
	//设置文件访问路径
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		//addResourceHandler指的是文件放置的目录，addResourceLocations指的是对外暴露的访问路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	//获取的index的页面请求，并且转向的index页面
	@Override
	public void addViewControllers(ViewControllerRegistry viewcontrollerregistry) {
		super.addViewControllers(viewcontrollerregistry);
		viewcontrollerregistry.addViewController("/index").setViewName("/index");
		
		//把提交到toUpload的请求转向upload
		viewcontrollerregistry.addViewController("/toUpload").setViewName("/upload");
		viewcontrollerregistry.addViewController("/converter").setViewName("/convert");
		viewcontrollerregistry.addViewController("/sse").setViewName("/sse");
		viewcontrollerregistry.addViewController("async").setViewName("/async");
	}
	
	//取消在url中出现”.“背过滤符号及后面的数据
	@Override
	public void configurePathMatch(PathMatchConfigurer pathmatchconfigurer) {
		// TODO Auto-generated method stub
		super.configurePathMatch(pathmatchconfigurer);
		pathmatchconfigurer.setUseSuffixPatternMatch(false);
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(1000000);
		return commonsMultipartResolver;
	}
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		converters.add(converter());
	}
	@Bean
	public MyMessageConverter converter(){
		return new MyMessageConverter();
	}
}
