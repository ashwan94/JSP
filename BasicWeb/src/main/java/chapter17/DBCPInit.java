package chapter17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@WebServlet(loadOnStartup = 1
			, initParams = {
					@WebInitParam(name = "jdbcdriver", value = "oracle.jdbc.OracleDriver"),
					@WebInitParam(name = "url" , value = "jdbc:oracle:thin:@nextit.or.kr:1521:xe"),
					@WebInitParam(name = "userName", value = "std121"),
					@WebInitParam(name = "password", value = "oracle21c"),
					@WebInitParam(name = "poolName", value = "chapter17")
})
public class DBCPInit extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("JDBC 드라이버 로딩중...");
		loadJDBCDrivet();
		System.out.println("Connection Pool 생성 중...");
		initConnectionPool();
		System.out.println("Connection Pool 생성 완료!");
	}
	
	/*
	 * JDBC Driver loading method 
	 * */
	private void loadJDBCDrivet() {
		String driverClass = getInitParameter("jdbcdriver");
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("fail to load JDBC Driver", e);
		}
	}
	
	/*
	 * Connection pool 을 이용해서 DataBase 연결
	 * */
	private void initConnectionPool() {
		String ConnectionUrl = getInitParameter("url");
		String userName = getInitParameter("userName");
		String password = getInitParameter("parssword");
		try {
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(ConnectionUrl, userName, password);
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1 from dual");
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRuns(Duration.ofMillis(1000L * 60L * 5L));
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxIdle(50);
			
			GenericObjectPool connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			String poolName = getInitParameter("poolName");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool(poolName, (ObjectPool<? extends Connection>) connectionPool);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
