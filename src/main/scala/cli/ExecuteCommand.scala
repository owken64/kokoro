package cli

import scala.sys.process._
import scala.io.Source
import gui.CustomStdOut

object ExecuteCommand {
  def execute(command: String): Unit = {
    try {

      // ProcessBuilderを使ってコマンドを実行
      //val process = Process(command)

      // コマンドの出力を読み取る
      //val output = process.lazyLines_!.mkString("\n")
      //CustomStdOut.myPrint(output)

      // プロセスの終了コードを取得
      //val exitCode = process.!
      //CustomStdOut.myPrint(s"Command executed with exit code: $exitCode")

      val result = command.!!
      CustomStdOut.myPrint(result)
    } catch {
      case e: Exception => {
        e.printStackTrace()
        CustomStdOut.myErr("Error occured@ExecuteCommand.execute")
      }
    }
  }
}
