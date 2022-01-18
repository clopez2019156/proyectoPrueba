package com.cesarlopez.REST;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cesarlopez.DAO.ProductoDAO;
import com.cesarlopez.model.Producto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@JsonIgnoreProperties
@RequestMapping("productos")
public class productoREST {
	
	@Autowired
	private ProductoDAO productoDAO;
	@ResponseBody
	@PostMapping("/guardar")
	public void guardar(@RequestBody Producto producto) {
		productoDAO.save(producto);
	}
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		
		return productoDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		productoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Producto producto) {
		productoDAO.save(producto);
	}
	
	@PutMapping("/listar/{id}")
public List<Producto> listar(@PathVariable("id") Integer id){
		
		 productoDAO.findById(id);
		return productoDAO.findAll();
	}
	
}


