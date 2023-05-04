package com.alon.jobApplicationsManager.responses;

import com.alon.jobApplicationsManager.beans.JobApplication;

public class JobApplicationResponse  extends SystemResponse {

    public JobApplicationResponse(JobApplication jobApplication) {
        super(jobApplication);
    }

    public JobApplicationResponse(JobApplication jobApplication, String messageText) {
        super(jobApplication, messageText);
    }
}
