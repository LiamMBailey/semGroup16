package com.napier.sem.blueprints;

public class City {

    private String _cityName;
    private String _cityCountry;
    private String _cityDistrict;
    private int _cityPopulation;

    public City(String cityName, String cityCountry, String cityDistrict, int cityPopulation)
    {
        _cityName = cityName;
        _cityCountry = cityCountry;
        _cityDistrict = cityDistrict;
        _cityPopulation = cityPopulation;
    }
    public City(){

    }
    // Getter and setter for Name
    public String getCityName() {
        return _cityName;
    }

    public void setCityName(String cityName) {
        _cityName = cityName;
    }

    // Getter and setter for Country
    public String getCityCountry() {
        return _cityCountry;
    }

    public void setCityCountry(String cityCountry) {
        _cityCountry = cityCountry;
    }

    // Getter and setter for District
    public String getCityDistrict() {
        return _cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        _cityDistrict =  cityDistrict;
    }

    // Getter and setter for Population
    public int getCityPopulation() {
        return _cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        _cityPopulation = cityPopulation;
    }

    public String toString(){
        return String.format("%s, %s, %s, %s", _cityName,_cityCountry,_cityDistrict,_cityPopulation);
    }

}
