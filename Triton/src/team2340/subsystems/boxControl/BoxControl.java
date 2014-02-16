/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340.subsystems.boxControl;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.Thread;
import team2340.TritionDefinitions;
import toolkit.CANJaguarFactory;

/**
 *
 * @author Team2340
 */
public class BoxControl{
    private CANJaguar boxMotor;
    private boolean upLimit;
    private boolean bottomLimit;
    
    public BoxControl() {
        boxMotor = CANJaguarFactory.getInstance().get(TritionDefinitions.TRITION_BOX_MOTOR_ID); 
        initializeLimits();
    }

    private void initializeLimits() {
        try {
        upLimit = !boxMotor.getForwardLimitOK();
        bottomLimit = !boxMotor.getReverseLimitOK();
        }
        catch (Exception ex) {
            System.out.println("initialLimits Exception");
        }
    }
    
    public boolean moveUp() {
        boolean limit = true;
        try {
            boxMotor.setX(TritionDefinitions.BOX_UP_SPEED);
            limit = !boxMotor.getForwardLimitOK();
        } catch (CANTimeoutException ex) {
            System.out.println("Move Up Exception");
        }
        return limit;
    }
    
    public boolean moveDown() {
        boolean limit = true;
        try {
            boxMotor.setX(TritionDefinitions.BOX_DOWN_SPEED);
            limit = !boxMotor.getReverseLimitOK();
        } catch (CANTimeoutException ex) {
            System.out.println("Move Down Exception");
        }
        return limit;
    }
    
    public void stop() {
        try {
            boxMotor.setX(TritionDefinitions.BOX_STOP);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

  

    
}
