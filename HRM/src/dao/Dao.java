package dao;

import java.util.List;

import dto.Emp;

/**
 * @brief dao 인터페이스
 * @author 이현우
 * @version 1.00(2020-02-11)
 * @see 사원정보 가져오기 샘플
 */
public interface Dao {

	public List<Emp> getEmpAll();
	
}
