package com.stiamiwebapps.stiami.controller;


import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.stiamiwebapps.stiami.constants.Constant;
import com.stiamiwebapps.stiami.responsemodel.ResponseModel;



@RestController
public class BaseController {
	protected Gson gson = new Gson();
	
	public HttpHeaders getResponseHeader() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return responseHeaders;
	}

	public HttpHeaders getResponseHeader(String keyHeader, String value) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		responseHeaders.add(keyHeader, value);
		return responseHeaders;
	}

	public String ObjectToJSON(Object src) {
		return gson.toJson(src);
	}

	public JsonObject toJSONObjectWithSerializer(Type typeOfSrc, Object serializer, Object src) {
		gson = new GsonBuilder()
				.registerTypeAdapter(typeOfSrc, serializer)
				.create();
		return (JsonObject) gson.toJsonTree(src);
	}
	
	public JsonArray toJSONArrayWithSerializer(Type typeOfSrc, Object serializer, Object src) {
		gson = new GsonBuilder()
				.registerTypeAdapter(typeOfSrc, serializer)
				.create();
		return (JsonArray) gson.toJsonTree(src);
	}

	public JsonObject getResponse(boolean status) {
		ResponseModel model = new ResponseModel();
		if(status) {
			model.setCode(Constant.SUCCESS_RESPONSE_CODE);
			model.setStatus(Constant.SUCCESS);
		}else {
			model.setCode(Constant.INTERNAL_SERVER_ERROR_RESPONSE_CODE);
			model.setStatus(Constant.ERROR);
		}
		return (JsonObject)new GsonBuilder().create().toJsonTree(model);
	}
	
	public JsonObject getSuccessResponse() {
		return getResponse(true);
	}
	
	public JsonObject getFailedResponse() {
		return getResponse(true);
	}
	
	public int getStartPage(int pages) {
		int startPage = 0;
		if(pages == 0) {
			startPage = pages * Constant.PAGE_SIZE;
		}else {
			startPage = pages * Constant.PAGE_SIZE + 1;
		}
		return startPage;
	}
	
	public int getEndPage(int startPage) {
		return startPage + Constant.PAGE_SIZE;
	}
	
	public void setDefaultCookies(String uid, HttpServletResponse response) {
		Cookie cookie = new Cookie("uid", uid);
		cookie.setMaxAge(3 * 24 * 60 * 60); // expires in 7 days
	    response.addCookie(cookie);
	}
	
	public JsonObject toJSONObject(Object src) {
		return (JsonObject)new GsonBuilder().create().toJsonTree(src);
	}

	public JsonArray toJSONArray(Object src) {
		return (JsonArray)new GsonBuilder().create().toJsonTree(src);
	}
	
	public String getExpiredDate() {
		long oneDay = 24 * 60 * 60 * 1000;
		Date date = new Date();
		long expDateMils = date.getTime() + oneDay;
		Date expDate = new Date(expDateMils);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter.format(expDate);
	}

}
