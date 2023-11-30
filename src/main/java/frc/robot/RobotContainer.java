// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Controllers.
  private XboxController m_driveController = new XboxController(Constants.DRIVE_CONTROLLER);
  // Subsystems.
  private DriveTrainSub m_driveTrainSub = new DriveTrainSub();
  private RampSub m_rampSub = new RampSub();

  // Commands.
  private DriveCommand m_driveCommand = new DriveCommand(m_driveController, m_driveTrainSub);
  private ControlRampCommand m_controlRampCommand = new ControlRampCommand(m_driveController, m_rampSub);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    CommandScheduler.getInstance().setDefaultCommand(m_driveTrainSub, m_driveCommand);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    final JoystickButton rampSpinButton = new JoystickButton(m_driveController, Constants.TRIGGER_BUTTON);
    //The line beloew only activates every other press.
    //rampSpinButton.onTrue(m_rampCommand);
    //This line schedules the command and attempts to cancel it if the button is let go, exactly what we want
    rampSpinButton.whileTrue(m_controlRampCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */  
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
