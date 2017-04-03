package Drawing;

import Node.Node;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ParallelogramStrategy implements NodeDrawingStrategy {

	@Override
	public Pane drawNode(Node node, Color outline, Color fill) {
		
		double x = node.getCoordinates().getX();
		double y = node.getCoordinates().getY();
		
		Polygon p = new Polygon(x, y, x+100, y, x+80, y+50, x-20, y+50); 
		p.setStrokeType(StrokeType.OUTSIDE);
		p.setStroke(outline);
		p.setFill(fill);
		
		Text text = new Text(node.getName());
		text.setFont(new Font(10));
		//text.setBoundsType(TextBoundsType.VISUAL);
		
		Text description = new Text("description");
		description.setFont(new Font(8));
		//description.setBoundsType(TextBoundsType.VISUAL);
		description.setFill(Color.GRAY);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(text, description);
		vBox.setAlignment(Pos.CENTER);
		
		StackPane stack = new StackPane();
		stack.getChildren().addAll(p, vBox);
		
		return stack;
	}

}
