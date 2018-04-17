package com.shannonholmes.guestbook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table (name = "entries")
public class GuestBookEntry
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "entry_id")
    private Integer id;

    @NotEmpty
    private String user;

    @NotEmpty
    private String comment;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public String getComment()
    {
        return comment;
    }

    public String getUser()
    {
        return user;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    GuestBookEntry ()
    {
        //setComment("");
    }
}
