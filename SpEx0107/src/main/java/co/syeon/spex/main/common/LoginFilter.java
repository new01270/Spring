package co.syeon.spex.main.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		
		System.out.println("서블릿 실행 전");
		
		// 다음 filter 호출
		chain.doFilter(request, response);
		
		System.out.println("서블릿 실행 후");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
