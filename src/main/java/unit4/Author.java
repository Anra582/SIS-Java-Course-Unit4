package unit4;

public class Author implements IAuthor {
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
    public IAuthor fromLine(String line) {
        return new Author(line.split(";")[0], line.split(";")[1]);
    }

    @Override
    public String getLine() {
        return this.name + ";" + this.birthPlace;
    }
}
