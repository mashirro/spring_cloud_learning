package com.mashirro.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SimplePreFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(SimplePreFilter.class);

    @Override
    public String filterType() {
        //过滤器类型,这里为预过滤器(有四种:pre,route,post,error)
        return "pre";
    }

    @Override
    public int filterOrder() {
        //此过滤器相对于其他过滤器的执行顺序。数值越小，优先级越高。
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException {
         /*
        Zuul过滤器将请求和状态信息存储在RequestContext(并通过RequestContext来共享),
        我们使用它来获取HttpServletRequest，然后在发送之前记录请求的HTTP方法和URL。
         */
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }

    public static void main(String[] args) {
        int i = 0;
        i++;
        System.out.println(i);
    }
}

