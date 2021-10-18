
package pkg4.pkg3.pkg7fadetransition;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import static javafx.application.Application.launch;
import javafx.util.Duration;

/**
 *
 * @author Iván Zambrana Naranjo
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Setting title
        primaryStage.setTitle("FadeTransition");
       
        //Creating an ellipse
        Ellipse ellipse = new Ellipse(150, 150, 100, 80);
        ellipse.setFill(javafx.scene.paint.Color.RED);

        // Aplying fade transition to a elipse
        FadeTransition ft = new FadeTransition(Duration.millis(3000),ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        
        // Start animation
        ft.play();
        
        // Control animation
        ellipse.setOnMousePressed(e->ft.pause());
        ellipse.setOnMouseReleased(e->ft.play());   
        
        //Pane
        Pane root = new Pane();
        
        root.getChildren().add(ellipse);        
        Scene scene = new Scene(root, 300, 250);
        
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