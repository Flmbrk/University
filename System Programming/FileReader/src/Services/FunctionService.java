package Services;

import java.util.*;

/**
 * Created by flmbrk on 15.09.2016.
 */
public class FunctionService implements Comparator<String>{


    public HashMap<String,Integer> calculateTimes(ArrayList<String> list){
        HashMap<String,Integer> map = new HashMap<>();
        for(String x: list){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else
                map.put(x,1);
        }
        return map;
    }

    public ArrayList<String> onlyVowels(ArrayList<String> list){
        ArrayList<String> result = new ArrayList<>();
        for(String x: list ){
            if(checkVowels(x))
                result.add(x);
        }
        return result;
    }

    private boolean checkVowels(String x){
        String vowels = "aeiou";
        for(int i=0;i<x.length();i++){
            if(vowels.indexOf(x.charAt(i))==-1){
                return false;
            }
        }
        return true;
    }

    @Override
        public int compare(String o1, String o2){
            return Integer.compare(o1.length(), o2.length());
        }

}
