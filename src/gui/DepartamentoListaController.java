package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;
import model.services.DepartamentService;

public class DepartamentoListaController implements Initializable {

	//criando uma dependencia com classe DepartamentService
	//temos ingetar a dependencia na classe
	@FXML
	DepartamentService service;// new DepartamentService(); nao vamos instanciar, pelo fato nao é boa pratica fazer um acoplamento forte
	@FXML
	private TableView<Departamento> tableViewDepartamento;
	@FXML 
	TableColumn<Departamento, Integer> tableColumnId;
	@FXML
	TableColumn<Departamento, String> tableColumnNome;
	@FXML
	private Button btnNovo;
	
	//vamos pegar service, carregar nossos departamentos, e mostrar dentro do tableViewm pelo obj tableViewDepartament
	//vamos carregar o departamento numa ObservableList, toda a lista de departamentos
	private ObservableList<Departamento> obsList;
		
	@FXML
	public void btnNewAction() {
		System.out.println("btnnewAction");
	}
	
	//ingetando a dependencia com set. "dessa forma nao faremos um acoplamento forte"
	public void setDepartamentService(DepartamentService service) {
		this.service=service;
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
		
	}
	//Fazendo a tabela funcionar
	private void initializeNodes() {
		//padrão do javaFx para inicializar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		//referencia para Stage, pegando uma referencia para stage
		Stage stage = (Stage) Main.getMainScene().getWindow();
		//fazer o TableView acompanhar a altura da janela
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
	}
	
	//metodo responsavel por acessar o serviço carregar os departamentos, e jogar os departamento na ObservableList
	//ObservableLList tera q ser associado ao TableView, os departamentos serm exibidos na tela
	public void updateTableView() {
		if(service==null) {//a ingeção de dependencia está manual, nao estamos usando framework ou container automatico
			throw new IllegalStateException("O servço está null");
		}
		List<Departamento> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartamento.setItems(obsList);
	}
	
}
