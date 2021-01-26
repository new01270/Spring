package co.syeon.spex.emp.service;

import java.util.List;
import java.util.Map;

import co.syeon.spex.emp.vo.DeptVo2;

public interface DeptService {

	//전체조회
	public List<Map<String,Object>> selectAll(DeptVo2 beans);
	
	//단건조회
	public DeptVo2 selectOne(DeptVo2 beans);
	
	//추가
	public int insert(DeptVo2 beans);
	
	//수정
	public int update(DeptVo2 beans);
	
	//삭제
	public int delete(DeptVo2 beans);
	
	//부서별인원수 조회
	public List<Map<String, Object>> deptEmpCnt();
	
}
