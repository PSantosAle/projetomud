package br.com.sandro.mudi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.sandro.mudi.interceptor.InteceptadorDeAcessos;

@Configuration
public class WebConfig  extends WebMvcConfigurationSupport{
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InteceptadorDeAcessos()).addPathPatterns("/**");
	}

}
