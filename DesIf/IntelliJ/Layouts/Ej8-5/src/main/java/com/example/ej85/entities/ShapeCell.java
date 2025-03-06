package com.example.ej85.entities;

import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class ShapeCell extends ListCell<String>
{
    @Override
    public void updateItem(String item, boolean empty)
    {
        super.updateItem(item, empty);

        if (empty)
        {
            setText(null);
            setGraphic(null);
        }
        else
        {
            setText(item);
            Shape shape = this.getShape(item);
            setGraphic(shape);
        }
    }

    public Shape getShape(String shapeType)
    {
        return switch (shapeType.toLowerCase()) {
            case "line" -> new Line(0, 10, 20, 10);
            case "rectangle" -> new Rectangle(0, 0, 20, 20);
            case "circle" -> new Circle(20, 20, 10);
            case "text" -> new Text(10, 50, "This is a Text");
            default -> null;
        };
    }
}