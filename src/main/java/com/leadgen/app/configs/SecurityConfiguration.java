//package com.leadgen.app.configs;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import in.paynearby.wallet.payment.auth.ApiFilter;
//
//@EnableWebSecurity
//@Order(value=2)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Value("${payment.service.api.header.key}")
//	private String paymentApiKeyHeader;
//
//	@Value("${payment.service.api.header.value}")
//	private String paymentApiKeyValue;
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		
//		.addFilterBefore(apiFilter(), UsernamePasswordAuthenticationFilter.class)
//		.authorizeRequests()
//		.antMatchers("/v2/api-docs").permitAll()
//		.antMatchers("/swagger-ui.html").permitAll()
//		.antMatchers("/swagger-resources/**").permitAll()
//		.antMatchers("/webjars/**").permitAll()
//		.antMatchers("/test").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
//
//	private ApiFilter apiFilter() {
//		return new ApiFilter(paymentApiKeyHeader,paymentApiKeyValue);
//	}
//}
