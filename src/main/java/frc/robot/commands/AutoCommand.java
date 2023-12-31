// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.Constants;

public class AutoCommand extends CommandBase {
  /** Creates a new AutoCommand. */
  private DriveTrainSub m_driveTrainSub;
  private int m_executed = 0;

  public AutoCommand(DriveTrainSub driveTrainSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrainSub = driveTrainSub;

    addRequirements(m_driveTrainSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("balls");
    if (m_executed < Constants.maxExecutions)
    {
      m_driveTrainSub.arcadeDrive(1 * Constants.DRIVE_SPEED, 0 * Constants.TURN_SPEED);
    }
    else
    {
      m_driveTrainSub.stop();
    }
    m_executed++;
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
