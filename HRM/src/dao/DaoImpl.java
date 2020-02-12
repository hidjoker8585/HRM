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
 * @brief dao ���� Ŭ����
 * @author ������
 * @version 1.00 (2020.02.11)
 * @see �����Դϴ�.
 *
 */
public class DaoImpl implements Dao{

	// DB ���� ��ü
	private Connection conn = DBconn.getConnection();
	
	// JDBC ��ü
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Emp> getEmpAll() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM EMP";
		
		//���  list
		List<Emp> list = new ArrayList<>();
		
		try {
			// PreparedStatement ����
			ps = conn.prepareStatement(sql);
			
			// ResultSet ��ȯ
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
