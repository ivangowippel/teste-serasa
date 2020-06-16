package com.ivango.testeserasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivango.testeserasa.entity.RegistroFinanceiroEntity;

@Repository
public interface RegistroFinanceiroDAO extends JpaRepository<RegistroFinanceiroEntity, Integer> {

}
