import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GolStrategyTest {

    LifeStrategy lifeStrategy = new GoLStrategy();

    @Test
    public void livingWithZeroNeighbour_dies() throws Exception {
        assertWillLive(true, 0, false);
    }

    @Test
    public void livingWithOneNeighbour_dies() throws Exception {
        assertWillLive(true, 1, false);
    }

    @Test
    public void livingWithTwoNeighbours_lives() throws Exception {
        assertWillLive(true, 2, true);
    }

    @Test
    public void livingWithThreeNeighbours_lives() throws Exception {
        assertWillLive(true, 3, true);
    }

    @Test
    public void livingWithFourNeighbours_dies() throws Exception {
        assertWillLive(true, 4, false);
    }

    @Test
    public void deadWithFourNeighbours_staysDead() throws Exception {
        assertWillLive(false, 4, false);
    }

    @Test
    public void deadWithThreeNeighbours_comesAlive() throws Exception {
        assertWillLive(false, 3, true);
    }

    private void assertWillLive(boolean alive, int livingNeighbours, boolean expected) {
        assertEquals(lifeStrategy.willLive(alive, livingNeighbours), expected);
    }
}
