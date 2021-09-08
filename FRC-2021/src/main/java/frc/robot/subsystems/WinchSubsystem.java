/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class WinchSubsystem extends SubsystemBase {
	private WPI_TalonFX winchMotor;
	private int winchState = 0;

	private double winchMaxDist;
	private double winchMinDist;

	public WinchSubsystem() {
		winchMotor = new WPI_TalonFX(Constants.WINCH_TALONFX_ID);
	}

	// public void DButtoneWinchState(int button){
	// 	if(button == 1) {
	// 		winchMotor.set(ControlMode.PercentOutput, 0.1);
	// 	} else if(button == 2) {
	// 		winchMotor.set(ControlMode.PercentOutput, -0.1);
	// 	} else {
	// 		winchMotor.set(ControlMode.PercentOutput, 0.0);
	// 	}
	// }

	public void toggleWinchState() {
		if (winchState == 0) {
			System.out.print("NEUTRAL STATE");
			SmartDashboard.putString("Winch State", "NEUTRAL");
			
			winchMotor.set(ControlMode.PercentOutput, 0.0);
		} else if (winchState == 1) {
			System.out.print("RETRACT STATE");
			SmartDashboard.putString("Winch State", "RETRACT");
			
			winchMotor.set(ControlMode.PercentOutput, 0.6);
		} else if (winchState == 2) {
			System.out.print("EXTEND STATE");
			SmartDashboard.putString("Winch State", "EXTEND");

			winchMotor.set(ControlMode.PercentOutput, -0.6);
		}

		winchState++;
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}