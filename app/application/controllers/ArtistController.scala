package application.controllers

import javax.inject._

import application.model.ArtistView
import domain.model.{ Artist, ArtistId }
import infrastructure.ArtistRepository
import play.api.libs.json.Json
import play.api.mvc.{ Action, Controller }
/**
 * Created by Fumiyasu on 2016/09/12.
 */
@Singleton
class ArtistController @Inject() () extends Controller {
  def create() = Action(parse.json) { request =>
    request.body.validate[ArtistView].fold(
      invalid => BadRequest,
      valid => {
        ArtistRepository.save(Artist(ArtistId(0L), valid.name))
        Ok(Json.toJson(valid))
      }
    )
  }
}
