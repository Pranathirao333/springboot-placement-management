package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

//service class - crud operation
@Service
public class AdminService {
	
	@Autowired
	AdminRepository erepo;
	
	//post data(inserting data into table)
	public Admin addAdmin(Admin admin)
	{
		return erepo.save(admin);
	}
	
	//display(retrieving data)
	public List<Admin> getAdmin()
	{
		return erepo.findAll();
	}
	
	//delete(deleting data)
	public void deleteAdmin(Long id)
	{
		erepo.deleteById(id);
	}
	
	//update(updating data)
	public Admin updateAdmin(Admin admin)
	{
		Long id = admin.getId();
		Admin admin1 = erepo.findById(id).get();
		admin1.setName(admin.getName());
		admin1.setPassword(admin.getPassword());
		return erepo.save(admin1);
	}
	
	public List<Admin> searchAdmin(String name)
	{
	    return erepo.findByName(name);
	}

}
