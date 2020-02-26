package dto;
/**
 * @brief �μ������� ���� dto
 * @author ������
 * @version v1.01 2020.02.21
 * @see ������ ���� compareTo ����
 */
public class Dept implements Comparable<Dept>{

	private int deptNo;
	private String name;
	private String intro;
	private int leaderNo;

	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getLeaderNo() {
		return leaderNo;
	}
	public void setLeaderNo(int leaderNo) {
		this.leaderNo = leaderNo;
	}
	
	@Override
	public int compareTo(Dept o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}

}
