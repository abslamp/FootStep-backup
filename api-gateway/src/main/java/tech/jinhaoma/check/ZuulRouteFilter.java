package tech.jinhaoma.check;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import tech.jinhaoma.common.TokenUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by mjrt on 2/23/2017.
 */
@Configuration
public class ZuulRouteFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        boolean flag = true;

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = TokenUtils.getCookieValueFormRequest("token",request);
        flag = TokenUtils.checkToken(token);
        System.out.println("filter:"+flag);
        return !flag;
    }

    @Override
    public Object run() {
        System.out.println("okk");
        return null;
    }
}
