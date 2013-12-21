import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class CoordinateTest {

    @Test
    public void create_hasXandY() {
        Coordinate coordinate = new Coordinate(0, 0);
        assertEquals(coordinate.getX(), 0);
        assertEquals(coordinate.getY(), 0);
    }

    @Test
    public void equalCoordinates_equal() {
        Coordinate a = new Coordinate(0, 0);
        Coordinate b = new Coordinate(0, 0);
        assertEquals(a, b);
    }

    @Test
    public void unequalCoordinates_dontEqual() {
        Coordinate a = new Coordinate(0, 0);
        Coordinate b = new Coordinate(1, 0);
        assertFalse(a.equals(b));
    }
}
