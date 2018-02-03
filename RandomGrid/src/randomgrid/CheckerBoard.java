/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author gambi
 */
public class CheckerBoard {
    
    @FXML
    
    
    private Color[] colors = {Color.BLACK, Color.RED};
    
    private double boardWidth;
    private double boardHeight;
    private int numRows;
    private int numCols;
    
    private AnchorPane anchorPane = new AnchorPane();
    private RandomGridFXMLController controller = new RandomGridFXMLController();
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.numCols = numCols;
        this.numRows = numRows; 
        colors[0] = lightColor;
        colors[1] = darkColor;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight=boardHeight;
        this.numRows=numRows;
        this.numCols=numCols;
        
    }
    
    public AnchorPane build(){
        
       //Random rn = new Random();
        
        double rectWidth = boardWidth / numCols;
        double rectHeight =boardHeight / numRows;
        //Color color;
        
        int numColors = colors.length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if(row%2==0 && col%2==0 || row%2==1 && col%2==1){
                    Color color = colors[1];
                    Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                    rect.setY((rectHeight)*row);
                    rect.setX((rectWidth)*col);
                    anchorPane.getChildren().add(rect);
                }
                else{
                    Color color = colors[0];
                    Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                    rect.setY((rectHeight)*row);
                    rect.setX((rectWidth)*col);
                    anchorPane.getChildren().add(rect);
                }
                
            }
        }        
       
        //anchorPane.getChildren().add(rect);
        
        return anchorPane;
    }
    
    
    
   

    
}
