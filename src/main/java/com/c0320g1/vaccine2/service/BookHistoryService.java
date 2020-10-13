package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.BookHistory;

import java.util.List;

public interface BookHistoryService {
    List<BookHistory> findAll();
    BookHistory findById(Long id);
    void save(BookHistory bookHistory);
}
