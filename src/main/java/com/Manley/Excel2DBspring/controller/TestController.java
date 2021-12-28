package com.Manley.Excel2DBspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	@RequestMapping(value = "/test")
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "success");

		return map;
	}
}
