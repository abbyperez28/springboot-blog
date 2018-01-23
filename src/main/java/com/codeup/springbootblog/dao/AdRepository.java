package com.codeup.springbootblog.dao;

import com.codeup.springbootblog.models.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {
}