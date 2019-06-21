package sei.amano.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sei.amano.dao.BlacklistDAO;
import sei.amano.util.IPUtil;

public class BlacklistFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ip = IPUtil.getIP((HttpServletRequest)request);
		try {
			if(BlacklistDAO.checkip(ip)) {
				((HttpServletResponse)response).sendRedirect("/PForum/error.html");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

}
