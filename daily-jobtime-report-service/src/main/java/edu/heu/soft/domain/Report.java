package edu.heu.soft.domain;

/**
 * Created by mjrt on 2/19/2017.
 */
public class Report {

    private Long id;
    private String name;    //unique
    private String project;
    private String task;     //length = 4096
    private double workLoad;
    private double overTime;
    private String state = "UNAUDITED";

    public Report() {
    }

    public Report(String name, String project, String task, double workLoad, double overTime, String state) {
        this.name = name;
        this.project = project;
        this.task = task;
        this.workLoad = workLoad;
        this.overTime = overTime;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(double workLoad) {
        this.workLoad = workLoad;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", project='" + project + '\'' +
                ", task='" + task + '\'' +
                ", workLoad=" + workLoad +
                ", overTime=" + overTime +
                ", state='" + state + '\'' +
                '}';
    }

}
