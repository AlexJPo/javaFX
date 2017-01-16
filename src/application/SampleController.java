package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import application.CollectionAdresBook;

public class SampleController {
	private CollectionAdresBook cab = new CollectionAdresBook();
	
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnEdit;	
	@FXML
	private Button btnDelete;
	
	@FXML
	private Button btnSearch;	
	@FXML
	private TextField tbSearch;
	
	@FXML
	private TableView<Person> personsTable;
	@FXML
	private TableColumn<Person, String> columnFio;
	@FXML
	private TableColumn<Person, String> columnPhone;
	
	@FXML
	private Label totalPersons;
	
	private Parent fxmlEdit;
	private FXMLLoader fxmlLoader = new FXMLLoader();
	private EditContoller editDialogController;
	private Stage editDialogStage;	
	
	@FXML
	private void initialize() {
		columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
		
		cab.FillTestData();
		
		personsTable.setItems(cab.getPersonList());
		updateCountLabel();
		
		
		try {
			fxmlLoader.setLocation(getClass().getResource("edit.fxml"));
			fxmlEdit = fxmlLoader.load();
			editDialogController = fxmlLoader.getController();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateCountLabel() {
		totalPersons.setText("Record count: " + cab.getPersonList().size());
	}
	
	public void actionButtonPressed(ActionEvent event)
	{
		Object source = event.getSource();
		
		if(!(source instanceof Button)) { return; }
		
		Button curentButton = (Button) source;
		Person selectedPerson = (Person)personsTable.getSelectionModel().getSelectedItem();
		Window parentWindow = ((Node) event.getSource()).getScene().getWindow();
		editDialogController.setPerson(selectedPerson);
		
		switch(curentButton.getId()) {
			case "btnAdd":
				System.out.println("add button - " + selectedPerson);
				break;
			case "btnEdit":
				ShowDialog(parentWindow);
				break;
			case "btnDelete":
				System.out.println("add button - " + selectedPerson);
				break;
		}
	}
	
	private void ShowDialog(Window parentWindow) {
		if (editDialogStage == null) {
			editDialogStage = new Stage();
			editDialogStage.setTitle("Edit person");
			editDialogStage.setMinWidth(300);
			editDialogStage.setMinHeight(150);
			editDialogStage.setResizable(false);
			editDialogStage.setScene(new Scene(fxmlEdit));
			editDialogStage.initOwner(parentWindow);			
		}
		
		editDialogStage.show();
	}
}
