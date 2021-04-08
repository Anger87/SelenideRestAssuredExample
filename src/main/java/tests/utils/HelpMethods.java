package tests.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import tests.responseClasses.User;

public class HelpMethods {
	public static String generateRandomString(String prefix, String postfix) {
		return prefix + System.currentTimeMillis() + postfix;
	}
	
	public static String ConvertJavaObjectToJsonString(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
}
