package com.wu.config;


import javax.xml.bind.annotation.XmlSchema;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SolarGalaxyConfig {

	private static final String NAMESPACE = "http://www.wu.com/solargalaxyservice/galaxy";//my xsd file content package name
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> 
	                     createServletRegistration(ApplicationContext context){
		
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/ws/*");//internally servlet used this path
		
	}
	
	@Bean("solarGalaxy")//for wsdl name creation
	public DefaultWsdl11Definition createDefaultWsdl11Definition(XsdSchema schema) {
		
		DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
		wsdl.setPortTypeName("WesternUnion-SolarGalaxy");//for service name creation
		wsdl.setTargetNamespace(NAMESPACE);
		wsdl.setLocationUri("/ws");//context path name for mu application api heating
		wsdl.setSchema(schema);
		
		return wsdl;
		
	}
	
	@Bean
	public XsdSchema createXsdSchema() {
		
		return new  SimpleXsdSchema(new ClassPathResource("/xsd/galaxy.xsd"));
		
	}
	
}
