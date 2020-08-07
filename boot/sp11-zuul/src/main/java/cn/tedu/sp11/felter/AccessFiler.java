package cn.tedu.sp11.felter;

import cn.tedu.web.util.JsonResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class  AccessFiler extends ZuulFilter {
    /*
    设置过滤器类型
     */

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /*
    过滤器顺序
     */
    @Override
    public int filterOrder() {
        return 7;
    }
    /*
    判断请求是否执行，  如果访问某服务 需要权限检查
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx   = RequestContext.getCurrentContext();
        Object serviceId = ctx.get(FilterConstants.SERVICE_ID_KEY);
        if (serviceId.equals("item-service")){
                return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            //没有token 设置false
            ctx.setSendZuulResponse(false);
            //发送提示，没有登录不能访问
            ctx.setResponseStatusCode(JsonResult.NOT_LOGIN);
            ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("not login").toString());

        }
        return null;
    }
}
