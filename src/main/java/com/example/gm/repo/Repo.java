package com.example.gm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.gm.model.User;

@Repository
public interface Repo extends CrudRepository <User,Integer>{

}
