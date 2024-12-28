package PractitionerDistribution;

// Razan Alamri, Program 1 KAU Vaccination Centers Management System, 3-10-2021.
public class Center {

    static String[] centerNames;
    

    // Data filed
    private int centerID;
    private int capacity;
    private Practitioner head;

    // contructors
    public Center() {
        head = null;
    }

    public Center(int centerID, int capacity) {
        this.centerID = centerID;
        this.capacity = capacity;
    }

    // Setters and Getters of Data filed
    public int getCenterID() {
        return centerID;
    }

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Practitioner getHead() {
        return head;
    }

    public void setHead(Practitioner head) {
        this.head = head;
    }

    //check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
    //add Practitioner

    public void addPractitioner(Practitioner practitioner) {

        //check if the head of the list is empty 
        if (isEmpty()) {
            this.head = practitioner;
        } else {
            //Create a pointer to traverse through the linked list
            Practitioner ptrForPractitioner = head;

            //while it is not null then get the next address
            while (ptrForPractitioner.getNext() != null) {
                ptrForPractitioner = ptrForPractitioner.getNext();
            }
            //if null set practitioner as the next
            ptrForPractitioner.setNext(practitioner);
        }
    }
    //search ID of practitioner

    public Practitioner searchByID(String practitionerID) {

        Practitioner ptrForPractitioner = this.head;

        //check if the head of the list is empty
        if (isEmpty()) {
            return null;
        }
        //while it doesn't point to null check if the practitioner object's ID is equal to the ID given  
        while (ptrForPractitioner != null) {
            if (ptrForPractitioner.getParctID().equals(practitionerID)) {
                return ptrForPractitioner;
            }
            //else return the practitioner object
            ptrForPractitioner = ptrForPractitioner.getNext();
        }

        //if not found return null
        return null;
    }
    //delete practitioner Based On Status

    public void deletePractitionersBasedOnStatus(String practitionerStatus) {

        if (!isEmpty()) {
            //create a Practitioner object
            Practitioner ptrForPractitioner = head;

            //if the practitioner object's Status is equal to the Status given, allow  ptrForPractitioner to the next object 
            if (ptrForPractitioner.getStatus().equals(practitionerStatus)) {
                ptrForPractitioner = ptrForPractitioner.getNext();
            }
            // Practitioner object for head
            Practitioner ptrForPractitioner2 = head;

            //check the ptrForPractitioner2 not null
            while (ptrForPractitioner2.getNext() != null) {
                // Check Status
                if (ptrForPractitioner2.getNext().getStatus().equals(practitionerStatus)) {
                    //set next
                    ptrForPractitioner2.setNext(ptrForPractitioner2.getNext().getNext());
                    return;
                }
                // Go to next
                ptrForPractitioner2 = ptrForPractitioner2.getNext();
            }
        }
    }
//delete practitioner by ID

    public void deletePractitionerById(String practitionerID) {

        if (!isEmpty()) {
            //create a Practitioner object
            Practitioner ptrForPractitioner = head;

            //if the practitioner object's ID is equal to the ID given, allow  ptrForPractitioner to the next object 
            if (ptrForPractitioner.getParctID().equals(practitionerID)) {
                ptrForPractitioner = ptrForPractitioner.getNext();
            } else {
                // Practitioner object for head
                Practitioner ptrForPractitioner2 = head;

                //check the ptrForPractitioner2 not null
                while (ptrForPractitioner2 != null) {
                    // Check ID
                    if (ptrForPractitioner2.getNext().getParctID().equals(practitionerID)) {
                        //set next
                        ptrForPractitioner2.setNext(ptrForPractitioner2.getNext().getNext());
                        return;
                    }
                    // Go to next
                    ptrForPractitioner2 = ptrForPractitioner2.getNext();
                }
            }
        }
    }
}
