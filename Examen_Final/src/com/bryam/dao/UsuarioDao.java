package com.bryam.dao;

import java.util.List;

import javax.persistence.Query;

import com.bryam.entity.*;
import com.bryam.util.*;

public class UsuarioDao extends Conexion<Usuario>{
	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario findByLogin(Usuario u) {
		String JPQL = "FROM Usuario u WHERE u.usuario='" + u.getUsuario() + "' AND u.pass='"
				+ u.getPass() + "' AND u.rol.id=" + u.getRol().getId();
		Query query = getEm().createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.getResultList();
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}
}
