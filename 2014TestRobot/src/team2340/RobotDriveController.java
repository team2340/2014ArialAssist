/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team2340;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;
import team2340.RobotDefinitions;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import toolkit.Direction;
import toolkit.LogitechF310;

/**
 *
 * @author Team 2340
 */
public class RobotDriveController extends RobotBase {

    LogitechF310 controller;
    RDrive driver;
    
    public RobotDriveController(RDrive driver, LogitechF310 driveController) {
        super(RobotDefinitions.ROBOT_DRIVE_NAME);
        this.driver = driver;
        controller = driveController;
    }

    public void run() {
        System.out.println("DoryDrive thread started!");
        try {
        while (runner != null && runner.isAlive()) {
            try {
                //updatePID();
                
                driver.drive(rangeCheck(controller.getRightStick()), controller.getDPad(), controller.getRB());
                runner.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void turnOff() {
        driver.stop();
    }

    private Direction rangeCheck(Direction dir) {
        if(dir == null) System.out.println("dir is null");
        Direction returnDir = new Direction(dir.x, dir.y);
        if (dir.x == 0.0) {
            double noSlope = Math.tan(75.0);
            double zeroSlope = Math.tan(15.0);
            double calculatedSlope = (dir.y / dir.x);

            if (Math.abs(calculatedSlope) > noSlope) {
                returnDir.x = 0.0;
                returnDir.y = dir.y;
            } else if (Math.abs(dir.y / dir.x) < zeroSlope) {
                returnDir.x = dir.x;
                returnDir.y = 0.0;
            }
        }
        return returnDir;
    }
    
}
