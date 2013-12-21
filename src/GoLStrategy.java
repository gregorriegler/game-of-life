public class GoLStrategy implements LifeStrategy {
    @Override
    public boolean willLive(boolean alive, int livingNeighbours) {
        return alive && !underpopulated(livingNeighbours) && !overcrowded(livingNeighbours) ||
                !alive && livingNeighbours == 3;
    }

    private boolean overcrowded(int livingNeighbours) {
        return livingNeighbours > 3;
    }

    private boolean underpopulated(int livingNeighbours) {
        return livingNeighbours < 2;
    }
}
