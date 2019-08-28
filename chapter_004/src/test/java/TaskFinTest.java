import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class TaskFinTest {
    @Test
    public void sort() {
        int[] mas = {1, 5, 15, 13, 2, 45, 8, 10};
        TaskFin task = new TaskFin();
        int result = task.make(mas);
        int expect = 168;
        assertThat(result, is(expect));
    }

}
