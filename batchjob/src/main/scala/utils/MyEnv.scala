package utils

import java.lang.management.ManagementFactory

object MyEnv {

  lazy val isWindows = System.getProperty("os.name").toLowerCase.contains("win")
  lazy val isRunningUnderIDE = ManagementFactory.getRuntimeMXBean.getInputArguments.toString.contains("IntelliJ IDEA")

}
