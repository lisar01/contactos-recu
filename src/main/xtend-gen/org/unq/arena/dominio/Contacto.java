package org.unq.arena.dominio;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;
import org.uqbar.commons.model.exceptions.UserException;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public class Contacto {
  private String nombreYApellido;
  
  private String email;
  
  private int telefono;
  
  private Boolean esFavorito;
  
  public Contacto() {
    this.esFavorito = Boolean.valueOf(false);
  }
  
  public void validarSiEsVacio(final String campo, final String aValidar) {
    if (((aValidar == null) || aValidar.trim().equals(""))) {
      throw new UserException(("Debe ingresar un " + campo));
    }
  }
  
  public String setNombreYApellido(final String nombreYApellido) {
    String _xblockexpression = null;
    {
      this.validarSiEsVacio("nombre y apellido", nombreYApellido);
      int _size = ((List<String>)Conversions.doWrapArray(nombreYApellido.split(""))).size();
      boolean _equals = (_size == 1);
      if (_equals) {
        throw new UserException("Debe ingresar un nombre y apellido");
      }
      _xblockexpression = this.nombreYApellido = nombreYApellido;
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
  
  @Pure
  public String getNombreYApellido() {
    return this.nombreYApellido;
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
