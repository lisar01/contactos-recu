package org.unq.arena.dominio

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import java.util.List

@Accessors
@Observable
class ContactosAppModel {
	Contactos contactosRepo;
	Contacto contactoSeleccionado;
	Contacto contactoNuevo;
	List<Contacto> contactos
	
	new() {
		contactosRepo = new Contactos();
		contactoNuevo = new Contacto;
		refresh
	}
	
	def refresh() {
		contactos = contactosRepo.contactos
	} 
	
	def agregarContacto() {
		contactosRepo.agregarContacto(contactoNuevo);
		contactoNuevo = new Contacto;
		refresh
	}
	
	
	def marcarDesmarcarFavorito() {
		contactoSeleccionado.marcarDesmarcarFavorito;
	}
	
	
}