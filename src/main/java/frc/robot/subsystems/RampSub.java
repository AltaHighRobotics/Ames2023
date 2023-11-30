// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;

public class RampSub extends SubsystemBase {
  /** Creates a new RampSub. */
  private WPI_TalonSRX rampMotor;

  public RampSub() {
    rampMotor = new WPI_TalonSRX(Constants.RAMP_MOTOR);

    rampMotor.configFactoryDefault();
  }

  public void stop() {
    rampMotor.neutralOutput();
  }

  public void setRampMotor(double power) {
    rampMotor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
