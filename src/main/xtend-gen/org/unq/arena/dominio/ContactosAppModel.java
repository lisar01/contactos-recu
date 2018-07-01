package org.unq.arena.dominio;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.unq.arena.dominio.Contacto;
import org.unq.arena.dominio.Contactos;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class ContactosAppModel {
  private Contactos contactosRepo;
  
  private Contacto contactoSeleccionado;
  
  private Contacto contactoNuevo;
  
  public ContactosAppModel() {
    Contactos _contactos = new Contactos();
    this.contactosRepo = _contactos;
  }
  
  public List<Contacto> getContactos() {
    return this.contactosRepo.getContactos();
  }
  
  public Boolean marcarDesmarcarFavorito() {
    return this.contactoSeleccionado.marcarDesmarcarFavorito();
  }
  
  @Pure
  public Contactos getContactosRepo() {
    return this.contactosRepo;
  }
  
  public void setContactosRepo(final Contactos contactosRepo) {
    this.contactosRepo = contactosRepo;
  }
  
  @Pure
  public Contacto getContactoSeleccionado() {
    return this.contactoSeleccionado;
  }
  
  public void setContactoSeleccionado(final Contacto contactoSeleccionado) {
    this.contactoSeleccionado = contactoSeleccionado;
  }
  
  @Pure
  public Contacto getContactoNuevo() {
    return this.contactoNuevo;
  }
  
  public void setContactoNuevo(final Contacto contactoNuevo) {
    this.contactoNuevo = contactoNuevo;
  }
}
