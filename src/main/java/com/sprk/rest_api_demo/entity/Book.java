package com.sprk.rest_api_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_table")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(nullable = false, name = "book_name")
    private String bookName;

    @Column(nullable = false, name = "author_name")
    private String authorName;

    @Column(nullable = false)
    private String publication;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "edition", nullable = false)
    private String edition;

}
