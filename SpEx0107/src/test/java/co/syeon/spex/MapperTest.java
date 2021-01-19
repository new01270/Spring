package co.syeon.spex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.syeon.spex.member.service.impl.MemberMapper;
import co.syeon.spex.member.vo.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:datasource-context.xml")
public class MapperTest {
	@Autowired MemberMapper dao;
	
	@Test
	public void mapperTest() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentName("개발");
		dao.deptIns(vo);
		assertEquals(vo.getOutMsg(), "SUCCESS");
	}

}
