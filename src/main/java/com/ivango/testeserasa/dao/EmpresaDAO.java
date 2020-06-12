package com.ivango.testeserasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivango.testeserasa.entity.EmpresaEntity;

@Repository
public interface EmpresaDAO extends JpaRepository<EmpresaEntity, Integer> {

}
