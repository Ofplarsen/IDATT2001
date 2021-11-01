package edu.ntnu.oflarsen.arvogpolymorfi.Members;

import edu.ntnu.oflarsen.arvogpolymorfi.Personals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class BonusMember {
    public static final double FACTOR_SILVER = 1.2;
    public static final double FACTOR_GOLD = 1.5;
    private final int memberNo;
    private final Personals personals;
    private final LocalDate enrolledDate;
    private int point = 0;

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
    }

    public int findQualificationPoints(LocalDate dato) throws IllegalArgumentException{
        try {
            if (ChronoUnit.DAYS.between(enrolledDate, dato) <= 365) {
                return point;
            } else {
                return 0;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public boolean okPassword(String password){
        return personals.okPassword(password);
    }

    public void registerPoints(int points){
        point += points;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public Personals getPersonals() {
        return personals;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getPoints() {
        return point;
    }

}
