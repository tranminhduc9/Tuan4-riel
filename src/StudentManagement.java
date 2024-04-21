import java.util.Scanner;
public class StudentManagement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = inputStudent(sc);
        
        outputStudent(students);
        System.out.println("sx theo ten");
        outputStudent(sortByName(students));
        System.out.println("sx theo gioi tinh");
        outputStudent(sortByGender(students));
        System.out.println("loc theo gioi tinh");
        String inputGender= sc.nextLine();
        outputStudent(filterByGender(students, inputGender));
        System.out.println("loc theo id");
        String inputClass= sc.nextLine();
        outputStudent(filterById(students, inputClass));
        
    }
    static Student[] inputStudent(Scanner sc){
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];
        for(int i =0; i<n;i++){
            String name =  sc.nextLine();
            String id =  sc.nextLine();
            String birth =  sc.nextLine();
            String gender =  sc.nextLine();
            String address =  sc.nextLine();
            students[i] = new Student(name,id,birth,gender,address);
        }
        return students;
    }
    static void outputStudent(Student[] students){
        for(int i=0; i< students.length;i++){
            if(students[i]==null)
                continue;
            else
                System.out.println(students[i].toString());
        }
    }
    static char firstNameChar(String name){
        int check = name.lastIndexOf(' ');
        char x = name.charAt(check+1);
        return x;
    }
    static Student[] sortByName(Student[] students){
        if(students.length>=2){
            Student[] students1= new Student[students.length];
            for(int i =0;i<students.length;i++){
                students1[i] = students[i];
            }
            for(int i=0; i< students.length-1;i++){
                for(int j =0; j< students.length-1;j++){
                    char stu1 = firstNameChar(students1[j].getName());
                    char stu2 = firstNameChar(students1[j+1].getName());
                    if(stu1 > stu2){
                        Student temp = students1[j];
                        students1[j]=students1[j+1];
                        students1[j+1]=temp;
                    }
                }
            }return students1;
        }
        else
        return students;
    }
    static Student[] sortByGender(Student[] students){
        if(students.length>=2){
            Student[] students1= new Student[students.length];
            int check=0;
            for(int i=0;i<students.length;i++){
                if(students[i].getGender().equals("Male")){
                    students1[check]=students[i];
                    check++;
                }
            }
            for(int i=0;i<students.length;i++){
                if(students[i].getGender().equals("Female")){
                    students1[check]=students[i];
                    check++;
                    if(check > students.length){
                        break;
                    }
                }
            }return students1;
        }
        else
        return students;
    }
    static Student[] filterByGender(Student[] students,String inputGender){
        int check=0;
        Student[] students1= new Student[students.length];
        for(int i=0;i<students.length;i++){
            if(students[i].getGender().equals(inputGender)){
                students1[check]=students[i];
                check++;
            }
        }
        return students1;
    }
    static Student[] filterById(Student[] students,String inputClass){
        int check=0;
        Student[] students1= new Student[students.length];
        for(int i=0;i<students.length;i++){
            if(students[i].getId().substring(0, 2).equals(inputClass)){
                students1[check]=students[i];
                check++;
            }
        }
        return students1;
    }
}
