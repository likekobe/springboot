package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper
{
    
    List<Category> findAll();
    
    int save(Category category);
    
    void delete(int id);
    
    Category get(int id);
    
    int update(Category category);
    
}
