package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	//INSERT
	public int insert(Student student) {
		int res  = (Integer) this.hibernateTemplate.save(student);
		return res;
	}
	
	//READ(SIngle Student)
	public Student getStudent(int studentId) {
		
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	//READ(All Students)
	public List<Student> getAllStudents(){
		
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	@Transactional
	//DELETE
	public void delete(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional
	//UPDATE
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
