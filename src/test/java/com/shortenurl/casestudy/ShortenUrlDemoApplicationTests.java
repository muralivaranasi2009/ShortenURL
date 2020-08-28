package com.shortenurl.casestudy;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.shortenurl.casestudy.controller.ShortenURLController;
import com.shortenurl.casestudy.service.ShortenService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ShortenUrlDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getShortenURLTest() throws Exception {
		this.mockMvc.perform(get("/shortenURL?longUrl=https://www2.deloitte.com/us/en.html"))
        .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
	}

	@Test
	void getHighShortenURLTest() throws Exception {
		this.mockMvc.perform(get("/highShortenURL?longUrl=https://www.google.com"))
        .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void routeURLTest() throws Exception {
		this.mockMvc.perform(get("/r/AAAAAA"))
		.andExpect(redirectedUrl("https://zoom.us/join"))
        .andExpect(status().isFound())
        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void routeURLInvalidTest() throws Exception {
		this.mockMvc.perform(get("/r/ZZZZZZ"))
        .andExpect(status().is4xxClientError())
        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void getAllTest() throws Exception {
		this.mockMvc.perform(get("/listShortenURLS"))
        .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
	}

}
