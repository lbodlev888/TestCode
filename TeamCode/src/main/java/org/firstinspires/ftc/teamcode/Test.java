package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Test extends OpMode {
    private final DcMotor[] motorcar = new DcMotor[5];
    private final String[] names = {"backLeftMotor", "frontLeftMotor", "frontRightMotor", "backRightMotor"};
    private boolean brake = true;
    private int count = 0;
    @Override
    public void init()
    {
        for(int i = 0; i < 4; i++)
        {
            motorcar[i] = hardwareMap.get(DcMotor.class, names[i]);
            motorcar[i].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motorcar[i].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motorcar[i].setDirection(DcMotor.Direction.FORWARD);
        }
        telemetry.addData("Hardware", "Initialized");
        telemetry.addData("Brake", brake);
    }
    @Override
    public void loop()
    {
        if(gamepad1.left_stick_y > 0) motorcar[count].setPower(gamepad1.left_stick_y);
        else motorcar[count].setPower(0);
        if(gamepad1.a) count++;
    }
}