package unit4;

import java.util.Arrays;
import java.util.List;

public class Author implements CSVEditable {
    private String name;
    private String birthPlace;

    public Author() {
        this.name = null;
        this.birthPlace = null;
    }

    public Author(String name, String birthPlace) {
        this.name = name;
        this.birthPlace = birthPlace;
    }

    public String getName() {
        return name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public void fromArray(List<String> stringList) {
        this.name = stringList.get(0);
        this.birthPlace = stringList.get(1);
    }

    @Override
    public List<String> getParamsAsArray() {
        return Arrays.asList(this.name, this.birthPlace);
    }
}
