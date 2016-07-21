/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kMeans;

/**
 *
 * @author mahfuz11
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;
public class KMeans {
    JTextArea jt;
    public KMeans(JTextArea j) {
        this.jt = j;
    }
    
    
    
    public ArrayList<Data> dataSet = new ArrayList<Data>();
    public ArrayList<Centroid> centroids = new ArrayList<Centroid>();
    
    public void initialize(double a, double b)
    {
        centroids.add(new Centroid(a, b));
        jt.append("     (" + a + ", " + b + ")");
        jt.append("\n");
        //System.out.println("     (" + centroids.get(1).X() + ", " + centroids.get(1).Y() + ")");
        //System.out.print("\n");
    }
    
    public void kMeanCluster(double SAMPLES[][],int TOTAL_DATA, int NUM_CLUSTERS)
    {
        double bigNumber = Math.pow(10, 10);  
        double minimum = bigNumber;                
        double distance = 0.0;                        
        int sampleNumber = 0;
        int cluster = 0;
        boolean isFurtherExecuting = true;
        Data newData = null;
        
        // Add in new data, one at a time, recalculating centroids with each new one. 
        while(dataSet.size() < TOTAL_DATA)
        {
            newData = new Data(SAMPLES[sampleNumber][0], SAMPLES[sampleNumber][1]);
            dataSet.add(newData);
            minimum = bigNumber;
            for(int i = 0; i < NUM_CLUSTERS; i++)
            {
                distance = dist(newData, centroids.get(i));
                //System.out.println("distance"+distance);
                if(distance < minimum){
                    minimum = distance;
                    cluster = i;
                }
            }
            newData.cluster(cluster);
            
            // calculate new centroids.
            for(int i = 0; i < NUM_CLUSTERS; i++)
            {
                double totalX = 0;
                double totalY = 0;
                int totalInCluster = 0;
                for(int j = 0; j < dataSet.size(); j++)
                {
                    if(dataSet.get(j).cluster() == i){
                        totalX += dataSet.get(j).X();
                        totalY += dataSet.get(j).Y();
                        totalInCluster++;
                    }
                }
                if(totalInCluster > 0){
                    centroids.get(i).X(totalX / totalInCluster);
                    centroids.get(i).Y(totalY / totalInCluster);
                }
            }
            sampleNumber++;
        }
        
        // Now, keep shifting centroids until equilibrium occurs.
        while(isFurtherExecuting)
        {
            // calculate new centroids.
            for(int i = 0; i < NUM_CLUSTERS; i++)
            {
                double totalX = 0;
                double totalY = 0;
                int totalInCluster = 0;
                for(int j = 0; j < dataSet.size(); j++)
                {
                    if(dataSet.get(j).cluster() == i){
                        totalX += dataSet.get(j).X();
                        totalY += dataSet.get(j).Y();
                        totalInCluster++;
                    }
                }
                if(totalInCluster > 0){
                    centroids.get(i).X(totalX / totalInCluster);
                    centroids.get(i).Y(totalY / totalInCluster);
                }
            }
            
            // Assign all data to the new centroids
            isFurtherExecuting = false;
            
            for(int i = 0; i < dataSet.size(); i++)
            {
                Data tempData = dataSet.get(i);
                minimum = bigNumber;
                for(int j = 0; j < NUM_CLUSTERS; j++)
                {
                    distance = dist(tempData, centroids.get(j));
                    if(distance < minimum){
                        minimum = distance;
                        cluster = j;
                    }
                }
                
                if(tempData.cluster() != cluster){
                    tempData.cluster(cluster);
                    isFurtherExecuting = true;
                }
            }
        }
    }
    
    
    // Calculate Euclidean distance.
     
    public double dist(Data d, Centroid c)
    {
        return Math.sqrt(Math.pow((c.Y() - d.Y()), 2) + Math.pow((c.X() - d.X()), 2));
    }
}