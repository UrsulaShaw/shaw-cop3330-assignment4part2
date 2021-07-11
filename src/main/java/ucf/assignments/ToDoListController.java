package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ursula Shaw
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {
    @FXML
    public Button addItemButton;
    @FXML
    public DatePicker dueDatePicker;
    @FXML
    public TextField newItemDescription;
    @FXML
    public ListView<Item> itemList;
    @FXML
    public Button saveListButton;
    @FXML
    public Button loadListButton;
    @FXML
    public ToggleButton viewAllToggleButton;
    @FXML
    public ToggleButton viewUncompletedToggleButton;
    @FXML
    public ToggleButton viewCompletedToggleButton;
    @FXML
    public Button removeSelected;
    @FXML
    public Button removeAll;
    @FXML
    public Button markCompleted;
    @FXML
    public Button markUncompleted;
    @FXML
    public Button editItemDesc;
    @FXML
    public Button changeDueDate;

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        addItem();
    }

    private void addItem() {
        toDoList.add(new Item(dueDatePicker.getValue(), newItemDescription.getText()));
        itemList.setItems(toDoList);
        refresh();
    }

    @FXML
    public void saveListButtonClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void loadListButtonClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void viewAllClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void viewUncompletedClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void viewCompletedClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void removeSelectedClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void removeAllClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void markCompletedClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void markUncompletedClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void editItemDescClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void changeDueDateClicked(ActionEvent actionEvent) {
    }


    private void refresh() {
        dueDatePicker.setValue(LocalDate.now());
        newItemDescription.setText(null);
    }

    ObservableList<Item> toDoList = FXCollections.observableArrayList();

    public Object[] getItems() {
        return itemList.getItems().toArray();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            var items = ItemSerializer.deserialize();
            itemList.getItems().addAll(items);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("To-Do List Alert");
            alert.setHeaderText("Error loading items from file system.");
        }
    }
    
}
