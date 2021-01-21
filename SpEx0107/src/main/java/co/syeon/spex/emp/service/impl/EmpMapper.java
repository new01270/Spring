package co.syeon.spex.emp.service.impl;

import java.util.List;

import co.syeon.spex.emp.vo.DeptVO;
import co.syeon.spex.emp.vo.EmpVO;
import co.syeon.spex.emp.vo.JobVO;

public interface EmpMapper {
	
	public EmpVO getEmp(EmpVO vo);
	public List<DeptVO> getDept();
	public List<JobVO> getJob();

}
