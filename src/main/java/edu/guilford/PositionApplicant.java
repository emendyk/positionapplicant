package edu.guilford;

public class PositionApplicant {
    // attributes
   
    private int applicantNumber;
    private int introCompProg;
    private int advCompProg;
    private int operatingSystems;
    private int networking;
    

    // constructor
    public PositionApplicant(int applicantNumber, int introCompProg, int advCompProg, int operatingSystems, int networking) {
        
        this.applicantNumber = applicantNumber;
        this.introCompProg = introCompProg;
        this.advCompProg = advCompProg;
        this.operatingSystems = operatingSystems;
        this.networking = networking;
        
    }
    // getters and setters
    
    
    public int getApplicantNumber() {
        return applicantNumber;
    }
    public void setApplicantNumber(int applicantNumber) {
        this.applicantNumber = applicantNumber;
    }
    public int getIntroCompProg() {
        return introCompProg;
    }
    public void setIntroCompProg(int introCompProg) {
        this.introCompProg = introCompProg;
    }
    public int getAdvCompProg() {
        return advCompProg;
    }
    public void setAdvCompProg(int advCompProg) {
        this.advCompProg = advCompProg;
    }
    public int getOperatingSystems() {
        return operatingSystems;
    }
    public void setOperatingSystems(int operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
    public int getNetworking() {
        return networking;
    }
    public void setNetworking(int networking) {
        this.networking = networking;
    }

    public static void quickSort(int[] applicants) {
        quickSort(applicants, 0, applicants.length - 1);
    }

    //Add a selection sort method that takes an array of integers as a parameter
    // and sorts them using selection sort
    public static void selectionSort(int[] applicants) {
        for (int i = 0; i < applicants.length; i++) {

            int smallest = i; // index of smallest element
            //swap the smallest element with the element at index i
            for (int j = i + 1; j < applicants.length; j++) {

                if (applicants[j] > applicants[smallest])
                // set the index of the smallest element to j
                    smallest = j;
            }
            
            int temp = applicants[i];
            applicants[i] = applicants[smallest];
            applicants[smallest] = temp;
        }
        
       
    }
    public static void quickSort(int[] applicants, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(applicants, start, end);
            quickSort(applicants, start, partitionIndex - 1);
            quickSort(applicants, partitionIndex + 1, end);
        }
    }

    public static int partition(int[] applicants, int start, int end) {
        int pivot = applicants[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (applicants[i] <= pivot) {
                int temp = applicants[i];
                applicants[i] = applicants[partitionIndex];
                applicants[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        int temp = applicants[partitionIndex];
        applicants[partitionIndex] = applicants[end];
        applicants[end] = temp;
        return partitionIndex;
    }

    // add a PositionApplicant sort method using linear search
    public static int linearSearch(int[] applicants, int applicantNumber) {
        for (int i = 0; i < applicants.length; i++) {
            if (applicants[i] == applicantNumber) {
                return i;
            }
        }
        return -1;
    }

    // add a binarySearch algorithm
    public static int binarySearch(int[] applicants, int applicantNumber) {
        int start = 0;
        int end = applicants.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (applicants[mid] == applicantNumber) {
                return mid;
            } else if (applicants[mid] < applicantNumber) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // not found
    }
    
}