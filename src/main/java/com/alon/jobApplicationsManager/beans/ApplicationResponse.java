package com.alon.jobApplicationsManager.beans;

import com.alon.jobApplicationsManager.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationResponse {
    private JobApplication jobApplication;
    private Message message;

    public ApplicationResponse(JobApplication jobApplication) {
        this.jobApplication = jobApplication;
        this.message = new Message();
    }

    public ApplicationResponse(JobApplication jobApplication, String messageText) {
        this.jobApplication = jobApplication;
        this.message = new Message(messageText);
    }
}
