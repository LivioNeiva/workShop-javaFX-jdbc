package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemDepartamento;
	@FXML
	private MenuItem menuItemSair;
	
	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("onMenuItemVendedorAction");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		loadView("/gui/DepartamentoList.fxml");
	}
	
	@FXML
	public void onMenuItemSairAction() {
		loadView("/gui/Sair.fxml");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			//mostrar a Sair.fxml dentro da janela principal, temos pegar uma referencia da Scene
			//vamos expor uma referencia para scene q está classe Main.java
			Scene mainScene = Main.getMainScene();
			
			//guardando uma referencia para menu.
			/*
			 *  classe Node(nó). Ela é a classe pai(mãe?) de tudo que está em uma aplicação
			 *  JavaFX: textos, formas geométricas, botões, tabelas, gerenciadores de layout 
			 *  que contém outros nós, etc...
			 */
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();//limpando todos os filhos mainVBox
			mainVBox.getChildren().add(mainMenu);//adicionando mainMenu no nainVBox
			mainVBox.getChildren().addAll(newVBox.getChildren());//add filhos newVBox no mainMenu
			
		}
		catch(IOException ex) {
			Alerts.showAlerts("IO Exception", "Erro ao abrir MainView", ex.getMessage(), AlertType.ERROR);
		}
		
	}

}
