//J-
package com.whippy.poker.state.beans;

import static org.junit.Assert.*;

import org.junit.Test;

import com.whippy.poker.state.orchestrators.Dealer;

public class DealerTest {

	//~ ----------------------------------------------------------------------------------------------------------------
	//~ Methods 
	//~ ----------------------------------------------------------------------------------------------------------------

	private static final int TABLE_ID = 0;
	private static final int TABLE_SIZE = 10;
	private static final String PLAYER_1 = "player1";
	private static final String PLAYER_2 = "player2";
	private static final int INIT_CHIPS = 1000;

	@Test
	public void testDealer() throws InterruptedException {
		//Create a table with 10 empty seats
		Table table = new Table(TABLE_SIZE, TABLE_ID);

		//Create a couple of players
		Player player1 = new Player(PLAYER_1, INIT_CHIPS);
		Player player2 = new Player(PLAYER_2, INIT_CHIPS);

		//Sit the players at the table
		table.seatPlayer(player1);
		table.seatPlayer(player2);

		//Create a new dealer for the table
		Dealer dealer = new Dealer(table);

		//Start the dealer
		Thread dealerThread = new Thread(dealer);

		dealerThread.start();

		Thread.sleep(500);
		if(table.getState().equals(TableState.IN_HAND)){
			System.out.println(table.toString());
		}else{
			table.updateTableState(TableState.CLOSING);
			fail("Table should be in a hand");
		}

		//Close the table
		table.updateTableState(TableState.CLOSING);

	}

}
//J=