package gamesStore;

import junit.framework.TestCase;

public class HibernateTest extends TestCase
{

	public void testSaveGamer()
	{
		new GamerDao().register(new Gamer("dsad","ssss"));
		System.out.println("successfully saved");

	}
//
//	public void testLoadGamers()
//	{
//		new GamerDao().loadList();
//		System.out.println("successfully loaded");
//	}
//	
	public void testPrintGamers()
	{
		System.out.println(new GamerDao().gamersToString());

		System.out.println("successfully printed");
	}
//	public void testDeleteAll()
//	{
//		new GamerDao().deleteAll();
//
//		System.out.println("successfully deleted");
//	}

}
