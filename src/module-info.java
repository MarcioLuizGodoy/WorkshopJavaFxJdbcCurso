module WorkshopJavafxJdbc {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	//ESSAS DUAS LINHAS FORAM ADICIONADAS APOS UMA EXCESSAO. A CORREÇÃO VEIO DE DICA DO CHATGPT
	  opens gui to javafx.fxml;
	  exports gui;
}
