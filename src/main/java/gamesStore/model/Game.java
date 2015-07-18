package gamesStore.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */

@Entity
@Table(name = "game")
public class Game implements Cloneable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGame")
    private int idGame;
    private String title;
    private String studio;
    private Date releaseDate;
    private int inStore;


    public Game()
    {

    }

    public Game(String title, String studio, Date releaseDate, int inStore)
    {
        this.title = title;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.inStore = inStore;
    }

    public int getIdGame()
    {
        return idGame;
    }

    public void setIdGame(int idGame)
    {
        this.idGame = idGame;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getStudio()
    {
        return studio;
    }

    public void setStudio(String studio)
    {
        this.studio = studio;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public int getInStore()
    {
        return inStore;
    }

    public void setInStore(int inStore)
    {
        this.inStore = inStore;
    }

    @Override
    public String toString()
    {
        return "Id: " + idGame + " | Title: " + title + " | Studio: " + studio + " | Release Date: " + releaseDate + " | In Store:" + inStore;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
