package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by flmbrk on 07.11.2016.
 */
public class Lexeme {
    public class Patterns{
        class Pair{
            Color color;
            String pattern;
            public Pair(String pattern){
                this.pattern = pattern;
                color = Color.WHITE;
            }
            public Pair(String pattern, Color color){
                this.pattern = pattern;
                this.color = color;
            }
        }

        //У нас была проблема. Для ее устранения мы решили использовать регулярные выражения. Теперь у нас две проблемы.
        //Regular expressions for parsing file
        final String commentPattern = "(?:/\\\\*(?:[^*]|(?:\\\\*+[^*/]))*\\\\*+/)|(?://.*)";
        final String stringPattern = "\".*\"";
        final String charPattern = "\'.*\'";
        final String decimalPattern = "\\d+[LlUu]*";
        final String floatPattern = "(\\\\d+\\\\.\\\\d*|\\\\.\\\\d+|\\\\d+)([eE][+-]?\\\\d+)?";
        final String hexPattern = ("0x[0-9a-fA-F]+[LlUu]*");
        final String octPattern = "0[0-7]+[LlUu]*";
        final String keywordsPattern = "(abstract|continue|for|new|switch|" +
                "assert|default|goto|package|synchronized|" +
                "do|if|private|this|" +
                "break|implements|protected|throw|" +
                "else|import|public|throws|" +
                "case|enum|instanceof|return|transient|" +
                "catch|extends|try|" +
                "final|interface|static|void|" +
                "class|finally|strictfp|volatile|" +
                "const|native|super|while)";

        final String operatorPattern = "[~!%^&*+=|?:<>\\\\/-]";
        final String typePattern = "(boolean|int|long|short|byte|char|float|double";
        final String punctuationPattern = "[()\\\\[\\\\],.;]";

        public final Pair comments = new Pair(commentPattern,Color.GREY);
        public final Pair strings = new Pair(stringPattern,Color.GREEN);
        public final Pair chars = new Pair(charPattern,Color.GREEN);
        public final Pair decimals = new Pair(decimalPattern,Color.BLUE);
        public final Pair floats = new Pair(floatPattern,Color.BLUE);
        public final Pair hexs = new Pair(hexPattern,Color.BLUE);
        public final Pair octs = new Pair(octPattern,Color.BLUE);
        public final Pair keywords = new Pair(keywordsPattern,Color.ORANGE);
        public final Pair operators = new Pair(operatorPattern,Color.PURPLE);
        public final Pair types = new Pair(typePattern,Color.ORANGE);
        public final Pair punctuations = new Pair(punctuationPattern, Color.WHITE);

       // public String getPatter(){

        //}

    }

    public final Patterns pair;
    public final int start;
    public final int end;
    Lexeme(Patterns pattern, int start, int end) {
        this.pair = pattern;
        this.start = start;
        this.end = end;
    }


}
