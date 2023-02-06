# Sunil Automation Task

## Automation installation Guide

### System Requirements
- Install **Node 18** or above and **npm 9.3** or above.
- Install **Appium 1.22.3** and above.
- Install **Java 11**
- Install Intellij IDEA Community Edition.
- Install **Maven 3.8.6** above
- Install Android SDK

### External Dependencies
- Install appium from terminal
    - `npm install -g appium`
    - `android adb platform tools`
    - `Android emulator - If required`

# Run our application
1. Download the source code on to your local.
2. Open intellijIDEA editor.
3. Import an Existing project from Maven.
4. Find `master.xml`, `masterWithValue.xml`, `masterParallel.xml` file and open it.
5. Provide all the Parameters on `masterWithValue.xml` file like below.
  - `platform` - To select `android` or `iOS`
  - `appPackage` - it should be the bundle ID of the application.
  - `deviceName` - Provide the current attached device Name.
  - `udid` - Provide Unique Identification of the device.
  - `wda` - Provide the WDA number.
  - `OSVersion` - Provide the OS value of the device.
6. RightClick on the XML file and Run it.

# Running the application from maven command.

1. Download the source code on to your local.
2. Make sure you have JDK and Maven installed and added to Environmental variable.
3. Open the cmd/terminal navigate to the Automation location.
4. Type `` for the first time to make sure all the .jar files loaded on to your machine.
5. Then enter the command as `mvn clean test -PMasterRun  -DdeviceName=$DEVICE_ID -DosVersion=$OS_VERSION` to run it on local. You can change the file name accordingly.
6. Once the Automation run got completed, it'll have a link to `index.html` file to view the test result from TestNG.
7. To view the Reports You can check the report in the `logs` and `ExtentReportResult` package.
#### NOTE: `master.xml` - Can only able to run on one device. `masterParallel` - Able to run it on two devices parallely. `masterWithValue.xml` file has to be edited before running the file.

## Running application on two Devices.

1. Open the cmd/terminal navigate to the Automation location.
2. Type `mvn clean complie` for the first time to make sure all the .jar files loaded on to your machine.
3. Then enter the command as `mvn clean test -PParallelRun  -DdeviceName1=$DEVICE_ID -DosVersion1=$OS_VERSION -DdeviceName2=$DEVICE_ID -DosVersion2=$OS_VERSION` to run it on local.

# Rerun failed test cases.
1. From the main folder navigate to the `testng-failed.xml` file.
   path of the file will be like - `<user.directory>/vanceAPPAutomationTask/target/surefire-reports/testng-failed.html`.
2. Open the file and Right click and Run it.


mvn clean test -PParallelRun -DdeviceName1=NRHAZTO7Q8KJUKFY -DosVersion1=12 -DdeviceName2=RZ8M93F2Y7A -DosVersion2=11