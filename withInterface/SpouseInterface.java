package withInterface;

import java.util.List;

public interface SpouseInterface {
    List<PersonInterface> getSpouse();
    void setSpouse(List<PersonInterface> spouse);
    default boolean isMarried() {
        return getSpouse().size() > 0;
    }
}
