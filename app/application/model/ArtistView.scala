package application.model

import play.api.libs.json.{ Json, Reads }

/**
 * Created by Fumiyasu on 2016/09/13.
 */
case class ArtistView(name: String)

object ArtistView {
  implicit val artistViewFormats = Json.format[ArtistView]
}
