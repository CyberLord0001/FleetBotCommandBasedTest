// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.Auto;
import frc.robot.commands.DriveWithController;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  private DriveTrain m_driveTrain = new DriveTrain();
  private Shooter m_shooter = new Shooter();
  private CommandXboxController m_controller = new CommandXboxController(0);
  public RobotContainer() {
    m_driveTrain.setDefaultCommand(new DriveWithController(m_driveTrain, m_controller, 0.85));
    configureBindings();
  }

  private void configureBindings() {
    m_controller.x()
      .whileTrue(new DriveWithController(m_driveTrain, m_controller, 0.5));
    m_controller.y()
      .whileTrue(new DriveWithController(m_driveTrain, m_controller, 0.25));
    m_controller.a()
      .whileTrue(new Shoot(m_shooter));
  }

  public Command getAutonomousCommand() {
    return(new Auto(m_driveTrain, m_controller, m_shooter));
  }
}
