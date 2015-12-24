package projectEuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Derek on 12/24/2015.
 */
public class P18 {

    //Pre: filename has been passed into program as argument
    //Post: Filename has been read
    private static int[][] getTriangleFromText(String filename){
        BufferedReader triFile = null;
        try {
            triFile = new BufferedReader(new FileReader(new File(filename)));
            int lines = 0;

            while (triFile.readLine() != null)
                lines++;

            triFile.close();

        }catch(IOException e) {
            e.printStackTrace();
        }finally{
            try {
                triFile.close();
            }catch(IOException e){e.printStackTrace();}}
    }

    public static void main(String[] args){
        int triangle[][] = getTriangleFromText(args[0]);
    }
}
