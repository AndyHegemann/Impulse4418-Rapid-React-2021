/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ClimbSubsystem extends SubsystemBase {
	private int climberState = 0;

	private WPI_TalonSRX climbMotor;
	private Encoder climbEncoder;

	//public double Distance(){return climbEncoder.getDistance();}
	private double climbMaxDist;
	private double climbMinDist;

	public ClimbSubsystem() {
		climbMotor = new WPI_TalonSRX(Constants.CLIMBER_TALONSRX_ID);
		climbMaxDist = 1;
		climbMinDist = 0;
	}

	public void setClimb(double motorValue) {
		climbMotor.set(ControlMode.PercentOutput, motorValue);
	}

	public void toggleElevatorState() {
		if (climberState == 0) {
			climbMotor.set(ControlMode.PercentOutput, 0.0);
		} else if (climberState == 1) {
			climbMotor.set(ControlMode.PercentOutput, 0.6);
		} else if (climberState == 2) {
			climbMotor.set(ControlMode.PercentOutput, -0.6);
		}
		
		if (climberState == 2) {
			climberState = 0;
		} else {
			climberState++;
		}

		// if(state == true)
		// {
			//if(climbMinDist < Distance() && Distance() > climbMaxDist)
			//{
			//	climbMotor.set(ControlMode.PercentOutput,0.5);
			//} else {
			//	climbMotor.set(ControlMode.PercentOutput,0);
			//}
		//} else {
		//	if(climbMinDist < Distance() && Distance() > climbMaxDist)
		//	{
		//		climbMotor.set(ControlMode.PercentOutput,-0.5);
		//	} else {
		//		climbMotor.set(ControlMode.PercentOutput,0);
		//	}
		// }
	}

	// public Encoder getClimbEncoder() { return climbEncoder; }

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}