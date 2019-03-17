import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xushaopeng
 * @date 2019/03/17
 */
@WebFilter(filterName = "filter", urlPatterns = {"/*"}, servletNames = {"demo"})
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //在servlet被调用之前截获，此时可以检查、修改request头和request数据;
        System.out.println("Intercept Url=" + httpServletRequest.getRequestURI());
        long start = System.currentTimeMillis();

        //Causes the next filter in the chain to be invoked, or if the calling filter is the last filter in the chain, causes the resource at the end of the chain to be invoked.
        filterChain.doFilter(servletRequest, servletResponse);

        //在servlet被调用之后截获,此时可以修改response头和response数据;
        long end = System.currentTimeMillis();
        System.out.println(servletRequest.getRemoteAddr() + ": time used :" + (end - start));

        servletResponse.getWriter().write("filter");
    }

    @Override
    public void destroy() {

    }
}
