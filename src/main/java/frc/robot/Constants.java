// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  // Controllers.
  public static final int DRIVE_CONTROLLER = 5;

  // Controller stuff.
  public static final int TRIGGER_BUTTON = 1;
  public static final int STICK_X_AXIS = 0;
  public static final int STICK_Y_AXIS = 1;
  public static final int STICK_Z_AXIS = 2;
  public static final int SLIDER_AXIS = 3;
  public static final int AUTONOMOUS_STARTER = 6;

  // Drive stuff.
  public static final double DRIVE_SPEED = 0.6;
  public static final double TURN_SPEED = 0.8;

  // Drive train.
  public static final int RIGHT_MOTOR_1 = 2; 
  public static final int RIGHT_MOTOR_2 = 1;
  public static final int LEFT_MOTOR_1 = 3;
  public static final int LEFT_MOTOR_2 = 4;

  //Ramp motor
  public static final int RAMP_MOTOR = 5;
  public static final double RAMP_SPEED = -.9;

  //Autonomous
  public static final int maxExecutions = 50; //50 = 1 second
}
