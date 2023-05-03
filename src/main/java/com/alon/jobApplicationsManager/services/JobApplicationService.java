package com.alon.jobApplicationsManager.services;

import com.alon.jobApplicationsManager.beans.Interview;
import com.alon.jobApplicationsManager.beans.JobApplication;
import com.alon.jobApplicationsManager.beans.User;
import com.alon.jobApplicationsManager.repositories.JobApplicationRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public void addInterview(Interview interviewToAdd, String userId) throws Exception {
        ArrayList<Interview> userInterviews = getUserInterviews(userId);

        boolean sameDayInterview = userInterviews.stream().anyMatch(
                interview -> interview.getInterviewTime().getDayOfYear() == interviewToAdd.getInterviewTime().getDayOfYear());

        if (sameDayInterview) throw new Exception("You have another interview on the same day");

        Optional<JobApplication> jobApplicationOptional = repository.findById(interviewToAdd.getJobApplicationId());

        jobApplicationOptional.orElseThrow(() -> new Exception("Job application not found")).addInterView(interviewToAdd);

        System.out.println("Interview " + interviewToAdd + " successfully added");
    }

    public void addJobApplication(JobApplication jobApplication) throws Exception {
        List<JobApplication> userApplications = getUserApplications(jobApplication.getUserId());

        boolean isApplicationExists = isApplicationExists(userApplications, jobApplication);

        if (isApplicationExists) throw new Exception("You have already applied to this position");

        repository.save(jobApplication);

        System.out.println("Application " + jobApplication + " successfully added.");
    }

    private boolean isApplicationExists(List<JobApplication> userApplications, JobApplication jobApplication) {
        return userApplications.stream().anyMatch(
                userApplication -> userApplication.equals(jobApplication));
    }

    private ArrayList<Interview> getUserInterviews(String userId) {
        ArrayList<JobApplication> userApplications = getUserApplications(userId);
        ArrayList<Interview> userInterviews = new ArrayList<>();
        userApplications.stream().forEach(app -> userInterviews.addAll(app.getInterviews()));
        return userInterviews;
    }

    private ArrayList<JobApplication> getUserApplications(String userId) {
        return repository.findByUserId(userId);

    }
}
