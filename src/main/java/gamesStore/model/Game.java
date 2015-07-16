package gamesStore.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */

@Entity
@Table(name = "game")
public class Game
{
    private int idGame;
    private String title;
    private String studio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;
    private int inStore;


    public Game()
    {

    }

    public Game(String title, String studio, LocalDate releaseDate, int inStore)
    {
        this.title = title;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.inStore = inStore;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGame")
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

    public LocalDate getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
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
