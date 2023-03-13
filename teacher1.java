import java.util.Scanner;

class teacher {
    Scanner sc = new Scanner(System.in);

    static class Student {
        String name, username, password;
        int rollNo, workday;
        int[] attendence = new int[20];
        boolean isApplied = false;
        String isAccepted = "NA";

        Student(String sName, int rNo, String un, String pd, int wd) {
            name = sName;
            rollNo = rNo;
            username = un;
            password = pd;
            workday = wd;
        }
        
        Student(String sName, int rNo, String un, String pd) {
            name = sName;
            rollNo = rNo;
            username = un;
            password = pd;
            workday = 10;
        }
    }

    static class Instructor {
        String name, username,password;
        int id;

        Instructor(String name,int id, String username, String password) {
            this.name = name;
            this.username = username;
            this.id=id;
            this.password = password;
        }

    }

    static class Administrator {

        Scanner sc = new Scanner(System.in);

        Student[] createStudentAccount() {
            System.out.println("Enter the no. of students: ");
            int num = sc.nextInt();
            Student[] st = new Student[num];
            System.out.println("Enter details of students: ");
            for (int i = 0; i < num; i++) {
                System.out.println("Enter the name of student no. " + i + 1);
                String name = sc.next();
                System.out.println("Enter the Roll No. of student " + i + 1);
                int roll = sc.nextInt();
                System.out.println("Enter the UserName of student " + i + 1);
                String un = sc.next();
                System.out.println("Enter the Password of student " + i + 1);
                String pd = sc.next();
                st[i] = new Student(name, roll, un, pd);
            }
            return st;
        }

        Instructor[] createInstructorAccount() {
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the no. of Instructors: ");
            int num = sc.nextInt();
            Instructor[] in = new Instructor[num];
            System.out.println("Enter details of Instructor: ");
            for (int i = 0; i < num; i++) {
                System.out.println("Enter the name of Instructor no. " + (i + 1));
                String name = sc.next();
                System.out.println("Enter the ID No. of Instructor " + (i + 1));
                int roll = sc.nextInt();
                System.out.println("Enter the UserName of Instructor " + (i + 1));
                String un = sc.next();
                System.out.println("Enter the Password of INSTRUCTOR " + (i + 1));
                String pd = sc.next();
                in[i] = new Instructor(name, roll, un, pd);
            }
            return in;
        }

        void viewStudentsList(Student[] s, int num) {
            for (int i = 0; i < num; i++) {
                System.out.println(s[i].name + " ");
                System.out.println(s[i].rollNo + "\n");
            }
        }

        void viewInstructorsList() {

        }
    }

    static void studentLogin(Student[] s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Login ID ");
        String Id = sc.next();
        System.out.println("Enter the password: ");
        String pass = sc.next();
        boolean isLogin = false;
        int studentId = -1;
        for (int i = 0; i < s.length; i++) {
            if ((s[i].username).compareTo(Id) == 0 && (s[i].password).compareTo(pass) == 0) {
                studentId = i;
                System.out.println("User Found and Logged In!\nNow Enter the choice to proceed: ");
                isLogin = true;
            }
        }
        if (!isLogin) {
            System.out.println("Username or Password Mismatch, Please retry!");
            return;
        }

        System.out.println("Select choice 1: View Attendence      2: Apply for Leave    3: View Application Status\n");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("\nYour Attendence is as follows :-\n");
                for (int i = 0; i < s[studentId].workday; i++) {
                    System.out.println(s[studentId].attendence[i] + "  ");
                }
                break;
            case 2:
            
                System.out.println("You have successfully applied for leave, Now go study!");
                s[studentId].isApplied = true;

                break;
            
            case 3:
                if(s[studentId].isAccepted.compareTo("NA") == 0){
                    System.out.println("You have not yet applied for leave!");
                }
                else if(s[studentId].isAccepted.compareTo("Yes")==0){
                    System.out.println("Congratulations! Your leave application has been accepted. Now go and have fun!");
                }
                else{
                    System.out.println("BadLuck! Your application was rejected, Try next time.");
                }
        }

    }

    static void instructorLogin(Instructor[] inst, Student[] s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Login ID ");
        String Id = sc.next();
        System.out.println("Enter the password: ");
        String pass = sc.next();
        boolean isLogin = false;
        int studentId = -1;
        for (int i = 0; i < inst.length; i++) {
            if ((inst[i].username).compareTo(Id) == 0 && (inst[i].password).compareTo(pass) == 0) {
                studentId = i;
                System.out.println("User Found and Logged In!\nNow Enter the choice to proceed: ");
                isLogin = true;
            }
        }
        if (!isLogin) {
            System.out.println("Username or Password Mismatch, Please retry!");
            return;
        } 

            int ch=0,it=0;
            while(it!=4){
                System.out.println("Select choice \n1:Set Attendence      \n2: View Leave Application\n3: View attendence\n4:Exit");
                ch = sc.nextInt();
             switch (ch) {
                case 1:
                System.out.println("enter the total no of working days");
                int workday=sc.nextInt();
                System.out.println("Enter the roll No. of student : ");
                int rollN = sc.nextInt();
                for (int i = 0; i < s.length; i++) {
                    if ((s[i].rollNo) == rollN ) {
                        studentId = i;
                    }
                }
                s[studentId].workday = workday;
                for (int i = 0; i < workday; i++) {
                    System.out.println("Enter day " + (i + 1) + " Attendence 0 for absent and 1 for present!");
                    s[studentId].attendence[i] = sc.nextInt();
                    }
                break;
                case 2:
                    System.out.println();
                    s[studentId].isApplied = true;
                    for (int i = 0; i < s.length; i++) {
                        if ((s[i].isApplied) == true) {
                            System.out.println("Student with roll No. "+ s[i].rollNo+" had applied for Leave\nDo you want to accept the request? for YES enter 1 else enter 0");
                            int ac = sc.nextInt();
                            if(ac==1)
                            s[i].isAccepted = "Yes";
                            else
                            s[i].isAccepted = "No";
                        }
                    }
                    break;
                
                case 3: 
                    System.out.println("Enter the Roll NO. of student to see attendence: ");
                    int rNo = sc.nextInt();
                    System.out.println("Following is the detail of student attendence: ");
                    for(int i=0; i<10; i++){
                        if(s[i].rollNo == rNo){
                            for(int j=0; j<10; j++){
                                System.out.println(s[i].attendence[j]+"  ");
                            }
                        }
                        
                    }
                case 4:
                 it=4;
                 break;
                }
                if(it==4)break;
            }
                
     }
    
        
        
    

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Administrator a = new Administrator();
        Student[] s = new Student[0];
        Instructor[] i = new Instructor[0];
        int iterate = 0;
        while (iterate != 4) {
            System.out.print("Select the Option 1: Admin    2: Student      3: Instructor         4: Exit\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(
                            "Welcome to the ADMIN PANEL select the option to operate the fuctions\n 1: Create Student Record\n 2: Create Instructors Record\n 3: View Student Record\n 4: View Instructors Record\n");
                    int aChoice = sc.nextInt();
                    switch (aChoice) {
                        case 1:
                            s = a.createStudentAccount();
                            break;
                        case 2:
                            i = a.createInstructorAccount();
                            break;
                        case 3:
                            a.viewStudentsList(s, 5);
                            break;
                        default:
                            System.out.println("Enter the correct choice: ");
                    }
                    break;

                case 2:
                    studentLogin(s);
                    break;
                case 3:
                    instructorLogin(i,s);
                    break;
                case 4:
                    iterate = 4;
                    break;

            }
        }
    }

}