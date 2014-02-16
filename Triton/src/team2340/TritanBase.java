/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team2340;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import toolkit.Logger;

/**
 *
 * @author Team 2340
 */
public abstract class TritanBase implements Runnable {
    
    public Thread runner;
    public Logger logger;
    public String name;
    
    public TritanBase(String name) {
        this.name = name;
        logger = Logger.getInstance();
    }
    
    synchronized public void enable() {
        runner = new Thread(this, name);
        runner.start();
    }
    
    synchronized public void disable() {
        runner = null;
        turnOff();
    }
    
    public void turnOff() {
        
    }
}
