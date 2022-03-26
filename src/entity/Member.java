
package entity;

/**
 *
 * @author Gunaseelan
 */
public class Member implements Comparable<Member>{
    protected int MemberId;
    private String MemberName;
    private String Email;
    private int Points;
    private static int MemberCount = 0;
    
    public Member() {
        
    }

    public Member(int MemberId, String MemberName, String Email, int Points) {
        this.MemberId = MemberId;
        this.MemberName = MemberName;
        this.Email = Email;
        this.Points = Points;
    }
    

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int MemberId) {
        this.MemberId = MemberId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPoints() {
        return this.Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public static int getMemberCount() {
        return MemberCount;
    }

    @Override
    public String toString() {
        return "\n{" +
                " memberID='" + getMemberId() + "'" +
                ", memberName='" + getMemberName() + "'" +
                ", email='" + getEmail() + "'" +
                ", numberOfPoints='" + getPoints() + "'" +
                "}";
    }
    
    @Override
    public int compareTo(Member t) {
        return (int) (this.MemberId - t.MemberId);
    }
    
}
