package geometry;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class DesktopApplication extends Application {
	private static final int SCALE = 50;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		GeometricDrawing[] drawings = new GeometricDrawing[10];
		drawings[0] = new Rectangle(new Point(1,0), 1.5, 2);
		Pane root = new Pane();
		for (GeometricDrawing drawing : drawings) {
			Shape shape = drawing.createShape(SCALE);
			shape.setStroke(Color.BLACK);
			shape.setFill(Color.BLACK);
			root.getChildren().add(shape);
		}
		Scene scene = new Scene(root,500,500);
		primaryStage.setTitle("Geometry");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
