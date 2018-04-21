/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application{
    Game g = new Game();
    @Override
    public void start(Stage primaryStage) {
        g.addNum();
        BorderPane root2 = new BorderPane();             
        root2.getChildren().add(g.getImage());
        Scene scene = new Scene(root2, 1000, 600);
        scene.setOnKeyPressed((KeyEvent event) -> {
            if(g.isover()){
                root2.getChildren().remove(1);
                root2.getChildren().add(g.getGameoverImage());
            }else{
                if(event.getCode()== KeyCode.LEFT)
                {
                    String olds = g.statestring();
                    g.pushUp();
                    String news = g.statestring();
                    if(!olds.equals(news))
                        g.addNum();
                    //root2.getChildren().remove(1);  
                    root2.getChildren().add(g.getImage());
                } 
                if(event.getCode()== KeyCode.DOWN)
                {
                    String olds = g.statestring();
                    g.pushright();
                    String news = g.statestring();
                    if(!olds.equals(news))
                        g.addNum();
                    //root2.getChildren().remove(1);  
                    root2.getChildren().add(g.getImage());
                } 
                if(event.getCode()== KeyCode.RIGHT)
                {
                    String olds = g.statestring();
                    g.pushdown();
                    String news = g.statestring();
                    if(!olds.equals(news))
                        g.addNum();
                   // root2.getChildren().remove(1);  
                    root2.getChildren().add(g.getImage());
                } 
                if(event.getCode()== KeyCode.UP)
                {
                    String olds = g.statestring();
                    g.pushleft();
                    String news = g.statestring();
                    if(!olds.equals(news))
                        g.addNum();
                    //root2.getChildren().remove(1);
                    root2.getChildren().add(g.getImage());
                }
            }
        });
        root2.getChildren().removeAll();
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
