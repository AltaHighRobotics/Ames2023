// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RampSub;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class ControlRampCommand extends CommandBase {
  /** Creates a new ControlRampCommand. */
  private XboxController m_driveController;
  private RampSub m_rampSub;

  public ControlRampCommand(XboxController driveController, RampSub rampSub) {
    m_driveController = driveController;
    m_rampSub = rampSub;

    addRequirements(m_rampSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double stick = m_driveController.getRawAxis(Constants.SLIDER_AXIS);
    m_rampSub.setRampMotor(-stick*Constants.RAMP_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_rampSub.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
