//khldoon khlefawi
//id : 218110351
package project1;
import java.util.*;
import java.io.*;

public class Menu {
    
    public static void main(String[] args) throws IOException, InterruptedException{
            
        Scanner keyb = new Scanner(System.in);
        ArrayList<Student> studList = new ArrayList<Student>();
        int ans = 0;
     
        System.out.println("Welcome to CS102 Lab Project");
        System.out.println("");
        
        
        boolean key = true;
        while(key == true){
            System.out.println("To read students data from a file, please enter    1");
            System.out.println("To search for a student record, please enter       2");
            System.out.println("To sort the students data, please enter            3");
            System.out.println("To update a student record, please enter           4");
            System.out.println("To delete a student record, please enter           5");
            System.out.println("To save the students data, please enter            6");
            System.out.println("To exit the program, please enter                  7");
            System.out.print("Please enter your choice: ");
            
            // checker for the choice input
            try{
            ans = keyb.nextInt();
            if(ans > 7 || ans < 1){
                System.out.println("there is no choice with input: " + ans);
                System.out.println("----------------------------");
            }
            }catch(Exception e){
                System.out.println("please make sure you enter an integer");
                System.out.println("----------------------------");
                keyb.nextLine();  
            }
            
            // reading file (choice 1)
            if(ans == 1){
                try {
                System.out.print("Please enter the location of the file: ");
                String loc = keyb.next();
                //file location
                //C:\Users\Edge\Desktop\Students_Records.txt
                File file = new File(loc);
                Scanner in = new Scanner(file);
                System.out.println("reading file (" + loc + ")....");
                while(in.hasNext()){
                    int id = in.nextInt();
                    Name name = new Name(in.next(), in.next(), in.next());
                    String major = in.next();
                    double gpa = in.nextDouble();
                    int cr = in.nextInt();                    
                    studList.add(new Student(id, name, gpa, major, cr));
                }
                in.close();
                System.out.println("file has been readed succsefuly");
                System.out.println("----------------------------");
                } catch (Exception e) {
                    System.out.println("the file location you entred is incorrect");
                    System.out.println("----------------------------");
                    }
            }
            
            //searching for a student (choice 2)
            if(ans == 2){
                if (!studList.isEmpty()) {
                    System.out.println("Search for a studetn by: ");
                    System.out.println("1 - by Id");
                    System.out.println("2 - by name");
                    System.out.println("3 - by major");
                    System.out.println("4 - by gpa");
                    System.out.println("5 - by cridet hours");
                    System.out.print("Enter the number of the method you want to search with: ");
                    int choice = keyb.nextInt();
                    
                    //search by id 
                    if (choice == 1) {
                        System.out.println("Enter the student id: ");
                        int stuId = keyb.nextInt();
                        int index = StudFinder(stuId, studList);
                        if (index == -10000) {
                            System.out.println("there is no student with this Id: " + stuId);
                            System.out.println("----------------------------");
                        }
                        else{
                            System.out.println("Student found, printing student data...");
                            System.out.println("----------------------------");
                            System.out.println(studList.get(index));
                            System.out.println("----------------------------");
                        }
                    }
                    
                    //search by name
                    if (choice == 2) {
                        System.out.print("Enter the student First name: ");
                        String fName = keyb.next();
                        System.out.print("Enter the student Middle name: ");
                        String mName = keyb.next();
                        System.out.print("Enter the student Last name: ");
                        String lName = keyb.next();
                        Name target = new Name(fName, mName, lName);
                        boolean found = false;
                        System.out.println("----------------------------");
                        for (int i = 0; i < studList.size(); i++) {
                            Student ref = studList.get(i);
                            if (ref.getName().equals(target)) {
                                System.out.println("student found - printing student data..");
                                System.out.println(ref);
                                found = true;
                            }
                        }
                        System.out.println("----------------------------");
                        if (found == false) {
                            System.out.println("student with name '" + target + "' not found!");
                            System.out.println("----------------------------");
                        }
                    }
                    
                    //search by major
                    if (choice == 3) {
                        System.out.print("Enter the student major: ");
                        String major = keyb.next();
                        boolean found = false;
                        System.out.println("----------------------------");
                        for (int i = 0; i < studList.size(); i++) {
                            Student ref = studList.get(i);
                            if (ref.getMajor().equalsIgnoreCase(major)) {
                                System.out.println(ref);
                                found = true;
                            }
                        }
                        System.out.println("----------------------------");
                        if (found == false) {
                            System.out.println("student with major '" + major + "' not found!");
                            System.out.println("----------------------------");
                        }
                    }
                    
                    //search by gpa
                    if (choice == 4) {
                        System.out.print("Enter the student gpa with 4 decimal places pleas: ");
                        Double gpa = keyb.nextDouble();
                        boolean found = false;
                        System.out.println("----------------------------");
                        for (int i = 0; i < studList.size(); i++) {
                            Student ref = studList.get(i);
                            if (gpa.equals(ref.getGpa())) {
                                System.out.println(ref);
                                found = true;
                            }
                        }
                        System.out.println("----------------------------");
                        if (found == false) {
                            System.out.println("student with gpa '" + gpa + "' not found!");
                            System.out.println("----------------------------");
                        }                        
                    }
                    
                    //search by credit hours
                    if (choice == 5) {
                        System.out.print("Enter the student credit hours: ");
                        Integer cr = keyb.nextInt();
                        boolean found = false;
                        System.out.println("----------------------------");
                        for (int i = 0; i < studList.size(); i++) {
                            Student ref = studList.get(i);
                            if (cr.equals(ref.getCredit_hours())) {
                                System.out.println(ref);
                                found = true;
                            }
                        }
                        System.out.println("----------------------------");
                        if (found == false) {
                            System.out.println("student with credit hours '" + cr + "' not found!");
                            System.out.println("----------------------------");
                        }
                    }                      
                }
                else
                    System.out.println("---------no data to read from---------");
                                  
            }
            
            //sorting the students list (choice 3)
            if (ans == 3) {
                if(!studList.isEmpty()){
                    System.out.println("1 - by Id");
                    System.out.println("2 - by name");
                    System.out.println("3 - by major");
                    System.out.println("4 - by gpa");
                    System.out.println("5 - by cridet hours");
                    System.out.print("Enter the number of the method you want to sort the list with: ");
                    int choice = keyb.nextInt();
                    System.out.print("enter 1 for Increasing order or 2 for Decreasing order: ");
                    int order = keyb.nextInt();
                    //sorting by id
                    if (choice == 1) {
                        //increasing
                        if (order == 1) {
                            Collections.sort(studList);
                        }
                        //decreasing
                        if (order == 2)
                            Collections.sort(studList, Collections.reverseOrder());
                    }
                    //sorting by name
                    if (choice == 2) {
                        //increasing
                        if (order == 1) {
                            Collections.sort(studList, new StudentSortNameInc());
                        }
                        //decreasing
                        if (order == 2)
                            Collections.sort(studList, new StudentSortNameDec());
                    }
                    //sorting by major
                    if (choice == 3) {
                        //increasing
                        if (order == 1) {
                            Collections.sort(studList, new StudentSortMajorInc());
                        }
                        //decreasing
                        if (order == 2)
                            Collections.sort(studList, new StudentSortMajorDec());    
                    }
                    //sorting by gpa
                    if (choice == 4) {
                        //increasing
                        if (order == 1) {
                            Collections.sort(studList, new StudentSortGpaInc());
                        }
                        //decreasing
                        if (order == 2)
                            Collections.sort(studList, new StudentSortGpaDec());                    
                    }
                    //sorting by Credit Hours
                    if (choice == 5) {
                        //increasing
                        if (order == 1) {
                            Collections.sort(studList, new StudentSortCHInc());
                        }
                        //decreasing
                        if (order == 2){
                            Collections.sort(studList, new StudentSortCHDec());
                        }
                    }
                    System.out.println("List has been sorted!");
                    System.out.println("----------------------------");
                }
                else
                    System.out.println("---------no data to read from---------"); 
            }
            
            //updating a student record (choice 4)
            if (ans ==4) {
                if(!studList.isEmpty()){
                System.out.print("Enter the student id: ");
                int id = keyb.nextInt();
                int index = StudFinder(id, studList);
                if (index == -10000) {
                    System.out.println("there is no student with this Id: " + id);
                    System.out.println("----------------------------");
                }
                else{
                    System.out.print("Enter the new First name: ");
                    String fName = keyb.next();
                    System.out.print("Enter the new Middle name: ");
                    String mName = keyb.next();
                    System.out.print("Enter the new Last name: ");
                    String lName = keyb.next();
                    Name newName = new Name(fName, mName, lName);
                    System.out.print("Enter the new Major: ");
                    String major = keyb.next();
                    System.out.print("Enter the new gpa: ");
                    double gpa = keyb.nextDouble();
                    System.out.print("Enter the new Credit Hours: ");
                    int CH = keyb.nextInt();
                    
                    studList.set(index, new Student(id, newName, gpa, major, CH));
                    System.out.println("Student record has been upadted");
                    System.out.println("----------------------------");
                }
            }
                else
                    System.out.println("---------no data to read from---------");
            }
            
            //delete a student record
            if (ans == 5) {
                if(!studList.isEmpty()){
                    System.out.print("Enter the student id: ");
                    int id = keyb.nextInt();
                    int index = StudFinder(id, studList);
                    if (index == -10000) {
                        System.out.println("there is no student with this Id: " + id);
                        System.out.println("----------------------------");
                    }
                    else{
                        studList.remove(index);
                        System.out.println("Student found---student record deleted...");
                        System.out.println("----------------------------");
                    
                    }   
                }
                else
                    System.out.println("---------no data to read from---------");
            }
            
            //saveing the students list into a new file
            if (ans == 6) {
                if(!studList.isEmpty()){
                    System.out.print("Enter the location you want to save the file in: ");                   
                    FileOutputStream fo = new FileOutputStream(new File(keyb.next()));
                    PrintWriter pw = new PrintWriter(fo);
                    for (Student std : studList){
                        pw.println(std);
                    }    
                    pw.close();
                    fo.close();
   
                    System.out.println("file saved in your location..");
                    System.out.println("----------------------------");
                }
                else
                    System.out.println("---------no data to read from---------");
            }
            
            //exit the program
            if (ans == 7) {
                System.exit(0);
            }
        }
    }
    
