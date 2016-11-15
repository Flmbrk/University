package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static ArrayList<NFA.State> makeStates(){
        ArrayList<NFA.State> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(new NFA.State(i+1));
        }
        return list;
    }

    public static void main(String[] args) {
	// write your code here
        final String sigma = "1234567890.@";
        final String digits = "1234567890";
        ArrayList<NFA.State> states1 = makeStates();
        NFA.Reader nfa1 = new NFA.Reader();
        nfa1.setq0(states1.get(0));
        nfa1.setSigma(sigma);
     //   nfa1.makePath();

    }
}
