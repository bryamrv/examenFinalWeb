package com.bryam.dao;

import com.bryam.entity.*;
import com.bryam.util.*;

public class TypedbDao  extends Conexion<Typedb>{
	private static final long serialVersionUID = 1L;

	public TypedbDao() {
		super(Typedb.class);
	}
}
