package com.library.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthenticationService {

	// create lazy init singleton
	private static AuthenticationService INSTANCE;

	private static String COOKIE_NAME = "email";

	public static AuthenticationService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AuthenticationService();
		}
		return INSTANCE;
	}

	public boolean isAuthenticated(String email, String password) {

		 if (email.equals("admin") && password.equals("admin")) {
			return true;
		}
		return false;
	}

	public void addSession(HttpServletRequest request, String email) {
		HttpSession session = request.getSession();

		session.setAttribute(COOKIE_NAME, email);

//		session.setMaxInactiveInterval(30 * 60);
//		Cookie emailCookie = new Cookie(COOKIE_NAME, email);
//		emailCookie.setMaxAge(30 * 60);
	}

	public void removeSession(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(COOKIE_NAME);
		}
	}

}
