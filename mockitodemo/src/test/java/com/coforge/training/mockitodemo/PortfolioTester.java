package com.coforge.training.mockitodemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioTester {

	@InjectMocks
	Portfolio portfolio;
	
	@Mock
	StockService stockService;
/*	
	@Before
	public void setUp() throws Exception {
	}*/

	@SuppressWarnings("deprecation")
	@Test
	public void testGetMarketValue() {
		portfolio.setStockService(stockService);
		
		//Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1","Google", 10);
		Stock microsoftStock = new Stock("2","Microsoft",100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		//add stocks to the portfolio
		portfolio.setStocks(stocks);
		
		//mock the behavior of stock Service
		//to return value of various stocks
		
		when(stockService.getPrice(googleStock)).thenReturn(50.00);
		when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);
		
		double marketValue=portfolio.getMarketValue();
		assertEquals(marketValue,100500.0,0);
		System.out.println(marketValue);
		
	}

}
