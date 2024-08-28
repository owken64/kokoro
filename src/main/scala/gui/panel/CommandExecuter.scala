package gui.panel

import javax.swing._
import java.awt._

object CommandExecuter {
  def panel(): JPanel = {
    // フレームを作成
    //val frame = new JFrame("TextField Example")
    //frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
    //frame.setSize(300, 100)
    // パネルを作成
    val panel = new JPanel
    // テキストフィールドを作成
    val textField = new JTextField(20) // 20はテキストフィールドの列数

    val executeButton = new JButton("Done")
    executeButton.addActionListener(_ => {
      cli.ExecuteCommand.execute(textField.getText)
    }) // ボタンを押すとプログラム終了


    // パネルにテキストフィールドを追加
    panel.add(textField)
    panel.add(executeButton)
    // フレームにパネルを追加
    //frame.add(panel)
    // フレームを表示
    //frame.setVisible(true)

    panel.setPreferredSize(new Dimension(300, 100))
    panel
  }
}
