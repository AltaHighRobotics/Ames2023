// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.Constants;

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */
  private XboxController m_driveController;
  private DriveTrainSub m_driveTrainSub;

  public DriveCommand(XboxController driveController, DriveTrainSub driveTrainSub) {
    m_driveController = driveController;
    m_driveTrainSub = driveTrainSub;

    addRequirements(m_driveTrainSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //robot was backwards, flipped these, if still wrong flip back!
    double xStick = m_driveController.getRawAxis(Constants.STICK_Y_AXIS);
    double yStick = m_driveController.getRawAxis(Constants.STICK_X_AXIS);

    m_driveTrainSub.arcadeDrive(yStick * Constants.DRIVE_SPEED, xStick * Constants.TURN_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
