import java.util.*;

public class StudentGradeCalculator{
//     public static void percentages(int marks){
//         int marks[] = new marks[5];
//     }
    public static void grade(int percentages){
         
        if(percentages>= 90){
           System.out.println("Grade : " + "A");
        } 
        else if(percentages>= 80){
            System.out.println("Grade : " + "B");
        } else {
            System.out.println("Grade : " + "C");
        }
    }
    

    public static void main(String args[]){
        int marks[] = new int[5];

        Scanner sc = new Scanner(System.in);
  
        System.out.println("Enter your marks : ");

        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();
        marks[3] = sc.nextInt();
        marks[4] = sc.nextInt();

        int totalmarks = (marks[0] + marks[1] + marks[2] + marks[3] + marks[4] );
        System.out.println("Total Marks = " + totalmarks);

        System.out.println("ADA : " + marks[0]);
        System.out.println("M3 : " + marks[1]);
        System.out.println("Operating System : " + marks[2] );
        System.out.println("Software Engineering : " + marks[3]);
        System.out.println("COA : " + marks[4]);

        int percentages = (marks[0] + marks[1] + marks[2] + marks[3] + marks[4] ) / 5;
        System.out.println("Percentages = " + percentages + "%");
        
        grade(percentages);
        
    }
}