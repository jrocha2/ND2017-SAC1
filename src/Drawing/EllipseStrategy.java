package Drawing;

import Node.Node;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EllipseStrategy implements NodeDrawingStrategy {

	@Override
	public NodePane drawNode(Node node, Color outline, Color fill) {
		
		Rectangle rect = new Rectangle(0, 0, 100, 60);
		
		// Hard coded for now
		rect.setStroke(outline);
		rect.setFill(fill);
		rect.setArcHeight(100);
		rect.setArcWidth(100);
		
		Text text = new Text(node.getName());
		text.setFont(new Font(10));
		//text.setBoundsType(TextBoundsType.VISUAL);
		
		Text description = new Text("description");
		description.setFont(new Font(8));
		//description.setBoundsType(TextBoundsType.VISUAL);
		description.setFill(Color.GRAY);
		description.setWrappingWidth(45);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(text, description);
		vBox.setAlignment(Pos.CENTER);
		
		NodePane stack = new NodePane(node);
		stack.getChildren().addAll(rect, vBox);
		stack.setTranslateX(node.getCoordinates().getX());
		stack.setTranslateY(node.getCoordinates().getY());
		
		return stack;
	}

	@Override
	public void resize(Node node, boolean delete) {
		NodePane pane = node.getPane();
		Text t = ((Text)((VBox)pane.getChildren().get(1)).getChildren().get(1));
		Text description = new Text(node.getDescription());
		int length = description.getText().length();
		int r = 1, m = 1;
		
		if(t.getWrappingWidth() < 70){
			t.setWrappingWidth(70);
		}
		
		r = (length-45)%34;
		m = (length-45)/34;
		if(r==0 && delete == false){
			pane.getChildren().get(0).setScaleX(1.2 + m*0.2);
			pane.getChildren().get(0).setScaleY(1.2 + m*0.2);
			t.setWrappingWidth(t.getWrappingWidth() + 10);
		}else if(r==0){
			pane.getChildren().get(0).setScaleX(1.0 + m*0.2);
			pane.getChildren().get(0).setScaleY(1.0 + m*0.2);
			t.setWrappingWidth(t.getWrappingWidth() - 10);
		}
	}
}
