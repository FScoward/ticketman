package application.model

import domain.model.{ ArtistId, EventDate, Place }
import play.api.libs.json.Json

/**
 * Created by Fumiyasu on 2016/09/13.
 */
case class LiveView(name: String, eventDate: EventDate, place: Place, artistId: Long)

object LiveView {
  implicit val eventDateReads = Json.reads[EventDate]
  implicit val placeReads = Json.reads[Place]
  implicit val liveViewReads = Json.reads[LiveView]
}
