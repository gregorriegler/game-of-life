public class Cell {

    private boolean alive;

    private LifeStrategy lifeStrategy;

    public Cell(LifeStrategy lifeStrategy) {
        this.lifeStrategy = lifeStrategy;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }

    public boolean willLive(int livingNeighbours) {
        return lifeStrategy.willLive(alive, livingNeighbours);
    }

}
