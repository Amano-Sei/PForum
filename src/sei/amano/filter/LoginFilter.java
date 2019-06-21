package sei.amano.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sei.amano.bean.User;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String preuri = request.getRequestURI(); 
		String uri = preuri.substring(request.getServletContext().getContextPath().length());
		if(user == null && (uri.startsWith("/content") || uri.startsWith("/admin") || uri.startsWith("/user/manage"))) {
			request.setAttribute("errlogin", "请先登录");
			request.setAttribute("preuri", preuri);
			request.getRequestDispatcher("/user/login.jsp").forward(arg0, arg1);
			return;
		}else if(user != null && (uri.startsWith("/user/login.jsp") || uri.startsWith("/user/register.jsp"))) {
			request.setAttribute("errhome", "您已登录");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			return;
		}
			
		chain.doFilter(arg0, arg1);
	}

}
