package com.alon.jobApplicationsManager.responses;

import com.alon.jobApplicationsManager.beans.User;

public class UserResponse extends SystemResponse{

    public UserResponse(User user) {
        super(user);
    }

    public UserResponse(User user, String messageText) {
        super(user, messageText);
    }
}
