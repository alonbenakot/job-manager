package com.alon.jobApplicationsManager.services;

import com.alon.jobApplicationsManager.exceptions.JobAppException;
import com.alon.jobApplicationsManager.beans.User;
import com.alon.jobApplicationsManager.messages.ErrorMessages;
import com.alon.jobApplicationsManager.repositories.UserRepository;
import com.alon.jobApplicationsManager.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponse addUser(User user) throws JobAppException {
        if (isUserExists(user)) {
            throw new JobAppException(ErrorMessages.USER_EXISTS);
        }
        return new UserResponse(repository.save(user));
    }

    private boolean isUserExists(User user) {
        return repository.existsByEmail(user.getEmail()) || !user.getId().isBlank();
    }

    private User getUser(String userId) throws JobAppException {
        Optional<User> userOptional = repository.findById(userId);
        return userOptional.orElseThrow(() -> new JobAppException(ErrorMessages.USER_NOT_FOUND));
    }

    public UserResponse getOneUser(String userId) throws JobAppException {
        return new UserResponse(getUser(userId));
    }

    public void deleteUser(String userId) throws JobAppException {
        long deleteCount = repository.removeById(userId);
        if (deleteCount < 1) {
            throw new JobAppException(ErrorMessages.USER_NOT_FOUND);
        }
    }

    public UserResponse updateUser(User userToUpdate) throws JobAppException {
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

        return new UserResponse(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
