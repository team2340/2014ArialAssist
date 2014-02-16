/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340.subsystems.boxControl;

import team2340.TritanBase;
import toolkit.LogitechF310;
import team2340.TritionDefinitions;

/**
 *
 * @author Team2340
 */
public class BoxController extends TritanBase {
    LogitechF310 controller;
    BoxControl bc;
    public BoxController(BoxControl bc, LogitechF310 controller){
        super (TritionDefinitions.BOX_CONTROLLER_NAME);
        
    }

    public void run() {
        System.out.println("Trition BoxController thread started!");
        while (runner != null && runner.isAlive()) {
            try {
                //updateSpeeds();
                if (controller.getRT()) {
                    fullUp();
                } else if (controller.getRT()) {
                    fullDown();
                } else if (controller.getLT()) {
                    partialUp();
                } else if (controller.getLB()) {
                    partialDown();
                } 
                runner.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void fullUp() {
        try {
        while(!bc.moveUp()) {
                runner.sleep(5);
            } 
        }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
     }

    private void fullDown() {
        try {
            while(!bc.moveDown()) {
                runner.sleep(5);
            }
            
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void partialUp() {
        try {
        bc.moveUp();
        runner.sleep(TritionDefinitions.BOX_PARTIAL_MOVE_SLEEP_TIME);
        bc.stop();
        } catch( InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void partialDown() {
        try {
        bc.moveDown();
        runner.sleep(TritionDefinitions.BOX_PARTIAL_MOVE_SLEEP_TIME);
        bc.stop();
        } catch ( InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
