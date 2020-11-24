package com.myway.tok.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myway.tok.dao.StudentDAO;
import com.myway.tok.model.Student;

@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentDAO StudentDAO;
	
	//방법1. return 값을 String형으로 만들어주고, Model을 따로 장착 시키는 방법
	// -return은 view의 이름을 명시해주고, view에서 사용될 model는 따로 주입을 하는 방법
	@RequestMapping(value ="/student01.do", method = RequestMethod.GET)
	public String student01(Model model) {
		model.addAttribute("student", new Student());
		return "student/student";
	}
	
	
	//방법2. ModelAndView를 활용하는 방식
	// - 방법1의 단계를 1개로 합친 것
	@RequestMapping(value="/student02.do", method = RequestMethod.GET)
	public ModelAndView student02() {
		//학생 조회
		StudentDAO.select();
		return new ModelAndView("student/student", "student", new Student());
		}
	
	//student.jsp의 요청에서 입력 값을 받아서 result.jsp로 전달하는 맵핑
	@RequestMapping(value = "/add/student.do", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student);
		
		//학생 객체를 DB에 입력
		StudentDAO.create(student);
		//StudentDAO.sampleTransaction(student);
		return "redirect:/student_list.do";
	}
	
	//student 조회 요청
	@RequestMapping(value = "/student_list.do", method = RequestMethod.GET)
	public String getStudent(Model model,
			@RequestParam(value = "seq", required = false, defaultValue = "0") Integer seq) {
		if(seq == 0) {
			// 학생 리스트 조회
			List<Student> students = StudentDAO.select();
			model.addAttribute("students", students);
			return "student/list";
		}else {
			// 학생 단건 조회
			model.addAttribute("student", StudentDAO.select(seq));
			return "student/result";
		}
	
	}
	
	//student 삭제 요청
	@RequestMapping(value = "/student_delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "seq", required = true) Integer seq) {
		StudentDAO.delect(seq);
		return "redirect:/student_list.do";
	}
	
	//student 수정 페이지 이동 요청
	@RequestMapping(value = "/move_update.do", method = RequestMethod.GET)
	public String moveUpdate(Model model, @RequestParam(value = "seq", required = true) Integer seq) {
		model.addAttribute("student", StudentDAO.select(seq));
		return "student/student";
	}
	
	// student 수정 요청
	@RequestMapping(value = "/update/student.do", method = RequestMethod.POST)
	public String update(@ModelAttribute Student student) {
		StudentDAO.update(student);
		return "redirect:/student_list.do?seq="+student.getSeq();
	}
	
}
