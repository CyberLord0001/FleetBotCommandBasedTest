// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class DriveWithController extends CommandBase {
  private DriveTrain m_driveTrain;
  private CommandXboxController m_controller;
  private double m_maxSpeed;
  

  /** Creates a new Drive. */
  public DriveWithController(DriveTrain driveTrain, CommandXboxController controller, double maxSpeed) {
    m_driveTrain=driveTrain;
    m_controller=controller;
    addRequirements(m_driveTrain);
    m_maxSpeed = maxSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.drive(m_maxSpeed*m_controller.getRawAxis(1), m_maxSpeed*m_controller.getRawAxis(4));
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
