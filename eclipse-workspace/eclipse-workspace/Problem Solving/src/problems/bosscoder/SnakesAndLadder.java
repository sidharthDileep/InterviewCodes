package problems.bosscoder;

import java.io.*;
import java.util.*;
 
 
public class SnakesAndLadder{
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      // Start writing your solution here. -------------------------------------
   
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */
      int size=sc.nextInt();
	  int tc=sc.nextInt();
      int mod=1000000007;
	 //   int[]dp=new int[size];
	  int[][]ladders=new int[tc][2];
	  long[][]dp=new long[size+2][size+2];
	  for(int i=0;i<dp.length;i++)
	      {
			  Arrays.fill(dp[i],-1);
		  }
	  for(int i=0;i<dp.length;i++)
	      {
			  for(int j=0;j<=i;j++)
			      {
					  if(i!=j)
					   {
						  dp[i][j]=0;
					   }
					  else {
						  dp[i][j]=1;
					  }

				  }
			 
		  }
	  HashMap<Integer,Integer>map=new HashMap<>();
	  for(int i=0;i<tc;i++)
	     {
			 ladders[i][0]=sc.nextInt();
			 ladders[i][1]=sc.nextInt();
			 map.put(ladders[i][0],ladders[i][1]);
		 }
	 
	 for(int t=0;t<tc;t++)
	    {
			long ctol;
			if(dp[0][ladders[t][0]]==-1)
			{
			ctol=0;
	  for(int i=1;i<=6;i++)
	      {
			  if(dp[i][ladders[t][0]]==-1)
			    {
				   long val=cost(i,ladders[t][0],map,size,dp);
				//    dp[i][ladders[t][0]]=val;
                   ctol=((ctol%mod)+(val%mod))%mod;
				}
				else{
					 ctol=((ctol%mod)+(dp[i][ladders[t][0]]%mod))%mod;
				}
			  
			//   out.println(ctol+" "+"cost to reach ladder"+i);
		  }
		dp[0][ladders[t][0]]=ctol;
			}
			else{
				ctol=dp[0][ladders[t][0]];
			}
		//   out.println(ctol+" "+"cost to reach ladder"+ladders[t][0]);
		  if(dp[ladders[t][0]][size]==-1)
		    {
				  long val=cost(ladders[t][0],size,map,size,dp);
				//   out.println(val+" "+ladders[t][0]);
				   dp[ladders[t][0]][size]=val;
                   long total=((ctol%mod)*(val%mod))%mod;
				   dp[ladders[t][0]][size]=total;
				   out.println(total);
			}
		 else{
			   long total=(dp[0][ladders[t][0]]*dp[ladders[t][0]][size])%mod;
			   out.println(total);
		 }
		  
		}
      // Stop writing your solution here. -------------------------------------
      out.close();
   }

    public static long cost(int curr,int target,HashMap<Integer,Integer>map,int size,long[][]dp)
	    {
			// out.println(curr+" "+target);
			if(curr>target)
			   {
				   return 0;
			   }
		    else if(curr==target)
			   {
				   return 1;
			   }
		   else	if(map.containsKey(curr))
			  {
				  long val=cost(map.get(curr),target,map,size,dp);
				  dp[curr][target]=cost(map.get(curr),target,map,size,dp);
				  return dp[curr][target];
			  }
		  else{
			     long tCost=0;
				 int mod=1000000007;
				 for(int i=1;i<=6;i++)
				  {
					  if(curr+i<=size)
					   {
			     if(dp[curr+i][target]==-1)
			    {
				   long val=cost(curr+i,target,map,size,dp);
				//    dp[curr+i][target]=val;
                   tCost=((tCost%mod)+(val%mod))%mod;
				}
				else{
					 tCost=((tCost%mod)+(dp[curr+i][target]%mod))%mod;
				}
				  }
				  }
				  dp[curr][target]=tCost;
				 return tCost;
		  }

		}

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
   //--------------------------------------------------------
}
