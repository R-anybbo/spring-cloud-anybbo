package com.anybbo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huopengbo
 * @date 2019/01/02
 * @copyright © 2019 anybbo
 */
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // pre 请求之前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
        }
        return null;
    }
}
