
	package gui;

	import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartmentService;

	public class MainViewController implements Initializable {
		
		//FUNCAO PARA ABRIR OUTRA TELA
		
		
		

		// BASE DE TODA A COMUNICAÇÃO COM A GUI, ESSE ATRIBUTOS SÃO IMPORTANTES.
		
		@FXML
		private MenuItem menuItemSeller;
		
		@FXML
		private MenuItem menuItemDepartment;
		
		@FXML
		private MenuItem menuItemAbout;

		
		//METODOS IMPORTANTES DE CONTROLE E COMUNICAÇÃO COM INTERFACE GUI
		
		@FXML
		public void onMenuItemSellerAction() {
			System.out.println("onMenuSellerAction");
		}

		@FXML
		public void onMenuItemDepartmentAction() {
			loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
				controller.setDepartmentService(new DepartmentService());
				controller.updateTableView();
			});
		}

		@FXML
		public void onMenuItemAboutAction() {
			loadView("/gui/About.fxml",  x->{}) ;{
				
			}
		}
		
		@Override
		public void initialize(URL url, ResourceBundle rb) {

		}
		private synchronized <T>void loadView(String absolutname, Consumer<T> initializingAction) {
			try {
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource(absolutname));
					VBox newVBox = loader.load();
				Scene mainScene = Main.getMainScene();
				VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
				Node mianMenu = mainVBox.getChildren().get(0);
				
				mainVBox.getChildren().clear();
				
				mainVBox.getChildren().add(mianMenu);
				mainVBox.getChildren().addAll(newVBox.getChildren());
				
			T controller = 	loader.getController();
			initializingAction.accept(controller);
				
			}
			catch (IOException e) {
				Alerts.showAlert("IoException","Error no carregamento da pagina", e.getMessage(), AlertType.ERROR);
			}
		}
		
		
		private synchronized void loadView2(String absolutname) {
			try {
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource(absolutname));
					VBox newVBox = loader.load();
				Scene mainScene = Main.getMainScene();
				VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
				Node mianMenu = mainVBox.getChildren().get(0);
				
				mainVBox.getChildren().clear();
				
				mainVBox.getChildren().add(mianMenu);
				mainVBox.getChildren().addAll(newVBox.getChildren());
				DepartmentListController controller = loader.getController();
				controller.setDepartmentService(new DepartmentService());
				controller.updateTableView();
			}
			catch (IOException e) {
				Alerts.showAlert("IoException","Error no carregamento da pagina", e.getMessage(), AlertType.ERROR);
			}
		}
			

	
}
