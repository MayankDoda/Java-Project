package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class PendulumPane extends Pane {
    Circle ball;
    Circle suspension;
    Line thread;

    int angle;
    double threadLength;
    boolean flag;

    PendulumPane(){
        suspension = new Circle();
        setSuspensionRadius(5);
        suspension.setFill(Color.GRAY);

        ball = new Circle();
        setBallRadius(17.5);
        ball.setFill(Color.LIGHTGRAY);
        ball.setStroke(Color.GRAY);
        ball.setStrokeWidth(0.5);

        thread = new Line();
        thread.setStrokeWidth(2);
        thread.setStroke(Color.GRAY);
        threadLength = 150;

        angle = 120;
        flag = true;
    }
    public void setBallRadius(double radius){
        if(ball != null)
            ball.setRadius(radius);
    }

    public void setSuspensionRadius(double radius){
        if(suspension != null)
           suspension.setRadius(radius);
    }
    public void setThreadLength(double length){
        threadLength = length;
    }

    public void setCoordinateSuspension(double x, double y){
        suspension.setCenterX(x);
        suspension.setCenterY(y);
    }

    public void setCoordinateBall(double x, double y){
        ball.setCenterX(x);
        ball.setCenterY(y);
    }

    public void next(){
        double xBall = suspension.getCenterX() + threadLength * Math.cos(Math.toRadians(angle));
        double yBall = suspension.getCenterY() + threadLength * Math.sin(Math.toRadians(angle));
        setCoordinateBall(xBall, yBall);
        thread.setEndX(suspension.getCenterX());
        thread.setEndY(suspension.getCenterY());
        thread.setStartX(ball.getCenterX());
        thread.setStartY(ball.getCenterY());
        getChildren().clear();
        getChildren().addAll(thread, suspension, ball);

        angle = flag ? angle - 1 : angle + 1;
        if(angle == 120)
            flag = true;
        else if(angle == 60)
            flag = false;
    }
}
