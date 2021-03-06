package org.unq.arena.dominio

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.exceptions.UserException

@Accessors
class Contactos {
	List<Contacto> contactos
	
	new(){
		crearContactos
	}
	
	def crearContactos() {
		contactos = newArrayList(
			new Contacto => [
				nombreYApellido = "Walter White"
				telefono = 121432432
				email = "ww@gmail.com"
			],
			new Contacto => [
				nombreYApellido = "Rick Grimes"
				telefono = 546768572
				email = "rg@gmail.com"
			],
			new Contacto => [
				nombreYApellido = "Barry Allen"
				telefono = 3465465
				email = "ba@gmail.com"
			],
			new Contacto => [
				nombreYApellido = "Tim Drake"
				telefono = 89785663
				email = "td@gmail.com"
			]
		);
	}
	
	
	def agregar(Contacto contacto) {
		contacto.validar()
		validarEsDuplicado(contacto)
		contactos.add(contacto)
	}
	
	def validarEsDuplicado(Contacto contacto) {
		if (contactos.findFirst[nombreYApellido.equals(contacto.nombreYApellido)] !== null) {
			throw new UserException("El contacto con ese nombre y apellido ya fue agregado")
		}
	}
	
}