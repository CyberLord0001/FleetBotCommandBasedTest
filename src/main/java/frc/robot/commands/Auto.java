// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class Auto extends SequentialCommandGroup {
  /** Creates a new Auto. */
  public Auto(DriveTrain driveTrain, CommandXboxController controller, Shooter shooter) {
    addCommands(
      new Drive(driveTrain, 0.5, 0.45).withTimeout(3), 
      new Shoot().withTimeout(1), 
      new Drive(driveTrain, -0.5, -0.45).withTimeout(3),  
      new Drive(driveTrain, -0.5, 0).withTimeout(3));
  }
}