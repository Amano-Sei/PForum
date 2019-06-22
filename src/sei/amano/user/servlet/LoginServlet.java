package sei.amano.user.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sei.amano.bean.User;
import sei.amano.dao.UserDAO;
import sei.amano.util.MD5Util;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String preuri = request.getParameter("preuri");
		boolean remme = (request.getParameter("remme") != null);
		if(uname == null || upassword == null || "".equals(uname) || "".equals(upassword)) {
			response.sendRedirect("/PForum/user/login.jsp?errlogin="+URLEncoder.encode("用户名或密码为空", StandardCharsets.UTF_8));
			return;
		}
		
		try {
			String md5password = MD5Util.getMd5s(upassword);
			User user = UserDAO.checkpassword(uname, md5password);
			if(user == null) {
				response.sendRedirect("/PForum/user/login.jsp?uname="+uname+"&errlogin="+URLEncoder.encode("用户名或密码错误", StandardCharsets.UTF_8));
				return;
			}
			session.setAttribute("user", user);
			if(remme) {
				response.addCookie(new Cookie("uname", uname));
				response.addCookie(new Cookie("upassword", upassword));
			}
			if(preuri == null || "".equals(preuri))
				response.sendRedirect("/PForum/home.jsp");
			else
				response.sendRedirect(preuri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
