package com.taskmgmt.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskmgmt.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
