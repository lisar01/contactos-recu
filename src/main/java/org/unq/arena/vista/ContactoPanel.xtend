package org.unq.arena.vista

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Container
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.NumericField

class ContactoPanel extends Panel {
	String scope;
	
	new(Container container,String scope) {
		super(container)
		this.scope = scope
		agregarInputs 
	}
	
	def agregarInputs() {
		agregarInput("Nombre y Apellido", "nombreYApellido", false);
		agregarInput("Email" , "email", false);
		agregarInput("Telfono", "telefono", true);
	}
	
	
	def agregarInput(String label, String campo, Boolean numeric) {
		val hpanel = new Panel(this)
		hpanel.layout = new HorizontalLayout;
		
		new Label(hpanel) => [
			text = label + ":"
			alignRight
			width = 140
		]
		
		val field = if (numeric) new NumericField(hpanel) else new TextBox(hpanel);   

		field => [
			value <=> scope + campo
		]
		
	}
	
}