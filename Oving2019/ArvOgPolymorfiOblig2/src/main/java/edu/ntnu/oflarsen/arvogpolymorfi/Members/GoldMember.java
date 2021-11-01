package edu.ntnu.oflarsen.arvogpolymorfi.Members;

import edu.ntnu.oflarsen.arvogpolymorfi.Members.BonusMember;
import edu.ntnu.oflarsen.arvogpolymorfi.Personals;

import java.time.LocalDate;

public class GoldMember extends BonusMember {
    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate);
        super.registerPoints(points);
    }

    @Override
    public void registerPoints(int points){
        super.registerPoints((int)Math.round(points* FACTOR_GOLD));
    }
}
