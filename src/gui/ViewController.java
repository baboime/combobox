package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entidades.Pessoa;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	
	@FXML
	private Button btExibirTudo;

	private ObservableList<Pessoa> obsLista;
	
	@FXML
	public void onBtExibirTudo() {
		for (Pessoa pessoas : comboBoxPessoa.getItems()) {
			System.out.println(pessoas);
		}
	}
	
	@FXML
	public void onComboBoxPessoa() {
		Pessoa pessoa = comboBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		List<Pessoa> lista = new ArrayList<>();

		lista.add(new Pessoa(1, "Maria", "maria@gmail.com"));
		lista.add(new Pessoa(2, "Alex", "alex@gmail.com"));
		lista.add(new Pessoa(3, "Bob", "bob@gmail.com"));

		obsLista = FXCollections.observableArrayList(lista);

		comboBoxPessoa.setItems(obsLista);

		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getNome());
			}
		};
		comboBoxPessoa.setCellFactory(factory);
		comboBoxPessoa.setButtonCell(factory.call(null));
	}
}
