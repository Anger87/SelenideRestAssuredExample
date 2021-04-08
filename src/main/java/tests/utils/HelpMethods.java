package tests.utils;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class HelpMethods {
	public static String generateRandomString(String prefix, String postfix) {
		return prefix + System.currentTimeMillis() + postfix;
	}
	
	public static String ConvertJavaObjectToJsonString(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	
	
}
