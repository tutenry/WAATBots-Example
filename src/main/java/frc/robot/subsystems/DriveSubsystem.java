// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private CANSparkMax frontLeft = new CANSparkMax(Constants.FL_ID, MotorType.kBrushless);
  private CANSparkMax frontRight = new CANSparkMax(Constants.FR_ID, MotorType.kBrushless);
  private CANSparkMax backLeft = new CANSparkMax(Constants.BL_ID, MotorType.kBrushless);
  private CANSparkMax backRight = new CANSparkMax(Constants.BR_ID, MotorType.kBrushless);

  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;

  private DifferentialDrive diffDrive;

  public DriveSubsystem() {
    leftMotors = new MotorControllerGroup(frontLeft, backLeft);
    rightMotors = new MotorControllerGroup(frontRight, backRight);

    rightMotors.setInverted(true);

    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void move(double speed, double rotation){
    diffDrive.arcadeDrive(speed, rotation);
  }

  public void stop(){
    diffDrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
