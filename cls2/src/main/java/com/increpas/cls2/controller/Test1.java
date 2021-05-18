package com.increpas.cls2.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class Test1 {
	
	@RequestMapping("/main.cls")
	public String getMain() {
		return "main";
	}
}
