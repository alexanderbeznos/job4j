package streamapi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 24.08.2019.
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
