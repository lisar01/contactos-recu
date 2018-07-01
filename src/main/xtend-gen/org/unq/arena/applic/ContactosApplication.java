package org.unq.arena.applic;

import org.unq.arena.dominio.ContactosAppModel;
import org.unq.arena.vista.ContactosMainWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class ContactosApplication extends Application {
  public static void main(final String[] args) {
    new ContactosApplication().start();
  }
  
  @Override
  protected Window<?> createMainWindow() {
    ContactosAppModel _contactosAppModel = new ContactosAppModel();
    return new ContactosMainWindow(this, _contactosAppModel);
  }
}
