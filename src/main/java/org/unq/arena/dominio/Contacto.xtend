package org.unq.arena.dominio

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.commons.model.annotations.TransactionalAndObservable

@Accessors
@TransactionalAndObservable
class Contacto {
	String nombre
	String apellido
	String email
	int telefono
	Boolean esFavorito;
	
	
	new() {
		esFavorito = false;
	}
	
	def validarSiEsVacio(String campo, String aValidar) {
		if (aValidar == null || aValidar.trim().equals("")) {
			throw new UserException("Debe ingresar un " + campo);
		}
	}
	
	def setNombre(String nombre) {
		validarSiEsVacio("nombre", nombre);
		this.nombre = nombre;
	}
	
	def setApellido(String apellido) {
		validarSiEsVacio("apellido", apellido);
		this.apellido = apellido;
	}
	
	def setEmail(String email) {
		validarSiEsVacio("email", email);
		this.email = email;
	}
	
	def marcarDesmarcarFavorito() {
		esFavorito = ! esFavorito;
	}
	
	def nombreYApellido() {
		nombre + " " + apellido;
	}
	
}