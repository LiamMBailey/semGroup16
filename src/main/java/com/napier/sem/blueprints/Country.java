package com.napier.sem.blueprints;


public class Country  {
    private String countryCode;
    private String countryName;
    private String countryContinent;
    private String countryRegion;
    private int countryPopulation;
    private String countryCapital;

    public Country(String _countryCode, String _countryName, String _countryContinent,
                   String _countryRegion, int _countryPopulation, String _countryCapital) {

        this.countryCode = _countryCode;
        this.countryName = _countryName;
        this.countryContinent = _countryContinent;
        this.countryRegion = _countryRegion;
        this.countryPopulation = _countryPopulation;
        this.countryCapital = _countryCapital;

    }

    public Country() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryContinent() {
        return countryContinent;
    }

    public void setCountryContinent(String countryContinent) {
        this.countryContinent = countryContinent;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String toString() {
        return String.format("%s , %s , %s , %s , %s , %s", getCountryCode(), getCountryName(), getCountryContinent(), getCountryRegion(), getCountryPopulation(), getCountryCapital());
    }


}

