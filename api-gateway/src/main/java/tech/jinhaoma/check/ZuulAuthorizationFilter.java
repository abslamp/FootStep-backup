package tech.jinhaoma.check;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;
import tech.jinhaoma.common.TokenUtils;
import tech.jinhaoma.domain.TokenPayload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mjrt on 2/23/2017.
 */
@Configuration
public class ZuulAuthorizationFilter extends ZuulFilter {

    private String token;

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

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        token = TokenUtils.getCookieValueFormRequest("token",request);
        System.out.println(token);
        return token==null && !TokenUtils.checkToken(token);

    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        TokenPayload payload = TokenUtils.parseToken(token);

        if (payload == null){
            try {
                response.sendRedirect("/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(payload.getSub() < getAuthorizationNumber()){
            try {
                request.getRequestDispatcher("/errorPermission.html").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }

    private int getAuthorizationNumber() {
        return 5;
    }
}
