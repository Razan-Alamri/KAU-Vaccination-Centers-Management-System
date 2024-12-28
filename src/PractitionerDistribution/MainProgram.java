package PractitionerDistribution;

// Razan Alamri, Program 1 KAU Vaccination Centers Management System, 3-10-2021.
import java.io.*;
import java.util.*;

public class MainProgram {

    //arraylist for center
    static ArrayList<Center> arraylistLLOfCenter = new ArrayList<>();
    //arraylist for center name
    static ArrayList<String> centrName = new ArrayList<>();
    //variable for center capacity
    static int maxCapacityOfCenter = 0;
   
    public static void main(String[] args) throws Exception {

        File inputFile = new File("intialInformation.txt");
        // check if the inputFile is exists.
        if (!inputFile.exists()) {
            System.out.println("The File " + inputFile.getName() + " is not exists");
            System.exit(0);
        }
        File inputFile2 = new File("commands.txt");
        // check if the inputFile2 is exists.
        if (!inputFile.exists()) {
            System.out.println("The File " + inputFile.getName() + " is not exists");
            System.exit(0);
        }
        // making txt file to print Log in it.
        File outputFile = new File("output.txt");
        // PrintWriter for that file.
        PrintWriter printSystem = new PrintWriter(outputFile);
        // Scanner to read from intialInformation txt file.
        Scanner inputSystem = new Scanner(inputFile);
        // Scanner to read from commands txt file.
        Scanner inputcommands = new Scanner(inputFile2);

        // print header.
        printSystem.println("	Welcome to the KAU Vaccination Centers Management System\n"
                + "       ---------------------------------------------------------");
        int counterDisplay = 0;

        String check;
        // **** Reading the commands from input ****.
        while (inputcommands.hasNext()) {

            check = inputcommands.next();

            if (check.equalsIgnoreCase("STARTUP")) {//command for start up.

                startup(inputSystem, inputcommands, printSystem);

            } else if (check.equalsIgnoreCase("DISPLAY_ALL_CENTERS")) {//command for DISPLAY_ALL_CENTERS.
                // for print this  meesage for once
                if (counterDisplay == 0) {
                    printSystem.println("\nThe first distribution for health practitioners among the vaccination centers \n"
                            + "=================================================================================================== \n");
                    counterDisplay++;
                }
                displayAllCenters(printSystem);
            } else if (check.equalsIgnoreCase("NUM_PRACTIONERS")) {//command for NUM_PRACTIONERS.

                numPractioners(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("DISPLAY")) {//command for DISPLAY.

                display(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("DISPLAY_ALL_BASED_ON_STATUS")) {//command for DISPLAY_ALL_BASED_ON_STATUS.

                displayAllBasedOnStatus(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("DISPLAY_BASED_ON_STATUS")) {//command for DISPLAY_BASED_ON_STATUS.

                displayBasedOnStatus(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("LEAVE_THE_JOB")) {//command foor LEAVE_THE_JOB.

                leaveTheJob(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("REMOVE_ALL_LEFT_PRACTITIONERS")) {//command for REMOVE_ALL_LEFT_PRACTITIONERS.

                removeAllLeftPractitioners(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("MOVE")) {//command for MOVE.

                move(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("DELETE_CENTER")) {//command for DELETE_CENTER.

                deleteCenter(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("MERGE")) {//command for MERGE.

                merge(inputcommands, printSystem);
            } else if (check.equalsIgnoreCase("QUIT")) {//command for stop the KAU Vaccination Centers Management System program.
                printSystem.println("			-------------------------------------\n"
                        + "	   	       |	     Good Bye                 |\n"
                        + "                        -------------------------------------    \n\n\n\n");
                break;
            }
        }
// * closing the printWriter and input for intialInformation.txt, commands.txt and output.txt *.
        inputSystem.close();
        inputcommands.close();
        printSystem.flush();
        printSystem.close();
    }

    // --------------------- this method for initialize the system .
    public static void startup(Scanner inputSystem, Scanner inputcommands, PrintWriter printSystem) {
        //read number of center.
         int numberOfCenter = inputSystem.nextInt();
        for (int ID = 0; ID < numberOfCenter; ID++) {
            //read capacity
             int capacityOfCenter = inputSystem.nextInt();
            //create a new center object, and send its ID to iteration + 1 and its capacity.
            Center center_LL = new Center(ID + 1, capacityOfCenter);
            //add to list
            arraylistLLOfCenter.add(center_LL);
        }
        // read and print vaccination centers name.
        printSystem.println("The vaccination centers are:");
        for (int i = 0; i < numberOfCenter; i++) {
            centrName.add(inputSystem.next().replace("_", " "));
            printSystem.print("   " + centrName.get(i) + "\n");
        }
        for (int a = 0; a < arraylistLLOfCenter.size(); a++) {
            for (int b = 0; b < arraylistLLOfCenter.get(a).getCapacity(); b++) {
                if (inputcommands.hasNext()) {
                    //add Practitioner to the list.
                    Practitioner toAddPractitioner = new Practitioner(inputSystem.next(), inputSystem.next(), inputSystem.next(), "Exist", a);
                    arraylistLLOfCenter.get(a).addPractitioner(toAddPractitioner);
                }
            }

        }
    }

    // --------------------- this method for display All Centers and thire Practioners.
    public static void displayAllCenters(PrintWriter printSystem) {

        // loop for print center.
        printSystem.print("       ");
        for (int c = 0; c < arraylistLLOfCenter.size(); c++) {
            printSystem.print(centrName.get(c) + "		  ");
        }
        printSystem.println("\n\n--------------------------------------------------------------------------------------------------");

        Practitioner forDisplayAllCenterspractitioner = null;

        // This variable (capacityOfCenter) for determain capsity in each center.
        for (int i = 0; i < arraylistLLOfCenter.size(); i++) {
            
            int capacityOfPract = arraylistLLOfCenter.get(i).getCapacity();             
            if (capacityOfPract > maxCapacityOfCenter) {
                maxCapacityOfCenter = capacityOfPract;              
            }
        }
        //loop for print practitioner in center.
        for (int k = 0; k < maxCapacityOfCenter; k++) {
            for (int h = 0; h < arraylistLLOfCenter.size(); h++) {

                // Create object to get head of practitioner in center.
                forDisplayAllCenterspractitioner = arraylistLLOfCenter.get(h).getHead();
                // Counter for check to print all information practitioner in center.
                int counterForCheckAllinfo = 0;
                // Loop for pass all Practitioner.
                while (counterForCheckAllinfo != k) {

                    if (forDisplayAllCenterspractitioner != null) {
                        forDisplayAllCenterspractitioner = forDisplayAllCenterspractitioner.getNext();
                    }
                    counterForCheckAllinfo++;
                }
                // Print practitioner informations.
                if (forDisplayAllCenterspractitioner != null) {

                    printSystem.printf("%-30s", forDisplayAllCenterspractitioner.toString());
                } 
                else if (forDisplayAllCenterspractitioner == null) {
         
                    break;
                }
            } printSystem.println();
        }
        printSystem.println("===================================================================================================");
    }

    // --------------------- this method for count Number of practitioners in each center.
    public static void numPractioners(Scanner inputcommands, PrintWriter printSystem) {

        //for read specified center.
        int specifiedCenterID = inputcommands.nextInt();
        //loop for print all center.
        for (int n = 0; n < arraylistLLOfCenter.size(); n++) {
            //Center object for found specific Center.
            Center specificCenter = arraylistLLOfCenter.get(n);
            //Check for center ID.
            if (specificCenter.getCenterID() == specifiedCenterID) {
                //print number of Practioners in center.
                printSystem.println("\nNumber of practitioners in center " + specifiedCenterID + ": " + specificCenter.getCapacity());
            }
        }
        printSystem.println("===================================================================================================");
    }

    // --------------------- this method for display all health practitioners in the specified center.
    public static void display(Scanner inputcommands, PrintWriter printSystem) {
        //for read specified center.
        int specifiedCenterID = inputcommands.nextInt();

        //create a pointer of type Practitioner to point at the Practitioner objects in each center.
        Practitioner forDisplayPractitioner = arraylistLLOfCenter.get(specifiedCenterID - 1).getHead();
        //print.
        printSystem.println("\n	The practitioners of center " + specifiedCenterID + " are\n"
                + "        -------------------------------------------------\n\n      			 " + centrName.get(specifiedCenterID - 1)
                + "\n\n-----------------------------------------------------");
        //while the pointer doesn't point to null, get next in linked list.
        while (forDisplayPractitioner != null) {

            printSystem.println("		" + forDisplayPractitioner.toString());

            forDisplayPractitioner = forDisplayPractitioner.getNext();
        }
        printSystem.println("=======================================================");
    }

    // --------------------- this method for display the health practitioners in all centers based on the status.  
    public static void displayAllBasedOnStatus(Scanner inputcommands, PrintWriter printSystem) {

        //assume that there are no exist practitioner.
        boolean statusIsExist = false;
        //for read the practitioner status.
        String specifiedPractitionerStatus = inputcommands.next();

        //loop to iterate over the list of practitioner. 
        for (int o = 0; o < arraylistLLOfCenter.size(); o++) {

            //create a practitioner object to read the code easier.
            Practitioner pointerForPractitionerStatus = arraylistLLOfCenter.get(o).getHead();

            //check each practitioner's status if it is exist. 
            while (pointerForPractitionerStatus != null) {

                //if the status is exist, change boolean variable to true. 
                if (pointerForPractitionerStatus.getStatus().equals(specifiedPractitionerStatus)) {
                    statusIsExist = true;
                }
                //move pointer to the next practitioner object in linked list. 
                pointerForPractitionerStatus = pointerForPractitionerStatus.getNext();
            }
        }
        //if Exist not true, print the following message.
        if (statusIsExist != true) {
            printSystem.println("\nNot found any practitioners of the status " + specifiedPractitionerStatus);
        } //if Exist true, print the the information of practitioner.
        else {

            printSystem.println("\n	The practitioners of status " + specifiedPractitionerStatus + " are");
            printSystem.println("        -------------------------------------\n");

            // loop for print center
            for (int u = 0; u < arraylistLLOfCenter.size(); u++) {
                printSystem.print("       " + centrName.get(u) + "		  ");
            }
            printSystem.println("\n\n--------------------------------------------------------------------------------------------------");

            //loop for print practitioner Exist in center.
            for (int q = 0; q < maxCapacityOfCenter; q++) {
                for (int r = 0; r < arraylistLLOfCenter.size(); r++) {

                    Practitioner pointerForPrintPractit = arraylistLLOfCenter.get(r).getHead();
                    // Counter for check to print all information practitioner in center.
                    int counterForCheckAllinfo = 0;
                    // Loop for pass all practitioner.
                    while (counterForCheckAllinfo != q) {

                        if (pointerForPrintPractit != null) {
                            pointerForPrintPractit = pointerForPrintPractit.getNext();
                        }
                        counterForCheckAllinfo++;
                    }
                    // Print practitioner informations.
                    if (pointerForPrintPractit != null) {
                        printSystem.printf("%-35s", pointerForPrintPractit.toString());

                    } else if (pointerForPrintPractit == null) {
                        break;
                    }
                }
                printSystem.println();
            }
        }
        printSystem.println("===================================================================================================");
    }

    // --------------------- this method for display the health practitioners in specific centers based on the status.  
    public static void displayBasedOnStatus(Scanner inputcommands, PrintWriter printSystem) {
        //assume that there are no exist practitioner.
        boolean statusIsExist = false;
        //for read the practitioner status.
        String specifiedPractitionerStatus = inputcommands.next();
        //for read specified center.
        int specifiedCenterID = inputcommands.nextInt();

        for (int f = 0; f < arraylistLLOfCenter.size(); f++) {

            //if the centerID is equal to the center value given.
            if (arraylistLLOfCenter.get(f).getCenterID() == specifiedCenterID) {
                Practitioner pointerForPractitionerStatus = arraylistLLOfCenter.get(f).getHead();

                //check each practitioner's status if it is exist. 
                while (pointerForPractitionerStatus != null) {
                    //if the status is exist, change boolean variable to true. 
                    if (pointerForPractitionerStatus.getStatus().equals(specifiedPractitionerStatus)) {
                        statusIsExist = true;
                    }
                    //move pointer to the next practitioner object in linked list. 
                    pointerForPractitionerStatus = pointerForPractitionerStatus.getNext();
                }
            }
        }
        //if Exist not true, print the following message.
        if (statusIsExist != true) {
            printSystem.println("\nNot found any practitioners of the status " + specifiedPractitionerStatus + " in center " + specifiedCenterID
                    + "\n===================================================================================================");
        } else {
            //print practitioners of status and center ID.
            printSystem.println("\n	The practitioners of status " + specifiedPractitionerStatus + " in center " + specifiedCenterID + " are"
                    + "\n        -------------------------------------------------\n");
            printSystem.println("      			 " + centrName.get(specifiedCenterID - 1)
                    + "\n\n-----------------------------------------------------");

            //for print practitioner Exist in specific center.
            Practitioner pointerForPrintPractit = arraylistLLOfCenter.get(specifiedCenterID - 1).getHead();
            while (pointerForPrintPractit != null) {
                if (pointerForPrintPractit.getStatus().equals(specifiedPractitionerStatus)) {
                    printSystem.println("		" + pointerForPrintPractit.toString());
                }
                pointerForPrintPractit = pointerForPrintPractit.getNext();
            }
            printSystem.println("=======================================================");
        }
    }

    // --------------------- this method for search practitioner ID who will given in all linked lists and change status to Left.
    public static void leaveTheJob(Scanner inputcommands, PrintWriter printSystem) {
        //represents the practitioner id who will leave the center.
        String specifiedPractitionerID = inputcommands.next();
        //assume that there are not found practitioner.
        boolean foundPractitioner = false;

        for (int s = 0; s < arraylistLLOfCenter.size(); s++) {

            //create a Practitioner object and search by ID.
            Practitioner forSearchPractitioner = arraylistLLOfCenter.get(s).searchByID(specifiedPractitionerID);
            //pointr for print all practitioner in specific center.
            Practitioner forPrintPractitioner = arraylistLLOfCenter.get(s).getHead();

            //if the practitionerID is equal to the practitioner ID value given.
            if (forSearchPractitioner != null) {
                //set status as left and foundPractitioner = true.
                forSearchPractitioner.setStatus("Left");
                foundPractitioner = true;

                printSystem.println("\nThe practitioner of id " + specifiedPractitionerID + " is left"
                        + "\n\n	The practitioners of center "+arraylistLLOfCenter.get(s).getCenterID()+" are"
                                + "\n        -------------------------------------------------\n");
                printSystem.println("      			 " + centrName.get(s)
                        + "\n\n-----------------------------------------------------");
                //loop for print all practitioner in specific center.                 
                while (forPrintPractitioner != null) {

                    printSystem.println("		" + forPrintPractitioner.toString());

                    forPrintPractitioner = forPrintPractitioner.getNext();
                }
            }
        }
        //if the foundPractitioner not true, print the following message.
        if (foundPractitioner != true) {
            printSystem.println("\nNot found any practitioners with ID" + specifiedPractitionerID + "  in any cener");
        }

        printSystem.println("=======================================================");
    }

    // --------------------- this method for delete all left practitioners from all centers and add them to the new linked list.
    public static void removeAllLeftPractitioners(Scanner inputcommands, PrintWriter printSystem) {
        //create Center linked list for all left practitioner.
        Center allLeftPracti = new Center();

        for (int u = 0; u < arraylistLLOfCenter.size(); u++) {
            //pointer for head.
            Practitioner pointerForLftPractitioner = arraylistLLOfCenter.get(u).getHead();

            while (pointerForLftPractitioner != null) {
                // Ckeck for status equal to left.
                if (pointerForLftPractitioner.getStatus().equalsIgnoreCase("left")) {
                    //create a new practitioner object to add to the list of left practitioner.
                    Practitioner leftPractitioner = new Practitioner(pointerForLftPractitioner.getParctID(), pointerForLftPractitioner.getFname(), pointerForLftPractitioner.getlName(), pointerForLftPractitioner.getStatus(), u);
                    //get all left practitioner from all center with ease.
                    allLeftPracti.addPractitioner(leftPractitioner);
                    //remove all left practitioner.
                    arraylistLLOfCenter.get(u).deletePractitionersBasedOnStatus(pointerForLftPractitioner.getStatus());
                    
                    //for change Capacity after remove practitioner with left status.
                    int changeC=(arraylistLLOfCenter.get(u).getCapacity())-1;
                    arraylistLLOfCenter.get(u).setCapacity(changeC);
                    maxCapacityOfCenter = 0;
                }
                pointerForLftPractitioner = pointerForLftPractitioner.getNext();
            }
        }
        //pointr for print all practitioner left.
        Practitioner forPrintPractitioner = allLeftPracti.getHead();
        printSystem.println("\n 	All left Practitioners are moved to new linked list\n"
                + "	---------------------------------------------------");
        while (forPrintPractitioner != null) {
            printSystem.println("   " + forPrintPractitioner);
            forPrintPractitioner = forPrintPractitioner.getNext();
        }
        //for display All Centers after remove the practitioners of status left. 
        printSystem.println("\n        The remaining practitioners After remove the practitioners of status left"
                + "\n	------------------------------------------------------------------------");
        displayAllCenters(printSystem);
    }

    // --------------------- this method for remove practitioners will given from a  current center and add them to the required  center.
    public static void move(Scanner inputcommands, PrintWriter printSystem) {
        //represents the practitioner id who will move from the center.
        String specifiedPractitionerID = inputcommands.next();
        //for read specified center.
        int specifiedCenterID = inputcommands.nextInt();

        for (int l = 0; l < arraylistLLOfCenter.size(); l++) {
            //pointer for head.
            Practitioner pointerForMovePractitioner = arraylistLLOfCenter.get(l).getHead();

            while (pointerForMovePractitioner != null) {
                //if the practitionerID is equal to the practitioner ID value given.
                if (pointerForMovePractitioner.getParctID().equalsIgnoreCase(specifiedPractitionerID)) {
                    //change Practitioner status to Moved.
                    pointerForMovePractitioner.setStatus("Moved");
                    //create a new practitioner object to add to the list of Moved practitioner.
                    Practitioner movePractitioner = new Practitioner(pointerForMovePractitioner.getParctID(), pointerForMovePractitioner.getFname(), pointerForMovePractitioner.getlName(), pointerForMovePractitioner.getStatus(), l);
                    //remove practitioner from the current center.
                    arraylistLLOfCenter.get(l).deletePractitionerById(pointerForMovePractitioner.getParctID());
                    
                    //for change Capacity after moved practitioner.
                    int changeC=(arraylistLLOfCenter.get(l).getCapacity())-1;
                    arraylistLLOfCenter.get(l).setCapacity(changeC);                    
                    //add practitioner to the required center.
                    arraylistLLOfCenter.get(specifiedCenterID - 1).addPractitioner(movePractitioner);
                    //for change Capacity after add practitioner.
                    int changeCa=(arraylistLLOfCenter.get(l).getCapacity())-1;
                    arraylistLLOfCenter.get(specifiedCenterID - 1).setCapacity(changeCa);
                    maxCapacityOfCenter = 0;
                }
                pointerForMovePractitioner = pointerForMovePractitioner.getNext();
            }
        }
        //for display All Centers after move some practitioners of status.
        printSystem.println("\n	The Practitioner of id " + specifiedPractitionerID + " is moved to center " + specifiedCenterID
                + "\n	------------------------------------------------");
        displayAllCenters(printSystem);
    }

    // --------------------- this method for delete the whole specified center.
    public static void deleteCenter(Scanner inputcommands, PrintWriter printSystem) {
        //for read specified center.
        int specifiedCenterID = inputcommands.nextInt();

        for (int g = 0; g < arraylistLLOfCenter.size(); g++) {
            //if the centerID is equal to the center ID value given.
            if (arraylistLLOfCenter.get(g).getCenterID() == specifiedCenterID) {
                //for remove the whole specified center.
                arraylistLLOfCenter.remove(g);
                //if the centeer has been remove, print this message.
                printSystem.println("\n  			Center " + specifiedCenterID + " is Closed\n"
                        + "===================================================================================================");
            }
        }
    }

    // --------------------- this method for merge all the remainingg linked lists to a new one.
    public static void merge(Scanner inputcommands, PrintWriter printSystem) {
        //create a new center linked list.
        Center linkedListForMerge = new Center();

        for (int w = 0; w < arraylistLLOfCenter.size(); w++) {
            // Create pointer object to get head of practitioner in center.
            Practitioner pointerForMerge = arraylistLLOfCenter.get(w).getHead();

            while (pointerForMerge != null) {
                //add each Practitioner to the list
                Practitioner pactitionerForAdded = new Practitioner(pointerForMerge.getParctID(), pointerForMerge.getFname(), pointerForMerge.getlName(), pointerForMerge.getStatus(), w);
                linkedListForMerge.addPractitioner(pactitionerForAdded);
                //move pointer to the next practitioner object in linked list.
                pointerForMerge = pointerForMerge.getNext();
            }
        }
        //prent heder.
        printSystem.println("\n			The remaing centers ar merged\n"
                + "\n--------------------------------------------------------------------------------------------------");

        // Create pointer object to get head of practitioner in center.
        Practitioner pointerForprint = linkedListForMerge.getHead();
        //for print a new linked list after merge.
        while (pointerForprint != null) {
            printSystem.println(pointerForprint.toString());
            //move pointer to the next practitioner object in linked list.
            pointerForprint = pointerForprint.getNext();
        }
        printSystem.println("===================================================================================================");
    }
}
