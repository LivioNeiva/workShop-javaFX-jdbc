package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {//ao instanciar o FXMLLoader temos instanciar a o arquivo fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load();//carrega o loader no obj parent
			Scene mainScene = new Scene(parent);//crio obj Scene q ser� minha tela principal, recebendo recebendo o parent
			primaryStage.setScene(mainScene);//Stage � palco principal da minha sena, recebo Scene mainScene
			primaryStage.setTitle("Aplica��o em javaFX");//definindo titulo para palco
			primaryStage.show();//mostrar palco
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
/*
A grande diferen�a � a cria��o de uma Parent, baseada no layout FXML. Para
isto, usamos o FXMLLoader.load(URL url), onde passamos como argumento
o diret�rio do arquivo MainView.fxml. Dica: coloque-o na mesma pasta da classe criada.
Ent�o, indicamos o Parent para uma Scene, como se fosse o nosso painel principal.
Volta mos a ressaltar: perceba a redu��o no c�digo, com apenas 15 linhas (fora os
imports), criamos a inicializa��o da tela. Por�m, ainda falta a segunda parte, sem
ela n�o podemos executar a��es nos componentes, por�mj� � poss�vel executar esta
classe e veremos o layout.
*/