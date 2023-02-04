// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Utilities;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;



/** Add your docs here. */
public class Controls { 
    public static XboxController Driver = new XboxController(Constants.DRIVER_PORT);
    private final static CommandXboxController operator = new CommandXboxController(Constants.OPERATOR_PORT);
    // binding the buttons to themselves

    public static Trigger yButton = operator.y();
    public static Trigger aButton = operator.a(); 
    public static Trigger bButton = operator.a();
    public static Trigger xButton = operator.x();
    
    // buttons for throttle and break


// method for getting the 
public static double Axis(XboxController controller, int axis){
   return controller.getRawAxis(axis);
}

}

