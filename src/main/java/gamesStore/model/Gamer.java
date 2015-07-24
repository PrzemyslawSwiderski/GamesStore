package gamesStore.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "gamer")
public class Gamer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idGamer")
    private int idGamer;

    @NotEmpty(message = "Name can not be empty.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Last Name can not be empty.")
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "signDate")
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

}
