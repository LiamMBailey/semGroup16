package com.napier.sem.blueprints;

public class Population {
    private String Name;
    private int  TotalPopulation = 1;
    private int PopulationInCities;
    private double PopPercentageInCities;
    private int PopulationNotInCities;
    private double PopPercentageNotInCities;


    public Population(String name, int totalPopulation, int populationInCities,double popPercentageInCities, int populationNotInCities, double popPercentageNotInCities) {
        Name = name;
        TotalPopulation = totalPopulation;
        PopulationInCities = populationInCities;
        PopulationNotInCities = populationNotInCities;
        PopPercentageInCities = popPercentageInCities;
        PopPercentageNotInCities = popPercentageNotInCities;
    }
    public void setPopPercentageInCities(double popPercentageInCities) {
        PopPercentageInCities = popPercentageInCities;
    }

    public void setPopPercentageNotInCities(double popPercentageNotInCities) {
        PopPercentageNotInCities = popPercentageNotInCities;
    }
    public Population() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTotalPopulation() {
        return TotalPopulation;
    }

    public void setTotalPopulation(int totalPopulation) {
        TotalPopulation = totalPopulation;
    }

    public int getPopulationInCities() {
        return PopulationInCities;
    }

    public void setPopulationInCities(int populationInCities) {
        PopulationInCities = populationInCities;
    }

    public double getPopPercentageInCities() {
        return PopPercentageInCities;
    }

    public int getPopulationNotInCities() {
        return PopulationNotInCities;
    }

    public void setPopulationNotInCities(int populationNotInCities) {
        PopulationNotInCities = populationNotInCities;
    }

    public double getPopPercentageNotInCities() {
        return PopPercentageNotInCities;
    }

    public String toString(){
        return String.format("%s, %s, %s, %s, %s, %s", Name, TotalPopulation, PopulationInCities, PopPercentageInCities, PopulationNotInCities, PopPercentageNotInCities);
    }
}
