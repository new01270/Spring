package co.syeon.spex.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.syeon.spex.emp.vo.DeptVo2;


@Repository
public interface DeptMapper {

	public abstract int insert(DeptVo2 bean);

	public abstract int update(DeptVo2 bean);

	public abstract int delete(DeptVo2 bean);

	public abstract DeptVo2 selectOne(DeptVo2 bean);

	public abstract List<Map<String, Object>> selectAll(DeptVo2 bean);
	
	public abstract List<Map<String, Object>> deptEmpCnt();
	

}