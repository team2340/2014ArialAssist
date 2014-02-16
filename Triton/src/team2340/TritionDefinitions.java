/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team2340;

/**
 *
 * @author Team 2340
 */
public class TritionDefinitions {
       // names
    public final static String TRITON_DRIVE_NAME = "Triton Drive";
    public final static String TRITON_SHOOTER_NAME = "Triton Shooter";
      
    public final static String TRITON_BALL_COLLECTION = "Triton Ball Collection";
    public final static String BOX_CONTROLLER_NAME = "Triton Box Control";
    
    public final static String TRITION_ACQUISITION_NAME = "Trition Acquisition";

    public final static String TRITON_CAMERA = "Triton Camera";
    public final static String TRITON_SONIC_SENSOR = "Triton Sonic Sensor";
    public final static String TRITON_GYRO_SENSOR = "Triton Gyro Sensor";
    public final static String TRITON_AUTO_MODE = "Triton Autonomous Mode";
    
    public final static String BOX_FULL_UP = "FULLUP";
    public final static String BOX_FULL_DOWN = "FULLDOWN";
    public final static String BOX_PARTIAL_UP = "PARTIALUP";
    public final static String BOX_PARTIAL_DOWN = "PARTIALDOWN";
    
    
    // smart dashboard names
    public static final String DRIVE_DIFFERENTIAL = "Drive PID: Differential";
    public static final String DRIVE_INTEGRAL = "Drive PID: Integral";
    public static final String DRIVE_PROPORTIONAL = "Drive PID: Proportional";
    public static final String DRIVE_RPM = "Drive Wheel RPM";
    
    public static final String SHOOTER_DIFFERENTIAL = "Shooter PID: Differential";
    public static final String SHOOTER_INTEGRAL = "Shooter PID: Integral";
    public static final String SHOOTER_PROPORTIONAL = "Shooter PID: Proportional";
    public static final String SHOOTER_RPM_ACTUAL = "Shooter Wheel RPM Actual"; // output
    public static final String SHOOTER_RPM_ACTUAL_LEFT = "Shooter Wheel RPM Actual LEFT"; // output
    public static final String SHOOTER_RPM_ACTUAL_RIGHT = "Shooter Wheel RPM Actual RIGHT"; // output
    public static final String SHOOTER_RPM_TARGET = "Shooter Wheel RPM Target"; // input
    public static final String SHOOTER_CONTROL_MODE = "Shooter Control Mode"; // input
    
    public static final String SHOOTER_TOP_TARGET_TO_PEAK = "Top Target To Peak (in)";
    public static final String SHOOTER_MIDDLE_TARGET_TO_PEAK = "Middle Target To Peak (in)";
    public static final String SHOOTER_BOTTOM_TARGET_TO_PEAK = "Bottom Target To Peak (in)";
    public static final String FLIPPER_AT_FORWARD_LIMIT = "Flipper at forward limit";
    public static final String FLIPPER_AT_REVERSE_LIMIT = "Flipper at reverse limit";
    
    public static final String TURRET_AT_FORWARD_LIMIT = "Turret at forward limit";
    public static final String TURRET_AT_REVERSE_LIMIT = "Turret at reverse limit";
    
    public static final String TURRET_SPEED = "Turret speed";
    
    public static final String TOP_ANEMONE_SPEED = "Top anemone speed";
    public static final String BOTTOM_ANEMONE_SPEED = "Bottom anemone speed";
    
    public static final String ARM_AT_REVERSE_LIMIT = "Arm at Reverse Limit";
    public static final String ARM_AT_FORWARD_LIMIT = "Arm at Forward Limit";
    public static final String ARM_SPEED = "Set Arm Speed";
    
    public static final String DRIVE_CONTROLLER = "Drive Controller";
    public static final String SHOOTER_CONTROLLER = "Shooter Controller";
    
    public static final String CAMERA_H_LOW = "Camera hue low"; // or red or 
    public static final String CAMERA_H_HIGH = "Camera hue high";
    public static final String CAMERA_S_LOW = "Camera saturation low"; // or green
    public static final String CAMERA_S_HIGH = "Camera saturation high";
    public static final String CAMERA_I_LOW = "Camera intensity low"; // or blue
    public static final String CAMERA_I_HIGH = "Camera intensity high";
    
    public static final String IP_PERCENT_OF_IMAGE_LOW = "%image / image area low";
    public static final String IP_PERCENT_OF_IMAGE_HIGH = "%image / image area high";
    
    public static final String CAMERA_NUM_RECTANGLES_FOUND = "Num rectangles found";
    
    public static final String BOX_SHOOTER_CONTROLLER_NAME = "Box Shooter Controller Name";
    
    // smart dashboard initial values
    public static final double DRIVE_P_INITIAL = 1.0;
    public static final double DRIVE_I_INITIAL = 0.01;
    public static final double DRIVE_D_INITIAL = 0.0;
        
