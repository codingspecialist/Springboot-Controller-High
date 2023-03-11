package shop.mtcoding.filterandhandler.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.mtcoding.filterandhandler.filter.BlackListFilter;

@Configuration
public class FilterRegister {
    @Bean
    public FilterRegistrationBean<?> myFilterRegistration() {
        FilterRegistrationBean<BlackListFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new BlackListFilter());
        registration.addUrlPatterns("/login/*");
        registration.setOrder(1); // 필터 순서 설정
        return registration;
    }
}
