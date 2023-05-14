package com.fluffydevs.journeybeacon.repository;

import com.fluffydevs.journeybeacon.model.Payments;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payments,String>  {

    @Query("SELECT * FROM PAYMENTS WHERE user_id = :userId")
    List<Payments> findByUserId(String userId);
}
