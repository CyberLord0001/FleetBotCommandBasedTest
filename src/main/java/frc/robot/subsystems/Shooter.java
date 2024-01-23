// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private WPI_TalonFX m_shooter1 = new WPI_TalonFX(4);
    private WPI_TalonFX m_shooter2 = new WPI_TalonFX(5);
    private MotorControllerGroup m_shooters = new MotorControllerGroup(m_shooter1, m_shooter2);
  /** Creates a new DriveTrain. */
  public Shooter() {}

  public void shoot(){
    m_shooters.set(0.65);
  }
  public void stop(){
    m_shooters.set(0);
  }
}