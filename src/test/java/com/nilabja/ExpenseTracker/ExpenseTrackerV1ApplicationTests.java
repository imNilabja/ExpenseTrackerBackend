package com.nilabja.ExpenseTracker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nilabja.ExpenseTracker.controller.ExpenseController;
import com.nilabja.ExpenseTracker.model.*;
import com.nilabja.ExpenseTracker.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExpenseController.class)
public class ExpenseTrackerV1ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExpenseService expenseService;

	@Autowired
	private ObjectMapper objectMapper;

	// ----------- FOOD TESTS -----------

	@Test
	void testAddFood() throws Exception {
		FoodItem food = new FoodItem();
		food.setItemName("Pizza");
		food.setItemCost(500.0);

		mockMvc.perform(post("/addFood")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(food)))
				.andExpect(status().isOk())
				.andExpect(content().string("Food added!!!"));
	}

	@Test
	void testGetFood() throws Exception {
		FoodItem food = new FoodItem();
		food.setItemName("Burger");
		food.setItemCost(250.0);

		when(expenseService.getAllFood()).thenReturn(List.of(food));

		mockMvc.perform(get("/getFood"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].itemName").value("Burger"))
				.andExpect(jsonPath("$[0].itemCost").value(250.0));
	}

	// ----------- MESC TESTS -----------

	@Test
	void testAddMesc() throws Exception {
		MescItem mesc = new MescItem();
		mesc.setItemName("Soap");
		mesc.setItemCost(50.0);

		mockMvc.perform(post("/addMesc")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(mesc)))
				.andExpect(status().isOk())
				.andExpect(content().string("Mesc added!!!"));
	}

	@Test
	void testGetMesc() throws Exception {
		MescItem mesc = new MescItem();
		mesc.setItemName("Shampoo");
		mesc.setItemCost(120.0);

		when(expenseService.getAllMesc()).thenReturn(List.of(mesc));

		mockMvc.perform(get("/getMesc"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].itemName").value("Shampoo"))
				.andExpect(jsonPath("$[0].itemCost").value(120.0));
	}

	// ----------- STUFF TESTS -----------

	@Test
	void testAddStuff() throws Exception {
		StuffItem stuff = new StuffItem();
		stuff.setItemName("Chair");
		stuff.setItemCost(800.0);

		mockMvc.perform(post("/addStuff")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(stuff)))
				.andExpect(status().isOk())
				.andExpect(content().string("Stuff added!!!"));
	}

	@Test
	void testGetStuff() throws Exception {
		StuffItem stuff = new StuffItem();
		stuff.setItemName("Table");
		stuff.setItemCost(1500.0);

		when(expenseService.getAllStuff()).thenReturn(List.of(stuff));

		mockMvc.perform(get("/getStuff"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].itemName").value("Table"))
				.andExpect(jsonPath("$[0].itemCost").value(1500.0));
	}

	// ----------- TRAVEL TESTS -----------

	@Test
	void testAddTravel() throws Exception {
		TravelItem travel = new TravelItem();
		travel.setItemName("Cab Ride");
		travel.setItemCost(300.0);

		mockMvc.perform(post("/addTravel")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(travel)))
				.andExpect(status().isOk())
				.andExpect(content().string("Travel added!!!"));
	}

	@Test
	void testGetTravel() throws Exception {
		TravelItem travel = new TravelItem();
		travel.setItemName("Train Ticket");
		travel.setItemCost(500.0);

		when(expenseService.getAllTravel()).thenReturn(List.of(travel));

		mockMvc.perform(get("/getTravel"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].itemName").value("Train Ticket"))
				.andExpect(jsonPath("$[0].itemCost").value(500.0));
	}

	// ----------- EMPTY RESPONSE TESTS -----------

	@Test
	void testEmptyFoodList() throws Exception {
		when(expenseService.getAllFood()).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/getFood"))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}

	@Test
	void testEmptyMescList() throws Exception {
		when(expenseService.getAllMesc()).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/getMesc"))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}

	@Test
	void testEmptyStuffList() throws Exception {
		when(expenseService.getAllStuff()).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/getStuff"))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}

	@Test
	void testEmptyTravelList() throws Exception {
		when(expenseService.getAllTravel()).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/getTravel"))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}
}
