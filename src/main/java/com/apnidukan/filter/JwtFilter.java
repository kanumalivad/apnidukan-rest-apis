package com.apnidukan.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.apnidukan.util.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtFilter implements Filter {
	
	private static final List<String> BYPASSED_URLS;

	static {
		List<String> urls = new ArrayList<>();
		urls.add("/user/login");
		urls.add("/otp/generateOTP");
		urls.add("/otp/validateOTP");
		urls.add("/user/setPassword");
		urls.add("/user/loggeduser");
		urls.add("/user/data");
		urls.add("/cart/add");
		urls.add("/cart/findCartSizeByUserId/1");
		urls.add("/description/findDescriptioinByProductId/2");
		BYPASSED_URLS = Collections.unmodifiableList(urls);
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request=(HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "false");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, X-Requested-With, accept, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
        response.setHeader("Access-Control-Expose-Headers",
                "Origin, Access-Control-Request-Method, Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        response.setHeader("Access-Control-Max-Age", "4000");
        
     
        if (isBypassedURL(request)) {
			chain.doFilter(req, res);
		} else {
			if(!request.getMethod().equalsIgnoreCase("OPTIONS"))
			{
				final String authHeader = request.getHeader("authorization");
				System.out.println(authHeader);
				if (Objects.isNull(authHeader) || !authHeader.startsWith("Bearer ")) {
					System.out.println("Missing or invalid Authorization header...");
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
							"Missing or invalid Authorization header.");
				} else {
					final String token = authHeader.substring(7);
					try {
						System.out.println("checking chalu");
						Jwts.parser().setSigningKey(Constants.JWT_TOKEN_SECRET).parseClaimsJws(token).getBody();
						chain.doFilter(req, res);
					} catch (final SignatureException e) {
						System.out.println("Invalid token...");
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
						
					}
				}
			}
			else
			{
				response.setStatus(HttpServletResponse.SC_OK);
			}
		}
    }

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}

	public boolean isBypassedURL(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return BYPASSED_URLS.contains(uri);
	}
	

}
