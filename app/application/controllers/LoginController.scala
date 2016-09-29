package application.controllers

import javax.inject.Inject

import play.api.Logger
import play.api.cache.CacheApi
import play.api.mvc.{ Action, Controller, Cookie }
import twitter4j.TwitterFactory

/**
 * Created by Fumiyasu on 2016/09/29.
 */
class LoginController @Inject() (cache: CacheApi) extends Controller {

  val twitter = TwitterFactory.getSingleton

  def login() = Action {
    val redirectUrl = twitter.getOAuthRequestToken.getAuthenticationURL
    Ok(redirectUrl)
  }

  def callback() = Action { request =>
    val oauthToken = request.getQueryString("oauth_token")
    val oauthVerifier = request.getQueryString("oauth_verifier")

    oauthVerifier match {
      case Some(v) => {
        val accessToken = twitter.getOAuthAccessToken(v)
        val uuid = java.util.UUID.randomUUID.toString
        // Cache 保存
        cache.set(uuid, v)
        // Cookie 発行
        Ok.withCookies(Cookie("user", uuid))
      }
      case None => Ok
    }
  }

}
