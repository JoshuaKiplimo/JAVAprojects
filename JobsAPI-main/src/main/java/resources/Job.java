package resources;

public class Job {
    private String jobTitle;
    private String location;
    private String companyName;
    private String jobsnippet;
    private String days;
    private String absoluteURL;


    public Job(String jobTitle, String location, String companyName, String jobsnippet, String days, String absoluteURL){
        this.jobTitle = jobTitle;
        this.location = location;
        this.companyName=companyName;
        this.jobsnippet = jobsnippet;
        this.days = days;
        this.absoluteURL = absoluteURL;
    }
    public String getjobTitle() {
        return this.jobTitle;
    };
    public String getLocation() {
        return this.location;
    };
    public String getcompanyName() {
        return this.companyName;
    };
    public String getjobsnippet() {
        return this.jobsnippet;
    };
    public String getdays() {
        return this.days;
    };
    public String getabsoluteURL() {
        return this.absoluteURL;
    };
}


