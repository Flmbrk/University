package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by flmbrk on 06.11.2016.
 */
public class DFA {

    private Set<State> Q; //States
    private Set<Character> sigma; //Alphabyte
    private Set<State> F; // Final states
  //  private Map<State,Map<Character,State>> delta; //Mapping function
    private State q0; // Entry state

    public DFA(Set<State> Q, Set<Character> sigma, Set<State> F, State q0){
        this.Q = Q;
        this.sigma = sigma;
        this.F = F;
        this.q0 = q0;
    }

    class State{

        public State(int id){
            this.id = id;
            this.delta = new ArrayList<>();
        }

        public State(int id, boolean finalState){
            this.id = id;
            this.delta = new ArrayList<>();
            this.finalState = finalState;
        }

        public void addTransition(char c, State s){
            this.delta.add(new Transition(c,s));
        }


        private ArrayList<Transition> delta;

        private int id;

        private boolean finalState;

    }

    class Transition {
        public Transition(char c, State next){
            this.c = c;
            this.next = next;
        }

        public char c;

        public State next;

    }





    public DFA minimize(){
       // return new DFA();
    }

    public boolean equals(DFA dfa){
        if(this == dfa)
            return true;
        return true;
    }


}
