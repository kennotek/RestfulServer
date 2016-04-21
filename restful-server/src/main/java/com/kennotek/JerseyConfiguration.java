package com.kennotek;

import static java.util.logging.Logger.getLogger;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

public class JerseyConfiguration extends ResourceConfig {
	private final Logger log = getLogger(getClass().getName());
	
	private class Binder extends AbstractBinder{

	    @Override
	    public void configure() {
	        bind(TestClass.class).to(IGetDate.class);
	    }
	}

	@Inject
	public JerseyConfiguration(ServiceLocator serviceLocator, ServletContext servletContext) {
		log.info("Creating JerseyConfiguration");
		packages("com.kennotek.resources");
		//moxy
//        register(createMoxyJsonResolver());
        //freemarker
		register(FreemarkerMvcFeature.class);
		//
		register(new Binder());

//		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
//		GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
//		guiceBridge.bridgeGuiceInjector((Injector) servletContext.getAttribute(Injector.class.getName()));
	}
//    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
//        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
//        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
//        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
//        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
//        return moxyJsonConfig.resolver();
//    }

}