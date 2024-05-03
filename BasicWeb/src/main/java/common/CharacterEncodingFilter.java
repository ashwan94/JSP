package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

@WebFilter(urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharacterEncodingFilter extends HttpFilter implements Filter {
	
	private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}
	
	// Filter 가 작동하는 구간
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		// 실행해야할 내용 기술하는 부분
		// 모든 request 에 대해 UTF-8 Encoding 실행
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		
		// chain 없이 하나로 끝나더라도 이게 없으면 절대 Servlet 으로 data 를 보낼 수 없다
		// 항상 맨 마지막에 위치시켜야함
		chain.doFilter(request, response);
	}

}
