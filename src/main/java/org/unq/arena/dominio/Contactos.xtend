package org.unq.arena.dominio

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Contactos {
	List<Contacto> contactos;
	
	new(){
		crearContactos
	}
	
	def crearContactos() {
		contactos = newArrayList(
			new Contacto => [
				nombre = "Walter";
				apellido =  "White";
				telefono = 121432432;
				email = "ww@gmail.com";
			],
			new Contacto => [
				nombre = "Rick";
				apellido =  "Grimes";
				telefono = 546768572;
				email = "rg@gmail.com";
			],
			new Contacto => [
				nombre = "Barry Allen";
				apellido =  "White";
				telefono = 3465465;
				email = "ba@gmail.com";
			],
			new Contacto => [
				nombre = "Tim";
				apellido =  "Drake";
				telefono = 89785663;
				email = "td@gmail.com";
			]
		);
	}
	
	
	def agregarContacto(Contacto contacto) {
		contactos.add(contacto);
	}
	
	
}