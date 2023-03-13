// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

public class PneumaticsCommand extends CommandBase {
  /** Creates a new PneumaticsCommand. */
  PneumaticsSubsystem pneumatics;
  PS4Controller control;
  public PneumaticsCommand(PneumaticsSubsystem pneumatics, PS4Controller control) {
    this.pneumatics = pneumatics;
    this.control = control;
    addRequirements(pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean state = false;
    if (control.getL1ButtonPressed()){
      state = true;
    }
    else if (control.getR1Button()){
      state = false;
    }
    pneumatics.manageSolenoid(state);
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
