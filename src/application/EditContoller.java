package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class EditContoller {
	@FXML
	private TextField tbFio;
	@FXML
	private TextField tbPhone;
	@FXML
	private Button btnAddNew;
	@FXML
	private Button btnCancel;
	
	private Person person;
	
	public void actionClose(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage scene = (Stage) source.getScene().getWindow();
		scene.close();
	}
	
	public void actionSave(ActionEvent event) {
		person.setFio(tbFio.getText());
		person.setPhone(tbPhone.getText());
		actionClose(event);
	}
	
	public void setPerson(Person person) {
		this.person = person;
		tbFio.setText(person.getFio());
		tbPhone.setText(person.getPhone());
	}

}