    public static final double SHOOTER_P_INITIAL = 1.0;
    public static final double SHOOTER_I_INITIAL = 0.01;
    public static final double SHOOTER_D_INITIAL = 0.0;
    
    public static final double SHOOTER_TTTP_INITIAL = 20.0;
    public static final double SHOOTER_MTTP_INITIAL = 15.0;
    public static final double SHOOTER_BTTP_INITIAL = 10.0;
    
    public static final int SHOOTER_CONTROL_MODE_INITIAL = 0;
    //public static final int SHOOTER_INCREASE = 1;
    //public static final int SHOOTER_DECREASE = 2;
    //public static final int SHOOTER_MAX = 3;
    //public static final int SHOOTER_AUTO = 4;
    
    public static final double TURRET_SPEED_INITIAL = 0.30;
    
    public static final double TOP_ANEMONE_SPEED_INITIAL = 0.6;
    public static final double BOTTOM_ANEMONE_SPEED_INITIAL = 0.8;
    
    public static final double ARM_SPEED_INITIAL = 1.0;
    
    public static final int CAMERA_H_LOW_INITIAL = 0;
    public static final int CAMERA_H_HIGH_INITIAL = 255;
    public static final int CAMERA_S_LOW_INITIAL = 175;
    public static final int CAMERA_S_HIGH_INITIAL = 255;
    public static final int CAMERA_I_LOW_INITIAL = 0;
    public static final int CAMERA_I_HIGH_INITIAL = 95;    
    
    public static final double IP_PERCENT_OF_IMAGE_LOW_INITIAL = 1.2;
    public static final double IP_PERCENT_OF_IMAGE_HIGH_INITIAL = 18.2;
    
    // can jag ids
    public final static int TRITION_FRONTRIGHT_DRIVE_JAG_ID = 5;
    public final static int TRITION_FRONTLEFT_DRIVE_JAG_ID = 4;
    public final static int TRITION_BACKRIGHT_DRIVE_JAG_ID = 3;
    public final static int TRITION_BACKLEFT_DRIVE_JAG_ID = 2;
    // TODO ID's need to be defined for additional motors.
    public final static int TRITION_ACQUISITION_SPINNER_ID = 0;
    public final static int TRITION_ACQUISITION_ARM_ID = 0;
    public final static int TRITION_BOX_MOTOR_ID = 0;
    public final static int TRITION_TOP_FLY_WHEEL_ID = 0;
    public final static int TRITION_BOTTOM_FLY_WHEEL_ID = 0;
    
    
    // analog channels
    public final static int SONIC_SENSOR_ANALOG_CHANNEL = 2;
    public final static int GYRO_SENSOR_CHANNEL = 1;
    
    // buttons
    public final static int BUTTON_X = 1;
    public final static int BUTTON_Y = 4;
    public final static int BUTTON_A = 2;
    public final static int BUTTON_B = 3;
    public final static int BUTTON_LB = 5;
    public final static int BUTTON_RB = 6;
    public final static int BUTTON_LT = 7;
    public final static int BUTTON_RT = 8;
    public final static int BUTTON_BACK = 9;
    public final static int BUTTON_START = 10;
    
    // constants
    public final static int CPR360 = 360;
    public final static int CPR250 = 250;
    
    // from carpet to middle of target rectangle
    public final static double TARGET_HEIGHT_IN = 18.0;
    public final static double TARGET_WIDTH_IN = 24.0;
    public final static double TOP_TARGET_HEIGHT_IN = 109.0;
    public final static double MIDDLE_TARGET_HEIGHT_IN = 71.0;
    public final static double BOTTOM_TARGET_HEIGHT_IN = 39.0;
    public final static double SHOOTER_HEIGHT_IN = 20.0; // FIX ME
    public final static double SHOOTER_WHEEL_DIAMETER_IN = 6.0;
    public final static double SHOOTER_CIRCUMFERENCE_IN = Math.PI * SHOOTER_WHEEL_DIAMETER_IN;
    public static double BOX_UP_SPEED = 0.25;
    public static double BOX_DOWN_SPEED = 0.25;
    public static double BOX_STOP = 0.0;
    public static long BOX_PARTIAL_MOVE_SLEEP_TIME = 2;
    public static long ACQUISITION_ARM_DELAY_TIME = 2;
    public static double ARM_STOP = 0.0;
    public static double ACQUISITION_ARM_OUT_SPEED = 0.25;
    public static double ACQUISITION_ARM_IN_SPEED = -0.25;
    public static long SHOOTER_SLEEP_TIME = 10;
    public static double TOP_FLYWHEEL_SPEED = 0.75;
    public static double BOTTOM_FLYWHEEL_SPEED = -0.75;
    public static double FLY_WHEEL_STOP = 0.0;
   
    
    
}
