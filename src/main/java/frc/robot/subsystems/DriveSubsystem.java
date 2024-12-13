// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    CANSparkMax frontLeftMotor;
    CANSparkMax frontLeftMotorFollower;
    CANSparkMax frontRightMotor;
    CANSparkMax frontRightMotorFollower;
    CANSparkMax backMotor;
    CANSparkMax backMotorFollower;
  
  /** 
   * Creates a new TankDriveSubsystem.
   * Controls the base driving 
  */
  public DriveSubsystem() {
    // Create Motors
    frontLeftMotor = new CANSparkMax(DriveConstants.frontLeftMotor, MotorType.kBrushless);
    frontLeftMotorFollower = new CANSparkMax(DriveConstants.frontLeftMotorFollower, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(DriveConstants.frontRightMotor, MotorType.kBrushless);
    frontRightMotorFollower = new CANSparkMax(DriveConstants.frontRightMotorFollower, MotorType.kBrushless);
    backMotor = new CANSparkMax(DriveConstants.backMotor, MotorType.kBrushless);
    backMotorFollower = new CANSparkMax(DriveConstants.backMotorFollower, MotorType.kBrushless);

    // .restoreFactoryDefaults()
    frontLeftMotor.restoreFactoryDefaults();
    frontLeftMotorFollower.restoreFactoryDefaults();
    frontRightMotor.restoreFactoryDefaults();
    frontRightMotorFollower.restoreFactoryDefaults();
    backMotor.restoreFactoryDefaults();
    backMotorFollower.restoreFactoryDefaults();

    // set current limits
    frontLeftMotor.setSmartCurrentLimit(DriveConstants.driveMotorsCurrentLimit);
    frontLeftMotorFollower.setSmartCurrentLimit(DriveConstants.driveMotorsCurrentLimit);
    frontRightMotor.setSmartCurrentLimit(DriveConstants.driveMotorsCurrentLimit);
    frontRightMotorFollower.setSmartCurrentLimit(DriveConstants.driveMotorsCurrentLimit);
    backMotor.setSmartCurrentLimit(DriveConstants.driveMotorsCurrentLimit);
    backMotorFollower.setSmartCurrentLimit(DriveConstants.driveMotorsCurrentLimit);

    // ramp rates
    frontLeftMotor.setClosedLoopRampRate(DriveConstants.driveMotorsRampRate);
    frontLeftMotorFollower.setClosedLoopRampRate(DriveConstants.driveMotorsRampRate);
    frontRightMotor.setClosedLoopRampRate(DriveConstants.driveMotorsRampRate);
    frontRightMotorFollower.setClosedLoopRampRate(DriveConstants.driveMotorsRampRate);
    backMotor.setClosedLoopRampRate(DriveConstants.driveMotorsRampRate);
    backMotorFollower.setClosedLoopRampRate(DriveConstants.driveMotorsRampRate);

    //follow motors
    frontLeftMotorFollower.follow(frontLeftMotor);
    frontRightMotorFollower.follow(frontRightMotor);
    backMotorFollower.follow(backMotor);

    // .getEncoder().setPosition(0);
    frontLeftMotor.getEncoder().setPosition(0);
    frontRightMotor.getEncoder().setPosition(0);
    backMotor.getEncoder().setPosition(0);

    // .getEncoder().setPositionConversionFactor()
    frontLeftMotor.getEncoder().setPositionConversionFactor(0.7854166666666673);
    frontRightMotor.getEncoder().setPositionConversionFactor(0.7854166666666673);
    backMotor.getEncoder().setPositionConversionFactor(0.7854166666666673);

    // pid?

  }

  /**
     * Drives the robot
     */
    public void drive(double leftMotorSpeed, double rightMotorSpeed, double backMotorSpeed){
        frontLeftMotor.set(leftMotorSpeed);
        frontRightMotor.set(rightMotorSpeed);
        backMotor.set(backMotorSpeed);
    }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {

  }
}
