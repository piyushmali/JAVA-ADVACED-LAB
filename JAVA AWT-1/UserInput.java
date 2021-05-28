  
import java.util.Scanner;
 
public class UserInput
{
    public static void main(String args[])  throws Exception
    {
        String name, gender;
        int age;
        float weight;
         
        Scanner SC=new Scanner(System.in);
         
        System.out.print("Enter name: ");
        name= SC.nextLine();
         
        System.out.print("Enter Gender (Male/Female): ");
        gender=SC.next();
 
        System.out.print("Enter age: ");
        age=SC.nextInt();
 
        System.out.print("Enter weight: ");
        weight=SC.nextFloat();
         
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
                                  
    }
}
