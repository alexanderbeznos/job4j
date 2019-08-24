package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public List<Integer> confer(List<List<Integer>> srray) {
        return srray.stream().flatMap(List :: stream).collect(Collectors.toList());
    }
}
