package util
import java.io.File

object ListFileAndFolder {

    def printFilesAndFolders(): Unit = {
      val currentDir = new File(".")
      listFiles(currentDir)
    }

    def listFiles(dir: File): Unit = {
      if (dir.exists && dir.isDirectory) {
        val files = dir.listFiles
        if (files != null) {
          files.foreach { file =>
            if (file.isDirectory) {
              println(s"Directory: ${file.getName}")
            } else {
              println(s"File: ${file.getName}")
            }
          }
        } else {
          println("Could not list files.")
        }
      } else {
        println("Provided path is not a directory.")
      }
    }
}
