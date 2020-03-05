package com.vinstorm.javafx_experiments.dev.vinayak.aaaan;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene;
	
	TableView<Product> table;
	
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("TableView Test");
		
		//Name Column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Quantity Column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(200);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		//Price Column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(200);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, quantityColumn, priceColumn);
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(table);
		
		Scene scene = new Scene(stackPane);
		window.setScene(scene);
		window.show();
	}
	
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 12, 899.99));
		products.add(new Product("Apple", 3488, 1.19));
		products.add(new Product("Usb Stick 16GB", 76, 17.99));
		products.add(new Product("Socks", 946, 2.99));
		products.add(new Product("PC Mouse", 4, 35.95));
		products.add(new Product("HDMI Cable 2M", 25, 9.99));
		return products;
	}
}
