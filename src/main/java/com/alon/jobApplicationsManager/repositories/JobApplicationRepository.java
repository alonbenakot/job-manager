package com.alon.jobApplicationsManager.repositories;

import com.alon.jobApplicationsManager.beans.JobApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends MongoRepository<JobApplication, String> {

    ArrayList<JobApplication> findByUserId(String userId);

}
