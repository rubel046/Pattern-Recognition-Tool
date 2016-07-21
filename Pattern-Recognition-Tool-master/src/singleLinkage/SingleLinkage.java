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
import javax.swing.JTextArea;
import kMeans.KMeans;
public class SingleLinkage 
{
    double [][] matrix;
    int point1=0,point2=0;
    int i,j;
    String cluster1="", cluster2="";
    JTextArea jt;

    SingleLinkage(int n,JTextArea j)
    {
        matrix=new double[n][n];
        this.jt = j;
    }
   
   
    public void Minimum(int totalSampleData)
    {
        double minimum_value=Math.pow(10, 10);;

        for(int i=0;i<totalSampleData;i++)
        {
            for(int j=0;j<totalSampleData;j++)
            {
           	if(matrix[i][j]!=0.0)
            	{
             	    if(matrix[i][j]<minimum_value)
                    {
                        minimum_value=matrix[i][j];
                        point1=i; point2=j;
                    }
                }
            }
    	}
        
	//System.out.println("Sample data "+(point1+1)+" and "+(point2+1)+" are merged at a distance "+String.format("%.1f", maximum_value));
        jt.append("Sample data "+point1+" and "+point2+" are merged at a distance "+String.format("%.1f", minimum_value));
        jt.append("\n");
    }

    public void Show(int totalSampleData)
    {
    	for(i=0;i<totalSampleData;i++)
      	{
            for(j=0;j<totalSampleData;j++)
            {
                //System.out.print(String.format("%.1f", matrix[i][j])+"\t");
                jt.append(String.format("%.1f", matrix[i][j])+"\t");
        
            }                   
            //System.out.println();
            jt.append("\n");
      	}
        
        Minimum(totalSampleData);
        
        mergeSampleData(totalSampleData);
    }

   
    public void mergeSampleData(int totalSampleData)
    {       
        for(int j=0;j<totalSampleData;j++)
            {
                if(matrix[point1][j]<matrix[point2][j])
                {
                    matrix[j][point1] = matrix[point1][j];
                }
                else
                {
                    matrix[point1][j]=matrix[j][point1]=matrix[point2][j];
                }
            }
        
          
        for(int i=0;i<totalSampleData;i++)
        {
            for(int j=0;j<totalSampleData;j++)
            {
                if(i==j)
            	{
                    matrix[i][j]=0.0;
                }
            }
        }
          
        for(int k=0;k<totalSampleData;k++)
        {
            matrix[point2][k]=matrix[k][point2]=0;
        }
    }
    
    
    
}
