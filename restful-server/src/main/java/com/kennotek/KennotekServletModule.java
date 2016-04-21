package com.kennotek;

import com.google.inject.servlet.ServletModule;

public class KennotekServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(IGetDate.class).to(TestClass.class);
	    serve("/knk/hi").with(HelloWorldServlet.class);
	}
}
