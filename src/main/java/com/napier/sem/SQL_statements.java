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

    /*All the countries in the world organised by largest population to smallest.
    All the countries in a continent organised by largest population to smallest.
    All the countries in a region organised by largest population to smallest.
    The top N populated countries in the world where N is provided by the user.
    The top N populated countries in a continent where N is provided by the user.
    The top N populated countries in a region where N is provided by the user.
    All the cities in the world organised by largest population to smallest.
    All the cities in a continent organised by largest population to smallest.
    All the cities in a region organised by largest population to smallest.
    All the cities in a country organised by largest population to smallest.
    All the cities in a district organised by largest population to smallest.
    The top N populated cities in the world where N is provided by the user.
    The top N populated cities in a continent where N is provided by the user.
    The top N populated cities in a region where N is provided by the user.
    The top N populated cities in a country where N is provided by the user.
    The top N populated cities in a district where N is provided by the user.
    All the capital cities in the world organised by largest population to smallest.
    All the capital cities in a continent organised by largest population to smallest.
    All the capital cities in a region organised by largest to smallest.
    The top N populated capital cities in the world where N is provided by the user.
    The top N populated capital cities in a continent where N is provided by the user.
    The top N populated capital cities in a region where N is provided by the user.
    The population of people, people living in cities, and people not living in cities in each continent.
    The population of people, people living in cities, and people not living in cities in each region.
    The population of people, people living in cities, and people not living in cities in each country.*/

    //sql statements
    public static final String sqlStatement1 = "select distinct country.name, country.population from country order by country.population DESC";
    public static final String sqlStatement2 = "select distinct country.name, country.population from country where country.continent = '" + CONTINENT + "' order by country.population DESC";
    public static final String sqlStatement3 = "select distinct country.name, country.population from country where country.region = '" + REGION + "' order by country.population DESC";
    public static final String sqlStatement4 = "select distinct country.name, country.population from country order by country.population DESC limit " + N;
    public static final String sqlStatement5 = "select distinct country.name, country.population from country where country.continent = '" + CONTINENT + "' order by country.population DESC limit " + N;
    public static final String sqlStatement6 = "select distinct country.name, country.population from country where country.region = '" + REGION + "' order by country.population DESC limit " + N ;
    public static final String sqlStatement7 = "select distinct city.name, city.population from city order by city.population DESC";
    public static final String sqlStatement8 = "select distinct city.name, city.population from city join country on city.countrycode = country.code where country.continent = '" + CONTINENT + "' order by city.population DESC";
    public static final String sqlStatement9 = "select distinct city.name, city.population from city join country on city.countrycode = country.code where country.region = '" + REGION + "' order by city.population DESC";
    public static final String sqlStatement10 = "select distinct city.name, city.population from city join country on city.countrycode = country.code where country.name = '" + COUNTRY + "' order by city.population DESC";
    public static final String sqlStatement11 = "select distinct city.name, city.population from city where city.district = '" + DISTRICT + "' order by city.population DESC";
    public static final String sqlStatement12 = "select distinct city.name, city.population from city order by city.population DESC limit " + N;
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

