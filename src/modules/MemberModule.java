
package modules;

import adt.Guna.*;
import entity.Member;
import utility.Utility;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Gunaseelan
 */
public class MemberModule extends Member {

    Scanner scanner = new Scanner(System.in);
    static SortedListInterface<Member> memberList = new SortedLinkedList<>();

    public MemberModule(int MemberId, String MemberName, String Email, int numberOfPoints) {
        super(MemberId, MemberName, Email, numberOfPoints);
    }

    public MemberModule() {

    }

    public static SortedListInterface<Member> getMemberList() {
        return memberList;
    }

    public void errorMessage() {
        System.out.println("Please enter between Option 1 until Option 6");
    }

    public void addMember() {
        System.out.println("Enter the details of the member to add.");
        int id = 106;
        id += 1;

        System.out.print("Member Name: ");
        String name = scanner.nextLine();

        System.out.print("Member Email: ");
        String email = scanner.nextLine();

        System.out.print("Member Points: ");
        int points = scanner.nextInt();

        memberList.add(new Member(id, name, email, points));

        System.out.println("\nMember \"" + name + "\" is added");
    }

    public void deleteMember() {
        System.out.println("Enter the member id to remove.");

        System.out.print("Member Id: ");
        int id = scanner.nextInt();

        Iterator<Member> m = memberList.getIterator();

        while (m.hasNext()) {
            Member member = m.next();

            if (member.getMemberId() == id) {
                memberList.remove(member);
                System.out.println("\nMember \"" + member.getMemberName() + "\" has been removed. ");
                break;
            }

        }

    }

    public void chooseMember() {
        System.out.println("Enter the member id to select.");

        System.out.print("Member Id: ");
        int id = scanner.nextInt();

        Iterator<Member> m = memberList.getIterator();

        while (m.hasNext()) {
            Member member = m.next();

            if (member.getMemberId() == id) {
                System.out.print("\n");
                System.out.println("---------Member---------");
                System.out.println("Member ID: \t" + member.getMemberId());
                System.out.println("Member Name: \t" + member.getMemberName());
                System.out.println("Member Email: \t" + member.getEmail());
                System.out.println("Member Points: \t" + member.getPoints());
            }
        }
    }

    public void highestPoints() {

        Iterator<Member> m = memberList.getIterator();
        int max = 0;
        int maxid = 0;
        String maxName = "";
        String maxEmail = "";

        while (m.hasNext()) {
            Member member = m.next();

            if (member.getPoints() > max) {
                max = member.getPoints();
                maxid = member.getMemberId();
                maxName = member.getMemberName();
                maxEmail = member.getEmail();
            }
        }

        System.out.println("---------Highest points---------");
        System.out.println("Member ID: \t" + maxid);
        System.out.println("Member Name: \t" + maxName);
        System.out.println("Member Email: \t" + maxEmail);
        System.out.println("Member Points: \t" + max);
    }

    public void lowestPoints() {

        Iterator<Member> m = memberList.getIterator();
        int min = 9999;
        int minid = 0;
        String minName = "";
        String minEmail = "";

        while (m.hasNext()) {
            Member member = m.next();

            if (member.getPoints() < min) {
                min = member.getPoints();
                minid = member.getMemberId();
                minName = member.getMemberName();
                minEmail = member.getEmail();
            }
        }

        System.out.println("---------Lowest points---------");
        System.out.println("Member ID: \t" + minid);
        System.out.println("Member Name: \t" + minName);
        System.out.println("Member Email: \t" + minEmail);
        System.out.println("Member Points: \t" + min);
        System.out.print("\n");
    }

    public void initMemberData() {
        memberList.add(new Member(101, "John", "john@gmail.com", 1000));
        memberList.add(new Member(102, "Joseph", "joseph@gmail.com", 1200));
        memberList.add(new Member(103, "Joshua", "joshua@gmail.com", 500));
        memberList.add(new Member(104, "Jack", "jack@gmail.com", 900));
        memberList.add(new Member(105, "Jill", "jill@gmail.com", 2000));
        memberList.add(new Member(106, "Jim", "jim@gmail.com", 2500));
    }

    public void viewMember() {
        Iterator<Member> ite = memberList.getIterator();
        System.out.println("Member ID\tMember Name\tMember Email\t\tMember Points");
        System.out.println("---------------------------------------------------------------------");
        while (ite.hasNext()) {
            Member mem = ite.next();
            System.out.printf("%-15d %-15s %-23s %-15d\n", mem.getMemberId(), mem.getMemberName(), mem.getEmail(),
                    mem.getPoints());
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.println("\nTotal Members: " + memberList.getNumberOfEntries());
    }

    public void displayMemberMenu() {
        // System.out.println("Choose the following options to run: ");
        System.out.println("Member Module Menu");
        System.out.println("====================");
        System.out.println("[1] Display member list");
        System.out.println("[2] Add new member");
        System.out.println("[3] Delete a member");
        System.out.println("[4] Select a member");
        System.out.println("[5] Select member with highest points");
        System.out.println("[6] Select member with lowest points");
        System.out.println("[0] Return to Main Menu\n");
    }

    public void memberMenu() {
        scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            Utility.clearScreen();
            displayMemberMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            System.out.println();
            System.out.println();
            switch (input) {
                case "1":
                    viewMember();
                    Utility.cont();
                    break;
                case "2":
                    addMember();
                    Utility.cont();
                    break;
                case "3":
                    deleteMember();
                    Utility.cont();
                    break;
                case "4":
                    Utility.clearScreen();
                    chooseMember();
                    Utility.cont();
                    break;
                case "5":
                    highestPoints();
                    Utility.cont();
                    break;
                case "6":
                    lowestPoints();
                    Utility.cont();
                    break;
                case "0":
                    exit = true;
                    Utility.clearScreen();
                    break;
                default:
                    errorMessage();
                    break;
            }
        } while (!exit);
    }

}
