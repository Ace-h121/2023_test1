// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */
  AHRS Gyro = new AHRS(I2C.Port.kMXP);
  CANSparkMax leftDrive1; 
  CANSparkMax leftDrive2;  
 // CANSparkMax leftDrive3;
  CANSparkMax rightDrive1; 
  CANSparkMax rightDrive2;
  // CANSparkMax rightDrive3;
  MotorControllerGroup leftDrives;  
  MotorControllerGroup rightDrives;
  private static DifferentialDrive ourDrive;

  /*private RelativeEncoder leftEncoders[];
  private RelativeEncoder rightEncoders[];
  */
  public Drivebase() {
    leftDrive1 = new CANSparkMax(Constants.motorConstants.MOTER1, MotorType.kBrushless);
   // leftDrive2 = new CANSparkMax(Constants.motorConstants.MOTER2, MotorType.kBrushless); 
    // leftDrive3 = new CANSparkMax(Constants.MOTER3, MotorType.kBrushless);
    rightDrive1 = new CANSparkMax(Constants.motorConstants.MOTER3, MotorType.kBrushless); 
   // rightDrive2 = new CANSparkMax(Constants.motorConstants.MOTER4, MotorType.kBrushless);
   // rightDrive3 = new CANSparkMax(Constants.MOTER6, MotorType.kBrushless);
    leftDrives = new MotorControllerGroup(leftDrive1);
    rightDrives = new MotorControllerGroup(rightDrive1);
    ourDrive = new DifferentialDrive(leftDrives, rightDrives);

/* 
    leftEncoders =  new RelativeEncoder[2];
    rightEncoders = new RelativeEncoder[2];
    leftEncoders[0] = leftDrive1.getEncoder();
    leftEncoders[1] = leftDrive2.getEncoder();
    leftEncoders[2] = leftDrive3.getEncoder();
    rightEncoders[0] = rightDrive1.getEncoder();
    rightEncoders[1] = rightDrive2.getEncoder();
    rightEncoders[2] = rightDrive3.getEncoder();
    leftEncoders[0].setPositionConversionFactor(100/21);
    leftEncoders[1].setPositionConversionFactor(100/21);
    leftEncoders[2].setPositionConversionFactor(100/21);
    rightEncoders[0].setPositionConversionFactor(100/21);
    rightEncoders[1].setPositionConversionFactor(100/21);
    rightEncoders[3].setPositionConversionFactor(100/21);
*/

    leftDrive1.setInverted(true);
    // leftDrive2.setInverted(true);
   // leftDrive3.setInverted(true);


  }
  public static void drive(double left, double right){
    ourDrive.tankDrive(left, right);
  }
  public double Getaxis(){
    return Gyro.getAngle();

  // System.out.println("Y axis:" + Gyro.getPitch());

  }
 /* 
  public void resetEncoders() {
    for (int i = 0; i < leftEncoders.length; i++) {
      leftEncoders[i].setPosition(0);
     rightEncoders[i].setPosition(0);
    }
  }
*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
