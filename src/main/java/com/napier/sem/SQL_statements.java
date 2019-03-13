package com.napier.sem;

public final class SQL_statements {

    //it is private to prevent instantiation
    private SQL_statements(){}
    //default
    public static int N = 1;
    public static String CONTINENT = "Europe";
    public static String REGION = "Western Europe";
    public static String COUNTRY = "United Kingdom";
    public static String DISTRICT = "Scotland";

    //sql statements
    public static final String sqlStatement13 = "select distinct city.name, city.population from city join country on country.continent = '" + CONTINENT + "' where city.countrycode = country.code order by city.population DESC limit " + N;
    public static final String sqlStatement14 = "select distinct city.name, city.population from city join country on country.region = '" + REGION + "' where city.countrycode = country.code order by city.population DESC  limit " + N;
    public static final String sqlStatement15 = "select distinct city.name, city.population from city join country on country.name = '" + COUNTRY + "' where city.countrycode = country.code order by city.population DESC  limit " + N;
    public static final String sqlStatement16 = "select distinct name, population from city where district = '" + DISTRICT + "' order by population DESC limit " + N;
    public static final String sqlStatement17 = "select city.name, city.population from city join country on city.id = country.capital order by city.population desc";
    public static final String sqlStatement18 = "select city.name, city.population from city join country on city.id = country.capital where country.continent = '" + CONTINENT + "' order by city.population desc";
    public static final String sqlStatement19 = "select city.name, city.population from city join country on city.id = country.capital where country.region = '" + REGION + "' order by city.population desc";
    public static final String sqlStatement20 = "select city.name, city.population from city join country on city.id = country.capital order by city.population desc limit " + N;
    public static final String sqlStatement21 = "select city.name, city.population from city join country on city.id = country.capital where country.continent = '" + CONTINENT + "' order by city.population desc limit " + N;
    public static final String sqlStatement22 = "select city.name, city.population from city join country on city.id = country.capital where country.region = '" + REGION + "' order by city.population desc limit " + N;
    public static final String sqlStatement23 = "select distinct country.continent ,sum(country.population), sum(city.population), ( sum(country.population) - sum(city.population) ) from city join country where city.countrycode = country.code group by country.continent";
    public static final String sqlStatement24 = "select distinct country.region ,sum(country.population), sum(city.population), ( sum(country.population) - sum(city.population) ) from city join country where city.countrycode = country.code group by country.region";
    public static final String sqlStatement25 = "select distinct country.name ,sum(country.population), sum(city.population), ( sum(country.population) - sum(city.population) ) from city join country where city.countrycode = country.code group by country.name";
}

