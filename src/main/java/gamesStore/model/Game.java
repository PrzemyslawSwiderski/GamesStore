package gamesStore.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */

@Entity
@Table(name = "game")
public class Game
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGame")
    private int idGame;

    @NotEmpty(message = "Title can not be empty.")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Studio can not be empty.")
    @Column(name = "studio")
    private String studio;

    @NotNull(message = "Date can not be null.")
    @Column(name = "releaseDate")
    private Date releaseDate;

    @NotNull
    @Column(name = "inStore")
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

}
