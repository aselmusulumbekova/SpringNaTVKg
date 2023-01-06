package com.example.springnatvkg.service;

import com.example.springnatvkg.models.request.PriceRequest;

import java.util.List;

public interface BaseService <T>{
    T save(T t);
    T findById(Long id);
    List<T> findAll();
}
