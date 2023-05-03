package com.alon.jobApplicationsManager.services;

import com.alon.jobApplicationsManager.beans.User;
import com.alon.jobApplicationsManager.messages.ErrorMessages;
import com.alon.jobApplicationsManager.messages.Messages;
import com.alon.jobApplicationsManager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void addUser(User user) throws Exception {
        if (repository.existsById(user.getId())) {
            throw new Exception(ErrorMessages.USER_EXISTS);
        }
        repository.save(user);
    }

}
