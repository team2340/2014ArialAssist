/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team2340;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;
import team2340.TritionDefinitions;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import toolkit.CANJaguarFactory;
import toolkit.Direction;

/**
 *
 * @author Team 2340
 */
public class TritonDrive {

    CANJaguar frontLeft;
    CANJaguar frontRight;
    CANJaguar backLeft;
    CANJaguar backRight;
    double p;
    double i;
    double d;

    public TritonDrive() {
        /*
        SmartDashboard.putDouble(RobotDefinitions.DRIVE_PROPORTIONAL, RobotDefinitions.DRIVE_P_INITIAL);
        SmartDashboard.putDouble(RobotDefinitions.DRIVE_INTEGRAL, RobotDefinitions.DRIVE_I_INITIAL);
        SmartDashboard.putDouble(RobotDefinitions.DRIVE_DIFFERENTIAL, RobotDefinitions.DRIVE_D_INITIAL);
        p = SmartDashboard.getDouble(RobotDefinitions.DRIVE_PROPORTIONAL, RobotDefinitions.DRIVE_P_INITIAL);
        i = SmartDashboard.getDouble(RobotDefinitions.DRIVE_INTEGRAL, RobotDefinitions.DRIVE_I_INITIAL);
        d = SmartDashboard.getDouble(RobotDefinitions.DRIVE_DIFFERENTIAL, RobotDefinitions.DRIVE_D_INITIAL);
        */
        frontLeft = initializeCANJag(TritionDefinitions.FRONTLEFT_DRIVE_JAG_ID, TritionDefinitions.CPR250);
        frontRight = initializeCANJag(TritionDefinitions.FRONTRIGHT_DRIVE_JAG_ID, TritionDefinitions.CPR250);
        backLeft = initializeCANJag(TritionDefinitions.BACKLEFT_DRIVE_JAG_ID, TritionDefinitions.CPR360);
        backRight = initializeCANJag(TritionDefinitions.BACKRIGHT_DRIVE_JAG_ID, TritionDefinitions.CPR360);
    }

    synchronized public void directionalDrive(Direction direction, Direction dPad) throws CANTimeoutException {
        direction.x *= .75;
        direction.y *= .75;
        double mag = Math.sqrt(direction.y * direction.y + direction.x * direction.x);
        SmartDashboard.putDouble("Driving direction.x", direction.x);
        SmartDashboard.putDouble("Driving direction.y", direction.y);
        //System.out.println("drive.x : "+ direction.x + " drive.y : " + direction.y);
        if (direction.y > 0 && direction.x == 0) {
            // Forward
            frontRight.setX(direction.y);
            frontLeft.setX(-1 * direction.y);
            backRight.setX(direction.y);
            backLeft.setX(-1 * direction.y);
        } else if (direction.y > 0 && direction.x > 0) {
            // 45 diagional front right
            frontRight.setX(0);
            frontLeft.setX(mag * -1);
            backRight.setX(mag);
            backLeft.setX(0);
        } else if (direction.y == 0 && direction.x > 0) {
            frontRight.setX(direction.x * -1);
            frontLeft.setX(-1 * direction.x);
            backRight.setX(direction.x);
            backLeft.setX(direction.x);
        } else if (direction.y < 0 && direction.x > 0) {
            frontRight.setX(mag);
            frontLeft.setX(0);
            backRight.setX(0);
            backLeft.setX(mag * -1);
        } else if (direction.y < 0 && direction.x == 0) {
            frontRight.setX(direction.y);
            frontLeft.setX(direction.y * -1);
            backRight.setX(direction.y);
            backLeft.setX(direction.y * -1);
        } else if (direction.y < 0 && direction.x < 0) {
            frontRight.setX(0);
            frontLeft.setX(mag * -1);
            backRight.setX(mag);
            backLeft.setX(0);
        } else if (direction.y == 0 && direction.x < 0) {
            frontRight.setX(direction.x * -1);
            frontLeft.setX(direction.x * -1);
            backRight.setX(direction.x);
            backLeft.setX(direction.x);
        } else if (direction.x < 0 && direction.y > 0) {
            frontRight.setX(mag * -1);
            frontLeft.setX(0);
            backRight.setX(0);
            backLeft.setX(mag);
        } else if (dPad.getX() > 0) {
            frontRight.setX(-0.6);
            frontLeft.setX(-0.6);
            backRight.setX(-0.6);
            backLeft.setX(-0.6);
        } else if (dPad.getX() < 0) {
            frontRight.setX(0.6);
            frontLeft.setX(0.6);
            backRight.setX(0.6);
            backLeft.setX(0.6);
        } else {
            frontRight.setX(0);
            frontLeft.setX(0);
            backRight.setX(0);
            backLeft.setX(0);
        }
        //logger.log("FR : " + frontRight.getX() + " RL : " + frontLeft.getX() 
        //        + " BR : " + backRight.getX() + " BL : " + backLeft.getX());
        //System.out.println("FR : " + frontRight.getX() + " RL : " + frontLeft.getX() 
        //        + " BR : " + backRight.getX() + " BL : " + backLeft.getX());
        
    }

    private CANJaguar initializeCANJag(int id, int clicksPerRev) {
        //CANJaguar canJag = CANJaguarFactory.getInstance().get(id, CANJaguar.ControlMode.kSpeed);
        CANJaguar canJag = CANJaguarFactory.getInstance().get(id, CANJaguar.ControlMode.kPercentVbus);
        try {
            //logger.log("initialize driveJag", id);

            //canJag.configEncoderCodesPerRev(clicksPerRev);
            //canJag.setPID(p, i, d);
            //canJag.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            //canJag.changeControlMode(CANJaguar.ControlMode.kSpeed);
            //canJag.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            //canJag.enableControl();   
            //canJag.configNeutralMode(CANJaguar.NeutralMode.kCoast);
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return canJag;
    }

    public void updatePID() {
        try {
            double newP = SmartDashboard.getDouble(TritionDefinitions.DRIVE_PROPORTIONAL);
            double newI = SmartDashboard.getDouble(TritionDefinitions.DRIVE_INTEGRAL);
            double newD = SmartDashboard.getDouble(TritionDefinitions.DRIVE_DIFFERENTIAL);
            if ((newP != p) || (newI != i) || (newD != d)) {
                p = newP;
                i = newI;
                d = newD;
                frontLeft.setPID(p, i, d);
                frontRight.setPID(p, i, d);
                backLeft.setPID(p, i, d);
                backRight.setPID(p, i, d);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public void drive(Direction direction, Direction dPad, boolean brakeMode) {
        try {
           // System.out.println("drive");
            directionalDrive(direction, dPad);

            if (brakeMode) {
                frontRight.configNeutralMode(CANJaguar.NeutralMode.kBrake);
                frontLeft.configNeutralMode(CANJaguar.NeutralMode.kBrake);
                backRight.configNeutralMode(CANJaguar.NeutralMode.kBrake);
                backLeft.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            } else {
                frontRight.configNeutralMode(CANJaguar.NeutralMode.kCoast);
                frontLeft.configNeutralMode(CANJaguar.NeutralMode.kCoast);
                backRight.configNeutralMode(CANJaguar.NeutralMode.kCoast);
                backLeft.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public void stop() {
        try {
            directionalDrive(new Direction(0, 0), new Direction(0, 0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    synchronized public void drive(Direction direction, Direction dPad) {
        try {
            directionalDrive(direction, dPad);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
}