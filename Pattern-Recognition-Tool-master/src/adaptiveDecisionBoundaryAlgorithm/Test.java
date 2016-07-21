/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptiveDecisionBoundaryAlgorithm;

/**
 *
 * @author mahfuz11
 */
//import ADBAGraphJFrame;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Test {
    JTextArea jt;

    public Test(JTextArea j) {
        this.jt = j;
    }
    /*public void ADBAlgorithm()throws IOException
    {
        int TotalSampleData;
        double SAMPLES[][] = new double[2][2];
        int count=0;
        Scanner sc = new Scanner( new File("adba.txt"));
        //System.out.println("Training Samples data");
        jt.append("Training Samples data");
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
        boolean isStillMoving = true;
        double W0 = 0, W1 = 0, D, c = 1, k = 1,sgnD=0, newW0,newW1;
        String Error;
        int iteration = 0, errorCount; ;
        //System.out.println("t\t"+"i"+"\t"+" x\t"+"d\t"+"Old W0\t"+"Old W1\t"+"D\t"+"Error?"+"  New W0"+"  New W1");
        jt.append("t\t"+"i"+"\t"+" x\t"+"d\t"+"Old W0\t"+"Old W1\t"+"D\t"+"Error?"+"\tNew W0"+"\tNew W1");
        jt.append("\n");
        while(isStillMoving)
        {
            errorCount = 0 ;
            for(int i = 0; i <TotalSampleData; i++)
            {
                
                iteration++;
                D = W0 + W1* SAMPLES[i][0];
                if(D>=0)
                    {
                        sgnD = 1;
                    }
                if(D<0)
                {
                    sgnD = -1;
                }
                if(sgnD != SAMPLES[i][1])
                {
                    
                    newW0 = W0 + c*SAMPLES[i][1]*k;
                    newW1 = W1 + c*SAMPLES[i][1]*SAMPLES[i][0];
                    Error = "Yes";
                    //System.out.println(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+W0+"\t"+W1+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1);
                    jt.append(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+W0+"\t"+W1+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1);
                    jt.append("\n");
                    W0 = newW0;
                    W1 = newW1;
                }
                else
                {
                    Error = "No";
                    newW0 = W0;
                    newW1 = W1;
                    //System.out.println(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+W0+"\t"+W1+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1);
                    jt.append(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+W0+"\t"+W1+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1);
                    jt.append("\n");
                    errorCount++;
                    //System.out.println("Errorcount= "+errorCount);
                    if(errorCount == TotalSampleData)
                    {
                        isStillMoving = false;
                    }
                } 
                
            }
        }
    }
}*/
public void ADBAlgorithm()throws IOException
    {
        int TotalSampleData;
        double SAMPLES[][] = new double[10][3];
        int count=0;
        //Scanner sc = new Scanner( new File("adba.txt"));
        //Scanner sc = new Scanner( new File("adba1.txt"));
        Scanner sc = new Scanner( new File("adba2.txt"));
        //System.out.println("Training Samples data");
        jt.append("Training Samples data");
        jt.append("\n");
        while(sc.hasNextDouble())
        {
            SAMPLES[count][0] = sc.nextDouble();
            SAMPLES[count][1] = sc.nextDouble();
            SAMPLES[count][2] = sc.nextDouble();
            //System.out.println(SAMPLES[count][0]+"\t"+SAMPLES[count][1]+"\t"+SAMPLES[count][2]);
            jt.append(SAMPLES[count][0]+"\t"+SAMPLES[count][1]+"\t"+SAMPLES[count][2]);
            jt.append("\n");
            
            count++;
        }
        sc.close();
        
        TotalSampleData = count;
        System.out.println("Total Sample Data = "+TotalSampleData);
        //jt.append("Total Sample Data = "+TotalSampleData);
        //jt.append("\n");
        boolean isStillMoving = true;
        double W0 = 0, W1 = 0, W2 = 0, D, c = 1, k = 1,sgnD=0, newW0,newW1,newW2;
        String Error;
        int iteration = 0, errorCount; ;
        //System.out.println("t\t"+"i"+"\t"+" x1\t"+" x2\t"+"d\t"+"Old W0\t"+"Old W1\t"+"Old W2\t"+"D\t"+"Error?"+"  New W0"+"  New W1"+"  New W2");
        jt.append("t\t"+"i"+"\t"+" x1\t"+" x2\t"+"d\t"+"Old W0\t"+"Old W1\t"+"Old W2\t"+"D\t"+"Error?"+"  New W0"+"  New W1"+"  New W2");
        jt.append("\n");
        while(isStillMoving)
        {
            errorCount = 0 ;
            for(int i = 0; i <TotalSampleData; i++)
            {
                
                iteration++;
                D = W0 + W1* SAMPLES[i][0] + W2* SAMPLES[i][1];
                if(D>=0)
                    {
                        sgnD = 1;
                    }
                if(D<0)
                {
                    sgnD = -1;
                }
                if(sgnD != SAMPLES[i][2])
                {
                    
                    newW0 = W0 + c*SAMPLES[i][2]*k;
                    newW1 = W1 + c*SAMPLES[i][2]*SAMPLES[i][0];
                    newW2 = W2 + c*SAMPLES[i][2]*SAMPLES[i][1];
                    Error = "Yes";
                    //System.out.println(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+SAMPLES[i][2]+"\t"+W0+"\t"+W1+"\t"+W2+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1+"\t"+newW2);
                    jt.append(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+SAMPLES[i][2]+"\t"+W0+"\t"+W1+"\t"+W2+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1+"\t"+newW2);
                    jt.append("\n");
                    W0 = newW0;
                    W1 = newW1;
                    W2 = newW2;
                }
                else
                {
                    Error = "No";
                    newW0 = W0;
                    newW1 = W1;
                    newW2 = W2;
                    //System.out.println(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+SAMPLES[i][2]+"\t"+W0+"\t"+W1+"\t"+W2+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1+"\t"+newW2);
                    jt.append(iteration +"\t"+(i+1)+"\t"+ SAMPLES[i][0]+"\t"+SAMPLES[i][1]+"\t"+SAMPLES[i][2]+"\t"+W0+"\t"+W1+"\t"+W2+"\t"+D+"\t"+Error+"\t"+newW0+"\t"+newW1+"\t"+newW2);
                    jt.append("\n");
                    errorCount++;
                    //System.out.println("Errorcount= "+errorCount);
                    if(errorCount == TotalSampleData)
                    {
                        isStillMoving = false;
                    }
                }
            }
        }
        
        long x1 = 0;
        long y1 = Math.round((-W0-W1*x1)/W2);
        long x2 = 60;
        long y2 = Math.round((-W0-W1*x1)/W2);
        //ADBAGraphJFrame aj = new ADBAGraphJFrame();
    }
}

