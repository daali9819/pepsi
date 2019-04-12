package org.hr_xiangmu.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hr_xiangmu.entity.Rolesysright;
import org.hr_xiangmu.entity.User;

public class guoFiler implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		Object user = session.getAttribute("login_user");
		if(user == null){
			System.out.println("你没有登录呢");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}else{
			arg2.doFilter(request, response);
//			String urlS = request.getRequestURI();
//			User u = (User)user; 
//			String path = urlS.replace(request.getContextPath()+"/", "");
//			System.out.println(path);
//			boolean asd = false;
//			for (Rolesysright rs : u.getRole().getRolesysrights()) {
//				System.out.println(rs.getSysright().getUrl());
//				if(path.equals(rs.getSysright().getUrl()) || path.contains("index") || path.contains("jsp") || path.contains("js")){
//					asd = true;
//				}else{
//					asd = false;
//				}
//			}
//			if(asd){
//				System.out.println("你能过去了");
//				arg2.doFilter(request, response);
//			}else{
//				response.sendRedirect(request.getContextPath()+"/login.jsp");
//			}
			
		}
		
		
		
		
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
