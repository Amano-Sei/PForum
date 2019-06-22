package sei.amano.user.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sei.amano.bean.User;
import sei.amano.dao.ULvNameDAO;
import sei.amano.dao.UserDAO;
import sei.amano.util.DateUtil;
import sei.amano.util.MD5Util;
import sei.amano.util.ParamUtil;

public class RegisterServlet extends HttpServlet {
	private static String[] mustlist = {"uname", "unickname", "upassword", "umail", "usex", "uagree", "reupassword"};
	private static String[] mustlistparttern = {"^[a-zA-Z]\\w{4,15}$", "^([^\\x00-\\xff]|\\w)([^\\x00-\\xff]|\\w| ){0,14}([^\\x00-\\xff]|\\w)$",
					"^[!@#$%&?><,^+\\/()\\[\\]{}.*\\-=\\\\\\w]{8,20}$", "^\\w+@(\\w+.)+\\w+$", "^(male|female|secret)$", "^on$"};
	//真的无比感激自己先写好了正则QAQ
	private static String[] optionallist = {"ubirth", "uhobby", "usignature", "uprofile"};
	private static String[] optionallistpattern = {"^(19[0-9][0-9]|200[0-9]|201[0-8])-((?<=(19([02468][048]|[13579][26])|200[048]|201[26])-)02-29|02-([01][1-9]|10|2[0-8])|(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01])|(0[469]|11)-(0[1-9]|[12][0-9]|30))$",
					"^([^\\x00-\\xff]|\\w)([^\\x00-\\xff]|\\w| ){0,58}([^\\x00-\\xff]|\\w)$", "^([^\\x00-\\xff]|[!@#$%&?><,^+\\/()\\[\\]{}.*\\-=\\\\\\w]){2,256}$"};
	
