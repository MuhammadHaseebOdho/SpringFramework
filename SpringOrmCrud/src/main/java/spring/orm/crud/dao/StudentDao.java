package spring.orm.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import spring.orm.crud.entities.Student;

public class StudentDao {

	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer addStudent(Student student) {

		Integer success = (Integer) hibernateTemplate.save(student);

		return success;
	}
	
	public List<Student> getStudents() {
		return hibernateTemplate.loadAll(Student.class);
	}
	public Student getStudent(int id) {
		return hibernateTemplate.get(Student.class, id);
		
	}
	@Transactional
	public void deleteStudent(int id) {
		Student student = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(student);
		
	}
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
