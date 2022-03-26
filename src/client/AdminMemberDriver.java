
package client;

import entity.MemberList;
import entity.Message;
import java.util.*;

/**
 *
 * @author Gunaseelan
 */

public class AdminMemberDriver  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberList member = new MemberList();
        int input;
        
        Message.MessageMenu();
        input = scanner.nextInt();
        member.rawData();
        
        do{
          if(input == 1){
                do{
                    System.out.print("\n");
                    member.addMember();
                    System.out.println("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input == 1);
            }

            if(input == 2){
                do{
                    System.out.print("\n");
                    member.deleteMember();
                    System.out.println("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input == 2);
            }

            if(input == 3){
                do{
                    System.out.print("\n");
                    member.chooseMember();
                    System.out.print("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input == 3);
            }

            if(input == 4){
                do{
                    System.out.print("\n");
                    member.highestPoints();
                    System.out.println("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input == 4);
            }

            if(input == 5){
                do{
                    System.out.print("\n");
                    member.lowestPoints();
                    System.out.print("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input == 5);
            }

            if(input == 6){
                do{
                    System.out.print("\n");
                    member.viewMember();
                    System.out.print("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input == 5);
            }

            if(input >= 7){
                do{
                    System.out.print("\n");
                    member.errorMessage();
                    System.out.println("\n");
                    Message.MessageMenu();
                    input = scanner.nextInt();
                }while(input >= 6);
            }  
        }while(input != 0);
    
    }
    
}
