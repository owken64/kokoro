package gui.frame

import gui.panel.CustomStdOut

import java.awt.{BorderLayout,FlowLayout, GraphicsDevice, GraphicsEnvironment}
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.swing.{JButton, JFrame, JTextField, SwingUtilities}
import gui.panel._

object Graphics {
  def view(): Unit = {

    // GUIの初期化はイベントディスパッチスレッドで実行する
    SwingUtilities.invokeLater(() => {
      val frame = new JFrame("Full Screen Example")
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE)

      // FlowLayoutをJFrameに設定
      frame.setLayout(new FlowLayout());

      // ウィンドウを非表示にしておく
      frame.setUndecorated(true)
      frame.setResizable(false)

      // パスワード入力欄を作成
      // テキストフィールドを作成
      //val textField = new JTextField("Enter text here...", 20)
      // 終了ボタンを作成
      //val enterButton = new JButton("Enter")
      //enterButton.addActionListener(_ => {
      //  CustomStdOut.myPrint(s"User entered: ${textField.getText()}")
      //})

      // 終了ボタンを作成
      val exitButton = new JButton("Exit Full Screen")
      exitButton.addActionListener(_ => System.exit(0)) // ボタンを押すとプログラム終了

      // ボタンをフレームに追加
      //frame.add(textField, BorderLayout.NORTH)
      //frame.add(enterButton, BorderLayout.CENTER)
      frame.add(CustomStdOut.panel())
      frame.add(TextEditor.panel())
      frame.add(CommandExecuter.panel())
      frame.add(exitButton)

      // デフォルトのグラフィックデバイスを取得
      val gd: GraphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment.getDefaultScreenDevice

      // フルスクリーンモードに移行
      gd.setFullScreenWindow(frame)

      // フレームを可視化
      frame.setVisible(true)
    })
  }
}
