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

@WebServlet(name = "rol", urlPatterns = { "/rol" })
public class RolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RolServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			try {
				switch (accion) {
				case "showInsert":
					showInsert(request, response);
					break;
				case "delete":
					delete(request, response);
					break;
				case "showEdit":
					showEdit(request, response);
					break;
				case "list":
					list(request, response);
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
				case "insert":
					insert(request, response);
					break;
				case "edit":
					edit(request, response);
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
	// Method
	///////////////////////////////////////////////////////
	private void showInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RolDao dao = new RolDao();
		List<Rol> list = dao.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/roles/role/list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
	}
	
	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
	}

}
