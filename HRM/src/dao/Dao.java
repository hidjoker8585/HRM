package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import dto.Dept;
import dto.Emp;
import dto.Option;

/**
 * @brief dao �������̽�
 * @author ������
 * @version 1.02(2020-02-25)
 * @see 
 */
public interface Dao {

	
	//�α��� ����� üũ
	public boolean chkLogin(Emp emp);
	
	//����� ����� ��ȸ
	public Emp getEmpForUser(Emp emp);
	
	//������ ����� ��ȸ
	public Emp getEmpForAdmin(Emp emp);
	
	//�������Ʈ ��ȸ
	public ArrayList<Emp> getEmpList();
	
	//��� ���
	public int addEmp(Emp emp);
	
	//�ֱ� ��� �����ȣ
	public int getEmpNoRecently();
	
	//��� ����
	public int editEmp(Emp emp);
	
	//���� �׸�ޱ�
	public Option getChoiceOption();
	
	//�μ��� ����Ʈ ��ȸ
	public TreeMap<Dept, ArrayList<Emp>> getAllByDept();
	
	//�μ� �߰�
	public int addDept(Dept dept);
	
	//�μ� ����
	public int editDept(Dept dept);
	
	//�μ� ���� ���� Ȯ��
	public boolean chkDeptToDelete(Dept dept);
	
	//�μ� ����
	public int deleteDept(Dept dept);
	

}
