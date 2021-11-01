package edu.ntnu.oflarsen.arvogpolymorfi.Members;

import edu.ntnu.oflarsen.arvogpolymorfi.Personals;

import java.time.LocalDate;

public class BasicMember extends BonusMember {

    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        super(memberNo, personals, enrolledDate);
    }

}
