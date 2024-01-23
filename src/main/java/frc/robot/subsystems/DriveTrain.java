// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private Talon m_left1 = new Talon(0);
  private Talon m_left2 = new Talon(1);
  private Talon m_right1 = new Talon(2);
  private Talon m_right2 = new Talon(3);
  private MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_left1, m_left2);
  private MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_right1, m_right2);
  private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  public void drive(double forwardsSpeed, double turningSpeed){
    m_differentialDrive.arcadeDrive(turningSpeed, forwardsSpeed);
  }
  public void stop(){
    m_differentialDrive.arcadeDrive(0, 0);
  }
}