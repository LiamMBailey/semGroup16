package com.napier.sem;
import com.napier.sem.blueprints.City;
import com.napier.sem.blueprints.Country;
import com.napier.sem.sqlserver.RequirementsSQL;
import com.napier.sem.sqlserver.SqlServerQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//The controller for the spring app. Handles all routes here
@CrossOrigin
@RestController
public class AppController {

    private final SqlServerQuery sqlServerQuery;
    private final RequirementsSQL requirementsSQL;

    //creating instances of the sql statements and the server query
    @Autowired
    public AppController(SqlServerQuery sqlServerQuery, RequirementsSQL requirementsSQL) {
        this.sqlServerQuery = sqlServerQuery;
        this.requirementsSQL = requirementsSQL;
    }

    //request mapping for the country reports, takes in a query id and a few optional request prams
    @RequestMapping(value = "/api/CountryReport/{queryID}", method = RequestMethod.GET)
    public List<Country> CountryQuery(@PathVariable String queryID,
                                      @RequestParam(value = "n", defaultValue = "0") String N,
                                      @RequestParam(value = "continent", defaultValue = "Europe") String Continent,
                                      @RequestParam(value = "region", defaultValue = "British Islands") String Region) {
        String countryReport = "country.Code AS Code, country.Name as Name, country.Continent AS Continent, country.Region AS Region, country.Population AS Population, country.Capital AS Capital";
        List<String> queries = requirementsSQL.reportRequirements();
        String query = queries.get(Integer.parseInt(queryID));

        //adding the optional prams to the sql statement, if provided
        query = query.replace("${COUNTRYREPORT}", countryReport);
        query = query.replace("${REGION}", Region);
        query = query.replace("${CONTINENT}", Continent);
        query = query.replace("${N}", N);

        //Storing in a country object list and returning it as a JSON object
        List<Country> cl;
        System.out.println(query);
        cl = sqlServerQuery.CountryQuery(query);
        return cl;

    }

    //Request mapping for the city objects, takes in query id as well as optional requests
    @RequestMapping(value = "/api/CityReport/{queryID}", method = RequestMethod.GET)
    public List<City> CityQuery(@PathVariable String queryID,
                                @RequestParam(value = "n", defaultValue = "0") String N,
                                @RequestParam(value = "country", defaultValue = "United Kingdom") String Country,
                                @RequestParam(value = "district", defaultValue = "Scotland") String District,
                                @RequestParam(value = "continent", defaultValue = "Europe") String Continent,
                                @RequestParam(value = "region", defaultValue = "British Islands") String Region) {
        String cityReport = "city.Name AS name, city.CountryCode as CountryCode, city.District AS District, city.Population AS Population";
        List<String> queries = requirementsSQL.reportRequirements();
        String query = queries.get(Integer.parseInt(queryID));


        //adding the optional prams to the sql statement, if provided
        query = query.replace("${CITYREPORT}", cityReport);
        query = query.replace("${COUNTRY}", Country);
        query = query.replace("${DISTRICT}", District);
        query = query.replace("${REGION}", Region);
        query = query.replace("${CONTINENT}", Continent);
        query = query.replace("${N}", N);

        //Storing in a City object list and returning it as a JSON object
        List<City> cl;
        System.out.println(query);
        cl = sqlServerQuery.cityQuery(query);
        return cl;

    }


}
