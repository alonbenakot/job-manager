package com.alon.jobApplicationsManager.services;

import com.alon.jobApplicationsManager.JobAppException;
import com.alon.jobApplicationsManager.beans.User;
import com.alon.jobApplicationsManager.messages.ErrorMessages;
import com.alon.jobApplicationsManager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User getUser(String userId) throws JobAppException {
        Optional<User> userOptional = repository.findById(userId);
        return userOptional.orElseThrow(() -> new JobAppException(ErrorMessages.USER_NOT_FOUND));
    }

    public void deleteUser(String userId) {
        repository.deleteById(userId);
    }

    public User updateUser(User userToUpdate) throws JobAppException {
        User user = getUser(userToUpdate.getId());
        if (userToUpdate.getFirstName() != null && !userToUpdate.getFirstName().equals(user.getFirstName())) {
            user.setFirstName(userToUpdate.getFirstName());
        }
        if (userToUpdate.getLastName() != null && !userToUpdate.getLastName().equals(user.getLastName())) {
            user.setLastName(userToUpdate.getLastName());
        }
        if (userToUpdate.getEmail() != null && !userToUpdate.getEmail().equals(user.getEmail())) {
            user.setEmail(userToUpdate.getEmail());
        }
        if (userToUpdate.getPassword() != null && !userToUpdate.getPassword().equals(user.getPassword())) {
            user.setPassword(userToUpdate.getPassword());
        }
        return user;
    }
}
