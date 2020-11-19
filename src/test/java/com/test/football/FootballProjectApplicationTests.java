package com.test.football;

//import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.test.football.controller.FootballController;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(value = FootballController.class)
@WithMockUser
//@ContextConfiguration(classes=Application.class)
public class FootballProjectApplicationTests {
	@Autowired
	private MockMvc mockMvc;
//	String testUrl = "";
//	@Test
//	void contextLoads() {
//	}
	
	@Test
	public void getStandingsTest() throws Exception{
		//Mockito.when();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/standings/England/Championship/Reading").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"country_name\":\"England\",\"league_id\":\"149\",\"league_name\":\"Championship\",\"team_id\":\"2647\",\"team_name\":\"Reading\",\"overall_promotion\":\"Promotion - Premier League\",\"overall_league_position\":\"1\",\"overall_league_payed\":\"11\",\"overall_league_W\":\"7\",\"overall_league_D\":\"1\",\"overall_league_L\":\"3\",\"overall_league_GF\":\"17\",\"overall_league_GA\":\"12\",\"overall_league_PTS\":\"22\",\"home_league_position\":\"2\",\"home_promotion\":\"\",\"home_league_payed\":\"6\",\"home_league_W\":\"4\",\"home_league_D\":\"0\",\"home_league_L\":\"2\",\"home_league_GF\":\"7\",\"home_league_GA\":\"6\",\"home_league_PTS\":\"12\",\"away_league_position\":\"4\",\"away_promotion\":\"\",\"away_league_payed\":\"5\",\"away_league_W\":\"3\",\"away_league_D\":\"1\",\"away_league_L\":\"1\",\"away_league_GF\":\"10\",\"away_league_GA\":\"6\",\"away_league_PTS\":\"10\",\"league_round\":\"\",\"team_badge\":\"https://apiv2.apifootball.com/badges/2647_reading.png\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
