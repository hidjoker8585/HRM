package dto;
/**
 * @brief 일정정보를 담을 dto
 * @author 이현우
 * @version v1.00 2020.02.21
 * @see 
 */

import java.util.Date;

public class Schedule {

	private int empNo;
	private String content;
	private Date alarmDate;

	@Override
	public String toString() {
		return "Schedule [empNo=" + empNo + ", content=" + content + ", alarmDate=" + alarmDate + "]";
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
	
	
}
