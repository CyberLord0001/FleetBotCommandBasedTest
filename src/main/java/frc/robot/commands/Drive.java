// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {
  private DriveTrain m_driveTrain;
  private double m_forwardsSpeed;
  private double m_turningSpeed;
  /** Creates a new Drive. */
  public Drive(DriveTrain driveTrain, double forwardsSpeed, double turningSpeed) {
    m_driveTrain=driveTrain;
    m_forwardsSpeed = forwardsSpeed;
    m_turningSpeed = turningSpeed;
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.drive(m_forwardsSpeed, m_turningSpeed);;
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
