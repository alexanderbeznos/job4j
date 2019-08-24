package streamapitest;

import org.junit.Test;
import streamapi.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;

public class MatrixTest {
    @Test
    public void sort() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> result = new Matrix().confer(matrix);
        List<Integer> except = List.of(1, 2, 3, 4);
        assertThat(result, is(except));

    }
}
