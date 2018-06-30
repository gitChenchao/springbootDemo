package com.cc.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 类名称：AccessFilter<br>
 * 类描述：<br>
 * 创建时间：2018年05月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器类型 它决定过滤器在请求的那个生命周期中执行。
     * 这里定义pre，代表会在请求被路由之前执行
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        LOGGER.info("filterType()");
        return "pre";
    }

    @Override
    public int filterOrder() {
        LOGGER.info("filterOrder()");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        LOGGER.info("shouldFilter()");
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("send() request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            LOGGER.warn("accessToken is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("accessToken is null");
            ctx.setResponseStatusCode(401);
            return null;
        }
        LOGGER.info("accessToken is ok");
        return null;
    }
}
