package shop.mtcoding.filterandhandler.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;

public class BlackListFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // x-www-form-urlencoded -> username=ssar
        String username = request.getParameter("username");
        if(username.equals("ssar")){
            // DS보다 먼저 작동한다.
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().println("당신은 블랙리스트입니다.");
            return;
        }
        chain.doFilter(request, response);
    }
}
