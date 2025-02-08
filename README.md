# Selenium Automation Setup with Java and Eclipse IDE

Welcome! This guide will walk you through the process of setting up a development environment for Selenium WebDriver using Java, Eclipse IDE, and EdgeDriver. Follow these instructions carefully, and you’ll be ready to start automating tests in no time!

## 1. Download and Install Java Development Kit (JDK)

To begin, we need to install the Java Development Kit (JDK).

1. **Download JDK**:  
   Go to the [JDK 23 download page](https://download.oracle.com/java/23/latest/jdk-23_windows-x64_bin.exe) and click to download the appropriate version for your operating system (Windows in this case).

2. **Install JDK**:  
   After downloading, open the installer and follow the on-screen instructions to install JDK on the computer.

### Configure Environment Variables for JDK:
1. **Copy the JDK Installation Path**:  
   Once JDK is installed, locate the installation folderand copy its path.

2. **Set the Path in Environment Variables**:  
   - Go to `Settings` → `System` → Search for “System environment” and click to open the System Properties.
   - Under the “System Properties” window, click on `Environment Variables`.
   - In the System variables section, scroll down and select `Path`, then click `Edit`.
   - Click on `New` and paste the copied path of your JDK.
   - Click `OK` to save the changes.

3. **Verify JDK Installation**:  
   Open the Command Prompt and type the following:
   java --version
## 2. Download and Install Eclipse IDE for Java Developers

Next, we will install Eclipse IDE for Java development.

### Download Eclipse:
- Download the installer for Eclipse IDE for Java Developers from [this link](https://www.eclipse.org/downloads/).

### Install Eclipse:
- Open the downloaded file to start the installation. 
- Select the first option for "Eclipse IDE for Java Developers" and click `Install`.

### Launch Eclipse:
- After installation is complete, click `Launch` to open Eclipse.
- When prompted, click `Launch` again to open the main IDE window.

### Final Setup:
- You should now see the Eclipse workspace. This means your Eclipse IDE setup is ready!

---

## 3. Download and Install Selenium WebDriver

Now we need to set up Selenium WebDriver.

### Download Selenium:
- Go to the [Selenium Downloads page](https://www.selenium.dev/downloads/) and download the latest stable version of Selenium (e.g., 4.11.0).

---

## 4. Download and Install EdgeDriver for Microsoft Edge

If you're planning to automate Microsoft Edge, you'll also need to install EdgeDriver.

### Download EdgeDriver:
- Visit [Microsoft Edge WebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/?form=MA13LH#downloads), then find your Microsoft Edge version.

### Choose the Correct Version:
- Click on the link corresponding to your version of Microsoft Edge (e.g., `x64` for 64-bit systems) to download the required EdgeDriver.

---

## 5. Configure Selenium in Eclipse

Now that we have everything downloaded, let’s configure Selenium in Eclipse.

### Create a New Java Project:
- Open Eclipse and click on `File` → `New` → `Java Project`.
- Enter your project name and click `Finish`.

### Add Selenium Libraries to the Project:
- Right-click on your project in the `Project Explorer`, and select `Properties`.
- Go to `Java Build Path` → `Libraries` → `Add External JARs`.
- Select all the JAR files you downloaded from Selenium and click `Apply and Close`.

---

## 6. Download and Install EdgeDriver for Microsoft Edge

