package org.unq.arena.dominio;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.unq.arena.dominio.Contacto;

@Accessors
@SuppressWarnings("all")
public class Contactos {
  private List<Contacto> contactos;
  
  public Contactos() {
    this.crearContactos();
  }
  
  public List<Contacto> crearContactos() {
    Contacto _contacto = new Contacto();
    final Procedure1<Contacto> _function = (Contacto it) -> {
      it.setNombre("Walter");
      it.setApellido("White");
      it.setTelefono(121432432);
      it.setEmail("ww@gmail.com");
    };
    Contacto _doubleArrow = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto, _function);
    Contacto _contacto_1 = new Contacto();
    final Procedure1<Contacto> _function_1 = (Contacto it) -> {
      it.setNombre("Rick");
      it.setApellido("Grimes");
      it.setTelefono(546768572);
      it.setEmail("rg@gmail.com");
    };
    Contacto _doubleArrow_1 = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto_1, _function_1);
    Contacto _contacto_2 = new Contacto();
    final Procedure1<Contacto> _function_2 = (Contacto it) -> {
      it.setNombre("Barry Allen");
      it.setApellido("White");
      it.setTelefono(3465465);
      it.setEmail("ba@gmail.com");
    };
    Contacto _doubleArrow_2 = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto_2, _function_2);
    Contacto _contacto_3 = new Contacto();
    final Procedure1<Contacto> _function_3 = (Contacto it) -> {
      it.setNombre("Tim");
      it.setApellido("Drake");
      it.setTelefono(89785663);
      it.setEmail("td@gmail.com");
    };
    Contacto _doubleArrow_3 = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto_3, _function_3);
    return this.contactos = CollectionLiterals.<Contacto>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2, _doubleArrow_3);
  }
  
  public boolean agregarContacto(final Contacto contacto) {
    return this.contactos.add(contacto);
  }
  
  @Pure
  public List<Contacto> getContactos() {
    return this.contactos;
  }
  
  public void setContactos(final List<Contacto> contactos) {
    this.contactos = contactos;
  }
}
