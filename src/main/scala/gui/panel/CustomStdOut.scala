package gui.panel

import java.awt.Dimension
import java.io.{ByteArrayOutputStream, OutputStream, PrintStream}
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.swing._

object CustomStdOut {
  val _frame = new JFrame("Console Output")
  val _panel = new JPanel
  val textArea = new JTextArea(20, 50)
  val scrollPane = new JScrollPane(textArea)
  val byteArrayOutputStream = new ByteArrayOutputStream()

  def panel(): JPanel = {
      // JFrameのセットアップ
      //_frame.add(scrollPane)
      //_frame.setSize(500, 300)
      //_frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
      //_frame.setVisible(true)
      _panel.add(scrollPane)
      _panel.setPreferredSize(new Dimension(500, 300))
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
      _panel
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
