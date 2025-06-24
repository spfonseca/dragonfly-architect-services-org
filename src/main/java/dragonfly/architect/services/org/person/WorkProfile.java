package dragonfly.architect.services.org.person;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "work_profile")
public class WorkProfile {
    
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "work_profile_id")
    private UUID workProfileId;

    @Column(name = "status", length = 32)
    private String status;

    @Column(name = "hire_date", length = 16)
    private String hireDate;

    @Column(name = "separation_date", length = 16)
    private String separationDate;

    // "current_role" is a reserved keyword in PostgreSQL. Use escaped column name.
    @Column(name = "\"current_role\"", length = 64)
    private String currentRole;

    @Column(name = "current_level", length = 32)
    private String currentLevel;

    @Column(name = "current_manager_id", length = 64)
    private String currentManagerId;

    @Column(name = "current_organization_id", length = 64)
    private String currentOrganizationId;

    @Embedded
    private PayDetails currentPayDetails;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "work_profile_id")
    private List<RoleHistory> roleHistory;

    // Getters and setters
    public UUID getWorkProfileId() {
        return workProfileId;
    }

    public void setWorkProfileId(UUID workProfileId) {
        this.workProfileId = workProfileId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getSeparationDate() {
        return separationDate;
    }

    public void setSeparationDate(String separationDate) {
        this.separationDate = separationDate;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getCurrentManagerId() {
        return currentManagerId;
    }

    public void setCurrentManagerId(String currentManagerId) {
        this.currentManagerId = currentManagerId;
    }

    public String getCurrentOrganizationId() {
        return currentOrganizationId;
    }

    public void setCurrentOrganizationId(String currentOrganizationId) {
        this.currentOrganizationId = currentOrganizationId;
    }

    public PayDetails getCurrentPayDetails() {
        return currentPayDetails;
    }

    public void setCurrentPayDetails(PayDetails currentPayDetails) {
        this.currentPayDetails = currentPayDetails;
    }

    public List<RoleHistory> getRoleHistory() {
        return roleHistory;
    }

    public void setRoleHistory(List<RoleHistory> roleHistory) {
        this.roleHistory = roleHistory;
    }
}

@Embeddable
class PayDetails {
    @Column(name = "yearly_salary")
    private Double yearlySalary;

    @Column(name = "yearly_equity")
    private Double yearlyEquity;

    @Column(name = "yearly_bonus_percentage")
    private Double yearlyBonusPercentage;
    // Getters and setters
    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public Double getYearlyEquity() {
        return yearlyEquity;
    }

    public void setYearlyEquity(Double yearlyEquity) {
        this.yearlyEquity = yearlyEquity;
    }

    public Double getYearlyBonusPercentage() {
        return yearlyBonusPercentage;
    }

    public void setYearlyBonusPercentage(Double yearlyBonusPercentage) {
        this.yearlyBonusPercentage = yearlyBonusPercentage;
    }
}

@Entity
@Table(name = "role_history")
class RoleHistory {
    
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "start_date", length = 16)
    private String startDate;

    @Column(name = "end_date", length = 16)
    private String endDate;

    @Column(name = "role", length = 64)
    private String role;

    @Column(name = "level", length = 32)
    private String level;

    @Column(name = "manager_id", length = 64)
    private String managerId;

    @Column(name = "organization_id", length = 64)
    private String organizationId;

    @Embedded
    private PayDetails payDetails;
    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public PayDetails getPayDetails() {
        return payDetails;
    }

    public void setPayDetails(PayDetails payDetails) {
        this.payDetails = payDetails;
    }
}
