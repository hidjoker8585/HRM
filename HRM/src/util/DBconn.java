package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * @brief JDBC을 위한 클래스 파일입니다
 * @author 이현우
 * @version ver 1.00 (2020.02.11)
 * @see 정보는 프로퍼티 값을 이용, 싱글톤 사용, 객체호출은 getConnetion() 입니다
 * 
 */

public class DBconn {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn = null; //연결 객체

	private static String url;
	private static String userName;
	private static String password;
	
	private static Properties props = new Properties();

	private DBconn() {} //DBConn 객체 생성 방지
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				props.loadFromXML(new FileInputStream(new File("./src/util","props.xml")));
				url = "jdbc:oracle:thin:@"+props.getProperty("serverIp")+":1521:XE";
				userName = props.getProperty("userName");
				password = props.getProperty("uesrPw");
				conn = DriverManager.getConnection(url,userName,password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPropertiesFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return conn;
	}
	
}
