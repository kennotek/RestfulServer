package com.kennotek;

import static java.util.logging.Logger.getLogger;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.glassfish.hk2.api.ServiceLocator;
//import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

public class JerseyConfiguration extends ResourceConfig {
	private final Logger log = getLogger(getClass().getName());
	
//	private class Binder extends AbstractBinder{
//
//	    @Override
//	    public void configure() {
//	        bind(TestClass.class).to(IGetDate.class);
//	    }
//	}

	@Inject
	public JerseyConfiguration(ServiceLocator serviceLocator, ServletContext servletContext) {
		log.info("Creating JerseyConfiguration");
		packages("com.kennotek.resources");
        //freemarker
		register(FreemarkerMvcFeature.class);
		//
//		register(new Binder());

	}

}