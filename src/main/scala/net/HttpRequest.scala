package net
import sttp.client3._

object HttpRequest {

  def request(uri: sttp.model.Uri): Either[String, Array[Byte]] = {
    val backend = HttpURLConnectionBackend()
    val request = basicRequest.get(uri).response(asByteArray)
    val response = request.send(backend)

    // レスポンスのステータスコードとヘッダーを出力
    //println(s"Status Code: ${response.code}")
    //println(s"Headers: ${response.headers}")

    response.body
  }

}

