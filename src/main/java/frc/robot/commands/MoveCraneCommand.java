// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CraneSubsystem;

public class MoveCraneCommand extends CommandBase {
  /** Creates a new MoveCraneCommand. */
  CraneSubsystem crane;
  PS4Controller control;
  public MoveCraneCommand(CraneSubsystem crane, PS4Controller control) {
    this.crane = crane;
    this.control = control;
    addRequirements(crane);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    crane.moveUpDown(control.getRightY());
    crane.moveLeftRight(control.getRightX());
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
