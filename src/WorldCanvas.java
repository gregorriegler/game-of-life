import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class WorldCanvas extends Canvas {

    private int cellSize;

    public WorldCanvas(int cellSize, World world) {
        super(world.getWidth() * cellSize, world.getHeight() * cellSize);
        this.cellSize = cellSize;
        drawWorld(world);
    }

    public void drawWorld(World world) {
        this.getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
        this.getGraphicsContext2D().setFill(Color.GREEN);
        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                if (world.at(x, y).isAlive()) {
                    drawCell(x, y);
                }
            }
        }
    }

    private void drawCell(int x, int y) {
        this.getGraphicsContext2D().fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
    }


}
