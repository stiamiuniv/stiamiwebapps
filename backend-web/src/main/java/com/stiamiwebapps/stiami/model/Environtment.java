package com.stiamiwebapps.stiami.model;

import com.stiamiwebapps.stiami.constants.Constant;

public class Environtment {
	private String environtment;
	
	public Environtment() {
		environtment = Constant.PRODUCTION_ENV;
	}

	public String getEnvirontment() {
		return environtment;
	}
}
