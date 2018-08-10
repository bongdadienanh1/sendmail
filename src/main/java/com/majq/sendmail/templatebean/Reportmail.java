package com.majq.sendmail.templatebean;

/**
 * reportmail 模板bean
 */
public class Reportmail {

    private String tddate;
    private String name;
    private String department;
    private String timeam;
    private String workcontentam;
    private String wayam;
    private String telleram;
    private String timepm;
    private String waypm;
    private String workcontentpm;
    private String tellerpm;
    private String experience;
    private String suggestion;

    public Reportmail(String tddate, String name, String department, String timeam,
                      String workcontentam, String wayam, String telleram, String timepm,
                      String waypm, String workcontentpm, String tellerpm, String experience,
                      String suggestion) {
        this.tddate = tddate;
        this.name = name;
        this.department = department;
        this.timeam = timeam;
        this.workcontentam = workcontentam;
        this.wayam = wayam;
        this.telleram = telleram;
        this.timepm = timepm;
        this.waypm = waypm;
        this.workcontentpm = workcontentpm;
        this.tellerpm = tellerpm;
        this.experience = experience;
        this.suggestion = suggestion;
    }

    public String getTddate() {
        return tddate;
    }

    public void setTddate(String tddate) {
        this.tddate = tddate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTimeam() {
        return timeam;
    }

    public void setTimeam(String timeam) {
        this.timeam = timeam;
    }

    public String getWorkcontentam() {
        return workcontentam;
    }

    public void setWorkcontentam(String workcontentam) {
        this.workcontentam = workcontentam;
    }

    public String getWayam() {
        return wayam;
    }

    public void setWayam(String wayam) {
        this.wayam = wayam;
    }

    public String getTelleram() {
        return telleram;
    }

    public void setTelleram(String telleram) {
        this.telleram = telleram;
    }

    public String getTimepm() {
        return timepm;
    }

    public void setTimepm(String timepm) {
        this.timepm = timepm;
    }

    public String getWaypm() {
        return waypm;
    }

    public void setWaypm(String waypm) {
        this.waypm = waypm;
    }

    public String getWorkcontentpm() {
        return workcontentpm;
    }

    public void setWorkcontentpm(String workcontentpm) {
        this.workcontentpm = workcontentpm;
    }

    public String getTellerpm() {
        return tellerpm;
    }

    public void setTellerpm(String tellerpm) {
        this.tellerpm = tellerpm;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Reportmail{");
        sb.append("tddate='").append(tddate).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", timeam='").append(timeam).append('\'');
        sb.append(", workcontentam='").append(workcontentam).append('\'');
        sb.append(", wayam='").append(wayam).append('\'');
        sb.append(", telleram='").append(telleram).append('\'');
        sb.append(", timepm='").append(timepm).append('\'');
        sb.append(", waypm='").append(waypm).append('\'');
        sb.append(", workcontentpm='").append(workcontentpm).append('\'');
        sb.append(", tellerpm='").append(tellerpm).append('\'');
        sb.append(", experience='").append(experience).append('\'');
        sb.append(", suggestion='").append(suggestion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
