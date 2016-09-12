package application.controllers

import javax.inject._

import application.model.ArtistView
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
      valid => Ok(Json.toJson(valid))
    )
  }
}
