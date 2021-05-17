package com.example.reservation.respository;

import com.example.reservation.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRespo extends MongoRepository<Reservation,String> {

    Optional<Reservation> findByName(String name);
}
