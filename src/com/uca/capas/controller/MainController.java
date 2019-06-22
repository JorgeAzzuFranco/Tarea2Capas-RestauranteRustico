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
import com.uca.capas.daos.StudentDAO;
import com.uca.capas.daos.SucursalDAO;
import com.uca.capas.daos.UsuarioDAO;
import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Student;
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
				sucursales = sucDao.findAll();
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
	
//EDITAR-SUCURSAL---------------------------------------------------------------------

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
	
//GUARDAR-O-ACTUALIZAR-SUCURSAL-------------------------------------------------------
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
		
		mav.addObject("sucursal",sucursal);
		mav.addObject("empleados", empleados);
		mav.setViewName("editarSucursal");
		return mav;
	}

	
	/*@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("form");
		
		return mav;
	}
	
	@RequestMapping(value="/formData", method=RequestMethod.POST)
	public ModelAndView formData(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		
		int cond;
		if(s.getcStudent() != null) cond = 0;
		else cond = 1;

		try {
			studentDao.save(s, cond);
		}catch(Exception w) {
			w.printStackTrace();
		}
		students = studentDao.findAll();
		mav.addObject("students", students);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public ModelAndView formData2(@RequestParam("cStudent") String Code) {
		ModelAndView mav = new ModelAndView();
		Student s = null;
		Integer code = Integer.parseInt(Code);
		try {
			s = studentDao.findOne(code);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("student", s);
		mav.setViewName("form2");
		return mav;
	}
	
	@RequestMapping(value="/eliminar", method=RequestMethod.GET)
	public ModelAndView eliminar(@RequestParam("cStudent") String Code) {
		ModelAndView mav = new ModelAndView();
		Integer code = Integer.parseInt(Code);
		try {
			studentDao.delete(code);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.setViewName("main");
		return mav;
	}*/
}
