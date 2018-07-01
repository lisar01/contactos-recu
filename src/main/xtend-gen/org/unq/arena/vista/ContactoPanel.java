package org.unq.arena.vista;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Container;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
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
      final Panel hpanel = new Panel(this);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      hpanel.setLayout(_horizontalLayout);
      Label _label = new Label(hpanel);
      _label.setText("Nombre");
      TextBox _textBox = new TextBox(hpanel);
      final Procedure1<TextBox> _function = (TextBox it) -> {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "contactoNuevo.nombre");
      };
      _xblockexpression = ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    }
    return _xblockexpression;
  }
}
