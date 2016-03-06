####Appium:

- test automation tool
- open source
- cross-platform
- for native and hybrid mobile apps
- tested on simulators (iOS, FirefoxOS)
- on emulators (Android)
- and real devices (iOS, Androi, FirefoxOS)
- supported platforms - iOS, Android, FirefoxOS
- equals Webdriver + Mobile Feature, webdriver is a subset of appium

####Why Appium?

- uses standard APIs on all platforms
- and so there is no need to recompile or modify app in any way
- can use any testing framework
- can write code in any language supported by Webdriver
- just an extension from Selenium Webdriver
- opens up possibility of 'true cross-platform mobile automation'

####Appium on MAC:

- install XCode
- check for iOS Simulator version in Xcode
- install Java
- install Eclipse
- download Appium + Selenium Server / Jars

####Desired Capabilities:

- options to customize and configure a browser session
- automationName: appium or selenroid
- platformName: iOS, Android, or FIrefoxOS
- platformVersion: version
- deviceName: device being used
- app: need path and point to apk 
- browserName: safari, chrome, or 'Browser' fro android (for web apps)
- newCommandTimeout: time to wait until element appears
- autoLaunch:
- orientation: 

####External Jar Files

- Right click on your project->Build Path->Configure Build Path
- Goto Libraries->Add External jar files
- Add all the jar files made available with Selenium



####Source:

* https://www.udemy.com/mobile-automation-using-appiumselenium-3
* http://docs.oracle.com/javase/8/
* https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md