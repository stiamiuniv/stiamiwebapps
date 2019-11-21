package com.stiamiwebapps.stiami.config;

public class CloudinaryConfig {
	private String cloud_name;
	private String api_key;
	private String api_secret;
	private String environment_variable;
	public String getCloud_name() {
		return cloud_name;
	}
	public void setCloud_name(String cloud_name) {
		this.cloud_name = cloud_name;
	}
	public String getApi_key() {
		return api_key;
	}
	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
	public String getApi_secret() {
		return api_secret;
	}
	public void setApi_secret(String api_secret) {
		this.api_secret = api_secret;
	}
	public String getEnvironment_variable() {
		return environment_variable;
	}
	public void setEnvironment_variable(String environment_variable) {
		this.environment_variable = environment_variable;
	}
}
