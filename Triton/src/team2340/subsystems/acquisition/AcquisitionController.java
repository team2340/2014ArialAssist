/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340.subsystems.acquisition;

import team2340.TritanBase;
import team2340.TritionDefinitions;
import team2340.subsystems.acquisition.TritionAcquisition;
import toolkit.LogitechF310;

/**
 *
 * @author Team2340
 */
public class AcquisitionController extends TritanBase {
    
    private TritionAcquisition acqControl;
    private LogitechF310 controller; 
    
    /**
     *
     * @param acquisitionControl
     */
    public AcquisitionController(TritionAcquisition acquisitionControl, LogitechF310 controller) {
        super(TritionDefinitions.TRITION_ACQUISITION_NAME);
        this.acqControl = acquisitionControl;
        this.controller = controller;
        
    }

    public void run() {
        System.out.println("Trition Acquisition thread started!");
        while (runner != null && runner.isAlive()) {
            try {
                //updateSpeeds();
                if (controller.getY()) {
                    aquire();
                } else if (controller.getA()) {
                    startAcquisition();
                } else if (controller.getB()) {
                    stopAcquisition();
                } else if (controller.getX()) {
                    grab();
                } else if (controller.getY()) {
                    // Single Command to do all ?
                }
                runner.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    
    }

    private void aquire() {
        try {
        acqControl.armOut();
        runner.sleep(TritionDefinitions.ACQUISITION_ARM_DELAY_TIME);
        acqControl.armStop();

        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    private void startAcquisition() {
        acqControl.startSpinner();
    }

    private void stopAcquisition() {
        acqControl.stopSpinner();
    }
    
    private void repell() {
        acqControl.reverseSpinner();
    }

    private void grab() { 
            try {
        acqControl.armIn();
        runner.sleep(TritionDefinitions.ACQUISITION_ARM_DELAY_TIME);
        acqControl.armStop();

        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    private void resetArm() {
        acqControl.armIn();
        // run to limit switch
    }
    
}
