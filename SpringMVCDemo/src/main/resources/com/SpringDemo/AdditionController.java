package com.SpringDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class AdditionController {

	@RequestMapping("/add")
	public void add() {
		System.out.println("I am here");
	}
}
