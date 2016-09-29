package infrastructure

import domain.model.{ ArtistId, UserId }

/**
 * Created by Fumiyasu on 2016/09/28.
 */
trait FavoriteAritstRepository {
  def save(userId: UserId, artistId: ArtistId)
}
