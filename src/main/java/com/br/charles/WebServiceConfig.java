package com.br.charles;

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

@EnableWs
@Configuration
public class WebServiceConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}

	@Bean(name = "movement")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema moveSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("MovePort");
		definition.setTargetNamespace("http://www.example.org/game");
		definition.setLocationUri("/ws/movement");
		definition.setSchema(moveSchema());
		return definition;
	}

	@Bean
	public XsdSchema moveSchema() {
		return new SimpleXsdSchema(new ClassPathResource("move.xsd"));
	}

	@Bean(name = "game")
	public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema gameSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("GamePort");
		definition.setTargetNamespace("http://www.example.org/game");
		definition.setLocationUri("/ws/game");
		definition.setSchema(gameSchema());
		return definition;
	}

	@Bean
	public XsdSchema gameSchema() {
		return new SimpleXsdSchema(new ClassPathResource("game.xsd"));
	}

}