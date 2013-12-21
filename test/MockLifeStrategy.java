public class MockLifeStrategy implements LifeStrategy {

    private int givenAmountOfLivingNeighbours;

    public boolean willLive(boolean alive, int livingNeighbours) {
        this.givenAmountOfLivingNeighbours = livingNeighbours;
        return true;
    }

    public int getGivenAmountOfLivingNeighbours() {
        return givenAmountOfLivingNeighbours;
    }
}
