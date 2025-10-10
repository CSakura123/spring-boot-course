package top.syy.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author 小c
 */
@Slf4j

public class Youfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("YouFilter,初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("YouFilter,在请求接口之前的执行逻辑");
            filterChain.doFilter(servletRequest, servletResponse);
        log.info("YouFilter,在请求接口之后的执行逻辑");
    }
    @Override
    public void destroy() {
        log.info("YouFilter,销毁了");
    }
}
