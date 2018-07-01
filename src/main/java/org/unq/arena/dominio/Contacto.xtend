package org.unq.arena.dominio

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.commons.model.annotations.TransactionalAndObservable

@Accessors
@TransactionalAndObservable
class Contacto {
	String nombreYApellido
	String email
	int telefono
	Boolean esFavorito;
	
	
	new() {
		esFavorito = false;
	}
	
	def void validarSiEsVacio(String campo, String aValidar) {
		if (aValidar === null || aValidar.trim().equals("")) {
			throw new UserException("Debe ingresar un " + campo)
		}
	}
	
	def void setNombreYApellido(String nombreYApellido) {
		validarSiEsVacio("nombre y apellido", nombreYApellido)
		if (nombreYApellido.split(" ").size == 1) {
			throw new UserException("Debe ingresar un nombre y apellido")
		}
		
		this.nombreYApellido = nombreYApellido
	}
	
	def void setEmail(String email) {
		validarSiEsVacio("email", email)
		this.email = email
	}
	
	def Boolean marcarDesmarcarFavorito() {
		esFavorito = ! esFavorito
	}
	
}