	/*private static void addParam(HashMap<String, String> allparam, String key, String value) {
		if(allparam == null)
			allparam = new HashMap<>();
		allparam.put(key, value);
		//想了想flag免不了，而且allparam必然要创建所以这个函数应该没用了
	}*/
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		//upload.setHeaderEncoding("UTF-8");
		upload.setHeaderEncoding(request.getCharacterEncoding());
		factory.setSizeThreshold(2097152);
		boolean flag = true;
		User user = new User();
		try {
			List<FileItem> items = upload.parseRequest(request);
			FileItem item = null;
			String itemname = null;
			Iterator<FileItem> it = items.iterator();
			HashMap<String, Object> allfield = new HashMap<>();
			while(it.hasNext()) {
				item = it.next();
				itemname = item.getFieldName();
				if(item.isFormField())
					allfield.put(itemname, item.getString(request.getCharacterEncoding()));
				else
					allfield.put(itemname, item);
			}
			String cf = null;
			String oripass = null;
			HashMap<String, String> allparam = new HashMap<>();
			for(int i = 0; i < 2; i++) {
				cf = (String)allfield.get(mustlist[i]);
				if(cf == null || !Pattern.matches(mustlistparttern[i], cf)) {
					//System.out.println(cf+"==="+new String(cf.getBytes(), StandardCharsets.UTF_8)+"==="+mustlistparttern[i]);
					allparam.put("err"+mustlist[i], "is-invalid");
					flag = false;
				}else if(i==0 && UserDAO.hasuname(cf)) {
					allparam.put("err"+mustlist[i], "is-invalid hasdesu");
					flag = false;
				}else if(i==1 && UserDAO.hasunickname(cf)) {
					allparam.put("err"+mustlist[i], "is-invalid hasdesu");
					flag = false;
				}else {
					allparam.put("err"+mustlist[i], "is-valid");
					allparam.put(mustlist[i], cf);
					User.class.getMethod("setU"+mustlist[i].substring(1), String.class).invoke(user, cf);
				}
			}
			for(int i = 2; i < 4; i++) {
				cf = (String)allfield.get(mustlist[i]);
				if(cf == null || !Pattern.matches(mustlistparttern[i], cf)) {
					if(i==3)
						allparam.put("err"+mustlist[i], "is-invalid");
					flag = false;
				}else {
					if(i == 2) {
						oripass = cf;
						cf = MD5Util.getMd5s(cf);
					}else { 
						allparam.put(mustlist[i], cf);
						allparam.put("err"+mustlist[i], "is-valid");
					}
					User.class.getMethod("setU"+mustlist[i].substring(1), String.class).invoke(user, cf);
				}
			}
			cf = (String)allfield.get(mustlist[4]);
			if(cf == null || !Pattern.matches(mustlistparttern[4], cf)) {
				allparam.put("err"+mustlist[4], "is-invalid");
				flag = false;
			}else {
				allparam.put("err"+mustlist[4], "is-valid");
				allparam.put(cf, "checked");
				switch(cf) {
					case "male":
						user.setUsex(1);
						break;
					case "female":
						user.setUsex(0);
						break;
					case "secret":
						user.setUsex(-1);
						break;
				}
			}
			cf = (String)allfield.get(mustlist[5]);
			if(cf == null || !Pattern.matches(mustlistparttern[5], cf)) {
				allparam.put("err"+mustlist[5], "is-invalid");
				flag = false;
			}else {
				allparam.put("err"+mustlist[5], "is-valid");
				allparam.put(mustlist[5], "checked");
			}
			cf = (String)allfield.get(mustlist[6]);
			if(cf == null || !cf.equals(oripass)) {
				//allparam.put("err"+mustlist[6], "is-invalid");
				flag = false;
			}else {
				//allparam.put("err"+mustlist[6], "is-valid");
			}
			
			for(int i = 0; i < 3; i++) {
				cf = (String)allfield.get(optionallist[i]);
				if(cf != null && !"".equals(cf)) {
					if(Pattern.matches(optionallistpattern[i], cf)) {
						allparam.put("err"+optionallist[i], "is-valid");
						allparam.put(optionallist[i], cf);
						if(i == 0)
							user.setUbirth(new SimpleDateFormat("yyyy-MM-dd").parse(cf));
						else
							User.class.getMethod("setU"+optionallist[i].substring(1), String.class).invoke(user, cf);
					}
				}
			}
			item = (FileItem)allfield.get(optionallist[3]);
			if(item != null && item.getSize()!=0) {
				if(item.getSize() > 1048576 || !item.getContentType().equals("image/jpeg")) {
					flag = false;
					//allparam.put("erruprofile", "is-invalid");
				}//else
				//	allparam.put("erruprofile", "is-valid");
			}
			if(flag) {
				user.setUregtime(new Date());
				if(user.getUbirth() != null)
					user.setUage(DateUtil.getAge(user.getUbirth()));
				user.setUpagecount(20);
				user.setUlv(1);
				user.setUlvname(ULvNameDAO.getULvName(1));
				if(user.getUsignature() == null)
					user.setUsignature("这个家伙很懒，什么都没有留下");;
				UserDAO.add(user);
				
				try(
					InputStream uprofileis = (item != null && item.getSize() != 0) ? item.getInputStream() : new FileInputStream(new File(request.getServletContext().getRealPath("/img/user/0.jpg")));
					OutputStream uprofileos = new FileOutputStream(new File(request.getServletContext().getRealPath("/img/user/"+user.getUid()+".jpg")));
				){
					int len = 0;
					byte[] data = new byte[512];
					while(-1 != (len = uprofileis.read(data)))
						uprofileos.write(data, 0, len);
				}
				response.sendRedirect("/PForum/user/login.jsp?uname="+user.getUname()+"&msglogin="+URLEncoder.encode("注册成功", StandardCharsets.UTF_8));
			}else
				response.sendRedirect("/PForum/user/register.jsp"+ParamUtil.getURLParam(allparam));
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/PForum/user/login.jsp?msglogin="+URLEncoder.encode("服务器错误", StandardCharsets.UTF_8));
		}
		/*
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
