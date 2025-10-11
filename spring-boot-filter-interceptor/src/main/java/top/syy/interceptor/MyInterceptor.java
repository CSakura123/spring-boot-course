package top.syy.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 小c
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("进入拦截器，请求路径为：{}",requestURI);
        long beginTime = System.currentTimeMillis();
        request.setAttribute("beginTime",beginTime);
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long beginTime =(Long) request.getAttribute("beginTime");
        long endTime = System.currentTimeMillis();
        String requestURI = request.getRequestURI();
        long duration = endTime - beginTime;
        log.info("拦截器执行结束:{}接口总耗时{}ms",requestURI, duration);
    }
}
