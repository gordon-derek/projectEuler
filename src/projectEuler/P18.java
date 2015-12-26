package projectEuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Derek on 12/24/2015.
 */
public class P18 {

    //Gets triangle depth from counting the lines in file
    private static int getTriDepth(BufferedReader triFile){
        int sum = 0;
        try {
            while(triFile.readLine() != null)
                sum++;
        }catch(IOException e){e.printStackTrace();}
        return sum;
    }

    //Pre: filename has been passed into program as argument
    //Post: Filename has been read
    private static int[][] getTriangleFromText(String filename){
        BufferedReader triFile = null;
        int triangle[][] = null;

        try {
            triFile = new BufferedReader(new FileReader(new File(filename)));
            int depth = getTriDepth(new BufferedReader(new FileReader(new File(filename))));
            triangle = new int[depth][depth];
            String line = triFile.readLine();
            String piece[];
            for(int i = 0; i < depth; i++){
                piece = line.split(" ");
                for(int j = 0; j < piece.length; j++)
                    triangle[i][j] = Integer.parseInt(piece[j]);
                line = triFile.readLine();
            }

            triFile.close();

        }catch(IOException e) {
            e.printStackTrace();
        }finally{
            try {
                triFile.close();
            }catch(IOException e){e.printStackTrace();}
        }
        return triangle;
    }

    public static void main(String[] args){
        int triangle[][] = getTriangleFromText(args[0]);
    }
}
