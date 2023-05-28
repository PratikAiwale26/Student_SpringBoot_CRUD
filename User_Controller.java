package org.jsp.spring_boot_user_app.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.spring_boot_user_app.dao.User_Dao;
import org.jsp.spring_boot_user_app.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_Controller 
{
	@Autowired
	private User_Dao dao;
	
	@GetMapping("getStudent")
    public List<User> getAllStudents() 
	{
        return dao.findAll();
    }
	
	
	@GetMapping("/getStudent/{id}")
	 public User getStudentById(@PathVariable int id)
	 {
	        return dao.findById(id);
	 }
	
	 
	@PostMapping("/user/save")
	public void saveStudent(@RequestBody User user)
	{
		dao.saveStudent(user);
	}
	
	
	@PostMapping("/userMultiple/student")
	public void saveAll(@RequestBody List<User> user) 
	{
		dao.saveAll(user);
	}
	
	@PutMapping("/updateStudent/{id}")
	public User updateStudent(@PathVariable int id ,@RequestBody User user )
	{
		return dao.updateStudent(id, user);
	}
	
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) 
	{
	    dao.deleteById(id);
	}


}
