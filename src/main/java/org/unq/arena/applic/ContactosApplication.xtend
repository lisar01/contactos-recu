package org.unq.arena.applic
import org.uqbar.arena.Application
import org.unq.arena.dominio.ContactosAppModel
import org.unq.arena.vista.ContactosMainWindow

class ContactosApplication extends Application {
	
	def static void main(String[] args) {	
		new ContactosApplication().start()
	}
	
	override protected createMainWindow() {	
		new ContactosMainWindow(this, new ContactosAppModel())
	}
}