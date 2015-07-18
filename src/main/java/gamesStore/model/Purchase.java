package gamesStore.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Przemek_Swiderski on 2015-07-17.
 */
@Entity
@Table(name = "purchase")
public class Purchase
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPurchase")
    private int idPurchase;

    private String name;

    private String lastName;

    private String title;

    private Date purchaseDate;

    public Purchase()
    {
        this.purchaseDate = Calendar.getInstance().getTime();

    }

    public Purchase(Game game, Gamer gamer)
    {
        this.name = gamer.getName();
        this.lastName=gamer.getLastName();
        this.title = game.getTitle();
        this.purchaseDate = Calendar.getInstance().getTime();
        int newInStore = game.getInStore();
        newInStore-=1;
        game.setInStore(newInStore);
    }

    public int getIdPurchase()
    {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase)
    {
        this.idPurchase = idPurchase;
    }

    public Date getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
