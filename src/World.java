import java.util.HashMap;
import java.util.Map;

public class World {

    private int width;
    private int height;
    private LifeStrategy lifeStrategy;

    private Map<Coordinate, Cell> cells = new HashMap<Coordinate, Cell>();

    private static final int[][] neighbourMap = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {+1, 0},
            {-1, 1}, {0, 1}, {1, 1}
    };

    public World(LifeStrategy lifeStrategy, int width, int height) {
        this.width = width;
        this.height = height;
        this.lifeStrategy = lifeStrategy;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells.put(new Coordinate(x, y), new Cell(lifeStrategy));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell at(int x, int y) {
        return cells.get(new Coordinate(x, y));
    }

    public Cell at(Coordinate coordinate) {
        return cells.get(coordinate);
    }

    public World nextGen() {
        World nextWorld = new World(this.lifeStrategy, this.width, this.height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Coordinate coordinate = new Coordinate(x, y);
                nextWorld.at(coordinate).setAlive(willLive(coordinate));
            }
        }

        return nextWorld;
    }

    private boolean willLive(Coordinate coordinate) {
        return at(coordinate).willLive(countLivingNeighbours(coordinate));
    }

    private int countLivingNeighbours(Coordinate coordinate) {
        assert (coordinate != null);
        int livingNeighbours = 0;
        for (int[] n : neighbourMap) {
            Cell neighbour = at(coordinate.getX() + n[0], coordinate.getY() + n[1]);
            if (neighbour != null && neighbour.isAlive()) {
                livingNeighbours++;
            }
        }
        return livingNeighbours;
    }

}
