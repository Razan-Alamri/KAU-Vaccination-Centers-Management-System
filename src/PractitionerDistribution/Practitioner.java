package PractitionerDistribution;

// Razan Alamri, Program 1 KAU Vaccination Centers Management System, 3-10-2021.
public class Practitioner {

    // Data filed
    private String parctID;
    private String Fname;
    private String lName;
    private String Status;
    private int center;
    private Practitioner next;

    // contructors
    public Practitioner(String parctID, String Fname, String lName, String Status, int center) {
        this.parctID = parctID;
        this.Fname = Fname;
        this.lName = lName;
        this.Status = Status;
        this.center = center;
        this.next = next;
    }

    // Setters and Getters of Data filed
    public String getParctID() {
        return parctID;
    }

    public void setParctID(String parctID) {
        this.parctID = parctID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public Practitioner getNext() {
        return next;
    }

    public void setNext(Practitioner next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return parctID + " " + Fname + " " + lName + " , " + Status;
    }

}
