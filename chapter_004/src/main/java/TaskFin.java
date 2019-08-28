import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class TaskFin {
    public int make(int[] array)  {
        return Arrays.stream(array).filter(t -> t % 2 == 0).map(t -> t * t).reduce((sum, a) -> sum + a).getAsInt();
    }
}
