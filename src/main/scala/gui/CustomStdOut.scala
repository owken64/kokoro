package gui

import javax.swing._
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import java.io.OutputStream
import java.io.PrintStream

object CustomStdOut {

    def frame(): Unit = {
      // JFrameのセットアップ
      val frame = new JFrame("Console Output")
      val textArea = new JTextArea
      val scrollPane = new JScrollPane(textArea)
      frame.add(scrollPane)
      frame.setSize(500, 300)
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
      frame.setVisible(true)
      // 標準出力をJTextAreaにリダイレクト
      val printStream = new PrintStream(new OutputStream() {
        override def write(b: Int): Unit = {
          // JTextAreaに書き込み
          textArea.append(String.valueOf(b.toChar))
        }
      })
      System.setOut(printStream)
      System.setErr(printStream)
      // テスト出力
      myPrint("This is a test output to the JTextArea.")
    }

    def myPrint(message: String): Unit = {
      System.out.println(message)
    }

    def myErr(message: String): Unit = {
      System.err.println(message)
    }
}
