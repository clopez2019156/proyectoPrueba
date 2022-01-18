package com.cesarlopez.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesarlopez.DAO.PersonaDAO;
import com.cesarlopez.model.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@JsonIgnoreProperties
@RequestMapping("personas")
public class PersonaREST {

	@Autowired
	private PersonaDAO personaDAO;
	@ResponseBody
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
}
