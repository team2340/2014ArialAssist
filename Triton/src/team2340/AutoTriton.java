/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team2340;

/**
 *
 * @author NAZareX Robotics
 */
public class AutoTriton extends TitanBase {
    
    //DoryShooter shooter;
    
    public AutoTriton( ) {
        super(TritionDefinitions.TRITON_AUTO_MODE);
       // this.shooter = shooter;
    }

    public void run() {
        try {
            System.out.println("AutoDory thread started!");
            //shooter.turnDrivesOn(0.55);
            runner.sleep(5000);
            //shooter.flip();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
