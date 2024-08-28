package util

import gui.panel.CustomStdOut
import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets

object SaveFile {

    def save(filename: String, content: String): Unit = {

      // 保存先のパス
      val path = Paths.get(filename)

      // テキストをファイルに書き込む
      try {
        Files.write(path, content.getBytes(StandardCharsets.UTF_8))
      } catch {
        case e: Exception =>
          CustomStdOut.myErr(s"エラーが発生しました: ${e.getMessage}")
      }
    }
}
