package br.com.kosmete.kosmeteapp;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(response instanceof HttpServletResponse){
			HttpServletResponse alteredResponse = ((HttpServletResponse)response);
			alteredResponse.addHeader("Access-Control-Allow-Origin", "*");
			alteredResponse.addHeader("Access-Control-Allow-Headers", "*");
			alteredResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
			alteredResponse.addHeader("Access-Control-Max-Age", "1728000");
		}
		chain.doFilter(request, response);
	}

}
