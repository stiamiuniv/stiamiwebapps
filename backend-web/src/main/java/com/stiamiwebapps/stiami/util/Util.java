package com.stiamiwebapps.stiami.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

public class Util {
	
	
	public String getJsonFile(String path) {
		File file = null;
		String content = "";
		try {
			file = ResourceUtils.getFile("classpath:"+path);
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public String getStringJsonFile(String path) {
		String content = "";
		ClassPathResource cpr = new ClassPathResource(path);
		try {
		    byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
		    content = new String(bdata, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
