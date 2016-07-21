/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForgyClustering;

/**
 *
 * @author mahfuz11
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextArea;
public class ForgyInput {
    Forgy f;
    JTextArea jt;

    public ForgyInput(JTextArea j) {
        this.jt = j;
        f = new Forgy(jt);
    }
    
    
    public void Input(int n) throws IOException
    {
        
        int NoOfCluster;    // Total clusters.
        int TotalSampleData;      // Total data points.
        double SAMPLES[][] = new double[50000][2];
        int count=0;
        Scanner sc = new Scanner( new File("forgy.txt"));
        //Scanner sc = new Scanner( new File("europediff.txt"));
        //Scanner sc1 = new Scanner(System.in);
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
        //System.out.println("Total Sample Data = "+TotalSampleData);
        jt.append("Total Sample Data = "+TotalSampleData);
        jt.append("\n");
        //System.out.println("Enter No of Cluster = ");
        
        NoOfCluster = n;
        jt.append("No of Cluster = "+NoOfCluster);
        jt.append("\n");
        //System.out.println("Centroids initialized at:");
        jt.append("initial centroid ");
        jt.append("\n");
        for(int i=0; i<NoOfCluster; i++)
        {
            f.initialize(SAMPLES[i][0],SAMPLES[i][1]);
        }
        
        //System.out.println("Data\t\t Centroid \t\t Distance");
        jt.append("Data\t Centroid \t Distance");
        jt.append("\n");
        f.forgysCluster(SAMPLES,TotalSampleData,NoOfCluster);
        
        // Print out clustering results.
        for(int i = 0; i < NoOfCluster; i++)
        {
            //System.out.println("Cluster " + i + " includes:");
            jt.append("Cluster " + i + " includes:");
            jt.append("\n");
            for(int j = 0; j < TotalSampleData; j++)
            {
                if(f.dataSet.get(j).cluster() == i){
                    //System.out.println("     (" +String.format("%.1f",km.dataSet.get(j).X()) + ", " +String.format("%.1f",km.dataSet.get(j).Y()) + ")");
                    jt.append("     (" +String.format("%.1f",f.dataSet.get(j).X()) + ", " +String.format("%.1f",f.dataSet.get(j).Y()) + ")");
                    jt.append("\n");
                }
            } // j
            //System.out.println();
            jt.append("\n");
        } // i
        
        // Print out centroid results.
        //System.out.println("Centroids finalized at:");
        jt.append("final centroid ");
        jt.append("\n");
        for(int i = 0; i < NoOfCluster; i++)
        {
            //System.out.println("(" +String.format("%.1f",km.centroids.get(i).X()) + ", " +String.format("%.1f",km.centroids.get(i).Y())+")");
            jt.append("(" +String.format("%.1f",f.centroids.get(i).X()) + ", " +String.format("%.1f",f.centroids.get(i).Y())+")");
            jt.append("\n");
        }
    }
    
    public void searchTestData(double a, double b,int NoOfCluster)
    {
        
        Data testData = new Data(a, b);
        int cluster=0;
        double minimum = Math.pow(10, 10),distance;
        //System.out.println("Centroids finalized at:"+minimum);
        for(int j = 0; j < NoOfCluster; j++)
                {
                    
                    distance = f.dist(testData, f.centroids.get(j));
                    //System.out.println("Centroids finalized at:"+distance);
                    
                    if(distance < minimum){
                        minimum = distance;
                        cluster = j;
                    }
                }
        
        //System.out.println("Test data ("+a+" "+b+") are in cluster "+cluster);
        jt.append("Test data ("+a+" , "+b+") are in cluster "+cluster);
        jt.append("\n");
    }
    
}
