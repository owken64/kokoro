package cli

import gui.panel.CustomStdOut
import scala.sys.process._
import scala.io.Source

object ExecutePython {

  def execute(filepath: String):Unit = {
    try {
      // 実行したいコマンドを指定
      val command = s"python $filepath"

      // ProcessBuilderを使ってコマンドを実行
      val process = Process(command)

      // コマンドの出力を読み取る
      //val output = process.lazyLines_!.mkString("\n")
      //CustomStdOut.myPrint(output)

      // プロセスの終了コードを取得
      val exitCode = process.!
      CustomStdOut.myPrint(s"Command executed with exit code: $exitCode")
    } catch {
      case e: Exception => {
        e.printStackTrace()
        CustomStdOut.myErr("Error occured@ExecutePython.execute")
      }
    }
  }
}
