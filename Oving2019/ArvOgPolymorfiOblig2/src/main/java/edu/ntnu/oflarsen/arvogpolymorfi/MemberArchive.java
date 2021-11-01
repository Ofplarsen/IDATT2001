package edu.ntnu.oflarsen.arvogpolymorfi;

import edu.ntnu.oflarsen.arvogpolymorfi.Members.BasicMember;
import edu.ntnu.oflarsen.arvogpolymorfi.Members.BonusMember;
import edu.ntnu.oflarsen.arvogpolymorfi.Members.GoldMember;
import edu.ntnu.oflarsen.arvogpolymorfi.Members.SilverMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MemberArchive {
    public static final int SILVER_LIMIT = 25000;
    public static final int GOLD_LIMIT = 75000;
    private static final int MAX_TRY = 0;
    private static final Random RANDOM_NUMBER = new Random();
    private ArrayList<BonusMember> bonusMembers;

    public MemberArchive(){
        bonusMembers = new ArrayList<>();
    }

    public int newMember(Personals personal, LocalDate date){
        int membershipNumber = findAvailableNo();
        bonusMembers.add(new BonusMember(membershipNumber,personal,date));
        return membershipNumber;
    }


    public int findPoints(int membershipNumber, String password){
        numberNotZero(membershipNumber);

        for(BonusMember bm : bonusMembers){
            if(bm.getMemberNo() == membershipNumber && bm.okPassword(password)){
                return bm.getPoints();
            }
        }
        return -1;
    }

    public boolean registerPoints(int membershipNumber, int points){
        numberNotZero(membershipNumber);
        for(BonusMember bm : bonusMembers){
            if(membershipNumber == bm.getMemberNo()){
                bm.registerPoints(points);
                return true;
            }
        }
        return false;
    }
    

    /**
     * Oppgraderer medlemmer med nok poeng til Silver, eventuelt gull.
     */
    public void checkMembers(LocalDate date) {
        for (int index = 0; index < bonusMembers.size(); index++) {
            BonusMember member = bonusMembers.get(index);
            if (member instanceof BasicMember) {
                member = checkSilverLimit(index, date);
            }
            if (member instanceof SilverMember) { // kan ha fÃ¥tt Silverstatus i setningen over
                checkGoldLimit(index, date);
            }
        }
    }

    private BonusMember checkSilverLimit(int index, LocalDate dato) {
        BonusMember member = bonusMembers.get(index);
        int kvalPoeng = member.findQualificationPoints(dato);
        if (kvalPoeng >= SILVER_LIMIT) {
            // Her kunne vi brukt kopikonstruktør hvis det hadde eksistert
            member = new SilverMember(member.getMemberNo(),
                    member.getPersonals(), member.getEnrolledDate(), member.getPoints());
            bonusMembers.set(index, member);
        }
        return member;
    }

    private BonusMember checkGoldLimit(int index, LocalDate dato) {
        BonusMember member = bonusMembers.get(index);
        int qualificationPoints = member.findQualificationPoints(dato);
        if (qualificationPoints >= GOLD_LIMIT) {
            // Her kunne vi brukt kopikonstruktør hvis det hadde eksistert
            member = new GoldMember(member.getMemberNo(),
                    member.getPersonals(), member.getEnrolledDate(), member.getPoints());
            bonusMembers.set(index, member);
        }
        return member;
    }

    private int findAvailableNo(){
        boolean available = true;
        int nmr = 0;
        do {
            nmr = RANDOM_NUMBER.nextInt();
            for (BonusMember bm : bonusMembers) {
                if(bm.getMemberNo() == nmr){
                    available = false;
                }
            }
        }while(available == false);
        return nmr;
    }

    private BonusMember findMember(int membershipNumber){
        for (BonusMember bm: bonusMembers
             ) {
            if(membershipNumber == bm.getMemberNo()){
                return bm;
            }
        }
        return null;
    }

    private void numberNotZero(int membershipNumber){

        if(membershipNumber <= 0){
            throw new IllegalArgumentException("Membership number can't be 0, or negative!");
        }
    }

}
