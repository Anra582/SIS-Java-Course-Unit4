package unit4;

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
    public CSVEditable fromLine(String line, String delimiter) {
        return new Author(line.split(delimiter)[0], line.split(delimiter)[1]);
    }

    @Override
    public String getLine(String delimiter) {
        return this.name + delimiter+ this.birthPlace;
    }
}
