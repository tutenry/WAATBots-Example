// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveCommand;
import frc.robot.commands.MoveCraneCommand;
import frc.robot.commands.PneumaticsCommand;
import frc.robot.subsystems.CraneSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  // The robot's subsystems and commands are defined here
  DriveSubsystem drive = new DriveSubsystem();
  CraneSubsystem crane = new CraneSubsystem();
  PneumaticsSubsystem pneumatics = new PneumaticsSubsystem();

  PS4Controller control = new PS4Controller(Constants.CONTROL_ID);

  public RobotContainer() {
    // Set default commands
    drive.setDefaultCommand(new DriveCommand(drive, control));
    crane.setDefaultCommand(new MoveCraneCommand(crane, control));
    pneumatics.setDefaultCommand(new PneumaticsCommand(pneumatics, control));
    

    configureBindings();
  }

  private void configureBindings() {  
    //You can configure button bindings here or do them in the command like I did
  }

  //This is the command the robot runs when in autonomous mode
  public Command getAutonomousCommand() {
    return new InstantCommand(() -> {
      drive.stop();
    });
  }
}
