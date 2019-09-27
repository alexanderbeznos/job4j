package ru.job4j.trac;

import org.junit.Test;
import ru.job4j.track.TrackerSQL;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        try (TrackerSQL sql = new TrackerSQL();) {
            assertThat(sql.init(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
