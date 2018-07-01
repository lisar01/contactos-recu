package org.unq.arena.vista

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.unq.arena.dominio.ContactosAppModel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.tables.Table
import org.unq.arena.dominio.Contacto
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.GroupPanel

class ContactosMainWindow  extends SimpleWindow<ContactosAppModel> {
	
	new(WindowOwner parent, ContactosAppModel model) {
		super(parent, model)
		title = "Contactos"
	}
	
	
	override protected addActions(Panel actionsPanel) {
		// Deshabilitar los botones si no hay ningún elemento seleccionado en la grilla.
		val elementSelected = new NotNullObservable("contactoSeleccionado")
		
		new Button(actionsPanel) => [
			caption = "Favorito"
			onClick [modelObject.marcarDesmarcarFavorito]
			bindEnabled(elementSelected)
		]
		
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val panelColumn = new Panel(mainPanel) => [
			layout = new ColumnLayout(2);
		]
		
		crearPanelDeTablaDeContactos(panelColumn)
		crearPanelDeNuevoContacto(panelColumn)
	}
	
	
	def crearPanelDeTablaDeContactos(Panel panelColumn) {
		val panel = new Panel(panelColumn);
		
		val table = new Table(panel, Contacto) => [
			items <=> "contactos"
			value <=> "contactoSeleccionado"
		]
		new Column(table) => [
			title = "Nombre y Apellido"
			alignRight
			bindContentsToProperty("nombreYApellido")
		]

		new Column(table) => [
			title = "Favorito"
			bindContentsToProperty("esFavorito")
		]
		
	}
	
	
	def crearPanelDeNuevoContacto(Panel panel) {
		val groupPanel = new GroupPanel(panel) => [
			title = "Nuevo Contacto"
		]
		
		new ContactoPanel(groupPanel,"contactoNuevo.",
			"Agregar",[this.modelObject.agregarContacto])
		
	}
	
	
}