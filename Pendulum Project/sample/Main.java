package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    boolean isPlaying;

    @Override
    public void start(Stage primaryStage) throws Exception{
        PendulumPane pane = new PendulumPane();
        pane.setSuspensionRadius(5);
        pane.setCoordinateSuspension(150, 20);
        pane.setStyle(" -fx-border-color: GRAY;" +
                "       -fx-background-color: aliceblue;");

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("./sample/pendulum.png"));
        primaryStage.show();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), e->{
            pane.next();
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        isPlaying = true;

        pane.setOnMouseClicked(e->{

        });
        pane.requestFocus();
        pane.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.SPACE && isPlaying) {
                animation.stop();
                isPlaying = false;
            } else if(e.getCode() == KeyCode.SPACE && !isPlaying) {
                animation.play();
                isPlaying = true;
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
