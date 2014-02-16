/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340.subsystems.acquisition;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import toolkit.CANJaguarFactory;
import team2340.TritionDefinitions;

/**
 *
 * @author Team2340
 */
public class TritionAcquisition {
    private CANJaguar spinner;
    private CANJaguar arm;
    
    public TritionAcquisition() {
        spinner =  CANJaguarFactory.getInstance().get(TritionDefinitions.TRITION_ACQUISITION_SPINNER_ID);
        arm = CANJaguarFactory.getInstance().get(TritionDefinitions.TRITION_ACQUISITION_ARM_ID);
        
    }
    
    public void armOut() {
        try {
            arm.setX(TritionDefinitions.ACQUISITION_ARM_OUT_SPEED);
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    //TODO: TEST HOW LONG IT NEEDS TO SPIN}
    }
    public void armIn() {
        try {
            arm.setX(TritionDefinitions.ACQUISITION_ARM_IN_SPEED);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void startSpinner() {
        try {
            spinner.setX(0.5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void stopSpinner() {
        try {
            spinner.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void reverseSpinner() {
        try {
            spinner.setX(-0.5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
            }

    void armStop() {
        try {
            arm.setX(TritionDefinitions.ARM_STOP);
        } catch(CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
}
