package com.camunda.bpm.servicesdemo.repositories;

import com.camunda.bpm.servicesdemo.model.common.Approver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends CrudRepository<Approver, Long> {

}