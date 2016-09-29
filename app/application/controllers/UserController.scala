package application.controllers

import javax.inject.{ Inject, Singleton }

import play.api.mvc._

/**
 * Created by Fumiyasu on 2016/09/28.
 */
@Singleton
class UserController @Inject() () extends Controller {
  def save() = Action(parse.json) { request =>

    Ok
  }
}
