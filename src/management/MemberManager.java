package management;

import datastructures.interfaces.Map;
import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private Map<String, Member> memberMap;

    public MemberManager() {
        this.memberMap = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new NullPointerException("Member cannot be null");
        }
        if (memberMap.containsKey(member.getMemberId())) {
            throw new IllegalArgumentException("Member already exists");
        }
        memberMap.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return memberMap.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = getMember(memberId);
        if (member != null) {
            member.addTransaction(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = getMember(memberId);
        return member != null ? member.getLastTransaction() : null;
    }
}