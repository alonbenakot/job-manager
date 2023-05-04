package com.alon.jobApplicationsManager.messages;

import lombok.Data;

@Data
public class SystemMessage {
    private String messageText;
    private boolean messageExists;

    public SystemMessage() {
        this.messageText = null;
        this.messageExists = false;
    }

    public SystemMessage(String messageText) {
        this.messageText = messageText;
        this.messageExists = true;
    }
}
