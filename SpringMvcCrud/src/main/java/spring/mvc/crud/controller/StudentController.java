package spring.mvc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.crud.dao.StudentDao;
import spring.mvc.crud.entities.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Student> students = studentDao.getStudents();
		model.addAttribute("studentsList",students);
		return "home";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		studentDao.addStudent(student);
		return "redirect:/home";
	}
	
	@RequestMapping("/addStudent")
	public String addForm() {
		return "addform";
	}
	
	@RequestMapping(value = "/deletestudent/{id}",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id) {
		studentDao.deleteStudent(id);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/editstudent",method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("student") Student student) {
		
		studentDao.updateStudent(student);
		return "redirect:/home";
	}
	
	@RequestMapping("/editstudentform/{id}")
	public String editStudentForm(@PathVariable("id") int id,Model model) {
		Student student = studentDao.getStudent(id);
		model.addAttribute("student", student);
		return "editstudent";
	}
	
}
