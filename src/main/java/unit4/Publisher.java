package unit4;

public class Publisher implements CSVEditable {
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
    public CSVEditable fromLine(String line, String delimiter) {
        return new Publisher(line.split(delimiter)[0], line.split(delimiter)[1], Integer.parseInt(line.split(delimiter)[2]));
    }

    @Override
    public String getLine(String delimiter) {
        return this.name + delimiter + this.headOfficeLocation + delimiter + this.countOfContracts;
    }
}
