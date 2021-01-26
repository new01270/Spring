package co.syeon.spex.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.syeon.spex.emp.service.DeptService;
import co.syeon.spex.emp.vo.DeptVo2;

@Service("deptService")
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptMapper deptDAO;

	@Override
	public List<Map<String, Object>> selectAll(DeptVo2 beans) {
		System.out.println("service selectAll");
		//int a = 5/0;
		return deptDAO.selectAll(beans);
	}

	@Override
	public DeptVo2 selectOne(DeptVo2 beans) {
		return deptDAO.selectOne(beans);
	}

	@Override
	public int insert(DeptVo2 beans) {
		return deptDAO.insert(beans);
	}

	@Override
	public int update(DeptVo2 beans) {
		return deptDAO.update(beans);
	}

	@Override
	public int delete(DeptVo2 beans) {
		return deptDAO.delete(beans);
	}

	@Override
	public List<Map<String, Object>> deptEmpCnt() {
		return  deptDAO.deptEmpCnt();
	}

}
