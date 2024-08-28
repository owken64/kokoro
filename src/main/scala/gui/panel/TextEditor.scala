package gui.panel

import util.SaveFile

import java.awt.Dimension
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.swing._

object TextEditor {
  def panel(): JPanel = {
      // JFrameの作成
      //val frame = new JFrame("Multi-line Text Field Example")
      //frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
      //frame.setSize(400, 300)
      // JTextAreaの作成
      val textArea = new JTextArea(20, 40) // 10行、30列のJTextArea

      textArea.setLineWrap(true) // 行の自動折り返しを有効にする

      textArea.setWrapStyleWord(true) // 単語単位で折り返す

      //val printButton = new JButton("Print")
      //printButton.addActionListener(_ => {
      //    CustomStdOut.myPrint(textArea.getText)
      //}) // ボタンを押すとプログラム終了

      val executeJuliaButton = new JButton("Execute Julia")
      executeJuliaButton.addActionListener(_ => {
          val filename:String = "temp.jl"
          SaveFile.save(filename, textArea.getText)
          cli.ExecuteJulia.execute(filename)
      }) // ボタンを押すとプログラム終了

      val executeLeanButton = new JButton("Execute Lean")
      executeLeanButton.addActionListener(_ => {
          val filename: String = "temp.lean"
          SaveFile.save(filename, textArea.getText)
          cli.ExecuteLean.execute(filename)
      }) // ボタンを押すとプログラム終了

      // JTextAreaをスクロール可能にするためにJScrollPaneに包む
      val scrollPane = new JScrollPane(textArea)


      val readFileField = new JTextField(40) // 40はテキストフィールドの列数

      val readFileButton = new JButton("Read")
      readFileButton.addActionListener(_ => {
          textArea.setText( util.ReadFile.read(readFileField.getText) )
      }) // ボタンを押すとプログラム終了


      val saveFileField = new JTextField(40) // 40はテキストフィールドの列数

      val saveFileButton = new JButton("Save")
      saveFileButton.addActionListener(_ => {
          util.SaveFile.save(saveFileField.getText, textArea.getText)
      }) // ボタンを押すとプログラム終了


      // JPanelを使ってコンポーネントを整理
      val panel:JPanel = new JPanel()
      panel.add(readFileField)
      panel.add(readFileButton)
      panel.add(scrollPane)
      panel.add(saveFileField)
      panel.add(saveFileButton)
      //panel.add(printButton)
      panel.add(executeJuliaButton)
      panel.add(executeLeanButton)

      panel.setPreferredSize(new Dimension(400, 300))
      // JFrameにJScrollPaneを追加
      //frame.add(panel)
      // フレームの表示
      //frame.setVisible(true)
      panel
    }
}
