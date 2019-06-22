package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.daos.EmpleadoDAO;
import com.uca.capas.daos.SucursalDAO;
import com.uca.capas.daos.UsuarioDAO;
import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.Usuario;

@Controller
public class MainController {
	
	@Autowired
	private UsuarioDAO userDao;
	@Autowired
	private SucursalDAO sucDao;
	@Autowired
	private EmpleadoDAO empDao;

//MAIN-PAGE------------------------------------------------------------------------

	@RequestMapping("/")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		Usuario u = new Usuario();
		mav.addObject("usuario",u);
		mav.setViewName("main");
		return mav;
		
	}
	
//LOG-IN------------------------------------------------------------------------------
	
	@RequestMapping("/login")
	public ModelAndView buscar(String usuario, String clave) {
		
		ModelAndView mav = new ModelAndView();
		
		Usuario user = new Usuario(usuario, clave);
		int admin = 0;
		
		try {
			admin = userDao.findUser(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(admin == 1) {
			List<Sucursal> sucursales = null;
			
			try {
				sucursales = getSucursales();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("sucursales", sucursales);
			mav.setViewName("control");
		}
		else {
			mav.addObject("usuario", user);
			mav.setViewName("main");
		}
		
		return mav;
		
	}
	
//EDITAR-SUCURSAL-(CENTRO-DE-CONTROL)--------------------------------------------

	@RequestMapping("/editarSucursal")
	public ModelAndView editarSucursal(@RequestParam("codigo") Integer codigo) {
		
		ModelAndView mav = new ModelAndView();
		
		Sucursal sucursal = null;
		List<Empleado> empleados = null;
		
		try {
			sucursal = sucDao.findOne(codigo);
			empleados = empDao.findAll(codigo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("sucursal",sucursal);
		mav.addObject("empleados", empleados);
		mav.setViewName("editarSucursal");
		return mav;
		
	}
	
//ELIMINAR-SUCURSAL-(CENTRO-DE-CONTROL)-------------------------------------------
	
	@RequestMapping("/borrarSucursal")
	public ModelAndView borrarSucursal(@RequestParam("codigo") Integer codigo) {
		
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		Integer borrado = 0;
		try {
			borrado = sucDao.delete(codigo);
			sucursales = getSucursales();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("sucursales", sucursales);
		mav.setViewName("control");
		return mav;
		
	}
	
//AGREGAR-SUCURSAL-(CENTRO-DE-CONTROL)-------------------------------------------
	@RequestMapping("/agregarSucursal")
	public ModelAndView agregarSucursal() {
		
		ModelAndView mav = new ModelAndView();
		
		Sucursal sucursal = new Sucursal();
		
		mav.addObject("sucursal",sucursal);
		mav.setViewName("editarSucursal");
		return mav;
	
	}
//GUARDAR-O-ACTUALIZAR-SUCURSAL-(DENTRO-DE-EDITAR-SUCURSAL)-----------------------
	
	@RequestMapping("/actualizarSucursal")
	public ModelAndView actualizarSucursal(@ModelAttribute Sucursal sucursal) {
		
		ModelAndView mav = new ModelAndView();
		Integer newRow = 1;
		List<Empleado> empleados = null;
		
		if(sucursal.getCodigo() != null) {
			newRow = 0;
		}
		
		try {
			sucDao.insert(sucursal, newRow);
			sucursal = sucDao.findOne(sucursal.getCodigo());
			empleados = empDao.findAll(sucursal.getCodigo());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(newRow == 1) {
			mav.addObject("sucursales", getSucursales());
			mav.setViewName("control");
		}else {
			mav.addObject("sucursal",sucursal);
			mav.addObject("empleados", empleados);
			mav.setViewName("editarSucursal");
		}
		return mav;
	}

//METODOS-RAPIDOS----------------------------------------------------
	
	private List<Sucursal> getSucursales() {
		List<Sucursal> sucursales = null;
		
		try {
		sucursales = sucDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sucursales;
	}
}
