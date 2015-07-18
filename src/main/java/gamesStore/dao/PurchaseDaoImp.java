package gamesStore.dao;

import gamesStore.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-18.
 */
public class PurchaseDaoImp implements PurchaseDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public PurchaseDaoImp(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Purchase> list()
    {
        List<Purchase> listPurchase = (List<Purchase>) sessionFactory.getCurrentSession()
                .createCriteria(Purchase.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listPurchase;
    }

    @Override
    @Transactional
    public Purchase get(int id)
    {
        String hql = "from Purchase where idPurchase=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Purchase> purchaseList = (List<Purchase>) query.list();

        if (purchaseList != null && !purchaseList.isEmpty())
        {
            return purchaseList.get(0);
        }

        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Purchase purchase)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(purchase);
    }

    @Override
    @Transactional
    public void delete(int id)
    {
        Purchase purchaseToDelete = new Purchase();
        purchaseToDelete.setIdPurchase(id);
        sessionFactory.getCurrentSession().delete(purchaseToDelete);
    }

    @Override
    @Transactional
    public void clear()
    {
        String hql = "delete from Purchase";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }
}
