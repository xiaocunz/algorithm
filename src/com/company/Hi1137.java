package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/2.
 */
public class Hi1137 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int b = in.nextInt();

        List<Candidate> mCandidates = new ArrayList<>();
        List<Candidate> fCandidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Candidate candidate = new Candidate();
            candidate.sex = in.next().charAt(0);
            candidate.ability = in.nextInt();
            candidate.salary = in.nextInt();
            candidate.index = i;
            if (candidate.sex == 'F') {
                fCandidates.add(candidate);
            } else {
                mCandidates.add(candidate);
            }
        }

        List<List<Candidate>> mLists = getCandidateList(mCandidates, x);
        List<List<Candidate>> fLists = getCandidateList(fCandidates, y);

        List<Candidate> result = new ArrayList<>();

        int ability = 0;
        int cost = Integer.MAX_VALUE;

        for (int i = 0; i < mCandidates.size(); i++) {
            for (int j = 0; j < fCandidates.size(); j++) {
                List<Candidate> item = new ArrayList<>();
                item.addAll(mLists.get(i));
                item.addAll(fLists.get(j));
                Collections.sort(item);
                AbilityAndCost abilityAndCost = getAbilityAndCost(item);
                if (abilityAndCost.cost > b || abilityAndCost.ablity < ability) {
                    continue;
                }
                if ((abilityAndCost.ablity > ability) || (abilityAndCost.ablity == ability && abilityAndCost.cost <cost)) {
                    result.clear();
                    result.addAll(item);
                    ability = abilityAndCost.ablity;
                    cost = abilityAndCost.cost;
                } else if ( abilityAndCost.ablity == ability && abilityAndCost.cost == cost) {
                    if (!compareIndex(result, item)) {
                        result.clear();
                        result.addAll(item);
                        ability = abilityAndCost.ablity;
                        cost = abilityAndCost.cost;
                    }
                }
            }
        }

        String str = "";
        System.out.println(ability + " " + cost);
        for (Candidate cadidate : result) {
            str += cadidate.index + 1 + " ";
        }
        System.out.println(str.trim());


//        System.out.println(candidates);
    }

    private static List<List<Candidate>> getCandidateList(List<Candidate> candidates, int n) {
        Candidate[] items = new Candidate[n];
        List<List<Candidate>> list = new ArrayList<>();
        get(candidates, 0, 0, items, list);

        return list;
    }

    private static void get(List<Candidate> candidates, int startIndex, int start, Candidate[] items, List<List<Candidate>> list) {
        if (start == items.length) {
            List<Candidate> temp = new ArrayList<>();
            for (Candidate c : items) {
                temp.add(c);
            }
            list.add(temp);
            return;
        }
        for (int i = startIndex; i < candidates.size(); i++) {
            Candidate candidate = candidates.get(i);

            items[start] = candidate;

            get(candidates, i + 1, start + 1, items, list);
        }
    }

    private static AbilityAndCost getAbilityAndCost(List<Candidate> candidates) {
        AbilityAndCost item = new AbilityAndCost();
        int ability = 0;
        int cost = 0;
        for (int i = 0; i < candidates.size(); i++) {
            ability += candidates.get(i).ability;
            cost += candidates.get(i).salary;
        }

        item.ablity = ability;
        item.cost = cost;
        return item;
    }

    private static boolean compareIndex(List<Candidate> candidates1, List<Candidate> candidates2) {
        for (int i = 0; i < candidates1.size(); i++) {
            if (candidates1.get(i).index - candidates2.get(i).index < 0) {
                return true;
            }
        }

        return false;
    }
}

class Candidate implements Comparable{
    public char sex;
    public int ability;
    public int salary;
    public int index;

    @Override
    public int compareTo(Object o) {
        return index - ((Candidate)o).index;
    }
}

class AbilityAndCost {
    public int ablity;
    public int cost;
}
