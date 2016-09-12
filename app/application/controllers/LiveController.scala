package application.controllers

import javax.inject._

import application.model.LiveView
import domain.model.{ ArtistId, Live, LiveId }
import play.api.mvc.{ Action, Controller }
/**
 * Created by Fumiyasu on 2016/09/12.
 */
@Singleton
class LiveController @Inject() () extends Controller {
  /**
   *
   * {
   * "name": "FScoward",
   * "eventDate": {
   * "start": "2000-01-01",
   * "end": "2000-01-01"
   * },
   * "place": {
   * "prefecture": "東京",
   * "address": "",
   * "name": "中野サンプラザ"
   * },
   * "artistId": 0
   * }
   *
   */
  def create() = Action(parse.json) { request =>
    request.body.validate[LiveView].fold(
      invalid => BadRequest,
      valid => {
        Live(LiveId(0L), valid.name, valid.eventDate, valid.place, Nil, ArtistId(valid.artistId))
        Ok
      }
    )
  }
}
