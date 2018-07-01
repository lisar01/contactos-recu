package org.unq.arena.vista;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.unq.arena.dominio.Contacto;
import org.unq.arena.dominio.ContactosAppModel;
import org.unq.arena.vista.ContactoPanel;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class ContactosMainWindow extends SimpleWindow<ContactosAppModel> {
  public ContactosMainWindow(final WindowOwner parent, final ContactosAppModel model) {
    super(parent, model);
    this.setTitle("Contactos");
  }
  
  @Override
  protected void addActions(final Panel actionsPanel) {
    final NotNullObservable elementSelected = new NotNullObservable("contactoSeleccionado");
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = (Button it) -> {
      it.setCaption("Favorito");
      final Action _function_1 = () -> {
        this.getModelObject().marcarDesmarcarFavorito();
      };
      it.onClick(_function_1);
      it.<Object, ControlBuilder>bindEnabled(elementSelected);
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  @Override
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    final Procedure1<Panel> _function = (Panel it) -> {
      ColumnLayout _columnLayout = new ColumnLayout(2);
      it.setLayout(_columnLayout);
    };
    final Panel panelColumn = ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
    this.crearPanelDeTablaDeContactos(panelColumn);
    this.crearPanelDeNuevoContacto(panelColumn);
  }
  
  public Column<Contacto> crearPanelDeTablaDeContactos(final Panel panelColumn) {
    Column<Contacto> _xblockexpression = null;
    {
      final Panel panel = new Panel(panelColumn);
      Table<Contacto> _table = new Table<Contacto>(panel, Contacto.class);
      final Procedure1<Table<Contacto>> _function = (Table<Contacto> it) -> {
        ViewObservable<Table<Contacto>, TableBuilder<Contacto>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "contactos");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "contactoSeleccionado");
      };
      final Table<Contacto> table = ObjectExtensions.<Table<Contacto>>operator_doubleArrow(_table, _function);
      Column<Contacto> _column = new Column<Contacto>(table);
      final Procedure1<Column<Contacto>> _function_1 = (Column<Contacto> it) -> {
        it.setTitle("Nombre y Apellido");
        it.alignRight();
        it.bindContentsToProperty("nombreYApellido");
      };
      ObjectExtensions.<Column<Contacto>>operator_doubleArrow(_column, _function_1);
      Column<Contacto> _column_1 = new Column<Contacto>(table);
      final Procedure1<Column<Contacto>> _function_2 = (Column<Contacto> it) -> {
        it.setTitle("Favorito");
        it.bindContentsToProperty("esFavorito");
      };
      _xblockexpression = ObjectExtensions.<Column<Contacto>>operator_doubleArrow(_column_1, _function_2);
    }
    return _xblockexpression;
  }
  
  public ContactoPanel crearPanelDeNuevoContacto(final Panel panel) {
    ContactoPanel _xblockexpression = null;
    {
      GroupPanel _groupPanel = new GroupPanel(panel);
      final Procedure1<GroupPanel> _function = (GroupPanel it) -> {
        it.setTitle("Nuevo Contacto");
      };
      final GroupPanel groupPanel = ObjectExtensions.<GroupPanel>operator_doubleArrow(_groupPanel, _function);
      _xblockexpression = new ContactoPanel(groupPanel, "contactoNuevo.");
    }
    return _xblockexpression;
  }
}
