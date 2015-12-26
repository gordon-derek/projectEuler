package projectEuler.P18_67;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Derek on 12/24/2015.
 */
public class P18_67 {

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

    //calculates max path from the bottom up by calculating max at each level.
    private static int calcMaxPath(int triangle[][]){
        int depth = triangle.length;
        for(int i = depth-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];
    }

    public static void main(String[] args){
        for(int i = 0; i < args.length; i++) {
            int triangle[][] = getTriangleFromText(args[i]);
            System.out.println(calcMaxPath(triangle));
        }
    }
}
