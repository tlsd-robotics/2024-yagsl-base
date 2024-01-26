package TLsdLibrary.Controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class T16000M {
    Joystick joy;


    public T16000M(int port) {
        joy = new Joystick(port);

    }


    public double getRawX() {
        return joy.getRawAxis(0);
    }


     public double getRawY() {
        return joy.getRawAxis(1);
    }


     public double getRawZ() {
        return joy.getRawAxis(2);
    }

    public JoystickButton getTrigger() {
        return new JoystickButton(joy, 1);
    }

    public JoystickButton getBottom() {
        return new JoystickButton(joy, 2);
    }

    public JoystickButton getLeft() {
        return new JoystickButton(joy,3 );
    }

    public JoystickButton getright() {
        return new JoystickButton(joy, 4);
    }

    public boolean getPovUp() {
        if (joy.getPOV() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getPovDown() {
        if (joy.getPOV() == 180) {
            return true;
        } else {
            return false;
        }
    }
    public boolean getPovLeft() {
        if (joy.getPOV() == 270) {
            return true;
        } else {
            return false;
        }
    }
    public boolean getPovRight() {
        if (joy.getPOV() == 90) {
            return true;
        } else {
            return false;
        }
    }
    public JoystickButton getJoystickButton(int id) {
        return new JoystickButton(joy, id);
    }
    public boolean getButtonBoolean(int id) {
        return joy.getRawButton(id);
    }
}
