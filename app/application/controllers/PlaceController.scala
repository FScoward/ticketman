package application.controllers

import javax.inject.Inject

import application.model.PlaceView
import domain.model.Place
import infrastructure.PlaceRepository
import play.api.mvc.{ Action, Controller }

/**
 * Created by Fumiyasu on 2016/09/15.
 */
class PlaceController @Inject() () extends Controller {
  def create() = Action(parse.json) { request =>
    request.body.validate[PlaceView].fold(
      invalid => BadRequest,
      valid => {
        val place = Place(valid.prefecture, valid.address, valid.name)
        PlaceRepository.save(place)
        Ok
      }
    )
  }
}
