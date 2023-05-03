package com.alon.jobApplicationsManager.services;

import com.alon.jobApplicationsManager.JobAppException;
import com.alon.jobApplicationsManager.beans.ApplicationResponse;
import com.alon.jobApplicationsManager.beans.Interview;
import com.alon.jobApplicationsManager.beans.JobApplication;
import com.alon.jobApplicationsManager.messages.ErrorMessages;
import com.alon.jobApplicationsManager.messages.Message;
import com.alon.jobApplicationsManager.repositories.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public ApplicationResponse addInterview(Interview interviewToAdd, String userId) throws JobAppException {
        ArrayList<Interview> userInterviews = getUserInterviews(userId);

        boolean sameDayInterview = userInterviews.stream().anyMatch(
                interview -> interview.getInterviewTime().getDayOfYear() == interviewToAdd.getInterviewTime().getDayOfYear());

        if (sameDayInterview) throw new JobAppException(ErrorMessages.SAME_DAY_INTERVIEW);

        Optional<JobApplication> jobApplicationOptional = repository.findById(interviewToAdd.getJobApplicationId());

        ApplicationResponse response = new ApplicationResponse(jobApplicationOptional.orElseThrow(
                () -> new JobAppException(ErrorMessages.JOB_APP_NOT_FOUND)).addInterView(interviewToAdd));

        System.out.println("Interview " + interviewToAdd + " successfully added");

        return response;
    }

    public ApplicationResponse addJobApplication(JobApplication jobApplication) throws JobAppException {
        List<JobApplication> userApplications = getUserApplications(jobApplication.getUserId());

        boolean isApplicationExists = isApplicationExists(userApplications, jobApplication);

        if (isApplicationExists) throw new JobAppException(ErrorMessages.POSITION_EXISTS);

        jobApplication = repository.save(jobApplication);

        System.out.println("Application " + jobApplication + " successfully added.");

        return new ApplicationResponse(jobApplication);
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
