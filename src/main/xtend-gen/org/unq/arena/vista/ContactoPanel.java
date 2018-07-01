package org.unq.arena.vista;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Container;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class ContactoPanel extends Panel {
  private String scope;
  
  public ContactoPanel(final Container container, final String scope) {
    super(container);
    this.scope = scope;
    this.agregarInputs();
  }
  
  public TextBox agregarInputs() {
    TextBox _xblockexpression = null;
    {
      this.agregarInput("Nombre y Apellido", "nombreYApellido", Boolean.valueOf(false));
      this.agregarInput("Email", "email", Boolean.valueOf(false));
      _xblockexpression = this.agregarInput("Telfono", "telefono", Boolean.valueOf(true));
    }
    return _xblockexpression;
  }
  
  public TextBox agregarInput(final String label, final String campo, final Boolean numeric) {
    TextBox _xblockexpression = null;
    {
      final Panel hpanel = new Panel(this);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      hpanel.setLayout(_horizontalLayout);
      Label _label = new Label(hpanel);
      final Procedure1<Label> _function = (Label it) -> {
        it.setText((label + ":"));
        it.alignRight();
        it.setWidth(140);
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      TextBox _xifexpression = null;
      if ((numeric).booleanValue()) {
        _xifexpression = new NumericField(hpanel);
      } else {
        _xifexpression = new TextBox(hpanel);
      }
      final TextBox field = _xifexpression;
      final Procedure1<TextBox> _function_1 = (TextBox it) -> {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, (this.scope + campo));
      };
      _xblockexpression = ObjectExtensions.<TextBox>operator_doubleArrow(field, _function_1);
    }
    return _xblockexpression;
  }
}
