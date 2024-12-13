// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class RobotContainer {

  private final DriveSubsystem driveSubsystem;

  private final CommandXboxController driverController = new CommandXboxController(
      DriveConstants.kDriverControllerPort);

  public RobotContainer() {

    driveSubsystem = new DriveSubsystem();

    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, () -> driverController.getLeftX(), () -> driverController.getLeftY(), () -> driverController.getRightX()));
        

    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
