package com.stiamiwebapps.stiami.serializer;

import com.google.gson.*;
import com.stiamiwebapps.stiami.model.Users;

import java.lang.reflect.Type;

public class UsersSerializer implements JsonSerializer<Users> {

	@Override
	public JsonElement serialize(Users src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObj = (JsonObject) new GsonBuilder().create().toJsonTree(src);
		String uid = src.getStringId();
		if (jsonObj.has("_id")) {
			jsonObj.remove("_id");
		}
		if (jsonObj.has("password")) {
			jsonObj.remove("password");
		}
		jsonObj.addProperty("id", uid);
		if (jsonObj.has("isValidated")) {
			jsonObj.remove("isValidated");
		}
		jsonObj.addProperty("validated", src.isValidated());
		return jsonObj;
	}
}
