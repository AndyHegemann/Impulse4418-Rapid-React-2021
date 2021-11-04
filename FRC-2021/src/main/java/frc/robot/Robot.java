/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a sample program showing the use of the solenoid classes during operator control. Three
 * buttons from a joystick will be used to control two solenoids: One button to control the position
 * of a single solenoid and the other two buttons to control a double solenoid. Single solenoids can
 * either be on or off, such that the air diverted through them goes through either one channel or
 * the other. Double solenoids have three states: Off, Forward, and Reverse. Forward and Reverse
 * divert the air through the two channels and correspond to the on and off of a single solenoid,
 * but a double solenoid can also be "off", where the solenoid will remain in its default power off
 * state. Additionally, double solenoids take up two channels on your PCM whereas single solenoids
 * only take a single channel.
 */
public class Robot extends TimedRobot {
  private final Joystick m_stick = new Joystick(0);

  // DoubleSolenoid corresponds to a double solenoid.
  private final DoubleSolenoid m_solenoidSmall =
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
        // DoubleSolenoid corresponds to a double solenoid.

  private final DoubleSolenoid m_solenoidMedium =
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
        // DoubleSolenoid corresponds to a double solenoid.

  private final DoubleSolenoid m_solenoidLarge =
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);


  private static final int kSolenoidSmallForward = Constants.GAMEPAD_BUTTON_A;
  private static final int kSolenoidSmallReverse = Constants.GAMEPAD_BUTTON_B;
  
  private static final int kSolenoidMediumForward = Constants.GAMEPAD_BUTTON_X;
  private static final int kSolenoidMediumReverse = Constants.GAMEPAD_BUTTON_Y;
  
  private static final int kSolenoidLargeForward = Constants.GAMEPAD_BUTTON_LEFT_BUMPER;
  private static final int kSolenoidLargeReverse = Constants.GAMEPAD_BUTTON_RIGHT_BUMPER;


  @Override
  public void teleopPeriodic() {
    /*
     * The output of GetRawButton is true/false depending on whether
     * the button is pressed; Set takes a boolean for whether
     * to use the default (false) channel or the other (true).
     *
     * In order to set the double solenoid, if just one button
     * is pressed, set the solenoid to correspond to that button.
     * If both are pressed, set the solenoid will be set to Forwards.
     */
    
    if (m_stick.getRawButton(kSolenoidSmallForward)) {
      m_solenoidSmall.set(DoubleSolenoid.Value.kForward);
    } else if (m_stick.getRawButton(kSolenoidSmallReverse)) {
      m_solenoidSmall.set(DoubleSolenoid.Value.kReverse);
    }

    if (m_stick.getRawButton(kSolenoidMediumForward)) {
      m_solenoidMedium.set(DoubleSolenoid.Value.kForward);
    } else if (m_stick.getRawButton(kSolenoidMediumReverse)) {
      m_solenoidMedium.set(DoubleSolenoid.Value.kReverse);
    }

    if (m_stick.getRawButton(kSolenoidLargeForward)) {
      m_solenoidLarge.set(DoubleSolenoid.Value.kForward);
    } else if (m_stick.getRawButton(kSolenoidLargeReverse)) {
      m_solenoidLarge.set(DoubleSolenoid.Value.kReverse);
    }
  }
}