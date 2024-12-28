# KAU Vaccination Centers Management System

## Objective
The primary objective of this program is to implement a linked list. The secondary objective is to practice with File I/O and arrays.

## Program Description
This program is designed to manage the distribution of health practitioners among vaccination centers. It utilizes linked lists to organize practitioners within each center, ensuring efficient management and handling of operations. The program interacts with three files: two input files and one output file.

### Assignment PDF
- You can find the detailed assignment in the uploaded PDF file: [KAU Vaccination Centers Management System Assignment.pdf](KAU%20Vaccination%20Centers%20Management%20System%20Assignment.pdf).

### Features
The program implements the following key methods:
1. **Add Practitioner**: Adds a practitioner to the specified center (at the end of the linked list).
2. **Search Practitioner**: Searches for a practitioner based on their ID.
3. **Remove Left Practitioner**: Moves practitioners who have left a center to a new linked list representing left practitioners.
4. **Delete Practitioner**: Deletes a node from the linked list based on the practitioner ID.

### Input Files
1. **`intialInformation.txt`**:
   - Contains system initialization data.
   - Structure:
     - First line: Number of centers and capacities for each center.
     - Second line: Names of the centers.
     - Remaining lines: Practitioners’ information (ID, first name, last name).

2. **`commands.txt`**:
   - Contains commands to perform various operations in the system.

### Output File
- **`output.txt`**:
  - Contains the output of all operations and commands executed by the program.

## Instructions
1. Ensure necessary libraries are installed.
2. Implement linked lists to manage practitioners in each center.
3. Write functions to handle file input/output operations.
4. Debug and test the system thoroughly.

## Files
- **Input Files**:
  - `intialInformation.txt`: Contains system setup and practitioners’ information.
  - `commands.txt`: Contains commands to execute operations.
- **Output File**:
  - `output.txt`: Records the results of executed commands.

## Expected Output
The output in `output.txt` should include:
- Details of practitioners in each center.
- Results of commands like practitioner search, movement, and status-based display.
- Messages for commands that do not find matching data, e.g., “Not found any practitioners of the status <status>”.

