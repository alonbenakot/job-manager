package com.alon.jobApplicationsManager.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class JobApplication {
    private String id;
    private String positionName;
    private LocalDateTime sentDate;
    private ContactPerson contactPerson;
    private Company company;
    private List<String> technologies;
    private String additionalComments;
    private List<Interview> interviews;
    private Boolean continuingProcess;
    private String userId;

    public JobApplication addInterView(Interview interview) {
        if (interviews.isEmpty()) {
            interviews = new ArrayList<>();
        }
        interview.setInterviewNumber(this.interviews.size()+1);
        interview.setJobApplicationId(this.id);
        this.interviews.add(interview);
        this.continuingProcess = Boolean.TRUE;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobApplication that = (JobApplication) o;

        if (!positionName.equals(that.positionName)) return false;
        if (!contactPerson.equals(that.contactPerson)) return false;
        return company.equals(that.company);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + positionName.hashCode();
        result = 31 * result + contactPerson.hashCode();
        result = 31 * result + company.hashCode();
        return result;
    }
}
