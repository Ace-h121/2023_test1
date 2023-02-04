// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class arm extends SubsystemBase {
  // a solenoid for breaking
  private Solenoid brakes;

  // two motors that control the arms movement 
  private CANSparkMax leftArm;
  private CANSparkMax rightArm;

  // a boolean to toggle for the breaks
  private boolean toggle;
  /** Creates a new arm. */
  public arm() {
    //init those objects from before
    brakes = new Solenoid(null, Constants.BREAK_SOLENOID);
    leftArm = new CANSparkMax(Constants.MOTER7, MotorType.kBrushless);
    rightArm = new CANSparkMax(Constants.MOTER8, MotorType.kBrushless);
    toggle = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  // takes in a string called mode that will determine how it runs, condensing what would be 3 methods to one.
  public void armMove(String mode){
    if(mode.equalsIgnoreCase("BREAK")){
      toggle = !toggle;
      brakes.set(toggle);
    }
    else if (mode.equalsIgnoreCase("FORWARD")){
      leftArm.set(-Constants.ARM_SPEED);
      rightArm.set(Constants.ARM_SPEED);
    }
    else if (mode.equalsIgnoreCase("REVERSE")){
      leftArm.set(Constants.ARM_SPEED);
      rightArm.set(-Constants.ARM_SPEED);

    }
  }
}