    //Student finder
    static int StudFinder(int key, ArrayList<Student> studList){
        int index = -10000;
        for (int i = 0; i < studList.size(); i++) {
            if(studList.get(i).getId() == key){
                index = i;
                return (i);
            }
        }
        return index;
    }
    
    //sorting classes
    static class StudentSortNameInc implements Comparator<Student> {
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null || P2 == null)
                throw new NullPointerException("one or two objects are missing");
        
            return(P1.getName().getFirst_name().compareTo(P2.getName().getFirst_name()));
        }
    }
    static class StudentSortNameDec implements Comparator<Student> {
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
        
            return(-P1.getName().getFirst_name().compareTo(P2.getName().getFirst_name()));
        }
    }
    static class StudentSortMajorInc implements Comparator<Student> {
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
        
            return(P1.getMajor().compareTo(P2.getMajor()));
        }
    }
    static class StudentSortMajorDec implements Comparator<Student> {
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
        
            return(-P1.getMajor().compareTo(P2.getMajor()));
        }
    }
    static class StudentSortGpaInc implements Comparator<Student>{
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
            
            Double gpa1 = new Double(P1.getGpa());
            Double gpa2 = new Double(P2.getGpa());
            return(gpa1.compareTo(gpa2));
        }
    }
    static class StudentSortGpaDec implements Comparator<Student> {
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
            
            Double gpa1 = new Double(P1.getGpa());
            Double gpa2 = new Double(P2.getGpa());
            return(-gpa1.compareTo(gpa2));
        }
    }
    static class StudentSortCHInc implements Comparator<Student>{
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
            
            return(P1.getCredit_hours()-P2.getCredit_hours());
        }
    }
    static class StudentSortCHDec implements Comparator<Student>{
        @Override
        public int compare(Student P1, Student P2){
            if(P1 == null | P2 == null)
                throw new NullPointerException("one or two objects are missing");
            
            return(P2.getCredit_hours()-P1.getCredit_hours());
        }
    }
}
