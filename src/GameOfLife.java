import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class GameOfLife extends Application {

    World world;
    WorldCanvas canvas;
    AnimationTimer animationTimer;

    public static void main(String... args) throws InterruptedException {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        world = new World(new GoLStrategy(), 250, 250);
        randomInitialization(this.world);
        canvas = new WorldCanvas(2, world);
        Group game = new Group(canvas);
        stage.setScene(new Scene(game));
        stage.show();

        animationTimer = new AnimationTimer() {
            public void handle(long arg0) {
                gameLoop();
            }
        };

        animationTimer.start();
    }

    private void gameLoop() {
        world = world.nextGen();
        canvas.drawWorld(world);
    }

    private void randomInitialization(World world) {
        Random random = new Random();
        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                world.at(x, y).setAlive(random.nextBoolean());
            }
        }
    }
}
