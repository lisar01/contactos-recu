package org.unq.arena.vista

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Container
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

class ContactoPanel extends Panel {
	String scope;
	
	new(Container container,String scope) {
		super(container)
		this.scope = scope
		agregarInputs 
	}
	
	def agregarInputs() {
		val hpanel = new Panel(this)
		hpanel.layout = new HorizontalLayout;
		
		new Label(hpanel).text = "Nombre"

		new TextBox(hpanel) => [
			value <=> "contactoNuevo.nombre"
		]
	}
	
}