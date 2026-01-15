import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStudentTest {
    @Test
    void testVenueGetterCoverage() {
        Venue v = new Venue("TestVenue", 100, 10, 5, 2);
        assertEquals(10, v.getCapacity());
    }
}
