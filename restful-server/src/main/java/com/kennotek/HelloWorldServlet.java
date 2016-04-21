package com.kennotek;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
@Singleton
public class HelloWorldServlet extends HttpServlet {


	@Inject
	IGetDate theClass;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, handrolled, guiced AppEngine!");
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		resp.getWriter().println("Date is: " + sdf.format(theClass.getDate()));
	}
}
