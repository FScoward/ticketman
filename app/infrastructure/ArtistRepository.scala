package infrastructure

import domain.model.{ Artist, ArtistId }
import scalikejdbc._
import scalikejdbc.config._

/**
 * Created by Fumiyasu on 2016/09/13.
 */
object Artists extends SQLSyntaxSupport[Artist] {
  def apply(artist: ResultName[Artist])(rs: WrappedResultSet): Artist = new Artist(ArtistId(rs.get(artist.artistId)), name = rs.get(artist.name))
}
object ArtistRepository {
  DBs.setupAll()
  def save(artist: Artist) = {
    DB localTx { implicit s =>
      withSQL {
        insert.into(Artists).namedValues()
      }.update().apply()
    }
  }
}
