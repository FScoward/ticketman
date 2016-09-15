package application.model

import play.api.libs.json.Json

/**
 * Created by Fumiyasu on 2016/09/15.
 */
case class PlaceView(name: String, prefecture: String, address: String)

object PlaceView {
  implicit val placeViewFormats = Json.format[PlaceView]
}
