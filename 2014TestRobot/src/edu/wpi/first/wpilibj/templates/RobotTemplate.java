/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;
//package RobotCode;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.IOException;
import team2340.AutomatousRobot;
import team2340.RDrive;
import team2340.RobotDefinitions;
import team2340.RobotDriveController;
import toolkit.LogitechF310;
import toolkit.RobotLogger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    
    LogitechF310 driveController;
    LogitechF310 shooterController;
    RDrive driver;
    RobotDriveController driveTeleOp;

   
    //DoryTurret turret;
    
  
    //DoryCamera camera;
    //SonicSensor sonicSensor;
    //GyroSensor gyroSensor;
    RobotLogger logger;
    
    AutomatousRobot auto;
    
    protected void robotInit() {
        logger = RobotLogger.getInstance();
        System.out.println("Commander Dory reporting for duty!");
        logger.log("Commander Dory Reporting for duty");
        
        driveController = new LogitechF310(RobotDefinitions.DRIVE_CONTROLLER, 1);
        driveController.init();
        //camera = new DoryCamera();
        shooterController = new LogitechF310(RobotDefinitions.SHOOTER_CONTROLLER, 2);
        shooterController.init();
        
        //sonicSensor = new SonicSensor(RobotDefinitions.SONIC_SENSOR_ANALOG_CHANNEL);
        //gyroSensor = new GyroSensor(RobotDefinitions.GYRO_SENSOR_CHANNEL);
        
        driver = new RDrive();
        driveTeleOp = new RobotDriveController(driver, driveController);
        
       // shooter = new DoryShooter();
      //  shooterTeleOp = new DoryShooterController(shooter, shooterController);// camera, sonicSensor);
        //turret = new DoryTurret(shooterController);
       // ballCollection = new DoryBallCollection(driveController);
//        arm = new DoryArm(shooterController);        
       
        auto = new AutomatousRobot();
    }

    protected void disabled() {
     
    }

    protected void enable() {
        
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        logger.log(" Autonomous () ");
        System.out.println("autonomous mode - go!");
        
        auto.enable();
        
        while (isEnabled() && isAutonomous()) {
            Timer.delay(0.02);
        }
        
        auto.disable();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        logger.log(" OperatorControl () " );
        System.out.println("operator control - go!");
               
        driveTeleOp.enable();
       // shooterTeleOp.enable();
       // ballCollection.enable();
  //      arm.enable();  
        
        while (isEnabled() && isOperatorControl()) {
            Timer.delay(0.02);
        }
        
        driveTeleOp.disable();
      //  shooterTeleOp.disable();
      //  ballCollection.disable();
    //    arm.disable();          
    }
}
