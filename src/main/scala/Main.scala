import gui._
object Main {
  def main(args:Array[String]): Unit = {
    //println("Hello world.")
    //util.ListFileAndFolder.printFilesAndFolders()
    //Graphics.view()
    CustomStdOut.frame()
    TextEditor.frame()
    CommandExecuter.frame()
    //HttpClient.frame()
    // メインスレッドが終了しないようにするため、ここで適切にブロックする方法を選びます
    // 例: スレッドを使って永遠に待機させる
    Thread.sleep(Long.MaxValue)
  }
}
