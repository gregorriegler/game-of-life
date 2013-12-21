import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CellTest {

    private MockLifeStrategy mockLifeStrategy = new MockLifeStrategy();
    private final Cell cell = new Cell(mockLifeStrategy);

    @Test
    public void canCreateDeadCell() throws Exception {
        assertFalse(cell.isAlive());
    }

    @Test
    public void canSetCellAlive() throws Exception {
        cell.setAlive(true);
        assertTrue(cell.isAlive());
    }

    @Test
    public void asksLifeStrategoyIfWillLive() throws Exception {
        int livingNeighbours = 999;
        assertTrue(cell.willLive(livingNeighbours));
        assertEquals(mockLifeStrategy.getGivenAmountOfLivingNeighbours(), livingNeighbours);
    }

}
