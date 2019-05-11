package com.napier.sem.blueprints;

//population object class
public class Population {
    private String Name;
    private long TotalPopulation = 1;
    private long PopulationInCities;
    private double PopPercentageInCities;
    private long PopulationNotInCities;
    private double PopPercentageNotInCities;


    public Population(String name, long totalPopulation, long populationInCities,double popPercentageInCities, long populationNotInCities, double popPercentageNotInCities) {
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

    public long getTotalPopulation() {
        return TotalPopulation;
    }

    public void setTotalPopulation(long totalPopulation) {
        TotalPopulation = totalPopulation;
    }

    public long getPopulationInCities() {
        return PopulationInCities;
    }

    public void setPopulationInCities(long populationInCities) {
        PopulationInCities = populationInCities;
    }

    public double getPopPercentageInCities() {
        return PopPercentageInCities;
    }

    public long getPopulationNotInCities() {
        return PopulationNotInCities;
    }

    public void setPopulationNotInCities(long populationNotInCities) {
        PopulationNotInCities = populationNotInCities;
    }

    public double getPopPercentageNotInCities() {
        return PopPercentageNotInCities;
    }

    public String toString(){
        return String.format("%s, %s, %s, %s, %s, %s", Name, TotalPopulation, PopulationInCities, PopPercentageInCities, PopulationNotInCities, PopPercentageNotInCities);
    }
}
