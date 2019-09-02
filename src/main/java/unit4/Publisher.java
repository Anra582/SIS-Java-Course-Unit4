package unit4;

import java.util.Arrays;
import java.util.List;

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
    public void fromArray(List<String> stringList) {
        this.name = stringList.get(0);
        this.headOfficeLocation = stringList.get(1);
        this.countOfContracts = Integer.parseInt(stringList.get(2));
    }

    @Override
    public List<String> getParamsAsArray() {
        return Arrays.asList(this.name, this.headOfficeLocation, String.valueOf(this.countOfContracts));
    }
}
