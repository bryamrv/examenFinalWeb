package com.bryam.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bryam.dao.*;
import com.bryam.entity.*;
import com.bryam.util.Email;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public LoginServlet() {
		super();
	}

	///////////////////////////////////////////////////////
	// Method - Servlet
	///////////////////////////////////////////////////////
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			try {
				switch (accion) {
				case "registrar":
					register(request, response);
					break;
				case "validarUsuario":
					cambiarEstdoUsuario(request, response);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			try {
				switch (accion) {
				case "registrarUsuario":
					registerUsuario(request, response);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		doGet(request, response);
	}

	///////////////////////////////////////////////////////
	// Method - All
	///////////////////////////////////////////////////////
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RolDao dao = new RolDao();
		List<Rol> list = dao.list();
		request.setAttribute("roles", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}
	
	
	///////////////////////////////////////////////////////
	// Method - All
	///////////////////////////////////////////////////////
	public void registerUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String usuario =  request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String email = request.getParameter("email");
		String tipo = request.getParameter("tipo_persona");
		
		UsuarioDao dao = new UsuarioDao();
		Usuario u = new Usuario(email, clave,(short) 0, usuario, new Rol(Integer.parseInt(tipo)));
		dao.insert(u);
		enviarCorreo(email, "Validar Usuario", "<a href='"+request.getContextPath()+"/login?accion=validarUsuario&&usuario=usuario'>Validar Usuario</a>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	
	public void enviarCorreo(String email, String header, String text) {
		Email e = new Email("bryamrodri09@gmail.com", "bryam123aA");
		e.enviarEmail(email, header, text);
	}
	
	public void cambiarEstdoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String usuario =  request.getParameter("usuario");
		UsuarioDao dao = new UsuarioDao();
		Usuario u =dao.findByField("usuario", usuario);
		if(u != null) {
			request.setAttribute("error_no_existe", false);
			if(u.getState() == 0) {
				u.setState((short)1);
				dao.update(u);
				request.setAttribute("cambio_estado", true);
			}else {
				request.setAttribute("cambio_estado", false);
			}
		}else {
			request.setAttribute("error_no_existe", true);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
}
