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
 * @brief JDBC�� ���� Ŭ���� �����Դϴ�
 * @author ������
 * @version ver 1.01 (2020.02.11)
 * @see ������ ������Ƽ ���� �̿�, �̱��� ���, ��üȣ���� getConnetion() �Դϴ�
 * 
 */

public class DBconn {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn = null; //���� ��ü

	private static String url;
	private static String userName;
	private static String password;
	
	private static Properties props = new Properties();

	private DBconn() {} //DBConn ��ü ���� ����
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				//String path = System.getProperty("user.home")+"//"+"Desktop";
				props.loadFromXML(new FileInputStream(new File("./src/resource","props.xml")));
				url = "jdbc:oracle:thin:@"+props.getProperty("serverIp")+":1521:XE";
				userName = props.getProperty("userName");
				password = props.getProperty("userPw");
				System.out.println(url);
				System.out.println(userName);
				System.out.println(password);
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
