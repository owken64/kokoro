package gui.panel

import net.HttpRequest
import sttp.client3.UriContext

import java.awt.Dimension
import java.nio.charset.StandardCharsets
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.swing._

object HttpClient {
  def panel(): JPanel = {
    // JFrameの作成
    //val frame = new JFrame("Multi-line Text Field Example")
    //frame.setDefaultCloseOperation(EXIT_ON_CLOSE)
    //frame.setSize(400, 300)

    val printButton = new JButton("GET")
    printButton.addActionListener(_ => {
      val response = HttpRequest.request(uri"https://owken64.github.io/Profile/index.html")
      response match {
        case Right(byteArray) => {
          // UTF-8として解釈して文字列に変換
          val fixedString = new String(byteArray, StandardCharsets.UTF_8)
          CustomStdOut.myPrint(fixedString)
          //System.out.println(fixedString)
          //println(s"Received ${byteArray.length} bytes.")
        }
        // バイトデータを処理するコード
        case Left(error) =>
          CustomStdOut.myErr(s"Error occurred: $error")
      }

    })

     // JPanelを使ってコンポーネントを整理
    val panel: JPanel = new JPanel()
    panel.add(printButton)

    // JFrameにJScrollPaneを追加
    //frame.add(panel)
    // フレームの表示
    //frame.setVisible(true)
    panel.setPreferredSize(new Dimension(200, 100))
    panel
  }
}
