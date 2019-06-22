package sei.amano.user.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sei.amano.bean.User;
import sei.amano.dao.UserDAO;
import sei.amano.util.IPUtil;
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
				//System.out.println(upassword);
				//System.out.println(md5password);
				//迷之查不出来...然后看自己check方法，惊了自己设置错变量了...
				//大概真的不能超荷工作了...
				response.sendRedirect("/PForum/user/login.jsp?uname="+uname+"&errlogin="+URLEncoder.encode("用户名或密码错误", StandardCharsets.UTF_8));
				return;
			}
			session.setAttribute("user", user);
			user.setUlastloginip(IPUtil.getIP(request));
			user.setUlastlogintime(new Date());
			UserDAO.edit(user.getUid(), user);
			if(remme) {
				Cookie cuname = new Cookie("uname", uname);
				cuname.setMaxAge(Integer.MAX_VALUE);
				Cookie cupassword = new Cookie("upassword", upassword);
				cupassword.setMaxAge(Integer.MAX_VALUE);
				//经过试验可以确定tomcat9可以设置这么大的maxage，并且网上也很难找到关于maxage的最大值的文献，并且可以确定tomcat9的文档中没有指出这个最大寿命有最大值
				//倒是找到stackflow上有人问在其他web容器中设置为maxvalue无效的，而且表示tomcat7设置有效
				response.addCookie(cuname);
				response.addCookie(cupassword);
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
