package domain.model

/**
 * Created by Fumiyasu on 2016/09/12.
 */
case class UserId(id: Long)
case class User(userId: UserId, name: String, favoriteArtists: FavoriteArtists)
