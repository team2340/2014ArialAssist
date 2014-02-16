/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340.subsystems.boxShooter;

import team2340.TritanBase;
import team2340.TritionDefinitions;
import toolkit.LogitechF310;

/**
 *
 * @author Team2340
 */
public class BoxShooterController extends TritanBase{
    private LogitechF310 controller;
    private BoxShooter shooter;
    
    public BoxShooterController(BoxShooter shooter, LogitechF310 controller) {
        super(TritionDefinitions.BOX_SHOOTER_CONTROLLER_NAME);
        this.shooter = shooter;
        this.controller = controller;
    }

    public void run() {
        if (controller.getDPad().getX() >0 ) {
            shoot();
        }
        else if (controller.getDPad().getX() < 0) {
            pass();
        }
    }
    
    public void shoot() {
        try {
        shooter.fullSpeed();
        runner.sleep(TritionDefinitions.SHOOTER_SLEEP_TIME);
        shooter.stop();

        } catch (Exception ex) {
            System.out.println("Shoot Exception");
        }
    }
    
    public void pass() {
        try {
        shooter.fullSpeed();
        runner.sleep(TritionDefinitions.SHOOTER_SLEEP_TIME);
        shooter.stop();
        } catch( Exception ex) {
            System.out.println("Pass Exception");
        }
        
    }
    
}
