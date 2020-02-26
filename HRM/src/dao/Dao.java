package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import dto.Dept;
import dto.Emp;
import dto.Option;

/**
 * @brief dao 인터페이스
 * @author 이현우
 * @version 1.02(2020-02-25)
 * @see 
 */
public interface Dao {

	
	//로그인 사용자 체크
	public boolean chkLogin(Emp emp);
	
	//사용자 사원상세 조회
	public Emp getEmpForUser(Emp emp);
	
	//관리자 사원상세 조회
	public Emp getEmpForAdmin(Emp emp);
	
	//사원리스트 조회
	public ArrayList<Emp> getEmpList();
	
	//사원 등록
	public int addEmp(Emp emp);
	
	//최근 등록 사원번호
	public int getEmpNoRecently();
	
	//사원 수정
	public int editEmp(Emp emp);
	
	//선택 항목받기
	public Option getChoiceOption();
	
	//부서별 리스트 조회
	public TreeMap<Dept, ArrayList<Emp>> getAllByDept();
	
	//부서 추가
	public int addDept(Dept dept);
	
	//부서 수정
	public int editDept(Dept dept);
	
	//부서 삭제 가능 확인
	public boolean chkDeptToDelete(Dept dept);
	
	//부서 삭제
	public int deleteDept(Dept dept);
	

}
