package com.sandbox.insuranceapplication.repositories;

import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends ListCrudRepository<PolicyEntity, Long> {

    @Query("SELECT p FROM PolicyEntity p WHERE p.name = :name")
    PolicyEntity findByPolicyName(@Param("name") String name);

}
