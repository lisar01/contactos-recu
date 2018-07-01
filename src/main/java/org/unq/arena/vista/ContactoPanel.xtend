package org.unq.arena.vista

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Container
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.NumericField
import org.uqbar.lacar.ui.model.Action
import org.uqbar.arena.widgets.Button
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ContactoPanel extends Panel {
	String scope;
	Action buttonAction
	String buttonCaption
	
	new(Container container, String scope, String buttonCaption, Action buttonAction) {
		super(container)
		this.scope = scope
		this.buttonCaption = buttonCaption
		this.buttonAction = buttonAction
		crearPanel 
	}
	
	def crearPanel() {
		agregarInput("Nombre y Apellido", "nombreYApellido", false);
		agregarInput("Email" , "email", false);
		agregarInput("Teléfono", "telefono", true);
		
		new Button(this) => [
			caption = buttonCaption
			onClick(buttonAction)
			setAsDefault
			disableOnError	
		]
		
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