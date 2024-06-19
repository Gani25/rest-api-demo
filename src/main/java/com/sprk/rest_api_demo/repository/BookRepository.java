package com.sprk.rest_api_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprk.rest_api_demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
