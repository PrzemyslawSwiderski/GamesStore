package gamesStore.dao;

import gamesStore.model.Gamer;
import gamesStore.model.Purchase;

import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-18.
 */
public interface PurchaseDao
{

    public List<Purchase> list();

    public Purchase get(int id);

    public void saveOrUpdate(Purchase purchase);

    public void delete(int id);

    public void clear();

}
