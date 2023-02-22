// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  DriveSubsystem drive;
  XboxController control;
  public DriveCommand(DriveSubsystem drive, XboxController control) {
    this.drive = drive;
    this.control = control;
    //Add requirements to ensure commands don't overlap on the same subsystem
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Getting control data to move the robot
    if (Math.sqrt(Math.pow(control.getLeftY(), 2) +  Math.pow(control.getLeftX(), 2)) < 0.1){
      drive.stop();
    }
    else{
      drive.move(control.getLeftY(), control.getLeftX());
    }
  }

  
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
