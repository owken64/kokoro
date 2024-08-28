package gui

import javax.swing._
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import java.io.{OutputStream,ByteArrayOutputStream}
import java.io.PrintStream

object CustomStdOut {
  val _frame = new JFrame("Console Output")
  val textArea = new JTextArea
  val scrollPane = new JScrollPane(textArea)
  val byteArrayOutputStream = new ByteArrayOutputStream()

  def frame(): Unit = {
      // JFrameのセットアップ
      _frame.add(scrollPane)
      _frame.setSize(500, 300)
      _frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
      _frame.setVisible(true)

      // バッファリングされたバイト出力ストリームを作成する

      // 標準出力をJTextAreaにリダイレクト
      val printStream = new PrintStream(new OutputStream() {
        override def write(b: Int): Unit = {
          // JTextAreaに書き込み
          //textArea.append(String.valueOf(b.toChar))
          byteArrayOutputStream.write(b)
        }
      })
      System.setOut(printStream)
      System.setErr(printStream)
      // テスト出力
      myPrint("This is a test output to the JTextArea.")
    }

    def myPrint(message: String): Unit = {
      System.out.println(message)
      textArea.append(byteArrayOutputStream.toString("UTF-8"))
      byteArrayOutputStream.reset()
    }

    def myPrint_SJIS(message:String): Unit = {
      System.out.println(message)
      textArea.append(byteArrayOutputStream.toString("Shift-JIS"))
      byteArrayOutputStream.reset()
    }

    def myErr(message: String): Unit = {
      System.err.println(message)
      textArea.append(byteArrayOutputStream.toString("UTF-8"))
      byteArrayOutputStream.reset()
    }
}
