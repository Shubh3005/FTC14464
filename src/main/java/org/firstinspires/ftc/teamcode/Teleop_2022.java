package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;



@TeleOp(name="Shlok's First Program", group="Pushbot")
public class Teleop_2022 extends LinearOpMode {
    private DcMotor FL = null;
    private DcMotor FR = null;
    private DcMotor BL = null;
    private DcMotor BR = null;
    private DcMotor wheel = null;
    private DcMotor intake = null;
    private DcMotor arm=null;
    @Override
    public void runOpMode() {

        ElapsedTime runtime = new ElapsedTime();

        FR = hardwareMap.get(DcMotor.class, "FR");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");
        FL = hardwareMap.get(DcMotor.class, "FL");
        intake = hardwareMap.get(DcMotor.class, "intake");
        wheel = hardwareMap.get(DcMotor.class, "wheel");
        arm = hardwareMap.get(DcMotor.class, "arm");

        double left;
        double right;
        double drive;
        double turn;
        double max;


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            FL.setPower((-y - x - rx)*0.5);
            BL.setPower((-y + x - rx) *0.5);
            FR.setPower((y - x - rx)*0.5);
            BR.setPower((y + x - rx)*0.5);
            intake.setPower(gamepad1.right_trigger);
            intake.setPower(gamepad1.left_trigger);
            wheel.setPower(gamepad2.left_trigger);
            arm.setPower(gamepad2.left_stick_y);
            int FLpower= (int) ((-y - x - rx)*0.5);
            int BLpower =(int)((-y + x - rx) *0.5);
            int FRpower = (int)((y - x - rx)*0.5);
            int BRpower= (int) ((y + x - rx)*0.5);
            // Send telemetry message to signify robot running;
            telemetry.addData("Front Left Wheel Power",FLpower);
            telemetry.addData("Back Left Wheel Power",BLpower);
            telemetry.addData("Front Right Wheel Power",FRpower);
            telemetry.addData("Back Right Wheel Power",BRpower);
            telemetry.update();

            // Pace this loop so jaw action is reasonable speed.
            sleep(50);
        }
    }
}
