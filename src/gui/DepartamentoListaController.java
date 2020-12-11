package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;

public class DepartamentoListaController implements Initializable {

	@FXML
	private TableView<Departamento> tableViewDepartamento;
	@FXML 
	TableColumn<Departamento, Integer> tableColumnId;
	@FXML
	TableColumn<Departamento, String> tableColumnNome;
	@FXML
	private Button btnNovo;
	
	@FXML
	public void btnnewAction() {
		System.out.println("btnnewAction");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
		
	}
	//Faendo a tabela funcionar
	private void initializeNodes() {
		//padrão do javaFx para inicializar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		//referencia para Stage, pegando uma referencia para stage
		Stage stage = (Stage) Main.getMainScene().getWindow();
		//fazer o TableView acompanhar a altura da janela
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
		
		
		
	}

	
}
