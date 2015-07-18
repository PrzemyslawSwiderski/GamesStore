package gamesStore.model;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "gamer")
public class Gamer implements Cloneable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGamer")
    private int idGamer;
    private String name;
    private String lastName;
    private Date signDate;

    public Gamer()
    {
        signDate = Calendar.getInstance().getTime();
    }

    public Gamer(String name, String lastName)
    {
        signDate = Calendar.getInstance().getTime();
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getIdGamer()
    {
        return this.idGamer;
    }

    public void setIdGamer(Integer idGamer)
    {
        this.idGamer = idGamer;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String toString()
    {
        return "Id:  " + idGamer + " | Last Name:  " + lastName + " | Name:   " + name + " | Sign Date:  " + signDate;
    }

    public Date getSignDate()
    {
        return signDate;
    }

    public void setSignDate(Date signDate)
    {
        this.signDate = signDate;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
