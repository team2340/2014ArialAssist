/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team2340;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import toolkit.RobotLogger;

/**
 *
 * @author Team 2340
 */
public abstract class RobotBase implements Runnable {
    
    Thread runner;
    RobotLogger logger;
    String name;
    
    RobotBase(String name) {
        this.name = name;
        logger = RobotLogger.getInstance();
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
