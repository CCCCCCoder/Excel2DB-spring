package com.Manley.Excel2DBspring.controller;

import cn.hutool.poi.excel.ExcelReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Manley
 */
@Slf4j
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

	@RequestMapping(value = "/upload")
	public ResponseEntity<?> acceptExcel(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExcelReader reader = new ExcelReader(inputStream, 0);
		List<Map<String, Object>> maps = reader.readAll();

		log.info(originalFilename);

		return ResponseEntity.ok().build();
	}

}
