import java.io.*;
import java.util.*;

/*
Imagine we have an image. We’ll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s. 

Write a function that takes in the image and returns the coordinates of the rectangle of 0’s -- either top-left and bottom-right; or top-left, width, and height.


Sample output:
x: 3, y: 2, width: 3, height: 2
2,3 3,5
3,2 5,3 -- it’s ok to reverse columns/rows as long as you’re consistent

 */

class FindImage {
  public static void main(String[] args) {
    // Java
    int[][] image = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };
    
    printSol(findRect2(image));
  }


  static int[] findRect2(int[][] grid) {

    int[] res = new int[4];

    //scan the grid to find the starting point of the image
    startloop:
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        if(grid[i][j] == 0) {
          res[0] = i;
          res[1] = j;
          break startloop;
        }
      }
    }

    // scan the grid from the end to find the tail of the image
    endloop:
    for(int m = grid.length-1; m >= 0; m--) {
      for(int n = grid[m].length-1; n >= 0; n--) {
        if(grid[m][n] == 0) {
          res[2] = m;
          res[3] = n;
          break endloop;
        }
      }
    }

    return res;
  } 
  
  public static void printSol(int[] arr) {
    for(int k = 0; k < arr.length; k++) {
      System.out.print(arr[k]+", ");
    }    
  }

  // This is the shit answer that I provided
  public static int[] findRect(int[][] image) {
    
    int[] res = new int[4];
    int ind = 0;
    boolean inGrid = false;
    
    for(int i = 0; i < image.length; i++) {
      for(int j = 0; j < image[i].length; j++) {
        
        if((j == 0 && image[i][j] == 0) || (image[i][j] == 1 && image[i][j] == 0) && !inGrid) {
          //System.out.println("1st: "+i+" "+j );
          res[0] = i;
          res[1] = j;
          inGrid = true;
        }
        
        if((j == image[i].length - 1 && image[i][j] == 0) || (image[i][j] == 0 && image[i][j] == 1)) {
          //System.out.println("2nd: "+i+" "+j );
          res[2] = i;
          res[3] = j-1;
        }

      }
    }
    
    return res;
  }
}
