package dto;
/**
 * @brief 사원평가 정보를 담을 dto
 * @author 이현우
 * @version v1.00 2020.02.21
 * @see 
 */
public class Evaluation {

	private int targetNo;
	private int manageNo;
	private int attitude;
	private int communication;
	private int ability;
	private String memo;
	
	
	
	@Override
	public String toString() {
		return "Evaluation [targetNo=" + targetNo + ", manageNo=" + manageNo + ", attitude=" + attitude
				+ ", communication=" + communication + ", ability=" + ability + ", memo=" + memo + "]";
	}
	public int getTargetNo() {
		return targetNo;
	}
	public void setTargetNo(int targetNo) {
		this.targetNo = targetNo;
	}
	public int getManageNo() {
		return manageNo;
	}
	public void setManageNo(int manageNo) {
		this.manageNo = manageNo;
	}
	public int getAttitude() {
		return attitude;
	}
	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}
	public int getCommunication() {
		return communication;
	}
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
