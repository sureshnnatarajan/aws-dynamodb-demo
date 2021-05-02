package com.vaaniga.aws.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaaniga.aws.model.DataSource;

@EnableScan
@Repository
public interface DataSourceRepository extends CrudRepository<DataSource, String> {

	Iterable<DataSource> findByDataSourceUrl(String dataSourceUrl);
}
