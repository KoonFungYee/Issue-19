package KoonFungYee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Issue19 {
    public static final List<Word> words=new ArrayList<>();
    public static final List<Character> characters=new ArrayList<>();

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        File file=new File("issue19.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        Scanner scan=new Scanner(fileInputStream);

        //Read txt file and store character to CountN file
        while (scan.hasNext()){
            String character = scan.next();
            String upperCase=character.toUpperCase();
            words.add(new Word(upperCase));
        }

        for (int i=0;i<words.size();i++){
            Word word=words.get(i);
            for (int j=0;j<word.getWord().length();j++){
                char charecter=word.getWord().charAt(j);
                characters.add(new Character(charecter));
            }
        }

        CountAllN countAllN=new CountAllN();
        CountN countN=new CountN();

        ExecutorService service= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> futureAll=service.submit(countAllN);
        System.out.println("Total number of integer N for this txt file is: "+futureAll.get());

        Future<Integer> future=service.submit(countN);
        System.out.println("Total number of integer N starting from 200 for this txt file is: "+future.get());

        fileInputStream.close();
        service.shutdown();

    }

}
