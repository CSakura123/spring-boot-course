package top.syy.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
/**
 * @author 小c
 */
@Slf4j

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter,初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        log.info("MyFilter,在请求接口之前的执行逻辑");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            log.info("MyFilter,在请求接口之后的执行逻辑");
            log.info("MyFilter耗时: {} ms\"", duration);
        }
    }

    @Override
    public void destroy() {
        log.info("MyFilter,销毁了");
    }
}
