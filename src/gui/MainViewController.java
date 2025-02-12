
	package gui;

	import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

	public class MainViewController implements Initializable {

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
			System.out.println("onMenuDepartmentAction");
		}

		@FXML
		public void onMenuItemAboutAction() {
			System.out.println("onMenuAboutAction");
		}
		
		@Override
		public void initialize(URL url, ResourceBundle rb) {

		}

	
}
