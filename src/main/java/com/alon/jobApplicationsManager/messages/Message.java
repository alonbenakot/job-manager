package com.alon.jobApplicationsManager.messages;

import lombok.Data;

@Data
public class Message {
    private String messageText;
    private boolean messageExists;

    public Message() {
        this.messageText = null;
        this.messageExists = false;
    }

    public Message(String messageText) {
        this.messageText = messageText;
        this.messageExists = true;
    }
}
