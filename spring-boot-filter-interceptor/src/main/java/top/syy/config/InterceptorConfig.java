package top.syy.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.syy.interceptor.MyInterceptor;

/**
 * @author 小c
 */
@Configuration
@Slf4j
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/test");
    }
}
