package com.stiamiwebapps.stiami.constants;

public class Constant {
	public static String ADMIN_ACCOUNT_USERNAME = "maribelajarbersama";
	public static String ADMIN_ACCOUNT_PASSWORD = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";
	public static String PRODUCTION_ENV = "prod";
	public static String DEV_ENV = "dev";
	
	public static int PAGE_SIZE = 25;

	public static String SUCCESS_RESPONSE_CODE ="200";
	public static String UNAUTHORIZED_RESPONSE_CODE = "401";
	public static String NOT_FOUND_RESPONSE_CODE = "404";
	public static String INTERNAL_SERVER_ERROR_RESPONSE_CODE = "500";
	
	public static String RESPONSE = "response";
	public static String ERROR_MESSAGE = "error_message";

	public static String SUCCESS = "success";
	public static String ERROR = "error"; 

	//Success Message
	public static String UPDATE_USER_PROFILE_SUCCESS_MESSAGE = "Success Update Profile";
	public static String SUCCESS_VALIDATED_USER_PROFILE_SUCCESS_MESSAGE = "Success validate Profile";
	public static String DELETE_USER_SUCCESS_MESSAGE = "Success Delete User";
	public static String UPDATE_ARTICLE_SUCCESS_MESSAGE = "Success Update Article";
	public static String UPDATE_CATEGORY_SUCCESS_MESSAGE = "Success Update Category";
	public static String UPDATE_ROLES_SUCCESS_MESSAGE = "Success Update Roles";
	public static String DELETE_ARTICLE_SUCCESS_MESSAGE = "Success Delete Article";
	public static String DELETE_BOOKMARK_SUCCESS_MESSAGE = "Success Delete Bookmark";
	public static String DELETE_CATEGORY_SUCCESS_MESSAGE = "Success Delete Category";
	public static String DELETE_ROLES_SUCCESS_MESSAGE = "Success Delete Roles";
	public static String SUCCESS_FOLLOW_AUHTORS_MESSAGE = "Success Follow Authors";
	public static String DELETE_UNFOLLOW_AUHTORS_MESSAGE = "Success UnFollow Authors";
	
	//Error Message
	public static String USER_NOT_VALIDATED_SUCCESS_MESSAGE = "User not validated please check your mail";
	public static String USER_ALREDY_EXISTS_ERROR_MESSAGE = "User Already Exists";
	public static String USER_NOT_FOUND_ERROR_MESSAGE = "User Not Found";
	public static String USER_FOUND_BUT_INACTIVE_ERROR_MESSAGE = "User Found But the account is inactive";
	public static String BOOKMARKS_ALREADY_EXISTS_ERROR_MESSAGE = "You bookmarked this article";
	
	public static String CLOUDINARY_CONFIG_PATH = "json/cloudinary_config.json";
	
	public static String MAIL_CONFIG_PATH = "json/mailconfig.json";
	public static String MAIL_TEMPLATE_PATH = "template/verification_mail_template.txt";
	public static String VERIFICATION_SIGN_UP_MAIL_SUBJECT = "verify your email";
	public static String BASE_URL_DEV = "http://localhost:8088/";
	public static String BASE_URL_PROD = "https://badebelajar.com/";

}
