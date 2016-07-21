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
public class Centroid 
{
    private double mX = 0.0;
    private double mY = 0.0;
        
        
    public Centroid(double newX, double newY)
    {
        this.mX = newX;
        this.mY = newY;
    }
        
    public void X(double newX)
    {
        this.mX = newX;
    }
        
    public double X()
    {
        return this.mX;
    }
        
    public void Y(double newY)
    {
        this.mY = newY;
    }
        
    public double Y()
    {
        return this.mY;
    }
    
}
