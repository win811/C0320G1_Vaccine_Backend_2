package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.BookHistory;
import com.c0320g1.vaccine2.repository.BookHistoryRepository;
import com.c0320g1.vaccine2.service.BookHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookHistoryServiceImpl implements BookHistoryService {
    @Autowired
    BookHistoryRepository bookHistoryRepository;

    @Override
    public List<BookHistory> findAll() {
        return bookHistoryRepository.findAll();
    }

    @Override
    public BookHistory findById(Long id) {
        return bookHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookHistory bookHistory) {
        bookHistoryRepository.save(bookHistory);
    }
}
