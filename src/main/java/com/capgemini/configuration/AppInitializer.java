package com.capgemini.configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class AppInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// Inicializar el contenedor web Spring (WebApplicationContext) con la configuración Java usando clases anotadas
//		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//        appContext.setConfigLocation("com.capgemini.configuration.WebConfig");
//
//        
//        // Registrar el Servlet y establecer su orden de inicio a 1 y agregar el patrón de URL a mapear, para nosotros /.
//        ServletRegistration.Dynamic registration
//                = servletContext.addServlet("spring", new DispatcherServlet(appContext));
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//        
//	}
//
//}


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
}