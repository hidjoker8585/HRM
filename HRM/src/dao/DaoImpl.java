package dao;
//test
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import dto.Dept;
import dto.Emp;
import dto.Option;
import util.DBconn;

/**
 * @brief dao 구현 클래스
 * @author 이현우
 * @version 1.03 (2020.02.25)
 * @see
 *
 */
public class DaoImpl implements Dao{

	// DB 연결 객체
	private Connection conn = DBconn.getConnection();
	
	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	// 사용자 로그인
	@Override
	public boolean chkLogin(Emp emp) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM EMP WHERE EMPNO = ? AND PW = ? ";
		boolean res = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getPw());
			
			rs = ps.executeQuery();
			rs.next();
			if(rs.getInt(1)>0) {
				res = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		
		return res;
	}
	//사원리스트 조회
	@Override
	public ArrayList<Emp> getEmpList() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT C.EMPNO, C.ENAME, C.DNAME, C.HIREDATE, R.RANKNAME, get_leader(C.DNAME) AS LEADER "
				    +"FROM (SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO) C, EMP_RANK R "
				    +"WHERE C.RANKNO = R.RANKNO "
				    +"ORDER BY C.ENAME";
		
		//결과  list
		ArrayList<Emp> list = new ArrayList<>();
		
		try {
			// PreparedStatement 생성
			ps = conn.prepareStatement(sql);
			
			// ResultSet 반환
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpNo(rs.getInt("EMPNO"));
				emp.setName(rs.getString("ENAME"));
				emp.setDept(rs.getString("DNAME"));
				emp.setHireDate(rs.getDate("HIREDATE"));
				emp.setRank(rs.getString("RANKNAME"));
				emp.setLeader(rs.getString("LEADER"));
				
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

	
	// 부서별 조회
	@Override
	public TreeMap<Dept, ArrayList<Emp>> getAllByDept() {
		// TODO Auto-generated method stub
		
		String sql1 = "SELECT * FROM DEPT ORDER BY DEPTNO";
		String sql2 = "SELECT A.EMPNO, A.ENAME, R.RANKNAME "
				+ " FROM (SELECT DISTINCT * FROM EMP WHERE DEPTNO = ?"
				+ " OR EMPNO=(SELECT LEADERNO FROM DEPT WHERE DEPTNO = ?))A, EMP_RANK R"
				+ " WHERE A.RANKNO = R.RANKNO ORDER BY R.RANKNO, A.EMPNO";
		
		TreeMap<Dept, ArrayList<Emp>> sourceMap = new TreeMap<>();
		ResultSet rs2 = null;
		
		try {
			ps = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptNo(rs.getInt("DEPTNO"));
				dept.setName(rs.getString("DNAME"));
				dept.setLeaderNo(rs.getInt("LEADERNO"));
				dept.setIntro(rs.getString("INTRO"));
				
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, dept.getDeptNo());
				ps.setInt(2, dept.getDeptNo());
				rs2 = ps.executeQuery();
				ArrayList<Emp> list = new ArrayList<>();

				while(rs2.next()) {
					Emp emp = new Emp();
					emp.setEmpNo(rs2.getInt("EMPNO"));
					emp.setName(rs2.getString("ENAME"));
					emp.setRank(rs2.getString("RANKNAME"));
					list.add(emp);
				}
				sourceMap.put(dept, list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs2!=null) rs2.close();
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return sourceMap;
	}

	//사용자용 사원 조회
	@Override
	public Emp getEmpForUser(Emp e) {
		// TODO Auto-generated method stub
		String sql = "SELECT A.*, S.STATENAME "
				+"FROM(SELECT B.*, R.RANKNAME FROM"
				+ "(SELECT E.*, D.DNAME FROM EMP E, dept D "
				+ "where E.deptno = D.deptno AND E.EMPNO = ? "
				+ "AND E.STATENO=1) B, EMP_RANK R "
				+ "WHERE B.RANKNO = R.RANKNO) A, EMP_STATE S "
				+" WHERE A.STATENO = S.STATENO";
		Emp emp = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getEmpNo());
			rs = ps.executeQuery();

			while(rs.next()) {
				emp = new Emp();
				emp.setEmpNo(rs.getInt("EMPNO"));
				emp.setPw(rs.getString("PW"));
				emp.setName(rs.getString("ENAME"));
				emp.setGender(rs.getString("GENDER"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress(rs.getString("ADDRESS"));
				emp.setDept(rs.getString("DNAME"));
				emp.setRank(rs.getString("RANKNAME"));
				emp.setSchool(rs.getString("SCHOOL"));
				emp.setMajor(rs.getString("MAJOR"));
				emp.setHireDate(rs.getDate("HIREDATE"));
				emp.setRetireDate(rs.getDate("RETIREDATE"));
				emp.setHobby(rs.getString("HOBBY"));
				emp.setSpecialty(rs.getString("SPECIALTY"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} try {
				if(ps!=null)ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		return emp;
	}

	//관리자용 사원 조회
	@Override
	public Emp getEmpForAdmin(Emp e) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT Z.*,O.* " + 
				"FROM (SELECT Y.*, P.PAYNAME " + 
				"FROM(SELECT T.*, Q.QUESTION " + 
				"FROM EMP_SECRET T, EMP_SECRET_QUESTION Q " + 
				"WHERE T.QNO = Q.QNO) Y, EMP_SECRET_PAYRANK P " + 
				"WHERE Y.PAYNO = P.PAYNO) Z, (SELECT U.*, M.STATENAME " + 
				"FROM(SELECT H.*, R.RANKNAME " + 
				"FROM (SELECT E.*, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND EMPNO = ?) H, EMP_RANK R " + 
				"WHERE H.RANKNO = R.RANKNO) U, EMP_STATE M " + 
				"WHERE U.STATENO = M.STATENO) O " + 
				"WHERE Z.SECRETNO = O.SECRETNO";
		Emp emp = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getEmpNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Emp();
				emp.setEmpNo(rs.getInt("EMPNO"));
				emp.setPw(rs.getString("PW"));
				emp.setName(rs.getString("ENAME"));
				emp.setGender(rs.getString("GENDER"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress(rs.getString("ADDRESS"));
				emp.setDept(rs.getString("DNAME"));
				emp.setSchool(rs.getString("SCHOOL"));
				emp.setMajor(rs.getString("MAJOR"));
				emp.setHireDate(rs.getDate("HIREDATE"));
				emp.setRetireDate(rs.getDate("RETIREDATE"));
				emp.setHobby(rs.getString("HOBBY"));
				emp.setSpecialty(rs.getString("SPECIALTY"));
				emp.setState(rs.getString("STATENAME"));
				emp.setBirth(rs.getDate("BIRTH"));
				emp.setPhoneNo(rs.getString("PHONENO"));
				emp.setQuestion(rs.getString("QUESTION"));
				emp.setAnswer(rs.getString("ASW"));
				emp.setBankName(rs.getString("BANKNAME"));
				emp.setAccount(rs.getString("ACCOUNTNO"));
				emp.setBankHolder(rs.getString("HOLDER"));
				emp.setPayRank(rs.getString("PAYNAME"));
				emp.setRank(rs.getString("RANKNAME"));
				emp.setRemarks(rs.getString("REMARKS"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}


		
		return emp;
	}

	//부서추가
	@Override
	public int addDept(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO DEPT(DNAME,LEADERNO,INTRO) VALUES(?,?,?)";
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getName());
			ps.setInt(2, dept.getLeaderNo());
			ps.setString(3, dept.getIntro());
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return res;
	}

	//부서수정
	@Override
	public int editDept(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "UPDATE DEPT SET DNAME = ?, LEADERNO = ?, INTRO = ?"
				+ " WHERE DEPTNO = ? ";
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getName());
			ps.setInt(2, dept.getLeaderNo());
			ps.setString(3, dept.getIntro());
			ps.setInt(4, dept.getDeptNo());
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return res;
	}

	//부서삭제
	@Override
	public int deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM DEPT WHERE DNAME = ? ";
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getName());
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	//사원 등록
	@Override
	public int addEmp(Emp emp) {
		// TODO Auto-generated method stub
		String sql1 = "INSERT INTO EMP_SECRET(BIRTH,PHONENO,QNO,ASW,PAYNO,BANKNAME,ACCOUNTNO,HOLDER,REMARKS) "
				+ "VALUES(?,?,(SELECT QNO FROM EMP_SECRET_QUESTION WHERE QUESTION = ?),?,"
				+ "(SELECT PAYNO FROM EMP_SECRET_PAYRANK WHERE PAYNAME = ?),?,?,?,?)"; 
		String sql2 ="INSERT INTO EMP(PW,ENAME,GENDER,EMAIL,ADDRESS,DEPTNO,RANKNO,SCHOOL,MAJOR,HIREDATE,"
			    + "RETIREDATE,HOBBY,SPECIALTY,STATENO) "
		        + "VALUES(?,?,?,?,?,(SELECT DEPTNO FROM DEPT WHERE DNAME = ?),"
		        + "(SELECT RANKNO FROM EMP_RANK WHERE RANKNAME = ?),?,?,?,?,?,?,"
		        + "(SELECT STATENO FROM EMP_STATE WHERE STATENAME = ?))";
		int res = 0;
		try {
			ps = conn.prepareStatement(sql1);
			ps.setDate(1, new Date(emp.getBirth().getTime()));
			ps.setString(2, emp.getPhoneNo());
			ps.setString(3, emp.getQuestion());
			ps.setString(4, emp.getAnswer());
			ps.setString(5, emp.getPayRank());
			ps.setString(6, emp.getBankName());
			ps.setString(7, emp.getAccount());
			ps.setString(8, emp.getBankHolder());
			ps.setString(9, emp.getRemarks());
			res = ps.executeUpdate();
			
			ps = conn.prepareStatement(sql2);
			ps.setString(1, emp.getPw());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getGender());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getDept());
			ps.setString(7, emp.getRank());
			ps.setString(8, emp.getSchool());
			ps.setString(9, emp.getMajor());
			ps.setDate(10, new Date(emp.getHireDate().getTime()));
			if(emp.getRetireDate()!=null) {
				ps.setDate(11, new Date(emp.getRetireDate().getTime()));
			}else {
				ps.setDate(11, null);
			}
			ps.setString(12, emp.getHobby());
			ps.setString(13, emp.getSpecialty());
			ps.setString(14, emp.getState());
			res = res * ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	//사원 수정
	@Override
	public int editEmp(Emp emp) {
		// TODO Auto-generated method stub
		
		String sql1 = "UPDATE EMP_SECRET SET BIRTH = ?, PHONENO = ? , QNO = (SELECT QNO FROM EMP_SECRET_QUESTION WHERE QUESTION = ? ) "
				+ ", ASW = ?, PAYNO = (SELECT PAYNO FROM EMP_SECRET_PAYRANK WHERE PAYNAME = ?), BANKNAME = ?, "
				+ "ACCOUNTNO = ?, HOLDER = ?, REMARKS = ? WHERE SECRETNO = (SELECT SECRETNO FROM EMP WHERE EMPNO = ? )";
		String sql2 = "UPDATE EMP SET ENAME = ?, GENDER = ?, EMAIL = ?, ADDRESS = ?, DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = ?), "
				    + "RANKNO = (SELECT RANKNO FROM EMP_RANK WHERE RANKNAME = ? ), SCHOOL = ?, MAJOR = ?, HIREDATE = ?, "
				    + "RETIREDATE = ?, HOBBY = ?, SPECIALTY = ?, STATENO = (SELECT STATENO FROM EMP_STATE WHERE STATENAME = ? ) "
				    + "WHERE EMPNO = ?";
		int res = 0;
		
		try {
	
			ps = conn.prepareStatement(sql1);
			ps.setDate(1, new Date(emp.getBirth().getTime()));
			ps.setString(2, emp.getPhoneNo());
			ps.setString(3, emp.getQuestion());
			ps.setString(4, emp.getAnswer());
			ps.setString(5, emp.getPayRank());
			ps.setString(6, emp.getBankName());
			ps.setString(7, emp.getAccount());
			ps.setString(8, emp.getBankHolder());
			ps.setString(9, emp.getRemarks());
			ps.setInt(10, emp.getEmpNo());
			res = ps.executeUpdate();
			
			ps = conn.prepareStatement(sql2);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getGender());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getAddress());
			ps.setString(5, emp.getDept());
			ps.setString(6, emp.getRank());
			ps.setString(7, emp.getSchool());
			ps.setString(8, emp.getMajor());
			ps.setDate(9, new Date(emp.getHireDate().getTime()));
			if(emp.getRetireDate()!=null) {
				ps.setDate(10, new Date(emp.getRetireDate().getTime()));
			}else {
				ps.setDate(10, null);
			}
			ps.setString(11, emp.getHobby());
			ps.setString(12, emp.getSpecialty());
			ps.setString(13, emp.getState());
			ps.setInt(14, emp.getEmpNo());
			
			res = res * ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return res;
	}

	//부서내 사원 존재여부 확인
	@Override
	public boolean chkDeptToDelete(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM EMP WHERE DEPTNO = "
				+ "(SELECT DEPTNO FROM DEPT WHERE DNAME = ? )";
		
		boolean res = false;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getName());
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			if(rs.getInt(1)==0) {
				res = true;
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
		return res;
	}

	//선택항목받기
	@Override
	public Option getChoiceOption() {
		// TODO Auto-generated method stub
		String sql1 = "SELECT DNAME FROM DEPT ORDER BY DEPTNO";
		String sql2 = "SELECT QUESTION FROM EMP_SECRET_QUESTION ORDER BY QNO"; 
		String sql3 = "SELECT PAYNAME FROM EMP_SECRET_PAYRANK ORDER BY PAYNO";
		String sql4 = "SELECT STATENAME FROM EMP_STATE ORDER BY STATENO";
		String sql5 = "SELECT RANKNAME FROM EMP_RANK ORDER BY RANKNO";
	
		Option option = new Option();
		
		Vector<String> deptList = new Vector<>();
		deptList.add("부서선택");
		Vector<String> qList = new Vector<>();
		qList.add("질문을 선택하세요");
		Vector<String> payList = new Vector<>();
		payList.add("호봉");
		Vector<String> stateList = new Vector<>();
		stateList.add("상태");
		Vector<String> rankList = new Vector<>();
		rankList.add("직급");

		
		try {
			ps = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			while(rs.next()) {
				deptList.add(rs.getString(1));
			}
			option.setDeptList(deptList);
			
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				qList.add(rs.getString(1));
			}
			option.setQuestionList(qList);
			
			ps = conn.prepareStatement(sql3);
			rs = ps.executeQuery();
			while(rs.next()) {
				payList.add(rs.getString(1));
			}
			option.setPayrankList(payList);
			
			ps = conn.prepareStatement(sql4);
			rs = ps.executeQuery();
			while(rs.next()) {
				stateList.add(rs.getString(1));
			}
			option.setStateList(stateList);
			
			ps = conn.prepareStatement(sql5);
			rs = ps.executeQuery();
			while(rs.next()) {
				rankList.add(rs.getString(1));
			}
			option.setRankList(rankList);
			
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
		
		return option;
	}

	//최근 사용한 사원번호
	@Override
	public int getEmpNoRecently() {
		// TODO Auto-generated method stub
		String sql = "SELECT EMP_SEQ.CURRVAL FROM DUAL";
		int empNo = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			empNo = rs.getInt(1);
			
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
		
		return empNo;
	}



	
}
