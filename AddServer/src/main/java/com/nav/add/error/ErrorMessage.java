package com.nav.add.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {
	private String message;
	private String error;

	public ErrorMessage(String message, String error) {
		this.message = message;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public String getError() {
		return error;
	}

	public static void main(String[] s) {

		Map<Integer, String> m8 = new HashMap<Integer, String>();
		m8.put(1, "A");
		m8.put(2, "B");

		m8.values().stream()
		.filter(v->v.startsWith("A"))
		.forEach(System.out::println);

	}
}
