package com.test.football.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.football.model.Competitions;
import com.test.football.model.Countries;
import com.test.football.model.Standing;
import com.test.football.util.JSONUtils;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FootballController {
	
	@Value("${rest.cnt.uri}")
	private String restUri;
	
	@Value("${rest.apikey}")
	private String restApiKey;
	
	private static Logger log = LoggerFactory.getLogger(FootballController.class);
	static RestTemplate restTemplate = new RestTemplate();
	private static final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
	
	@CrossOrigin("*")
	@GetMapping("/standings/{countryName}/{leagueName}/{teamName}")
	public @ResponseBody Standing getStandings(@PathVariable("countryName") String countryName, @PathVariable("leagueName") String leagueName, @PathVariable("teamName") String teamName) throws InterruptedException, ExecutionException, JsonParseException, JsonMappingException, IOException{
		log.info("Inside FootballController ---> getStandings mtd ---> countryName: {}, leagueName: {}, teamName: {}, restUri: {}, restApiKey: {}", countryName, leagueName, teamName, restUri, restApiKey);
		//  Calling the APIs: 
		String country_id="";
		String league_id="";
		boolean hasCountry=false;
		boolean hasCompletion=false;
		boolean hasStanding=false;
		Standing final_standing=null;
//		String countryNameEncoded = encodeValue(countryName);
//		log.info("leagueName: {}", leagueName);
//		String leagueNameEncoded = encodeValue(leagueName);
//		log.info("leagueNameEncoded: {}", leagueNameEncoded);
//		String teamNameEncoded = encodeValue(teamName);
		CompletableFuture<HttpResponse<String>> responseCnt = getResponse("?action=get_countries");
	    responseCnt.thenAccept(res -> System.out.println(res));
		//CompletableFuture response = FootballController.getResponseType();
	    List<Countries> countries = JSONUtils.convertFromJsonToList(((HttpResponse<String>) responseCnt.get()).body(), new TypeReference<List<Countries>>() {});
	    log.info("countries: {}", countries);
	    
	    for (Countries cntry: countries) {
	    	if(cntry.getCountry_name().equalsIgnoreCase(countryName)) {
	    		hasCountry=true;
	    		country_id = cntry.getCountry_id();
	    	}
	    }
	    if(!hasCountry) {
	    	throw new IOException("Country didnot match....."); 
	    }
	    log.info("For input country : {} country_id is: {}", countryName, country_id);
	    
	    // Calling API Competitions with the country_id of the given country name: 
	    //get_leagues
	    CompletableFuture<HttpResponse<String>> responseCompetition = getResponse("?action=get_leagues&country_id="+country_id);
	    List<Competitions> completitions = JSONUtils.convertFromJsonToList(((HttpResponse<String>) responseCompetition.get()).body(), new TypeReference<List<Competitions>>() {});
	    log.info("completitions for country_id: {} is: {}", country_id, completitions);
	    
	    for (Competitions cmptition: completitions) {
	    	log.info("cmptition.getLeague_name(): {} and leagueName: {}", cmptition.getLeague_name(), leagueName);
	    	if (cmptition.getLeague_name().equalsIgnoreCase(leagueName)) {
	    		hasCompletion=true;
	    		league_id=cmptition.getLeague_id();
	    	}
	    }
	    if(!hasCompletion) {
	    	throw new IOException("Competition didnot match....."); 
	    }
	    log.info("Selected league_id is: {}", league_id);
		
		// Calling API Standings with league_id:
		CompletableFuture<HttpResponse<String>> responseStandings = getResponse("?action=get_standings&league_id="+league_id);
	    List<Standing> standings = JSONUtils.convertFromJsonToList(((HttpResponse<String>) responseStandings.get()).body(), new TypeReference<List<Standing>>() {});
	    log.info("completitions for league_id: {} is: {}", league_id, standings);
	    
	    for (Standing standing: standings) {
	    	if(standing.getTeam_name().equalsIgnoreCase(teamName)) {
	    		hasStanding=true;
	    		final_standing = standing;
	    		break;
	    	}
	    }
	    if(!hasStanding) {
	    	throw new IOException("Standing didnot match....."); 
	    }
		return final_standing;
	}
	
	private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

	private CompletableFuture<HttpResponse<String>> getResponse(String url_substr) {
		//"?action="+action_name+"&country_id="+country_id
		HttpRequest reqCompetitions = HttpRequest.newBuilder(URI.create(restUri+url_substr+"&APIkey="+restApiKey))
	            .GET().build();
	    log.info("reqCompetitions: {}", reqCompetitions);
	    CompletableFuture<HttpResponse<String>> responseCompetition = client.sendAsync(reqCompetitions, BodyHandlers.ofString());
	    //responseCompetition.thenAccept(res -> System.out.println(res));
		return responseCompetition;
	}
}