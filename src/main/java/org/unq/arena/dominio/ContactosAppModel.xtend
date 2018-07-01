package org.unq.arena.dominio

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class ContactosAppModel {
	Contactos contactosRepo;
	Contacto contactoSeleccionado;
	Contacto contactoNuevo;
	
	new() {
		contactosRepo = new Contactos();
	}
	
	def getContactos(){
		contactosRepo.contactos;
	}
	
	
	def marcarDesmarcarFavorito() {
		contactoSeleccionado.marcarDesmarcarFavorito;
	}
	
	
}