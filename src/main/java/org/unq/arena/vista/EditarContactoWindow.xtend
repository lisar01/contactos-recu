package org.unq.arena.vista

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.unq.arena.dominio.Contacto

class EditarContactoWindow extends TransactionalDialog<Contacto> {
	
	new(WindowOwner owner, Contacto model) {
		super(owner, model)
		title = "Editar Contacto"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new ContactoPanel(mainPanel, "", "Aceptar", [this.accept])
	}
	
}