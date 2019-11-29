package layouts_gridpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author JorgeLPR
 */
public class Layouts_GridPane extends Application {
    
    int tipo = 1;    
    
    @Override
    public void init(){
    
        try{

            tipo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione \n"+
                                               "1- Ejemplo # 1 - Distribución uniforme.\n"+
                                               "2- Ejemplo # 2 - Propiedad RowSpan y ColumnSpan."));
            switch(tipo){
                case 1: 
                    tipo=1;
                break;
                
                case 2: 
                    tipo=2;
                break;
                
                default:
                    tipo=1;
                break;
            }            
            
        }catch(NumberFormatException ex){
            tipo=1;
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        
        //Creamos los nodos Hijos
        Button btn1 = new Button("BOTON # 1");
        Button btn2 = new Button("BOTON # 2");
        Button btn3 = new Button("BOTON # 3");        
        Button btn4 = new Button("BOTON # 4");
        Button btn5 = new Button("BOTON # 5");
        Button btn6 = new Button("BOTON # 6");
                
        //Creamos el nodo raiz GridPane
        GridPane root = new GridPane();

        //Agregamos nodos en la FILA 0
        GridPane.setColumnIndex(btn1, 0);
        GridPane.setRowIndex(btn1, 0);  

        GridPane.setConstraints(btn5, 1, 1);
        GridPane.setConstraints(btn6, 2, 1);
        
        if(tipo==1){

            GridPane.setConstraints(btn2, 1, 0);                    
            GridPane.setConstraints(btn3, 2, 0);

            //Agregamos nodos en la FILA 1
            GridPane.setConstraints(btn4, 0, 1);

            root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
            
        }else{

            GridPane.setRowSpan(btn1, 2);
            btn1.setMaxHeight(Double.MAX_VALUE);

            GridPane.setConstraints(btn2, 1, 0, 2, 1);
            btn2.setMaxWidth(Double.MAX_VALUE);

            //agregamos nodos hijos al nodo raiz
            root.getChildren().addAll(btn1, btn2, btn5, btn6);
                        
        }

        //aplicamos espacios horizontal y verticalmente
        root.setHgap(10);
        root.setVgap(10);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("GridPane - Layout");
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
