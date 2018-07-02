package org.unq.arena.dominio

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.commons.model.annotations.TransactionalAndObservable
import java.util.regex.Pattern

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
	
	
	def Boolean marcarDesmarcarFavorito() {
		esFavorito = ! esFavorito
	}
	
	def validar() {
		validarSiEsVacio("nombre y apellido", nombreYApellido)
		validarSiEsVacio("email", email)
	}
	
	
	def void setNombreYApellido(String nombreYApellido) {
		validarSiEsVacio("nombre y apellido", nombreYApellido)
		validarTieneApellido(nombreYApellido)
		this.nombreYApellido = nombreYApellido
	}
	
	def void setEmail(String email) {
		validarSiEsVacio("email", email)
		validarEsEmail(email)
		this.email = email
	}
	
	
	def void validarSiEsVacio(String campo, String aValidar) {
		if (aValidar === null || aValidar.trim().equals("")) {
			throw new UserException("Debe ingresar un " + campo)
		}
	}
	
	
	def validarTieneApellido(String nombreYApellido) {
		if (nombreYApellido.split(" ").size == 1) {
			throw new UserException("El campo ingresado no contiene Nombre o Apellido")
		}
	}
	
	
	def validarEsEmail(String email) {
    val pattern = Pattern.compile("^.+@.+\\..+$")
    val matcher = pattern.matcher(email)
    
    if(! matcher.matches) throw new UserException("El campo ingresado no es un email valido") 
    }  
	
}
