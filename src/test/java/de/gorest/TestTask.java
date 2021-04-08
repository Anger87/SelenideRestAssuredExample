package de.gorest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TestTask {
	
	public static ArrayList readFileToArrayList(String filePath) {
		String line;
		ArrayList<Float> lines = new ArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
				if (!line.matches("^#") && line.matches("[+-]?\\d+.\\d+")) {
					lines.add(Float.parseFloat(line));
				}
				
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return lines;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Float> list = readFileToArrayList(System.getProperty("user.dir") + "/src/test/resources/number.txt");
		Float Sum = 0f;
		for (Float el : list) {
			Sum = Float.sum(Sum, el);
		}
		System.out.println("the sum of all numbers in the file named numbers.txt is:" + Sum);
	}
}


