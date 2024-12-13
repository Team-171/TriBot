// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** A command that runs the drive. */
public class TankDriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem driveSubsystem;

  // the speed to go forward
  private DoubleSupplier forward;

  // the speed to turn at
  private DoubleSupplier rotation;

  /**
   * Creates a new TankDriveCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TankDriveCommand(DriveSubsystem subsystem, DoubleSupplier forward, DoubleSupplier rotation) {
    driveSubsystem = subsystem;
    this.forward = forward;
    this.rotation = rotation;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Move forward and rotate at the given speeds. Move slowly if it should be slow.
    
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
