// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsystem. */
  public static PneumaticHub pneumatics = new PneumaticHub(Constants.PneumaticsHubID);
  private Solenoid solenoid = pneumatics.makeSolenoid(Constants.SolenoidPort);
  public PneumaticsSubsystem() {
    pneumatics.enableCompressorAnalog(Constants.PneumaticsMinPressure, Constants.PneumaticsMaxPressure);
  }

  public void manageSolenoid(boolean open){
    solenoid.set(open);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
