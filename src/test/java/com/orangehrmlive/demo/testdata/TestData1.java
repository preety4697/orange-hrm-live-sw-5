package com.orangehrmlive.demo.testdata;

import org.testng.annotations.DataProvider;

public class TestData1 {
    @DataProvider(name = "Data Set")
    public Object[][] getData1(){
        Object[][] data = new Object[][]{
                {"Admin", "Admin", "Paul Colling", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope","Enable"},
                {"Nina.Pate", "ESS", "Nina Patel","Enable"},
                {"Odis.Adalwin", "Admin","Odis Adalwin","Enable"}
        };
        return data;
    }
    @DataProvider(name = "Test Data")
    public Object[][] getData2(){
        Object[][] data = new Object[][]{
                {"", "", "required"},
                {"test123@gmail.com", "", "required"},
                {" ", "test123", "required"},
                {"test123@gmail.com", "test123", "Invalid credenentials"}
        };
        return data;

        }
}
