package com.springMvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.DemoObj;

@Controller
public class ConverterController {
	@RequestMapping(value = "/convert",produces={"application/x-wisely"})//1
	public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj){
		return demoObj;
	}

}
