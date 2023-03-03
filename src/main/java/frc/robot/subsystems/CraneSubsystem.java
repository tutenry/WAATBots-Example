// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CraneSubsystem extends SubsystemBase {
  /** Creates a new CraneSubsystem. */
  private final CANSparkMax UpDownCraneMotor = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax LeftRightCraneMotor = new CANSparkMax(1, MotorType.kBrushless);
  public CraneSubsystem() {}

  public void moveUpDown(double speed){
    if (speed >= 0.15){
      UpDownCraneMotor.set(speed);
    }
    else{
      UpDownCraneMotor.set(0);
    }
  }

  public void moveLeftRight(double speed){
    if (speed >= 0.15){
      LeftRightCraneMotor.set(speed);
    }
    else{
      LeftRightCraneMotor.set(0);
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
