package com.bryam.dao;

import com.bryam.entity.*;
import com.bryam.util.*;

public class UsuarioDao extends Conexion<Usuario>{
	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super(Usuario.class);
	}
}
