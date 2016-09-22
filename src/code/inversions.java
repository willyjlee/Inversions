package code;

import java.util.Scanner;

/**
 * Created by william_lee on 7/14/16.
 */
public class inversions {

    private static long cct=0;

    public static void main(String[]args){
        //int[]arr= {1,1,1,1};

        //Scanner in = new Scanner(System.in);

        //int[]arr=new int[100000];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=in.nextInt();
//        }

        int[]arr = {1,2,3,5,4,3,2,-1,0};

        dot(arr);
        System.out.println(cct);
    }

    public static int[] dot(int[]arr){
        if(arr.length==1){
            return arr;
        }
        int split = (arr.length-1)/2;
        int[]f=new int[split+1];
        int[]s=new int[arr.length - f.length];

        System.arraycopy(arr, 0, f, 0, f.length);
        f=dot(f);
        System.arraycopy(arr, split+1, s, 0, s.length);
        s=dot(s);
        return sc(f,s);
    }

    public static int[] sc(int[]l, int[]r){

        int i=0;
        int j=0;

        int[]arr=new int[l.length+r.length];

        for(int ind=0;ind<arr.length;ind++){
            if(i>=l.length || j<r.length&&l[i]>r[j]){
                arr[ind]=r[j];
                j++;
                if(i<l.length){
                    cct+=l.length-i;
                }
            }
            else if(j>=r.length || i<l.length&&l[i]<=r[j]){
                arr[ind]=l[i];
                i++;
            }
        }
        return arr;
    }

}
