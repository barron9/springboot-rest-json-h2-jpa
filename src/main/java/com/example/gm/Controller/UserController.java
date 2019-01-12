package com.example.gm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.gm.model.User;
import com.example.gm.repo.Repo;

@RestController
public class UserController {

	@Autowired
	Repo repo;

	@RequestMapping("/")
	public String home() {

		return "home.jsp";
	}

	@RequestMapping("/add")
	public String add(User user) {
		repo.save(user);
		return "home.jsp";
	}

	@GetMapping(value = "/no", produces = { "application/json" })
	public Iterable<User> API_URL_PROD() {
		System.out.println(repo.findAll().toString());
		return repo.findAll();
	}
	
	@RequestMapping("/web")
	public ModelAndView getweb(@RequestParam int uid) {
		ModelAndView mv = new ModelAndView("home.jsp");
		mv.addObject("uid",uid);
		
		return mv;
		
	}
}
