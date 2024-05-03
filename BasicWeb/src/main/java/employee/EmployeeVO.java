package employee;

import java.time.LocalDate;

public class EmployeeVO {
	private int employeeId;
	private String empName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;

	public EmployeeVO() {}
	public EmployeeVO(int employeeId, String empName, String email, String phoneNumber, LocalDate hireDate) {
//		super(); 모든 class 는 Object 를 기본적으로 상속받고 있으며, super를 포함하고 있다. 하지만 생략 가능하므로 표기를 안하는것뿐
		this.employeeId = employeeId;
		this.empName = empName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
	}
	// 생성자가 setter 를 대신할 수 있기 때문에 현실에서는 setter 를 만들지 않음
	// 하지만 배우는 시간이니까 여기서는 Setter 를 만들어줌
	@Override
	public String toString() {
		return "EmployeeVO [employeeId=" + employeeId + ", empName=" + empName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", hireDate=" + hireDate + "]";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
}
