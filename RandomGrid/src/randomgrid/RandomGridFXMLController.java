/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author dale
 */
public class RandomGridFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    CheckerBoard checkerBoard;
    
    //private final Color[] colors = {Color.RED, Color.BLACK};
    private final Color[] colorsBlue = {Color.SKYBLUE, Color.DARKBLUE};
    
    
    @FXML
    private AnchorPane anchorPane;
    
    
    private int numRows = 8;
    private int numCols = 8; 
    
    private boolean isBlue = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println(anchorPane.getWidth());
    } 
    
    public void start(Stage stage) {
        this.stage = stage;
        checkerBoard = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        
        getAnchorPane().getChildren().add(checkerBoard.build());
                
        
        
        
       
        this.stage.heightProperty().addListener(new ChangeListener <Number>(){
           @Override
             public void changed(ObservableValue <? extends Number> observable, Number oldValue, final Number newValue){
                 refresh();
                 //getAnchorPane().getChildren().add(checkerBoard.build());
                }
        });
        
        this.stage.widthProperty().addListener(new ChangeListener <Number>(){
           @Override
             public void changed(ObservableValue <? extends Number> observable, Number oldValue, final Number newValue){
                 refresh();
                 //getAnchorPane().getChildren().add(checkerBoard.build());
                }
        });
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) ->{
          refresh();
          getAnchorPane().getChildren().add(checkerBoard.build());
        }; 
                
        this.stage.widthProperty();
        this.stage.heightProperty();
        
        //refresh();
        //getAnchorPane().getChildren().add(checkerBoard.build());
        
    }

    @FXML
    private void resize16x16(ActionEvent event) {
        System.out.println("16x16");
        numRows=16;
        numCols=16;
        refresh();
    }
    
    @FXML
    private void resize10x10(ActionEvent event) {
        System.out.println("10x10");
        numRows=10;
        numCols=10;
        refresh();
        //CheckerBoard.clearAnchorPane();
    }
    
     @FXML
    private void resize8x8(ActionEvent event) {
        System.out.println("8x8");
        numRows=8;
        numCols=8;
        refresh();
        //CheckerBoard.clearAnchorPane();
    } 
    @FXML
    private void resize3x3(ActionEvent event) {
        System.out.println("3x3");
        numRows=3;
        numCols=3;
        refresh();
        //CheckerBoard.clearAnchorPane();
    }
    
     @FXML
    private void changeRedBlack(ActionEvent event) {
        System.out.println("red and black");
        isBlue = false;
        refresh();
    }
    
     @FXML
    private void changeBlue(ActionEvent event) {
        System.out.println("blue");
        isBlue = true;
        refresh();
    }
    
    private void refresh() {
        clearAnchorPane();
        if(isBlue){
            checkerBoard = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight(), colorsBlue[0], colorsBlue[1]);
        }
        else{
            checkerBoard = new CheckerBoard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());   
        }
        getAnchorPane().getChildren().add(checkerBoard.build());
    }
    
    private void clearAnchorPane() {
        
        //if(getAnchorPane() != null)
            getAnchorPane().getChildren().clear();
    }

    /**
     * @return the anchorPane
     */
    public AnchorPane getAnchorPane() {
        if(anchorPane!=null)
            return anchorPane;
        else
            return null;
    }
   
    
    
}
