package nhc.erp.common.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nhc.erp.common.resolver.UserInfoArgumentResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private UserInfoArgumentResolver userInfoArgumentResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(userInfoArgumentResolver);
		// WebMvcConfigurer.super.addArgumentResolvers(resolvers);
	}	
}
