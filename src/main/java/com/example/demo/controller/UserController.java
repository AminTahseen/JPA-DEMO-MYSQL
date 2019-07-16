package com.example.demo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;


@Controller
public class UserController {

	private static final Logger LOGGER = Logger.getLogger("UserController");
	
	@Autowired
	UserRepository rep;
	
	@RequestMapping("/")
	public ModelAndView getmain() 
	{
		LOGGER.log(Level.INFO, "Preparing modelview object");
		ModelAndView m=new ModelAndView();
		m.setViewName("list.jsp");
		m.addObject("list",rep.getAllUsers());
		LOGGER.log(Level.INFO, "Modelview is prepared , returning it for the view ");
		return m;
	}
	
	@RequestMapping("/list")
	public ModelAndView getlist() 
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("list.jsp");
		m.addObject("list",rep.getAllUsers());
		return m;
	}
	
	@RequestMapping("/addPage")
	public String AddPage() 
	{
		return "create.jsp";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
    public ModelAndView AddUser(
    		@RequestParam("name") String uname,
            @RequestParam("job")  String ujob
            ) 
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("list.jsp");
		UserModel us=new UserModel(rep.getCount()*2,uname,ujob);
		if(rep.addUser(us) >=1 ) 
		{
			m.addObject("list",rep.getAllUsers());
			return m;
		}
		else 
		{
			m.addObject("msg","OOPS Something's Wrong !");
			return m;
		}
	}
	
	@RequestMapping("/delete")
	public ModelAndView DeleteUser(@RequestParam("name") String uname)
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("list.jsp");
		if(rep.deleteUser(uname) >=1 ) 
		{
			m.addObject("list",rep.getAllUsers());
			return m;
		}
		else 
		{
			m.addObject("msg","Such Data Does Not Exists !");
			m.addObject("list",rep.getAllUsers());
			return m;
		}
	}
	@RequestMapping("/UpdatePage")
	public ModelAndView UpdatePage(@RequestParam("name") String uname) 
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("update.jsp");
		UserModel us=rep.getUser(uname);
		m.addObject("uname", us.getUser_name());
		m.addObject("ujob", us.getUser_job());
		return m;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
    public ModelAndView UpdateUser(
    		@RequestParam("name") String uname,
            @RequestParam("job")  String ujob
            ) 
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("list.jsp");
		UserModel us=new UserModel(rep.getCount()*2,uname,ujob);
		if(rep.UpdateUser(us) >=1 ) 
		{
			m.addObject("list",rep.getAllUsers());
			return m;
			
		}
		else 
		{
			m.addObject("list",rep.getAllUsers());
			return m;
		}
	}
	
	@RequestMapping("/search")
	public ModelAndView SearchUser(@RequestParam("name") String uname)
	{
		ModelAndView m=new ModelAndView();
		m.setViewName("list.jsp");
		UserModel us=rep.getUser(uname);
		return m;
	}
	
}
