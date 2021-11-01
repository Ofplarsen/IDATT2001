package edu.ntnu.oflarsen.arvogpolymorfi.Members;

import edu.ntnu.oflarsen.arvogpolymorfi.Personals;

import java.time.LocalDate;

public class SilverMember extends BonusMember{

    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int poeng) {
        super(memberNo, personals, enrolledDate);
        super.registerPoints(poeng);
    }
    @Override
    public void registerPoints(int points){
        super.registerPoints((int) (points * FACTOR_SILVER));
    }
}
