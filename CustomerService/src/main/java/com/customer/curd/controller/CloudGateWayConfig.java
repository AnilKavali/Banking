package com.customer.curd.controller;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudGateWayConfig {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/customer/**").uri("lb://customer-service"))
				.route(p->p.path("/manager/**").uri("lb://manager-service"))
				.route(p->p.path("/get")
						.filters(f->f
								.addRequestHeader("MyHeader", "NewUri")
						        .addRequestParameter("Param", "NewParam"))
						.uri("http://httpbin.org:80"))
				.build();
	}

}
