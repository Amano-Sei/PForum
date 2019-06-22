package sei.amano.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sei.amano.dao.UserDAO;

public class ChecknameServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter pw = response.getWriter();
		try {
			String uname = request.getParameter("uname");
			if(uname != null) {
				pw.print(UserDAO.hasuname(uname));
				return;
			}
			String unickname = request.getParameter("unickname");
			if(unickname != null) {
				pw.print(UserDAO.hasunickname(unickname));
				return;
			}
			pw.print("error");
		} catch (SQLException e) {
			e.printStackTrace();
			pw.print("error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
