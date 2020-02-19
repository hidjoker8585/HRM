package dto;
/**
 * @brief 사원정보를 담을 dto
 * @author 이현우
 * @version v1.00 2020.02.18
 * @see 
 */
public class Emp {
	
	private int empNo;
	private String name;
	private String dept;
	private String position;
	
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", name=" + name + ", dept=" + dept + ", position=" + position + "]";
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
