package Services;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by flmbrk on 15.09.2016.
 */
public class FileReaderService {
    private ArrayList<String> words;
    private File file;

    public ArrayList<String> getWords(){
        return this.words;
    }

    public FileReaderService(String path){
        this.file = new File(path);
        words = new ArrayList<String>();
    }

    public void readFromFile() throws IOException {
            try {
                StringBuilder str = new StringBuilder();
                InputStream stream = new FileInputStream(this.file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                int symbol,counter=0;
                while((symbol=reader.read())!=-1){
                    char c = (char)symbol;

                    if(checkChar(c)){
                        str.append(c);
                    }

                    else {

                        this.words.add(str.toString());
                        str = new StringBuilder(); // str.setLength(0) will work not so fast and use the same buffer, so we should just create new StringBuilder
                    }
                }
                stream.close();
                reader.close();
                deleteNulls();
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    private void deleteNulls(){
      this.words.removeAll(Arrays.asList("",null));
    }

    private boolean checkChar(char c){
        return (Character.isDigit(c)||Character.isLetter(c)) ? true : false;
    }

    public void printWords(){
        for(String x: this.words)
            System.out.println(x);
    }



}
