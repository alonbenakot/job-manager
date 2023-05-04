package com.alon.jobApplicationsManager.repositories;

import com.alon.jobApplicationsManager.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<String> findByEmail(String email);

    boolean existsByEmail(String email);

    Long removeById(String userId);
}
