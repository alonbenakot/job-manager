package com.alon.jobApplicationsManager.beans;

public enum ContactType {
    HR("HR"),
    TEAM_LEADER("Team Leader"),
    RECRUITER("Recruiter"),
    PRODUCT_MANAGER("Product Manager"),
    CEO("CEO");

    public final String role;

    ContactType(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
