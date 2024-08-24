import javax.swing.{JButton, JFrame, SwingUtilities}
import java.awt.{GraphicsDevice, GraphicsEnvironment, BorderLayout}
import javax.swing.WindowConstants.EXIT_ON_CLOSE
object Graphics {
  def view(): Unit = {

    // GUIの初期化はイベントディスパッチスレッドで実行する
    SwingUtilities.invokeLater(() => {
      val frame = new JFrame("Full Screen Example")
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE)

      // ウィンドウを非表示にしておく
      frame.setUndecorated(true)
      frame.setResizable(false)

      // 終了ボタンを作成
      val exitButton = new JButton("Exit Full Screen")
      exitButton.addActionListener(_ => System.exit(0)) // ボタンを押すとプログラム終了

      // ボタンをフレームに追加
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
