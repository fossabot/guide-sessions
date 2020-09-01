// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.cart;

 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
 
@SpringBootApplication(scanBasePackages = { "com.tcb.webatm.base.app", "com.tcb.webatm.base.app.restapi",
		"com.tcb.webatm.base.app.redis", "com.tcb.webatm.base.app.session", "com.tcb.webatm.eatm",
		"com.tcb.webatm.eatm.*" ,"com.tcb.webatm.base.data" })
public class CartApplication  extends SpringBootServletInitializer {
	public static void main(String[] args)
	{
		System.out.println("=============================================================");
		System.out.println("=============================================================");
		ApplicationContext applicationContext = SpringApplication.run(CartApplication.class, args);

		for (String string : applicationContext.getBeanDefinitionNames())
		{
			System.out.println(string);
		}

		System.out.println("=============================================================");
		System.out.println("=============================================================");
	}
	@Bean
	CartResource restTemplate()
	{
		return new CartResource();
	}
	@Bean
	SwaggerConfig getSwaggerConfig() {
		return new SwaggerConfig();
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(CartApplication.class);
	}

}
