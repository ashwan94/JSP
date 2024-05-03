package common;

import java.io.IOException;
import java.io.InputStream;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("톰캣 실행");
        
//        try {
//			Context context = new InitialContext();
//			DataSource dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/nextit");
//			
//			ServletContext servletContext = sce.getServletContext();
//			servletContext.setAttribute("dataSource", dataSource);
//			
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        // Server 부팅 시 Mybatis 를 사용하도록 변경
        try {
        	String resource = "mybatis-config.xml";
        	InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			ServletContext servletContext = sce.getServletContext();
			servletContext.setAttribute("sqlSession", sqlSession);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("톰캣 종료");
    }

	
}
