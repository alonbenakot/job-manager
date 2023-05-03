package com.alon.jobApplicationsManager.beans;

import lombok.Data;

@Data
public class Company {
    private String id;
    private String name;
    private String field;


    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return this.getName().equals(((Company) o).getName());
    }
}
