import javax.swing.{JButton, JFrame, JTextField,SwingUtilities}
import java.awt.{GraphicsDevice, GraphicsEnvironment, BorderLayout}
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import gui.CustomStdOut

object Graphics {
  def view(): Unit = {

    // GUIの初期化はイベントディスパッチスレッドで実行する
    SwingUtilities.invokeLater(() => {
      val frame = new JFrame("Full Screen Example")
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE)

      // ウィンドウを非表示にしておく
      frame.setUndecorated(true)
      frame.setResizable(false)

      // パスワード入力欄を作成
      // テキストフィールドを作成
      val textField = new JTextField("Enter text here...", 20)
      // 終了ボタンを作成
      val enterButton = new JButton("Enter")
      enterButton.addActionListener(_ => {
        CustomStdOut.myPrint(s"User entered: ${textField.getText()}")
      })

      // 終了ボタンを作成
      val exitButton = new JButton("Exit Full Screen")
      exitButton.addActionListener(_ => System.exit(0)) // ボタンを押すとプログラム終了

      // ボタンをフレームに追加
      frame.add(textField, BorderLayout.NORTH)
      frame.add(enterButton, BorderLayout.CENTER)
      frame.add(exitButton, BorderLayout.SOUTH)

      // デフォルトのグラフィックデバイスを取得
      val gd: GraphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment.getDefaultScreenDevice

      // フルスクリーンモードに移行
      gd.setFullScreenWindow(frame)

      // フレームを可視化
      frame.setVisible(true)
    })
  }
}
