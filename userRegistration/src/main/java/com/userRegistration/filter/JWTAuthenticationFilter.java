package com.userRegistration.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userRegistration.service.UserProfileServiceImpl;
import com.userRegistration.util.JWTUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebFilter(urlPatterns = "/*")
@Component
public class JWTAuthenticationFilter implements Filter{

	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String requestTokenHeader = request.getHeader("Authorization");
		String loginId = null;
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);

			try {
				loginId = jwtUtil.getloginIdFromToken(jwtToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		filterChain.doFilter(request, response);
	}
}
