package com.company;

/**
 * Created by flmbrk on 06.11.2016.
 */


import java.util.*;

/**
 * Goal: Check that two NFA's are equal. Two FA equal when thei accept the same language.
 * To check this statement for NFA's we can build two DFA's that accepts same language and then minimize them.
 * Therefore there can be only one minimal DFA for some DFA, after minimizing our DFA's we just using BFS to check that they are the same.
 *
 */


public class NFA   {

    private Set<Character> sigma;
    private Set<State> Q;
    private Set<State> F;
    private Map<State,Map<Character,Set<State>>> delta;
    private State q0;

    public NFA(Set<Character> sigma, Set<State> Q, Set<State> F,Map<State,Map<Character,Set<State>>> delta, State q0){
        this.sigma = sigma;
        this.Q = Q;
        this.F = F;
        this.delta = delta;
        this.q0 = q0;
    }

    public static class State {
        public final int id;
        public boolean terminal = false;
        public State(int id){
            this.id = id;
        }
        public void makeTerminal(){
            this.terminal = true;
        }
    }


    public static class Reader{
        private Set<Character> sigma = new HashSet<>();
        private Set<State> Q = new HashSet<>();
        private Set<State> F = new HashSet<>();
        private Map<State,Map<Character,Set<State>>> delta = new HashMap<>();
        private State q0;

        public State getState(int i){
            for (Iterator<State> it = Q.iterator(); it.hasNext(); ) {
                State f = it.next();
                if (f.id==i)
                    return f;
            }
            return null;
        }

        public void setq0(State q0){
            this.q0 = q0;
        }

        public void makeFinal(State f){
            F.add(f);
        }

        public void setSigma(String str){
            for(char c : str.toCharArray())
                sigma.add(c);
        }

        public void makePath(State from, State to, String str){
            for(char c : str.toCharArray()){
                if (!delta.containsKey(from)) {
                    delta.put(from, new HashMap<>());
                }
                if (!delta.get(from).containsKey(c)) {
                    delta.get(from).put(c, new HashSet<>());
                }
                delta.get(from).get(c).add(to);
            }
        }

        public NFA makeNFA(){
            return new NFA(sigma,Q,F,delta,q0);
        }
    }
    //Implementation of Thompson's algorithm
    /*
    Automaton getDFAbyNFA(\langle \Sigma, Q, s, T, \delta \rangle : Automaton):
        P.push(\{s\})
         Q_d = \varnothing
   while P \neq \varnothing
      P.pop(p_d)
      for c \in \Sigma
         q_d = \varnothing
         for p \in p_d
            q_d = q_d \cup \{ \delta(p, c) \}
            \delta_d(p_d, q_d) = c
         if q_d \notin Q_d
            P.push(q_d)
            Q_d.add(q_d)
   T_d = \{q_d \in Q_d \mid \exists p \in T : p \in q_d\}
   return \langle \Sigma, Q_d, \{s\}, T_d, \delta_d \rangle
     */



    public DFA convertToDfa(){
        Set<Set<State>> qD = new HashSet<>(); // Set of states for our DFA
        HashMap<Set<State>,HashMap<Character,Set<State>>> deltaD = new HashMap<>(); // Delta function for our new DFA
        Queue<Set<State>> queue = new LinkedList<>();
        queue.add(new HashSet<State>());
        queue.peek().add(q0);
        while(!queue.isEmpty()){
            Set<State> temp = queue.poll();
            for(char c : sigma){
                Set<State> newStates = new HashSet<>();
                for(State s : temp){
                    newStates.addAll(delta.get(s).get(c));
                    deltaD.put(temp,new HashMap<>().put(c,newStates));
                }
                if(!qD.contains(newStates)){
                    queue.add(newStates);
                }
            }

        }
        return new DFA(sigma,)
    }




    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

   //public DFA convertToDfa(){

        //return new DFA();
   // }

    //public boolean equal(NFA nfa){
    //    return (this.convertToDfa().minimize().equals(nfa.convertToDfa().minimize()));
  //  }


}
