/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340.subsystems.boxShooter;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import team2340.TritionDefinitions;
import toolkit.CANJaguarFactory;

/**
 *
 * @author Team2340
 */
public class BoxShooter {
    private CANJaguar topFlyWheel;
    private CANJaguar bottomFlyWheel;
    public BoxShooter() {
        initializeFlyWheels();
        
    }
    
    private void initializeFlyWheels() {
        try {
            topFlyWheel = CANJaguarFactory.getInstance().get(TritionDefinitions.TRITION_TOP_FLY_WHEEL_ID);
            bottomFlyWheel = CANJaguarFactory.getInstance().get(TritionDefinitions.TRITION_BOTTOM_FLY_WHEEL_ID);
            
        } catch( Exception ex) {
            System.out.println("initializeFlyWheel Exception");
        }
    }

   

    void fullSpeed() { 
        try {
            topFlyWheel.setX(TritionDefinitions.TOP_FLYWHEEL_SPEED);
            bottomFlyWheel.setX(TritionDefinitions.BOTTOM_FLYWHEEL_SPEED);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }

    void stop() {
        try {
            topFlyWheel.setX(TritionDefinitions.FLY_WHEEL_STOP);
            bottomFlyWheel.setX(TritionDefinitions.FLY_WHEEL_STOP);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
}
