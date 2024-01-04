//package com.leadgen.app.configs;
//
//import java.io.IOException;
//
//import org.jboss.logging.MDC;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CORSFilter implements Filter {
//
//	/**
//	 * Default constructor.
//	 */
//	public CORSFilter() {
//		// default constructor
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		MDC.clear();
//		// Authorize (allow) all domains to consume the content
//		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
//		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
//				"GET, OPTIONS, HEAD, PUT, POST");
//		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers",
//				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
//		((HttpServletResponse) servletResponse).addHeader("Content-Type", "application/json");
//
//		HttpServletResponse resp = (HttpServletResponse) servletResponse;
//		// For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS
//		// handshake
//		if (request.getMethod().equals("OPTIONS")) {
//			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
//			return;
//		}
//
//		// pass the request along the filter chain
//		chain.doFilter(request, servletResponse);
//	}
//	
//	@Override
//	public void destroy() {
//		MDC.clear();
//	}
//}