package com.alon.jobApplicationsManager.responses;

import com.alon.jobApplicationsManager.beans.JobApplication;
import com.alon.jobApplicationsManager.messages.SystemMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SystemResponse {

    private SystemMessage systemMessage;
    private Object data;

     public SystemResponse(Object data) {
          this.data = data;
          this.systemMessage = new SystemMessage();
     }

     public SystemResponse(Object data, String messageText) {
          this.data = data;
          this.systemMessage = new SystemMessage(messageText);
     }

}
