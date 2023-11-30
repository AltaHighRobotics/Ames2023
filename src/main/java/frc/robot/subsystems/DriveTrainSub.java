// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;

public class DriveTrainSub extends SubsystemBase {
  /** Creates a new DriveTrainSub. */
  private WPI_TalonSRX rightMotor1;
  private WPI_TalonSRX rightMotor2;
  private WPI_TalonSRX leftMotor1;
  private WPI_TalonSRX leftMotor2;

  public DriveTrainSub() {
    rightMotor1 = new WPI_TalonSRX(Constants.RIGHT_MOTOR_1);
    rightMotor2 = new WPI_TalonSRX(Constants.RIGHT_MOTOR_2);
    leftMotor1 = new WPI_TalonSRX(Constants.LEFT_MOTOR_1);
    leftMotor2 = new WPI_TalonSRX(Constants.LEFT_MOTOR_2);

    rightMotor1.configFactoryDefault();
    rightMotor2.configFactoryDefault();
    leftMotor1.configFactoryDefault();
    leftMotor2.configFactoryDefault();

    //this motor.follow(this motor); 
    //The first motor object follows the motor object passed as an argument (as far as I(duncan) can tell)
    rightMotor2.follow(rightMotor1);
    leftMotor2.follow(leftMotor1);
    //Telling the back motors {Motor2} to follow front Motor's {Motor1}
  }

  public void stop() {
    rightMotor1.neutralOutput();
    leftMotor1.neutralOutput();
  }

  public void setRightMotors(double power) {
    rightMotor1.set(ControlMode.PercentOutput, power);
  }

  public void setLeftMotors(double power) {
    leftMotor1.set(ControlMode.PercentOutput, power);
  }

  public void arcadeDrive(double forwardPower, double turnPower) {
    setRightMotors(forwardPower + turnPower);
    setLeftMotors(forwardPower - turnPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
