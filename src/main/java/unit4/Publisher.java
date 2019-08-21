package unit4;

public class Publisher implements IAuthor {
    private String name;
    private String headOfficeLocation;
    private int countOfContracts;

    public Publisher() {
        this.name = null;
        this.headOfficeLocation = null;
        this.countOfContracts = 0;
    }

    public Publisher(String name, String headOfficeLocation, int countOfContracts) {
        this.name = name;
        this.headOfficeLocation = headOfficeLocation;
        this.countOfContracts = countOfContracts;
    }

    public String getName() {
        return name;
    }

    public String getHeadOfficeLocation() {
        return headOfficeLocation;
    }

    public int getCountOfContracts() {
        return countOfContracts;
    }
    
    @Override
    public IAuthor fromLine(String line) {
        return new Publisher(line.split(";")[0], line.split(";")[1], Integer.parseInt(line.split(";")[2]));
    }

    @Override
    public String getLine() {
        return this.name + ";" + this.headOfficeLocation + ";" + this.countOfContracts;
    }


}
