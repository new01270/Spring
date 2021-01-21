package co.syeon.spex.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import co.syeon.spex.emp.service.impl.EmpMapper;
import co.syeon.spex.emp.vo.DeptVO;
import co.syeon.spex.emp.vo.EmpVO;
import co.syeon.spex.emp.vo.JobVO;

@Controller
public class EmpController {

	@Autowired
	EmpMapper empMapper;

	@ModelAttribute("deptList") // 먼저 실행 <form:select items="${ deptList}"../>
	public List<DeptVO> deptList() {

		return empMapper.getDept();
	}

	@ModelAttribute("jobList") // <form:radiobuttons items="${ jobList}" ../>
	public List<JobVO> jobList() {

		return empMapper.getJob();
	}

	// 등록 페이지로 이동
	@RequestMapping("insEmpForm")
	public String insEmpForm(EmpVO vo) {

		return "emp/empForm";
	}

	// 수정 페이지로 이동
	@RequestMapping("updEmpForm")
	public String updEmpForm(EmpVO vo, Model model) {

		model.addAttribute("empVO", empMapper.getEmp(vo));

		return "emp/empForm";
	}

	// 등록과 수정 같이 처리
	@RequestMapping("insUpdEmp")
	public String insUpdEmp() {

		return "emp/empForm";
	}

}
