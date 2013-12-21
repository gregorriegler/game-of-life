import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WorldTest {

    private MockLifeStrategy mockLifeStrategy;
    private World world;

    @BeforeMethod
    public void setUp() throws Exception {
        mockLifeStrategy = new MockLifeStrategy();
        world = new World(mockLifeStrategy, 100, 100);
    }

    @Test
    public void canGetCellFromWorld() throws Exception {
        assertNotNull(world.at(0, 0));
        assertNotNull(world.at(99, 99));
    }

    @Test
    public void canCreateNextGeneration() throws Exception {
        World nextWorld = world.nextGen();
        assertNotSame(nextWorld, world);
    }

    @Test
    public void nextGenerationHasBeingsNextState() throws Exception {
        World nextWorld = world.nextGen();
        assertTrue(nextWorld.at(2, 2).isAlive());
        assertTrue(nextWorld.at(31, 20).isAlive());
        assertTrue(nextWorld.at(99, 99).isAlive());
    }

    @Test
    public void worldIsCorrectlyCountingZeroNeighbours() throws Exception {
        world.nextGen();
        assertEquals(0, mockLifeStrategy.getGivenAmountOfLivingNeighbours());
    }

    @Test
    public void worldIsCorrectlyCountingThreeNeighbours() throws Exception {
        world.at(98, 98).setAlive(true);
        world.at(99, 98).setAlive(true);
        world.at(98, 99).setAlive(true);
        world.nextGen();
        assertEquals(3, mockLifeStrategy.getGivenAmountOfLivingNeighbours());
    }
}
