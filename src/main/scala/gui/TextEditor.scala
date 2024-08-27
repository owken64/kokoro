package gui
import javax.swing._
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import util.SaveFile

object TextEditor {
  def frame(): Unit = {
      // JFrameの作成
      val frame = new JFrame("Multi-line Text Field Example")
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
      frame.setSize(400, 300)
      // JTextAreaの作成
      val textArea = new JTextArea(10, 30) // 10行、30列のJTextArea

      textArea.setLineWrap(true) // 行の自動折り返しを有効にする

      textArea.setWrapStyleWord(true) // 単語単位で折り返す

      val printButton = new JButton("Print")
      printButton.addActionListener(_ => {
          CustomStdOut.myPrint(textArea.getText)
      }) // ボタンを押すとプログラム終了

      val executeButton = new JButton("Execute Python")
      executeButton.addActionListener(_ => {
          val filename:String = "temp.py"
          SaveFile.save(filename, textArea.getText)
          cli.ExecutePython.execute(filename)
      }) // ボタンを押すとプログラム終了

      val executeLeanButton = new JButton("Execute Lean")
      executeLeanButton.addActionListener(_ => {
          val filename: String = "temp.lean"
          SaveFile.save(filename, textArea.getText)
          cli.ExecuteLean.execute(filename)
      }) // ボタンを押すとプログラム終了


      // JTextAreaをスクロール可能にするためにJScrollPaneに包む
      val scrollPane = new JScrollPane(textArea)

      // JPanelを使ってコンポーネントを整理
      val panel:JPanel = new JPanel()
      panel.add(scrollPane)
      panel.add(printButton)
      panel.add(executeButton)
      panel.add(executeLeanButton)

      // JFrameにJScrollPaneを追加
      frame.add(panel)
      // フレームの表示
      frame.setVisible(true)
    }
}
