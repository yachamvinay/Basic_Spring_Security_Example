package com.greatlearning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/index")
	public String index()
	{
		return "this is index page";
	}
	@GetMapping("/secureAPI")
	public String secureAPI()
	{
		return "this is api";
	}

}
