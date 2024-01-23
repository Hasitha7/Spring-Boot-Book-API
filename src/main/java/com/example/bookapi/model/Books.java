package com.example.bookapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.Valid;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name = "Books")
public class Books {
    //Defining book id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-generated keys
    @Column
    private int bookid;
    @Column
    @Valid
    @NotBlank(message = "Book title can't be blank")
    @NotNull(message = "Book title can't be null")
    private String booktitle;
    @Column
    @Valid
    @NotBlank(message = "Author name can't be blank")
    private String authorname;
    @Column
    @Valid
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String authoremail;
    @Column
    @Valid
    @NotNull(message = "Price can't be null")
    @Positive(message = "Price must be greater than zero")
    private double price;
    public int getBookid()
    {
        return bookid;
    }
    public void setBookid(int bookid)
    {
        this.bookid = bookid;
    }
    public String getBooktitle()
    {
        return booktitle;
    }
    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }
    public String getAuthorname()
    {
        return authorname;
    }
    public void setAuthorname(String authorname)
    {
        this.authorname = authorname;
    }
    public String getAuthoremail()
    {
        return authoremail;
    }
    public void setAuthoremail(String authoremail)
    {
        this.authoremail = authoremail;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
}
