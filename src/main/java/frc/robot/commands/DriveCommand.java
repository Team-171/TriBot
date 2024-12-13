// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

/** A command that runs the drive. */
public class DriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem driveSubsystem;

  private double leftX;

  // the speed to turn at
  private double leftY;

  private double rightX;

  private double maxSpeed;

  private double frontRightMotor;
  private double frontLeftMotor;
  private double backMotor;

  /**
   * Creates a new TankDriveCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveSubsystem subsystem, DoubleSupplier leftX, DoubleSupplier leftY, DoubleSupplier rightX) {
    driveSubsystem = subsystem;
    this.leftX = leftX.getAsDouble() * 100;
    this.leftY = leftY.getAsDouble() * 100;
    this.rightX = rightX.getAsDouble() * 100;
    maxSpeed = 100;
    
    //https://www.desmos.com/calculator/lyzy8svf33

    frontRightMotor = maxSpeed * Math.sqrt((this.leftX*this.leftX)+(this.leftY*this.leftY)) * Math.sin((Math.PI/6)-Math.atan2(this.leftY, this.leftX));
    frontRightMotor = frontRightMotor / (Math.min(Math.abs(Math.cos(100/((Math.PI/2)-Math.atan2(this.leftY, this.leftX)))), Math.abs(Math.sin(100/((Math.PI/2)-Math.atan2(this.leftY, this.leftX))))));
    frontRightMotor = frontRightMotor + this.rightX;
    frontRightMotor = frontRightMotor / 100;  
    
    frontLeftMotor = maxSpeed * Math.sqrt((this.leftX*this.leftX)+(this.leftY*this.leftY)) * Math.sin(((Math.PI * 5)/6)-Math.atan2(this.leftY, this.leftX));
    frontLeftMotor = frontLeftMotor / (Math.min(Math.abs(Math.cos(100/((Math.PI/2)-Math.atan2(this.leftY, this.leftX)))), Math.abs(Math.sin(100/((Math.PI/2)-Math.atan2(this.leftY, this.leftX))))));
    frontLeftMotor = frontLeftMotor + this.rightX;
    frontLeftMotor = frontLeftMotor / 100;

    backMotor = maxSpeed * Math.sqrt((this.leftX*this.leftX)+(this.leftY*this.leftY)) * Math.sin(((Math.PI * 3)/6)-Math.atan2(this.leftY, this.leftX));
    backMotor = backMotor / (Math.min(Math.abs(Math.cos(100/((Math.PI/2)-Math.atan2(this.leftY, this.leftX)))), Math.abs(Math.sin(100/((Math.PI/2)-Math.atan2(this.leftY, this.leftX))))));
    backMotor = backMotor + this.rightX;
    backMotor = backMotor / 100;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.drive(frontLeftMotor, frontRightMotor, backMotor);
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
