package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	//vamos expor uma referencia para Scene, a referencia do Sair.fxml está sendo guardada no atributo mainScene
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {//ao instanciar o FXMLLoader temos instanciar a o arquivo fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();//carrega o loader no obj parent
			scrollPane.setFitToHeight(true);//ajustar a altura
			scrollPane.setFitToWidth(true);//ajustar largura
			mainScene = new Scene(scrollPane);//crio obj Scene q será minha tela principal, recebendo recebendo o parent
			primaryStage.setScene(mainScene);//Stage é palco principal da minha sena, recebo Scene mainScene
			primaryStage.setTitle("Aplicação em javaFX");//definindo titulo para palco
			primaryStage.show();//mostrar palco
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//metodo para pegar a referencia do Sair.fxml
	public static Scene  getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
/*
A grande diferença é a criação de uma Parent, baseada no layout FXML. Para
isto, usamos o FXMLLoader.load(URL url), onde passamos como argumento
o diretório do arquivo MainView.fxml. Dica: coloque-o na mesma pasta da classe criada.
Então, indicamos o Parent para uma Scene, como se fosse o nosso painel principal.
Volta mos a ressaltar: perceba a redução no código, com apenas 15 linhas (fora os
imports), criamos a inicialização da tela. Porém, ainda falta a segunda parte, sem
ela não podemos executar ações nos componentes, porémjá é possível executar esta
classe e veremos o layout.
*/