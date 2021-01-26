package co.syeon.spex.emp.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.syeon.spex.emp.service.DeptService;
import co.syeon.spex.emp.service.impl.EmpMapper;
import co.syeon.spex.emp.vo.DeptVO;
import co.syeon.spex.emp.vo.DeptVo2;
import co.syeon.spex.emp.vo.EmpVO;
import co.syeon.spex.emp.vo.JobVO;

@Controller
public class EmpController {

	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptService deptService;

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

		// http://localhost/spex/updEmpForm?employee_id=100
		return "emp/empForm";
	}

	// 등록과 수정 같이 처리
	@RequestMapping("insUpdEmp")
	public String insUpdEmp(EmpVO vo, HttpServletRequest request,
			@RequestParam(required = false) MultipartFile[] uploadfiles) throws IllegalStateException, IOException {
		// (required = false) 파일업로드가 필수요소가 아님.

		// resurces의 URL경로.
		String path = request.getSession().getServletContext().getRealPath("/resources/images");

		// empMapper.insert(vo);

		for (MultipartFile uploadfile : uploadfiles) {

			// 첨부파일 처리
			if (uploadfile != null && uploadfile.getSize() > 0) {

				// File file = new File("d:/upload", uploadfile.getOriginalFilename());
				File file = new File(path, uploadfile.getOriginalFilename());

				// Rename

				uploadfile.transferTo(file);
				vo.setProfile(uploadfile.getOriginalFilename());

				// file.insert()
			}
		}
		System.out.println("파일명::" + vo);

		return "emp/empForm";
	}

	// 파일다운로드
	@RequestMapping("/download/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) {

		String dataDirectory = "d:/upload";
		// String dataDirectory =
		// request.getSession().getServletContext().getRealPath("/resources/image/");
		Path file = Paths.get(dataDirectory, fileName);
		if (Files.exists(file)) {
			response.setContentType("application/pdf;charset=UTF-8");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// 엑셀출력
	@RequestMapping("/deptExcelView.do")
	public ModelAndView excelView(DeptVo2 vo, HttpServletResponse response) throws IOException {
		// http://localhost/spex/deptExcelView.do 들어가면 다운 바로.
		
		List<Map<String, Object>> list = deptService.selectAll(vo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		String[] header = { "departmentId", "departmentName", "managerId" };	// alias 와 같은 컬럼명
		map.put("headers", header);
		map.put("filename", "excel_dept");
		map.put("datas", list);
		
		return new ModelAndView("commonExcelView", map);	// map으로만 처리.
	}

}
