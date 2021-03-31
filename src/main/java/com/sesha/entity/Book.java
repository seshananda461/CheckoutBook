package com.sesha.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private String bookDescription;
    private String bookAuthor;
    private Type bookType;
     private Long bookPrice;
    private Long bookISBN;
}
