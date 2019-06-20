/*

*Implemented Methods:Recursive Function and dividing problem into breakable parts.
**The program is executed successfully.
*
*/

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * && open the template in the editor.
 */

/**
 *
 * @author akash
 */

public class TilingTro {
  class Trominos implements Comparable<Object> { //class defining Trominos 
     int a[];
     int b;
     public Trominos(int a[],int b){
     this.a=a;
     this.b=b;
     }
     public int compareTo(Object temp){
         Trominos other=(Trominos) temp; 
         if (this.a[0]==other.a[0]){
              if(this.a[1]==other.a[1]){
             return 0;
              }
              else if(this.a[1]>other.a[1]){
                  return 1;
              }
              else
                  return -1;
         }
         else if (this.a[0]>other.a[0]){
             return 1;
         }
         else
             return -1;
             }
             
     }
        

        

        
     List<Trominos> n=new ArrayList();
    public List<Trominos> getn(){
    return this.n;
    }
     public  int mSmall(int[] a,int[] b){ //It helps to find the starting co-ordinate when 2 by 2 tiling is given
        if(a[0]==b[0]-1 && a[1]==b[1]){
            return 3;
        }
        else if(a[1]==b[1]-1 && a[0]==b[0]-1){
            return 2;
        }
        else if(a[0]==b[0] && a[1]==b[1]-1){
            return 1;
        }else            
        
        return 0;
    }
public  int mLarge(int[] a,int[] b){
    if (a[0]<=b[0] && b[1]>=a[1]){
            return 2;
    }
    if (a[0]<=b[0] && a[1]>b[1]){
        return 3;
    }
    if (a[0]>b[0] && a[1]>b[1]){
        return 0;
    }
    else
    return 1;
}
public  int[] mid(int m,int[] b){
	int x=b[0];
	int y=b[1];	
	int h=m/2;	
	int[] a=new int[2];
        if (x<m && y>=m){
            a[0]=h;
            a[1]=y-(y%m)+h;
            return a;
        }		
        else if  (x>=m && y<m){
            a[0]=x-(x%m)+h;
            a[1]=h;
            
}
        else if (x<m && y<m){
            a[0]=h;
            a[1]=h;
            return a;
        }   
        else if (x>=m && y>=m){
            a[0]=x-(x%m)+h;	
            a[1]=y-(y%m)+h;
        return a;
        }
        return a;
}
public  int[] startf(int[] point,int[] mid){
	int a=0;
	int b=0;
	
        if (point[0]<mid[0]){
		a=mid[0]-2;
                        }
        else if (point[0]>=mid[0]){
		a=mid[0];	
                        }
		
	if (point[1]<mid[1]){
		b=mid[1]-2;
                        }
        else if (point[1]>=mid[1]){
		b=mid[1];
        }
        return new int[]{a,b};
                }
           
           public void out(int a,int[] d, int[] e){
               func(a,d,e);
               System.out.println("BOARD SIZE: "+a);
               System.out.println("LOCATION AT "+d[0]+" AND "+d[1]);
               System.out.println("MISSING SQUARE AT: "+e[0]+" AND "+e[1]);
               System.out.println("TOTAL OF TROMINOES COMPUTED:::"+n.size());
               System.out.println("ALL TROMINOES FOLLOW:::");
               System.out.println();
               Collections.sort(n);
               int i=1;
               for(Trominos t:n){
               System.out.println(i+": (("+t.a[0]+", "+t.a[1]+"), "+t.b+")" );
                i++;
               }
           }     
public  void func(int a,int[] d,int[] e){
    int y=0;
    int[] dc;
    //int[][] dc1;
    ArrayList<int[]> dc1;
    int a2;
    if (a/2==1){
        y=mSmall(d,e);
        n.add(new Trominos(d, y));
    }
    else
    {
        dc=mid(a,e);
        a2=a/2;
       int[][] dc2={new int[]{dc[0]-1,dc[1]-1},new int[]{dc[0]-1,dc[1]},new int[]{dc[0],dc[1]},new int[]{dc[0],dc[1]-1}}; 
      dc1=new ArrayList<int[]>(Arrays.asList(dc2));
        
      int t=mLarge(dc, e);
      dc1.remove(t);
      dc1.add(e);
      int[] z=new int[]{dc[0]-1,dc[1]-1};
//  int[] ka=startf(dc1.get(t),dc);
        n.add(new Trominos(z, t));
     int j=0;
     while(j<dc1.size()){
         int[] s2=mid(a,dc1.get(j));
         int[] s1=startf(dc1.get(j),s2);
         func(a2,s1,dc1.get(j));
         j+=1;
     }
    }
}
public static void main( String[] args){
    TilingTro input1=new TilingTro();
    TilingTro input2=new TilingTro();
    TilingTro input3=new TilingTro();
    TilingTro input4=new TilingTro();
   System.out.println("INPUT COUNT:: 1");
    input1.out(4,new int[]{0,0},new int[]{3,3});
   System.out.println();
   
    System.out.println("INPUT COUNT:: 2");
   
    input2.out(8,new int[]{0,0},new int[]{4,5});
   System.out.println();
   
    System.out.println("INPUT COUNT:: 3");
    input3.out(8,new int[]{0,0},new int[]{4,4});
    System.out.println();
   
    System.out.println("INPUT COUNT:: 4");
    input4.out(16,new int[]{0,0},new int[]{0,0});
}
}
