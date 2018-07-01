package org.unq.arena.dominio;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;
import org.uqbar.commons.model.exceptions.UserException;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public class Contacto {
  private String nombre;
  
  private String apellido;
  
  private String email;
  
  private int telefono;
  
  private Boolean esFavorito;
  
  public Contacto() {
    this.esFavorito = Boolean.valueOf(false);
  }
  
  public void validarSiEsVacio(final String campo, final String aValidar) {
    if ((Objects.equal(aValidar, null) || aValidar.trim().equals(""))) {
      throw new UserException(("Debe ingresar un " + campo));
    }
  }
  
  public String setNombre(final String nombre) {
    String _xblockexpression = null;
    {
      this.validarSiEsVacio("nombre", nombre);
      _xblockexpression = this.nombre = nombre;
    }
    return _xblockexpression;
  }
  
  public String setApellido(final String apellido) {
    String _xblockexpression = null;
    {
      this.validarSiEsVacio("apellido", apellido);
      _xblockexpression = this.apellido = apellido;
    }
    return _xblockexpression;
  }
  
  public String setEmail(final String email) {
    String _xblockexpression = null;
    {
      this.validarSiEsVacio("email", email);
      _xblockexpression = this.email = email;
    }
    return _xblockexpression;
  }
  
  public Boolean marcarDesmarcarFavorito() {
    return this.esFavorito = Boolean.valueOf((!(this.esFavorito).booleanValue()));
  }
  
  public String nombreYApellido() {
    return ((this.nombre + " ") + this.apellido);
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  @Pure
  public String getApellido() {
    return this.apellido;
  }
  
  @Pure
  public String getEmail() {
    return this.email;
  }
  
  @Pure
  public int getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(final int telefono) {
    this.telefono = telefono;
  }
  
  @Pure
  public Boolean getEsFavorito() {
    return this.esFavorito;
  }
  
  public void setEsFavorito(final Boolean esFavorito) {
    this.esFavorito = esFavorito;
  }
}
