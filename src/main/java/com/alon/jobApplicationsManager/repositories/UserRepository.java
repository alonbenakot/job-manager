package com.alon.jobApplicationsManager.repositories;

import com.alon.jobApplicationsManager.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
