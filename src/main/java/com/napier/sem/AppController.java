package com.napier.sem;
import com.napier.sem.blueprints.CapitalCity;
import com.napier.sem.blueprints.City;
import com.napier.sem.blueprints.Country;
import com.napier.sem.blueprints.Population;
import com.napier.sem.sqlserver.RequirementsSQL;
import com.napier.sem.sqlserver.SqlServerQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class AppController {

    private final SqlServerQuery sqlServerQuery;
    private final RequirementsSQL requirementsSQL;

    @Autowired
    public AppController(SqlServerQuery sqlServerQuery, RequirementsSQL requirementsSQL) {
        this.sqlServerQuery = sqlServerQuery;
        this.requirementsSQL = requirementsSQL;
    }

    @RequestMapping(value = "/api/CountryReport/{queryID}", method = RequestMethod.GET)
    public List<Country> CountryQuery(@PathVariable String queryID,
                                      @RequestParam(value = "n", defaultValue = "0") String N,
                                      @RequestParam(value = "continent", defaultValue = "Europe") String Continent,
                                      @RequestParam(value = "region", defaultValue = "British Islands") String Region) {
        String countryReport = "country.Code AS Code, country.Name as Name, country.Continent AS Continent, country.Region AS Region, country.Population AS Population, country.Capital AS Capital";
        List<String> queries = requirementsSQL.reportRequirements();
        String query = queries.get(Integer.parseInt(queryID));


        query = query.replace("${COUNTRYREPORT}", countryReport);
        query = query.replace("${REGION}", Region);
        query = query.replace("${CONTINENT}", Continent);
        query = query.replace("${N}", N);

        List<Country> cl;
        System.out.println(query);
        cl = sqlServerQuery.CountryQuery(query);
        return cl;

    }

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


        query = query.replace("${CITYREPORT}", cityReport);
        query = query.replace("${COUNTRY}", Country);
        query = query.replace("${DISTRICT}", District);
        query = query.replace("${REGION}", Region);
        query = query.replace("${CONTINENT}", Continent);
        query = query.replace("${N}", N);

        List<City> cl;
        System.out.println(query);
        cl = sqlServerQuery.cityQuery(query);
        return cl;

    }
    @RequestMapping(value = "/api/CapitalCityReport/{queryID}", method = RequestMethod.GET)
    public List<CapitalCity> CapitalCityQuery(@PathVariable String queryID,
                                @RequestParam(value = "n", defaultValue = "0") String N,
                                @RequestParam(value = "country", defaultValue = "United Kingdom") String Country,
                                @RequestParam(value = "district", defaultValue = "Scotland") String District,
                                @RequestParam(value = "continent", defaultValue = "Europe") String Continent,
                                @RequestParam(value = "region", defaultValue = "British Islands") String Region) {
        String cityReport = "city.Name AS name, city.CountryCode as CountryCode, city.Population AS Population";
        List<String> queries = requirementsSQL.reportRequirements();
        String query = queries.get(Integer.parseInt(queryID));


        query = query.replace("${CITYREPORT}", cityReport);
        query = query.replace("${COUNTRY}", Country);
        query = query.replace("${DISTRICT}", District);
        query = query.replace("${REGION}", Region);
        query = query.replace("${CONTINENT}", Continent);
        query = query.replace("${N}", N);

        List<CapitalCity> cl;
        System.out.println(query);
        cl = sqlServerQuery.capitalCityQuery(query);
        return cl;

    }

    @RequestMapping(value = "/api/CapitalCityReport/{queryID}", method = RequestMethod.GET)
    public List<Population> CapitalCityQuery(@PathVariable String queryID) {
        List<String> queries = requirementsSQL.reportRequirements();
        String query = queries.get(Integer.parseInt(queryID));

        List<Population> cl;
        System.out.println(query);
        cl = sqlServerQuery.populationQuery(query);
        return cl;

    }

}
