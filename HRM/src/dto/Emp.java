package dto;

import java.util.Date;

/**
 * @brief 사원정보를 담을 dto
 * @author 이현우
 * @version v1.01 2020.02.21
 * @see 
 */
public class Emp {
	
	private int empNo;
	private String pw;
	private String name;
	private String gender;
	private String email;
	private String address;
	private String dept;
	private String rank;
	private String school;
	private String major;
	private Date hireDate;
	private Date retireDate;
	private String hobby;
	private String specialty;
	private String state;
	private Date birth;
	private String phoneNo;
	private String question;
	private String answer;
	private String payRank;
	private String bankName;
	private String account;
	private String bankHolder;
	private String remarks;
	private String leader;
	
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", email=" + email
				+ ", address=" + address + ", dept=" + dept + ", rank=" + rank + ", school=" + school + ", major="
				+ major + ", hireDate=" + hireDate + ", retireDate=" + retireDate + ", hobby=" + hobby + ", specialty="
				+ specialty + ", state=" + state + ", birth=" + birth + ", phoneNo=" + phoneNo + ", question="
				+ question + ", answer=" + answer + ", payRank=" + payRank + ", bankName=" + bankName + ", account="
				+ account + ", bankHolder=" + bankHolder + ", remarks=" + remarks + "]";
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPayRank() {
		return payRank;
	}
	public void setPayRank(String payRank) {
		this.payRank = payRank;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date date) {
		this.birth = date;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBankHolder() {
		return bankHolder;
	}
	public void setBankHolder(String bankHolder) {
		this.bankHolder = bankHolder;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
}
