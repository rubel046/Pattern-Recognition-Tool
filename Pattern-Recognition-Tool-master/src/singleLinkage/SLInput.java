/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleLinkage;

/**
 *
 * @author mahfuz11
 */
import java.io.*;
import java.util.*;
import javax.swing.JTextArea;

public class SLInput
{
    JTextArea jt;
    static int TotalSampleData; 
    double SAMPLES[][] = new double[100000][2];
    SingleLinkage sl;

    public SLInput(JTextArea j) {
        this.jt = j;
    }
    
    
    public void Input() throws IOException
    {
        
        int count=0;
        //Scanner sc = new Scanner( new File("sl.txt"));
        //Scanner sc = new Scanner( new File("sl1.txt"));
        Scanner sc = new Scanner( new File("sl2.txt"));
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Sample data");
        jt.append("Sample data");
        jt.append("\n");
        while(sc.hasNextDouble())
        {
            SAMPLES[count][0] = sc.nextDouble();
            SAMPLES[count][1] = sc.nextDouble();
            //System.out.println(SAMPLES[count][0]+"\t"+SAMPLES[count][1]);
            jt.append(SAMPLES[count][0]+"\t"+SAMPLES[count][1]);
            jt.append("\n");
            
            count++;
        }
        sc.close();
        TotalSampleData = count;
        //System.out.println("Total Sample Data:"+TotalSampleData);
        jt.append("Total Sample Data:"+TotalSampleData);
        jt.append("\n");
        sl = new SingleLinkage(TotalSampleData,jt);
        
        //System.out.println("\nMatrix:");
        jt.append("Matrix:");
        jt.append("\n");
          
        for(int p = 0; p < TotalSampleData; p++)
        {
            for(int q = 0; q < TotalSampleData; q++)
            {
                if(q>p)
                {
                    double z = Math.sqrt(Math.pow(SAMPLES[p][0]-SAMPLES[q][0], 2) + Math.pow(SAMPLES[p][1]-SAMPLES[q][1], 2));
                    sl.matrix[p][q] = sl.matrix[q][p] = z;
                    //System.out.println("value of z = "+z);
                }
            }
        }


        System.out.println();
        int first=0,second=0;
        String symbol1="",symbol2="",symbol3,symbol4;
        do
        {
            StringTokenizer clusterFinder1=new StringTokenizer(sl.cluster1,",");
            StringTokenizer clusterFinder2=new StringTokenizer(sl.cluster2,",");
            if(clusterFinder1.hasMoreTokens())
            {
                symbol1 = clusterFinder1.nextToken();
            }
            if(clusterFinder2.hasMoreTokens())
            {
                symbol2 = clusterFinder2.nextToken();
            }
            sl.Show(TotalSampleData);
            //symbol1 = String.valueOf(sl.cluster1.charAt(0));
            //symbol2 = String.valueOf(sl.cluster2.charAt(0));
            symbol3 = String.valueOf(sl.point1);
            symbol4 = String.valueOf(sl.point2);
            if(count==TotalSampleData)
            {
                sl.cluster1+=sl.point1+","+sl.point2;
                //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                jt.append("\n");
            }
            else if(count==2)
            {
                if(sl.cluster2.equals(""))
                {
                    sl.cluster2+=sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
                else if(sl.cluster1.equals(""))
                {
                    sl.cluster1+=sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
                else
                {
                    break;
                }
            }
            else if(symbol1.equals(symbol3) && !sl.cluster2.equals(null))
            {
                if(!symbol2.equals(symbol4))
                {
                    sl.cluster1+=","+sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
                else
                {
                    sl.cluster1+=","+sl.cluster2;
                    sl.cluster2="";
                    first=0;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
            }
            else if(symbol2.equals(symbol3)&& !sl.cluster1.equals(null))
            {
                if(!symbol1.equals(symbol4))
                {
                    sl.cluster2+=","+sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
                else
                {
                    sl.cluster2+=","+sl.cluster1;
                    sl.cluster1="";
                    second=0;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
            }
          
            else
            {
                if(first==0 && sl.cluster2.equals(""))
                {
                    sl.cluster2+=sl.point1+","+sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                    first=1;
                }
                else if(second == 0 && sl.cluster1.equals(""))
                {
                    sl.cluster1+=sl.point1+","+sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                    first=1;
                }
                else
                {
                    sl.cluster1+=","+sl.point2;
                    //System.out.println("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("cluster1= {"+sl.cluster1+"}\tcluster2= {"+sl.cluster2+"}");
                    jt.append("\n");
                }
                
            }
            count--;
        }while(count != 1);
    }
    
    public void searchTestData(double a, double b)
    {
        double x=0, y=0;
        int totalCluster=0;
        StringTokenizer clusterFinder=new StringTokenizer(sl.cluster1,",");
	while(clusterFinder.hasMoreTokens())
	{
            //System.out.println(clusterFinder.nextToken());
            int index1 =Integer.parseInt( clusterFinder.nextToken());
            //System.out.println("sample data= "+index1);
            x +=SAMPLES[index1][0];
            y +=SAMPLES[index1][1];
            totalCluster++;
	}
        double clusterCenter[][] = new double[2][2];
        clusterCenter[0][0] = x/totalCluster;
        clusterCenter[0][1] = y/totalCluster;
        
        x=0;
        y=0;
        totalCluster=0;
        clusterFinder=new StringTokenizer(sl.cluster2,",");
	while(clusterFinder.hasMoreTokens())
	{
            //System.out.println(clusterFinder.nextToken());
            int index1 =Integer.parseInt( clusterFinder.nextToken());
            //System.out.println("sample data= "+index1);
            x +=SAMPLES[index1][0];
            y +=SAMPLES[index1][1];
            totalCluster++;
	}
        clusterCenter[1][0] = x/totalCluster;
        clusterCenter[1][1] = y/totalCluster;
        int cluster=0;
        double minimum = Math.pow(10, 10),distance;
        for(int j = 0; j < 2; j++)
                {
                    distance= Math.sqrt(Math.pow(a-clusterCenter[j][0], 2) + Math.pow(b-clusterCenter[j][1], 2));
                    
                    if(distance < minimum){
                        minimum = distance;
                        cluster = j;
                    }
                }
        
        //System.out.println("Test data ("+a+" "+b+") are in cluster "+cluster);
        jt.append("Test data ("+a+" "+b+") are in cluster "+(cluster+1));
        jt.append("\n");
       
    }
    
}

