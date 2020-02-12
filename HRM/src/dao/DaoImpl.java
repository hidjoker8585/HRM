package dao;
//test
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;
import util.DBconn;

/**
 * @brief dao 구현 클래스
 * @author 이현우
 * @version 1.00 (2020.02.11)
 * @see 샘플입니다.
 *
 */
public class DaoImpl implements Dao{

	// DB 연결 객체
	private Connection conn = DBconn.getConnection();
	
	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Emp> getEmpAll() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM EMP";
		
		//결과  list
		List<Emp> list = new ArrayList<>();
		
		try {
			// PreparedStatement 생성
			ps = conn.prepareStatement(sql);
			
			// ResultSet 반환
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
}
