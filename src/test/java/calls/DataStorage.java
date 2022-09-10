package calls;

import org.testng.annotations.DataProvider;

public class DataStorage {
    @DataProvider(name = "AddDataForOrderPositive")
    public Object[][] dataForOrder() {
        return new Object[][]{
                {5,"Alina Yrs"},
                {1,"Ben Jacob"},
                {6,"Kelly Jhonson"}
        };

    }
    @DataProvider(name = "AddDataForOrderNegative")
    public Object[][] dataForOrderNegativeScenario() {
        return new Object[][]{
                {1000,"A"},
                {0,"Jacob"},
                {00000,"Kelly **"}
        };

    }

}
