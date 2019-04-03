package com.napier.sem.blueprints;

public class CapitalCity
{
    private String _capitalCityName;
    private String _capitalCityCountry;
    private int _capitalCityPopulation;

    public CapitalCity(String capitalCityName, String capitalCityCountry, int capitalCityPopulation)
    {
        _capitalCityName = capitalCityName;
        _capitalCityCountry = capitalCityCountry;
        _capitalCityPopulation = capitalCityPopulation;
    }
    public CapitalCity(){}

    // Getter and setter for Name
    public String getCapitalCityName() {
        return _capitalCityName;
    }

    public void setCapitalCityName(String capitalCityName) {
        _capitalCityName = capitalCityName;
    }

    // Getter and setter for Country
    public String getCapitalCityCountry() {
        return _capitalCityCountry;
    }

    public void setCapitalCityCountry(String capitalCityCountry) {
        _capitalCityCountry = capitalCityCountry;
    }

    // Getter and setter for Population
    public int getCapitalCityPopulation() {
        return _capitalCityPopulation;
    }

    public void setCapitalCityPopulation(int capitalCityPopulation) {
        _capitalCityPopulation = capitalCityPopulation;
    }

}
