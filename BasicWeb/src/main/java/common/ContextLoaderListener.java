package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
	// new -> Listener -> 맨 위 servlet context 항목에서 life cycle 1개만 선택해줌
	
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("톰캣 시작");
		// DataSource 를 사용하는 code 작성
		// Server 에서 제공하는 DataSource 사용, java 에서 new 를 사용하면 server 가 직접 관리하는게 아니게 됨

		// new BasicData
		// 톰캣 서버의 context.xml 에 JNDI 방식으로 이름을 작성한 뒤
		// 톰캣 서버가 제공하는 DataSource 를 사용하는 방식으로 작성해야함
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/nextit"); // java:/comp/evn 는 고정된
																								// 값이라 변경하면 안됨
			// 여기까지가 DataSource 라는 객체 생성 과정
			// 이는 모든 DAO 가 공통으로 사용하는 객체가 된다.

			ServletContext servletContext = sce.getServletContext();
			servletContext.setAttribute("dataSource", dataSource);
			// dataSource 를 꺼내올 수 있음
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("톰캣 종료");
	}

}
