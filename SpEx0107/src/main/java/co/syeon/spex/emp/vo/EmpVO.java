package co.syeon.spex.emp.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// HR.employees

@Data
public class EmpVO {

	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	private String profile;	// DB에 저장되는 객체
	// private MultipartFile uploadFile; // 첨부파일 트랜스퍼 전, 임시로 담아주는 객체->컨트롤러에서 원하는 위치로 업로드(불필요)
}
