package com.alon.jobApplicationsManager.beans;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Interview {
    private LocalDateTime interviewTime;
    private Address address;
    private ContactPerson person;
    private String additionalComments;
    private int interviewNumber;
    private boolean reminder;
    private String JobApplicationId;

}
