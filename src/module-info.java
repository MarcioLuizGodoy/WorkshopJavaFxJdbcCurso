module WorkshopJavafxJdbc {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	//ESSAS DUAS LINHAS FORAM ADICIONADAS APOS UMA EXCESSAO. A CORREÇÃO VEIO DE DICA DO CHATGPT
	  opens gui to javafx.fxml;
	  exports gui;
	  opens model.entities to javafx.fxml;
	  exports model.entities;
}
