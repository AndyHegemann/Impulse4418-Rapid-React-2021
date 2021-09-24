/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;

	// Shoulder Motor = Loader/Feeder
	// Elbow Motor = Lower shooter
	// Wrist Motor = Higher shooter

public class FireCommand extends CommandBase {
	public FireCommand() {
		addRequirements(RobotContainer.manipulatorsubsystem);		
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		int SpeedTolerance = 100;
		int WristTargetSpeed = 2000; 		//in RPM, changed to counts/100ms in motor commands 	// TODO: Config wrist fire motor speed
		int ElbowTargetSpeed = 2000;		// TODO: Config elbow fire motor speed
		int CountsPerRev = 1024;
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		// SmartDashboard.putNumber("Wrist Fire", RobotContainer.manipulatorsubsystem.getWristFireMotor());
		// SmartDashboard.putNumber("Elbow Fire", RobotContainer.manipulatorsubsystem.getElbowFireMotor());
		// SmartDashboard.putNumber("Shoulder Fire", RobotContainer.manipulatorsubsystem.getShoulderFireMotor());
		
		RobotContainer.manipulatorsubsystem.setElbowFireMotor(-(WristTargetSpeed*(CountsPerRev/600)));	
		RobotContainer.manipulatorsubsystem.setWristFireMotor(-(ElbowTargetSpeed*(CountsPerRev/600)));	
		// System.out.println(elbowFireMotor.getSelectedSensorVelocity(0));

		//need to wait until motors are up to speed
		if ((WristTargetSpeed - abs(wristFireMotor.getSelectedSensorVelocity) <= SpeedTolerance) && (WristTargetSpeed - abs(elbowFireMotor.getSelectedSensorVelocity) <= SpeedTolerance)){
			RobotContainer.manipulatorsubsystem.setShoulderFireMotor(-0.5);	// TODO: Config shoulder fire motor speed
		}
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		RobotContainer.manipulatorsubsystem.setShoulderFireMotor(0.0);
		RobotContainer.manipulatorsubsystem.setElbowFireMotor(0.0);
		RobotContainer.manipulatorsubsystem.setWristFireMotor(0.0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
