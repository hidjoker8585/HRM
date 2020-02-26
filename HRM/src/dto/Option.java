package dto;
/**
 * @brief 선택항목을 담은 dto
 * @author 이현우
 * @version v1.00 2020.02.22
 * @see 
 */

import java.util.Vector;

public class Option {

	private Vector<String> deptList;
	private Vector<String> stateList;
	private Vector<String> questionList;
	private Vector<String> payrankList;
	private Vector<String> rankList;
	
	public Vector<String> getDeptList() {
		return deptList;
	}
	public void setDeptList(Vector<String> deptList) {
		this.deptList = deptList;
	}
	public Vector<String> getStateList() {
		return stateList;
	}
	public void setStateList(Vector<String> stateList) {
		this.stateList = stateList;
	}
	public Vector<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(Vector<String> questionList) {
		this.questionList = questionList;
	}
	public Vector<String> getPayrankList() {
		return payrankList;
	}
	public void setPayrankList(Vector<String> payrankList) {
		this.payrankList = payrankList;
	}
	public Vector<String> getRankList() {
		return rankList;
	}
	public void setRankList(Vector<String> rankList) {
		this.rankList = rankList;
	}

	
}