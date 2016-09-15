package application.controllers

import javax.inject._

import application.model.ArtistView
import domain.model.{ Artist, ArtistId }
import infrastructure.ArtistRepository
import play.api.libs.json.Json
import play.api.mvc.{ Action, Controller }
import utils.Id64
/**
 * Created by Fumiyasu on 2016/09/12.
 */
@Singleton
class ArtistController @Inject() () extends Controller {
  def create() = Action(parse.json) { request =>
    request.body.validate[ArtistView].fold(
      invalid => BadRequest,
      valid => {
        val artist = Artist(ArtistId(Id64.nextAscId()), valid.name)
        ArtistRepository.save(artist)
        Ok(Json.toJson(valid))
      }
    )
  }
}
